package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion{
    
    private static final String IP = "localhost";
    private static final int Puerto = 3306;
    private static final String Esquema = "JavaBeansCafe";
    private static final String USUARIO = "admin_guillermo"; 
    private static final String CONTRASENA = "YKMemo2047**";
    private static final String URL = "jdbc:mysql://" + IP + ":" + Puerto + "/" + Esquema;
    

    
    public static Connection getConexion() {
        Connection conexion = null;
        
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexion exitosa a la base de datos JavaBeansCafe");
            
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
        
        return conexion;
    }
}
