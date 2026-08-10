package acceso;

import conexion.Conexion;
import entidades.Producto;
import entidades.CategoriaProducto;
import entidades.Receta;
import estructuras.ListaDinamica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductoAcceso implements MantenimientoAcceso<Producto> {

    @Override
    public boolean insertar(Producto producto) {
      
        String sql = "INSERT INTO producto (Codigo_Producto, Nombre, Categoria, Precio_Venta, Fotografia) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, producto.getCodigoProducto());
            stmt.setString(2, producto.getNombre());
            stmt.setString(3, producto.getCategoria().name());
            stmt.setDouble(4, producto.getPrecioVenta());
            stmt.setString(5, producto.getFotografia());
            
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al insertar producto sin receta: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Producto producto) {
        String sql = "UPDATE producto SET Nombre = ?, Categoria = ?, Precio_Venta = ?, Fotografia = ? WHERE Codigo_Producto = ?";
        
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getCategoria().name());
            stmt.setDouble(3, producto.getPrecioVenta());
            stmt.setString(4, producto.getFotografia());
            stmt.setString(5, producto.getCodigoProducto());
            
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al actualizar producto: " + e.getMessage());
            return false;
        }
    }

    @Override
    public ListaDinamica<Producto> listarTodos() {
        ListaDinamica<Producto> listaProductos = new ListaDinamica<>();
        String sql = "SELECT * FROM producto";
        
        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                Producto p = new Producto();
                p.setCodigoProducto(rs.getString("Codigo_Producto"));
                p.setNombre(rs.getString("Nombre"));
                
                String catStr = rs.getString("Categoria");
                p.setCategoria(CategoriaProducto.valueOf(catStr)); 
                
                p.setPrecioVenta(rs.getDouble("Precio_Venta"));
                p.setFotografia(rs.getString("Fotografia"));
                
                listaProductos.agregar(p);
            }
            
        } catch (SQLException e) {
            System.err.println("Error al listar productos: " + e.getMessage());
        }
        return listaProductos;
    }


    public boolean registrarProductoConReceta(Producto producto, ListaDinamica<Receta> listaReceta) {
        String sqlProducto = "INSERT INTO producto (Codigo_Producto, Nombre, Categoria, Precio_Venta, Fotografia) VALUES (?, ?, ?, ?, ?)";
        String sqlReceta = "INSERT INTO receta (Codigo_Producto, Codigo_Insumo, Cantidad_Necesaria) VALUES (?, ?, ?)";
        
        Connection conn = null;
        
        try {
            conn = Conexion.getConexion();
            conn.setAutoCommit(false); 
            
            try (PreparedStatement stmtProd = conn.prepareStatement(sqlProducto)) {
                stmtProd.setString(1, producto.getCodigoProducto());
                stmtProd.setString(2, producto.getNombre());
                stmtProd.setString(3, producto.getCategoria().name());
                stmtProd.setDouble(4, producto.getPrecioVenta());
                stmtProd.setString(5, producto.getFotografia()); 
                stmtProd.executeUpdate();
            }
            
            if (listaReceta.getTamaño() > 0) {
                try (PreparedStatement stmtRec = conn.prepareStatement(sqlReceta)) {
                    for (int i = 0; i < listaReceta.getTamaño(); i++) {
                        Receta ingrediente = listaReceta.obtener(i);
                        stmtRec.setString(1, producto.getCodigoProducto());
                        stmtRec.setString(2, ingrediente.getCodigoInsumo());
                        stmtRec.setDouble(3, ingrediente.getCantidad());
                        stmtRec.executeUpdate();
                    }
                }
            }
            
            conn.commit();
            return true;
            
        } catch (SQLException e) {
            System.err.println("Error transaccional. Haciendo Rollback... " + e.getMessage());
            if (conn != null) {
                try { conn.rollback(); } catch (SQLException ex) { }
            }
            return false;
        } finally {
            if (conn != null) {
                try { conn.setAutoCommit(true); conn.close(); } catch (SQLException e) { }
            }
        }
    }
    
    
    public ListaDinamica<Producto> buscarPorNombre(String nombreBuscado) {
        ListaDinamica<Producto> lista = new ListaDinamica<>();
        String sql = "SELECT * FROM producto WHERE Nombre LIKE ?";
        
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, "%" + nombreBuscado + "%");
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    entidades.Producto p = new entidades.Producto();
                    p.setCodigoProducto(rs.getString("Codigo_Producto"));
                    p.setNombre(rs.getString("Nombre"));
                    p.setCategoria(entidades.CategoriaProducto.valueOf(rs.getString("Categoria")));
                    p.setPrecioVenta(rs.getDouble("Precio_Venta"));
                    p.setFotografia(rs.getString("Fotografia"));
                    lista.agregar(p);
                }
            }
        } catch (java.sql.SQLException e) {
            System.err.println("Error al buscar producto: " + e.getMessage());
        }
        return lista;
    }

    
    public ListaDinamica<Producto> filtrarPorCategoria(String categoria) {
        ListaDinamica<Producto> lista = new ListaDinamica<>();
        String sql = "SELECT * FROM producto WHERE Categoria = ?";
        
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, categoria);
            
            try (java.sql.ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    entidades.Producto p = new entidades.Producto();
                    p.setCodigoProducto(rs.getString("Codigo_Producto"));
                    p.setNombre(rs.getString("Nombre"));
                    p.setCategoria(entidades.CategoriaProducto.valueOf(rs.getString("Categoria")));
                    p.setPrecioVenta(rs.getDouble("Precio_Venta"));
                    p.setFotografia(rs.getString("Fotografia"));
                    lista.agregar(p);
                }
            }
        } catch (java.sql.SQLException e) {
            System.err.println("Error al filtrar producto: " + e.getMessage());
        }
        return lista;
    }
    
    
    public String obtenerRutaImagen(String codigoProducto) {
        String ruta = "";
        String sql = "SELECT Fotografia FROM producto WHERE Codigo_Producto = ?";
        
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, codigoProducto);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ruta = rs.getString("Fotografia");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al recuperar ruta de imagen: " + e.getMessage());
        }
        
        return ruta;
    }
}