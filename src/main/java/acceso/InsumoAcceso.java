package acceso;

import conexion.Conexion;
import entidades.Insumo;
import estructuras.ListaDinamica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsumoAcceso implements MantenimientoAcceso<Insumo> {

    @Override
    public boolean insertar(Insumo insumo) {
        String sql = "INSERT INTO insumo (Codigo_Insumo, Nombre, Unidad_Medida, Stock_Actual, Stock_Minimo, Costo) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, insumo.getCodigoInsumo());
            stmt.setString(2, insumo.getNombre());
            stmt.setString(3, insumo.getUnidadMedida());
            stmt.setDouble(4, insumo.getStockActual());
            stmt.setDouble(5, insumo.getStockMinimo());
            stmt.setDouble(6, insumo.getCosto());
            
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al insertar el insumo: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Insumo insumo) {
        String sql = "UPDATE insumo SET Nombre = ?, Unidad_Medida = ?, Stock_Actual = ?, Stock_Minimo = ?, Costo = ? WHERE Codigo_Insumo = ?";
        
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, insumo.getNombre());
            stmt.setString(2, insumo.getUnidadMedida());
            stmt.setDouble(3, insumo.getStockActual());
            stmt.setDouble(4, insumo.getStockMinimo());
            stmt.setDouble(5, insumo.getCosto());
            
            stmt.setString(6, insumo.getCodigoInsumo());
            
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al actualizar el insumo: " + e.getMessage());
            return false;
        }
    }

    @Override
    public ListaDinamica<Insumo> listarTodos() {
        ListaDinamica<Insumo> listaInsumos = new ListaDinamica<>();
        String sql = "SELECT * FROM insumo"; 
        
        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
                        
            while (rs.next()) {
                String codigo = rs.getString("Codigo_Insumo");
                String nombre = rs.getString("Nombre");
                String unidad = rs.getString("Unidad_Medida");
                double stockActual = rs.getDouble("Stock_Actual");
                double stockMinimo = rs.getDouble("Stock_Minimo");
                double costo = rs.getDouble("Costo");
                
                Insumo insumo = new Insumo(codigo, nombre, unidad, costo, stockActual, stockMinimo);
                listaInsumos.agregar(insumo);
            }
            
        } catch (SQLException e) {
            System.err.println("Error al listar insumos: " + e.getMessage());
        }
        
        return listaInsumos;
    }


    public boolean abastecerInsumo(String codigo, double cantidadComprada) {
        
        String sql = "UPDATE insumo SET Stock_Actual = Stock_Actual + ? WHERE Codigo_Insumo = ?";
        
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setDouble(1, cantidadComprada);
            stmt.setString(2, codigo);
            
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al abastecer el insumo: " + e.getMessage());
            return false;
        }
    }
    

    public ListaDinamica<Insumo> buscarPorNombre(String nombreBuscado) {
        ListaDinamica<Insumo> listaResultados = new ListaDinamica<>();
        
        String sql = "SELECT * FROM insumo WHERE Nombre LIKE ?";
        
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, "%" + nombreBuscado + "%");
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String codigo = rs.getString("Codigo_Insumo");
                    String nombre = rs.getString("Nombre");
                    String unidad = rs.getString("Unidad_Medida");
                    double stockActual = rs.getDouble("Stock_Actual");
                    double stockMinimo = rs.getDouble("Stock_Minimo");
                    double costo = rs.getDouble("Costo");
                    
                    Insumo insumo = new Insumo(codigo, nombre, unidad, costo, stockActual, stockMinimo);
                    listaResultados.agregar(insumo);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar por nombre: " + e.getMessage());
        }
        
        return listaResultados;
    }


    public ListaDinamica<Insumo> filtrarPorStock(String criterio) {
        ListaDinamica<Insumo> listaResultados = new ListaDinamica<>();
        String sql = "";
        
        
        switch (criterio) {
            case "Mayor":
                
                sql = "SELECT * FROM insumo ORDER BY Stock_Actual DESC";
                break;
            case "Menor":
                
                sql = "SELECT * FROM insumo ORDER BY Stock_Actual ASC";
                break;
            case "Alerta":
                
                sql = "SELECT * FROM insumo WHERE Stock_Actual <= Stock_Minimo";
                break;
            default:
                sql = "SELECT * FROM insumo";
                break;
        }
        
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                String codigo = rs.getString("Codigo_Insumo");
                String nombre = rs.getString("Nombre");
                String unidad = rs.getString("Unidad_Medida");
                double stockActual = rs.getDouble("Stock_Actual");
                double stockMinimo = rs.getDouble("Stock_Minimo");
                double costo = rs.getDouble("Costo");
                
                Insumo insumo = new Insumo(codigo, nombre, unidad, costo, stockActual, stockMinimo);
                listaResultados.agregar(insumo);
            }
        } catch (SQLException e) {
            System.err.println("Error al filtrar por stock: " + e.getMessage());
        }
        
        return listaResultados;
    }
    
}