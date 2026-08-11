package acceso;

import entidades.Cuenta;
import entidades.EstadoCuenta;
import estructuras.ListaDinamica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CuentaAcceso implements MantenimientoAcceso<Cuenta> {


    @Override
    public boolean insertar(Cuenta objeto) {
        
        String sql = "INSERT INTO cuenta (Numero_Mesa, DPI_Mesero, Fecha_Hora_Ocupacion, Estado, Total_Pagar, Propina) VALUES (?, ?, NOW(), ?, ?, ?)";
        
        try (Connection conn = conexion.Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, objeto.getNumeroMesa());
            stmt.setString(2, objeto.getDpiMesero());
            stmt.setString(3, objeto.getEstado().name());
            stmt.setDouble(4, objeto.getTotalPagar());
            stmt.setDouble(5, objeto.getPropina());
            
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al insertar cuenta: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Cuenta objeto) {
        
        String sql = "UPDATE cuenta SET Estado = ?, Fecha_Hora_Liberacion = NOW(), Total_Pagar = ?, Propina = ? WHERE ID_Cuenta = ?";
        
        try (Connection conn = conexion.Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, objeto.getEstado().name());
            stmt.setDouble(2, objeto.getTotalPagar());
            stmt.setDouble(3, objeto.getPropina());
            stmt.setInt(4, objeto.getIdCuenta());
            
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al actualizar cuenta: " + e.getMessage());
            return false;
        }
    }

    @Override
    public ListaDinamica<Cuenta> listarTodos() {
        ListaDinamica<Cuenta> listaCuentas = new ListaDinamica<>();
        
        String sql = "SELECT * FROM cuenta ORDER BY Fecha_Hora_Ocupacion ASC"; 
        
        try (Connection conn = conexion.Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                Cuenta c = new Cuenta();
                c.setIdCuenta(rs.getInt("ID_Cuenta"));
                c.setNumeroMesa(rs.getInt("Numero_Mesa"));
                c.setDpiMesero(rs.getString("DPI_Mesero"));
                String estadoStr = rs.getString("Estado").toUpperCase();
                c.setEstado(EstadoCuenta.valueOf(estadoStr));
                c.setTotalPagar(rs.getDouble("Total_Pagar"));
                c.setPropina(rs.getDouble("Propina"));
                
                listaCuentas.agregar(c);
            }
            
        } catch (SQLException e) {
            System.err.println("Error al listar cuentas: " + e.getMessage());
        }
        return listaCuentas;
    }


    
    public boolean levantarCuentaTransaccional(int numeroMesa, String dpiMesero, double totalPagar, ListaDinamica<Object[]> detallesCarrito) {
        Connection conn = null;
        
        try {
            conn = conexion.Conexion.getConexion();
            conn.setAutoCommit(false); 

            String sqlCuenta = "INSERT INTO cuenta (Numero_Mesa, DPI_Mesero, Fecha_Hora_Ocupacion, Estado, Total_Pagar, Propina) VALUES (?, ?, NOW(), 'ABIERTA', ?, 0.00)";
            PreparedStatement psCuenta = conn.prepareStatement(sqlCuenta);
            psCuenta.setInt(1, numeroMesa);
            psCuenta.setString(2, dpiMesero);
            psCuenta.setDouble(3, totalPagar);
            psCuenta.executeUpdate();
            
            String sqlUltimoId = "SELECT MAX(ID_Cuenta) AS Ultimo_ID FROM cuenta";
            PreparedStatement psUltimoId = conn.prepareStatement(sqlUltimoId);
            ResultSet rsId = psUltimoId.executeQuery();
            
            int idCuentaGenerado = 0;
            if (rsId.next()) {
                idCuentaGenerado = rsId.getInt("Ultimo_ID");
            } else {
                throw new SQLException("No se pudo obtener el ID de la cuenta recién creada.");
            }

            //Crear la cuenta
            String sqlDetalle = "INSERT INTO detalle_cuenta (ID_Cuenta, Codigo_Producto, Cantidad, Subtotal) VALUES (?, ?, ?, ?)";
            PreparedStatement psDetalle = conn.prepareStatement(sqlDetalle);
            //Consultar la receta
            String sqlReceta = "SELECT Codigo_Insumo, Cantidad_Necesaria FROM receta WHERE Codigo_Producto = ?";
            PreparedStatement psReceta = conn.prepareStatement(sqlReceta);
            //Descontar los insumos
            String sqlInventario = "UPDATE insumo SET Stock_Actual = Stock_Actual - ? WHERE Codigo_Insumo = ?";
            PreparedStatement psInventario = conn.prepareStatement(sqlInventario);

            
            for (int i = 0; i < detallesCarrito.getTamaño(); i++) {
                Object[] fila = detallesCarrito.obtener(i);
                String codProducto = fila[0].toString();
                int cantidadPedida = Integer.parseInt(fila[1].toString());
                double subtotal = Double.parseDouble(fila[2].toString());

                // Guardar cuenta
                psDetalle.setInt(1, idCuentaGenerado);
                psDetalle.setString(2, codProducto);
                psDetalle.setInt(3, cantidadPedida);
                psDetalle.setDouble(4, subtotal);
                psDetalle.executeUpdate();

                // Buscar Receta 
                psReceta.setString(1, codProducto);
                ResultSet rsReceta = psReceta.executeQuery();
                
                //Descontar insumos
                while (rsReceta.next()) {
                    String codInsumo = rsReceta.getString("Codigo_Insumo");
                    double cantidadNecesaria = rsReceta.getDouble("Cantidad_Necesaria");
                    double totalADescontar = cantidadNecesaria * cantidadPedida;
                    
                    psInventario.setDouble(1, totalADescontar);
                    psInventario.setString(2, codInsumo);
                    psInventario.executeUpdate();
                }
            }

            //Cambiar el estado de la mesa
            String sqlMesa = "UPDATE mesa SET Estado = 'OCUPADA' WHERE Numero_Mesa = ?";
            PreparedStatement psMesa = conn.prepareStatement(sqlMesa);
            psMesa.setInt(1, numeroMesa);
            psMesa.executeUpdate();

            //Ejecutar transaccion
            conn.commit(); 
            return true;

        } catch (SQLException e) {
            System.err.println("Error en transacción. Aplicando Rollback: " + e.getMessage());
            try {
                if (conn != null) conn.rollback(); 
            } catch (SQLException ex) {
                System.err.println("Error al hacer rollback: " + ex.getMessage());
            }
            return false;
        } finally {
            try {
                if (conn != null) conn.setAutoCommit(true);
            } catch (SQLException e) {}
        }
    }
}