package acceso;

import conexion.Conexion;
import entidades.Empleado;
import entidades.RolEmpleado;
import estructuras.ListaDinamica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmpleadoAcceso implements MantenimientoAcceso<Empleado> {

    @Override
    public boolean insertar(Empleado empleado) {

        String sql = "INSERT INTO empleado (DPI, Nombre_Completo, Correo, Rol, Jornada, Salario, Fecha_Contratacion, Estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
                        
            stmt.setString(1, empleado.getDpi());
            stmt.setString(2, empleado.getNombreCompleto());
            stmt.setString(3, empleado.getCorreo());
                       
            stmt.setString(4, empleado.getRol().name()); 
            stmt.setString(5, empleado.getJornada().name());
            
            stmt.setDouble(6, empleado.getSalario());
            stmt.setDate(7, empleado.getFechaContratacion());
            stmt.setInt(8, empleado.getEstado());
            
            
            int filasAfectadas = stmt.executeUpdate();
            
            
            return filasAfectadas > 0; 
            
        } catch (SQLException e) {
            System.err.println("Error al insertar el empleado: " + e.getMessage());
            return false;
        }
    }

    
    @Override
    public boolean actualizar(Empleado empleado) {
        String sql = "UPDATE empleado SET Nombre_Completo = ?, Correo = ?, Rol = ?, Jornada = ?, Salario = ?, Fecha_Contratacion = ?, Estado = ? WHERE DPI = ?";
        
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, empleado.getNombreCompleto());
            stmt.setString(2, empleado.getCorreo());
            stmt.setString(3, empleado.getRol().name());
            stmt.setString(4, empleado.getJornada().name());
            stmt.setDouble(5, empleado.getSalario());
            stmt.setDate(6, empleado.getFechaContratacion());
            stmt.setInt(7, empleado.getEstado());
            
            stmt.setString(8, empleado.getDpi());
            
            int filasAfectadas = stmt.executeUpdate();
            
            return filasAfectadas > 0; 
            
        } catch (SQLException e) {
            System.err.println("Error al actualizar el empleado: " + e.getMessage());
            return false;
        }
    }


    @Override
    public ListaDinamica<Empleado> listarTodos() {
        ListaDinamica<Empleado> listaEmpleados = new ListaDinamica<>();
        String sql = "SELECT * FROM empleado"; 
        
      
        try (Connection conn = Conexion.getConexion();
             java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(sql)) {
                        
            while (rs.next()) {
                
                String dpi = rs.getString("DPI");
                String nombre = rs.getString("Nombre_Completo");
                String correo = rs.getString("Correo");
                
                entidades.RolEmpleado rol = entidades.RolEmpleado.valueOf(rs.getString("Rol"));
                entidades.Jornada jornada = entidades.Jornada.valueOf(rs.getString("Jornada"));
                
                double salario = rs.getDouble("Salario");
                java.sql.Date fecha = rs.getDate("Fecha_Contratacion");
                int estado = rs.getInt("Estado");
                
                entidades.Empleado emp = new entidades.Empleado(dpi, nombre, correo, rol, jornada, salario, fecha, estado);
                
                listaEmpleados.agregar(emp);
            }
            
        } catch (SQLException e) {
            System.err.println("Error al listar empleados: " + e.getMessage());
        }
        
        return listaEmpleados;
    }
    

    public Empleado buscarPorDpi(String dpiBuscado) {
        String sql = "SELECT * FROM empleado WHERE DPI = ?";
        Empleado empEncontrado = null; 

        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, dpiBuscado);
            
            try (ResultSet rs = stmt.executeQuery()) {
                
                if (rs.next()) {
                    String nombre = rs.getString("Nombre_Completo");
                    String correo = rs.getString("Correo");
                    RolEmpleado rol = RolEmpleado.valueOf(rs.getString("Rol"));
                    entidades.Jornada jornada = entidades.Jornada.valueOf(rs.getString("Jornada"));
                    double salario = rs.getDouble("Salario");
                    java.sql.Date fecha = rs.getDate("Fecha_Contratacion");
                    int estado = rs.getInt("Estado");
                    
                    empEncontrado = new entidades.Empleado(dpiBuscado, nombre, correo, rol, jornada, salario, fecha, estado);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error al buscar por DPI: " + e.getMessage());
        }
        
        return empEncontrado; 
    }
    
    
    public ListaDinamica<Empleado> filtrarEmpleados(String columna, String valorFiltro) {
        ListaDinamica<Empleado> listaFiltrada = new ListaDinamica<>();
        

        String sql = "SELECT * FROM empleado WHERE " + columna + " = ?";
        
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, valorFiltro);
            
            try (java.sql.ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String dpi = rs.getString("DPI");
                    String nombre = rs.getString("Nombre_Completo");
                    String correo = rs.getString("Correo");
                    entidades.RolEmpleado rol = entidades.RolEmpleado.valueOf(rs.getString("Rol"));
                    entidades.Jornada jornada = entidades.Jornada.valueOf(rs.getString("Jornada"));
                    double salario = rs.getDouble("Salario");
                    java.sql.Date fecha = rs.getDate("Fecha_Contratacion");
                    int estado = rs.getInt("Estado");
                    
                    entidades.Empleado emp = new entidades.Empleado(dpi, nombre, correo, rol, jornada, salario, fecha, estado);
                    listaFiltrada.agregar(emp);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al filtrar: " + e.getMessage());
        }
        
        return listaFiltrada;
    }
    
    
    public ListaDinamica<Empleado> listarMeserosActivos() {
        ListaDinamica<Empleado> listaMeseros = new ListaDinamica<>();
        
        String sql = "SELECT DPI, Nombre_Completo FROM empleado WHERE Rol = 'MESERO' AND Estado = 1";
        
        try (Connection conn = conexion.Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setDpi(rs.getString("DPI"));
                emp.setNombreCompleto(rs.getString("Nombre_Completo"));            
                listaMeseros.agregar(emp);
            }
            
        } catch (java.sql.SQLException e) {
            System.err.println("Error al extraer meseros: " + e.getMessage());
        }
        
        return listaMeseros;
    }
}