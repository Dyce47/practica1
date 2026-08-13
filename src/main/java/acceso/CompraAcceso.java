package acceso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class CompraAcceso {

    public boolean registrarCompra(String codigoInsumo, double cantidad, double totalCompra) {
        Connection conn = null;
        try {
            conn = conexion.Conexion.getConexion();
            conn.setAutoCommit(false); 

            String sqlCompra = "INSERT INTO compra_insumo (Codigo_Insumo, Cantidad, Total_Compra, Fecha_Compra) VALUES (?, ?, ?, ?)";
            try (PreparedStatement psCompra = conn.prepareStatement(sqlCompra)) {
                psCompra.setString(1, codigoInsumo);
                psCompra.setDouble(2, cantidad);
                psCompra.setDouble(3, totalCompra);
                psCompra.setString(4, LocalDate.now().toString()); 
                psCompra.executeUpdate();
            }

            String sqlInventario = "UPDATE insumo SET Stock_Actual = Stock_Actual + ? WHERE Codigo_Insumo = ?";
            try (PreparedStatement psInventario = conn.prepareStatement(sqlInventario)) {
                psInventario.setDouble(1, cantidad);
                psInventario.setString(2, codigoInsumo);
                psInventario.executeUpdate();
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            System.err.println("Error al registrar compra: " + e.getMessage());
            try {
                if (conn != null) conn.rollback(); 
            } catch (SQLException ex) {}
            return false;
        } finally {
            try { 
                if (conn != null) conn.setAutoCommit(true); 
            } catch (SQLException e) {}
        }
    }
}