package acceso;

import entidades.Mesa;
import entidades.EstadoMesa;
import estructuras.ListaDinamica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MesaAcceso implements MantenimientoAcceso<Mesa> {

    @Override
    public boolean insertar(Mesa objeto) {
     
        String sql = "INSERT INTO mesa (Numero_Mesa, Capacidad, Estado) VALUES (?, ?, ?)";
        
        try (Connection conn = conexion.Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, objeto.getNumeroMesa());
            stmt.setInt(2, objeto.getCapacidad());
            stmt.setString(3, objeto.getEstado().name()); 
            
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al registrar mesa: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Mesa objeto) {

        String sql = "UPDATE mesa SET Capacidad = ?, Estado = ? WHERE Numero_Mesa = ?";
        
        try (Connection conn = conexion.Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, objeto.getCapacidad());
            stmt.setString(2, objeto.getEstado().name());
            stmt.setInt(3, objeto.getNumeroMesa());
            
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al actualizar mesa: " + e.getMessage());
            return false;
        }
    }

    @Override
    public ListaDinamica<Mesa> listarTodos() {
        ListaDinamica<Mesa> listaMesas = new ListaDinamica<>();
        String sql = "SELECT * FROM mesa ORDER BY Numero_Mesa ASC"; 
        
        try (Connection conn = conexion.Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                Mesa mesa = new Mesa();
                mesa.setNumeroMesa(rs.getInt("Numero_Mesa"));
                mesa.setCapacidad(rs.getInt("Capacidad"));
                String estadoStr = rs.getString("Estado").toUpperCase();
                mesa.setEstado(EstadoMesa.valueOf(estadoStr));
                
                listaMesas.agregar(mesa);
            }
            
        } catch (SQLException e) {
            System.err.println("Error al listar mesas: " + e.getMessage());
        }
        
        return listaMesas;
    }
    
    public Mesa buscarPorNumero(int numeroMesa) {
        Mesa mesaEncontrada = null;
        String sql = "SELECT * FROM mesa WHERE Numero_Mesa = ?";
        
        try (Connection conn = conexion.Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, numeroMesa);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    mesaEncontrada = new Mesa();
                    mesaEncontrada.setNumeroMesa(rs.getInt("Numero_Mesa"));
                    mesaEncontrada.setCapacidad(rs.getInt("Capacidad"));
                    mesaEncontrada.setEstado(EstadoMesa.valueOf(rs.getString("Estado").toUpperCase()));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar mesa: " + e.getMessage());
        }
        return mesaEncontrada;
    }
}