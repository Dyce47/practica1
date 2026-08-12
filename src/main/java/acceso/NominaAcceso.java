package acceso;

import entidades.Nomina;
import entidades.TipoPago;
import entidades.EstadoPago;
import estructuras.ListaDinamica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class NominaAcceso implements MantenimientoAcceso<Nomina> {

    @Override
    public boolean insertar(Nomina objeto) {
        String sql = "INSERT INTO nomina (DPI_Empleado, Fecha_Emision, Tipo_Pago, Monto, Estado_Pago) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = conexion.Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, objeto.getDpiEmpleado());
            stmt.setString(2, objeto.getFechaEmision());
            stmt.setString(3, objeto.getTipoPago().name());
            stmt.setDouble(4, objeto.getMonto());
            stmt.setString(5, objeto.getEstadoPago().name());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar nómina: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Nomina objeto) {
        String sql = "UPDATE nomina SET Estado_Pago = 'PAGADO' WHERE Codigo_Nomina = ?";
        try (Connection conn = conexion.Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, objeto.getCodigoNomina());
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al actualizar estado de nómina: " + e.getMessage());
            return false;
        }
    }

    @Override
    public ListaDinamica<Nomina> listarTodos() {
        return consultarNominas("SELECT * FROM nomina ORDER BY Fecha_Emision DESC");
    }


    public ListaDinamica<Nomina> listarPendientes() {
        return consultarNominas("SELECT * FROM nomina WHERE Estado_Pago = 'PENDIENTE' ORDER BY Fecha_Emision ASC");
    }

    public ListaDinamica<Nomina> listarPorDPI(String dpi) {
        String sql = "SELECT * FROM nomina WHERE DPI_Empleado = '" + dpi + "' ORDER BY Fecha_Emision DESC";
        return consultarNominas(sql);
    }

    private ListaDinamica<Nomina> consultarNominas(String sql) {
        ListaDinamica<Nomina> lista = new ListaDinamica<>();
        try (Connection conn = conexion.Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                Nomina n = new Nomina();
                n.setCodigoNomina(rs.getInt("Codigo_Nomina"));
                n.setDpiEmpleado(rs.getString("DPI_Empleado"));
                n.setFechaEmision(rs.getString("Fecha_Emision"));
                n.setTipoPago(TipoPago.valueOf(rs.getString("Tipo_Pago").toUpperCase()));
                n.setMonto(rs.getDouble("Monto"));
                n.setEstadoPago(EstadoPago.valueOf(rs.getString("Estado_Pago").toUpperCase()));
                lista.agregar(n);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar nóminas: " + e.getMessage());
        }
        return lista;
    }


    public void verificarYGenerarNominasAutomaticas() {
        LocalDate hoy = LocalDate.now();
        int dia = hoy.getDayOfMonth();


        if (dia >= 10 && dia <= 14) {
            generarLoteSiNoExiste("QUINCENA");
        } else if (dia >= 25 && dia <= 31) {
            generarLoteSiNoExiste("FIN_DE_MES");
        }
    }

    private void generarLoteSiNoExiste(String tipoPago) {
        Connection conn = null;
        try {
            conn = conexion.Conexion.getConexion();
            
            String sqlCheck = "SELECT COUNT(*) FROM nomina WHERE Tipo_Pago = ? AND MONTH(Fecha_Emision) = MONTH(CURRENT_DATE()) AND YEAR(Fecha_Emision) = YEAR(CURRENT_DATE())";
            try (PreparedStatement psCheck = conn.prepareStatement(sqlCheck)) {
                psCheck.setString(1, tipoPago);
                ResultSet rsCheck = psCheck.executeQuery();
                if (rsCheck.next() && rsCheck.getInt(1) > 0) {
                    return;
                }
            }

            String sqlEmpleados = "SELECT DPI, Salario, Rol FROM empleado WHERE Estado = 1";
            try (PreparedStatement psEmp = conn.prepareStatement(sqlEmpleados);
                 ResultSet rsEmp = psEmp.executeQuery()) {
                 
                while (rsEmp.next()) {
                    String dpi = rsEmp.getString("DPI");
                    double salarioBase = rsEmp.getDouble("Salario");
                    String rol = rsEmp.getString("Rol");
                    double montoAPagar = 0.0;

                    if (tipoPago.equals("QUINCENA")) {
                        montoAPagar = salarioBase * 0.30;
                    } 
                    else if (tipoPago.equals("FIN_DE_MES")) {
                        montoAPagar = salarioBase * 0.70; 
                        
                        if (rol.equalsIgnoreCase("MESERO") || rol.equalsIgnoreCase("MESERA")) {
                            String sqlPropinas = "SELECT SUM(Propina) FROM cuenta WHERE DPI_Mesero = ? AND Estado = 'PAGADA' AND MONTH(Fecha_Hora_Liberacion) = MONTH(CURRENT_DATE()) AND YEAR(Fecha_Hora_Liberacion) = YEAR(CURRENT_DATE())";
                            try (PreparedStatement psPropina = conn.prepareStatement(sqlPropinas)) {
                                psPropina.setString(1, dpi);
                                ResultSet rsPropina = psPropina.executeQuery();
                                if (rsPropina.next()) {
                                    montoAPagar += rsPropina.getDouble(1); 
                                }
                            }
                        }
                    }

                    Nomina nuevaNomina = new Nomina(0, dpi, LocalDate.now().toString(), TipoPago.valueOf(tipoPago), montoAPagar, EstadoPago.PENDIENTE);
                    insertar(nuevaNomina);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al generar nóminas automáticas: " + e.getMessage());
        }
    }
    

    public ListaDinamica<Object[]> listarPendientesVisual() {
        return consultarNominasVisual("SELECT * FROM nomina WHERE Estado_Pago = 'PENDIENTE' ORDER BY Fecha_Emision ASC");
    }

    public ListaDinamica<Object[]> listarHistorialVisual(String dpiFiltro) {
        if (dpiFiltro == null || dpiFiltro.trim().isEmpty()) {
            return consultarNominasVisual("SELECT * FROM nomina ORDER BY Fecha_Emision DESC");
        } else {
            return consultarNominasVisual("SELECT * FROM nomina WHERE DPI_Empleado = '" + dpiFiltro + "' ORDER BY Fecha_Emision DESC");
        }
    }

    private ListaDinamica<Object[]> consultarNominasVisual(String sql) {
        ListaDinamica<Object[]> listaVisual = new ListaDinamica<>();
        
        try (Connection conn = conexion.Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                int codNomina = rs.getInt("Codigo_Nomina");
                String dpi = rs.getString("DPI_Empleado");
                String fecha = rs.getString("Fecha_Emision");
                String tipoPago = rs.getString("Tipo_Pago");
                double monto = rs.getDouble("Monto");
                String estado = rs.getString("Estado_Pago");
                
                String nombreEmpleado = "Desconocido";
                String rolEmpleado = "N/A";
                
                String sqlEmp = "SELECT Nombre_Completo, Rol FROM empleado WHERE DPI = ?";
                try (PreparedStatement stmtEmp = conn.prepareStatement(sqlEmp)) {
                    stmtEmp.setString(1, dpi);
                    try (ResultSet rsEmp = stmtEmp.executeQuery()) {
                        if (rsEmp.next()) {
                            nombreEmpleado = rsEmp.getString("Nombre_Completo");
                            rolEmpleado = rsEmp.getString("Rol");
                        }
                    }
                }
                
                listaVisual.agregar(new Object[]{
                    codNomina, dpi, nombreEmpleado, rolEmpleado, fecha, tipoPago, monto, estado
                });
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar nóminas visuales: " + e.getMessage());
        }
        return listaVisual;
    }
}