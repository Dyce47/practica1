package reportes; 

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Desktop;

public class GeneradorReportes {

    public void generarReporteFlujoCaja(String fechaInicio, String fechaFin) {
        double totalIngresos = 0.0;
        double totalNominas = 0.0;
        double totalCompras = 0.0;
        String tituloFecha = "Histórico Completo";

        boolean usarFiltro = (fechaInicio != null && !fechaInicio.isEmpty() && fechaFin != null && !fechaFin.isEmpty());
        
        if (usarFiltro) {
            tituloFecha = "Del " + fechaInicio + " al " + fechaFin;
        }

        try (Connection conn = conexion.Conexion.getConexion()) {
            
            //Ingresos
            String sqlCuentas = "SELECT Total_Pagar, Propina, Fecha_Hora_Liberacion FROM cuenta WHERE Estado = 'PAGADA'";
            try (PreparedStatement ps = conn.prepareStatement(sqlCuentas); 
                ResultSet rs = ps.executeQuery()) {
                
                while (rs.next()) {
                    double total = rs.getDouble("Total_Pagar");
                    double propina = rs.getDouble("Propina");
                    String fechaHora = rs.getString("Fecha_Hora_Liberacion");
                    
                    if (usarFiltro) {
                        String soloFecha = fechaHora.substring(0, 10);
                        if (soloFecha.compareTo(fechaInicio) >= 0 && soloFecha.compareTo(fechaFin) <= 0) {
                            totalIngresos = totalIngresos + (total - propina);
                        }
                    } else {
                        totalIngresos = totalIngresos + (total - propina);
                    }
                }
            }

            //Egresos
            String sqlNominas = "SELECT Monto, Fecha_Emision FROM nomina WHERE Estado_Pago = 'PAGADO'";
            try (PreparedStatement ps = conn.prepareStatement(sqlNominas); ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    double monto = rs.getDouble("Monto");
                    String fecha = rs.getString("Fecha_Emision");
                    
                    if (usarFiltro) {
                        if (fecha.compareTo(fechaInicio) >= 0 && fecha.compareTo(fechaFin) <= 0) {
                            totalNominas = totalNominas + monto;
                        }
                    } else {
                        totalNominas = totalNominas + monto;
                    }
                }
            }

            String sqlCompras = "SELECT Total_Compra, Fecha_Compra FROM compra_insumo";
            try (PreparedStatement ps = conn.prepareStatement(sqlCompras); ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    double montoCompra = rs.getDouble("Total_Compra");
                    String fecha = rs.getString("Fecha_Compra");
                    
                    if (usarFiltro) {
                        if (fecha.compareTo(fechaInicio) >= 0 && fecha.compareTo(fechaFin) <= 0) {
                            totalCompras = totalCompras + montoCompra;
                        }
                    } else {
                        totalCompras = totalCompras + montoCompra;
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al extraer datos para el reporte: " + e.getMessage());
            return;
        }

        double totalEgresos = totalNominas + totalCompras;
        double balanceFinal = totalIngresos - totalEgresos;
        String estadoBalance = (balanceFinal >= 0) ? "<span style='color:green; font-weight:bold;'>GANANCIA</span>" : "<span style='color:red; font-weight:bold;'>PÉRDIDA</span>";

        
        StringBuilder html = new StringBuilder();
        
        html.append("<html><head><title>Flujo de Caja</title></head>");
        html.append("<body style='font-family: Arial, sans-serif; margin: 20px;'>");
        
        html.append("<h2>Reporte de Flujo de Caja</h2>");
        html.append("<h3>Período: ").append(tituloFecha).append("</h3>");
        
        //Tabla
        html.append("<table border='1' style='border-collapse: collapse; width: 600px; text-align: left; padding: 5px;'>");
        html.append("<tr style='background-color: #f2f2f2;'><th>Concepto</th><th>Monto (Q)</th></tr>");
        
        // Filas de datos 
        html.append("<tr><td>Total Ingresos (Ventas netas)</td><td style='color: green;'>+ Q ").append(String.format("%.2f", totalIngresos)).append("</td></tr>");
        html.append("<tr><td>Egresos por Pago de Nóminas</td><td style='color: red;'>- Q ").append(String.format("%.2f", totalNominas)).append("</td></tr>");
        html.append("<tr><td>Egresos por Compra de Insumos</td><td style='color: red;'>- Q ").append(String.format("%.2f", totalCompras)).append("</td></tr>");       
        html.append("<tr><td><b>TOTAL EGRESOS</b></td><td style='color: red;'><b>- Q ").append(String.format("%.2f", totalEgresos)).append("</b></td></tr>");
        html.append("</table>");
        
        //Colores
        String colorBalance = (balanceFinal >= 0) ? "green" : "red";
        String textoBalance = (balanceFinal >= 0) ? "GANANCIA" : "PÉRDIDA";
        

        html.append("<br>");
        html.append("<div style='padding: 10px; border: 1px solid black; width: 580px; background-color: #e6e6e6;'>");
        html.append("<b>BALANCE FINAL (").append(textoBalance).append("): </b>");
        html.append("<span style='color: ").append(colorBalance).append(";'><b>Q ").append(String.format("%.2f", balanceFinal)).append("</b></span>");
        html.append("</div>");
        
        html.append("</body></html>");
        
        //Guardar
        try {
            File archivo = new File("Reporte_Flujo_Caja.html");
            FileWriter writer = new FileWriter(archivo);
            writer.write(html.toString());
            writer.close();
            
            java.awt.Desktop.getDesktop().browse(archivo.toURI());
            
        } catch (IOException e) {
            System.err.println("Error al generar el archivo HTML: " + e.getMessage());
        }
    }
    
    
    
    public void generarReporteProductosMasVendidos(String fechaInicio, String fechaFin) {
        int cantidadProductos = 0;
        String tituloFecha = "Histórico Completo";
        boolean usarFiltro = (fechaInicio != null && !fechaInicio.isEmpty() && fechaFin != null && !fechaFin.isEmpty());
        
        if (usarFiltro) {
            tituloFecha = "Del " + fechaInicio + " al " + fechaFin;
        }

        try (java.sql.Connection conn = conexion.Conexion.getConexion()) {
            
            String sqlCount = "SELECT COUNT(*) FROM producto";
            try (PreparedStatement ps = conn.prepareStatement(sqlCount); 
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()){
                    cantidadProductos = rs.getInt(1);
                }
            }

            if (cantidadProductos == 0){
                return;
            }

            String[] codigos = new String[cantidadProductos];
            String[] nombres = new String[cantidadProductos];
            int[] ventasTotales = new int[cantidadProductos];

            String sqlProd = "SELECT Codigo_Producto, Nombre FROM producto";
            try (PreparedStatement ps = conn.prepareStatement(sqlProd);
                ResultSet rs = ps.executeQuery()) {
                int indice = 0;
                while (rs.next()) {
                    codigos[indice] = rs.getString("Codigo_Producto");
                    nombres[indice] = rs.getString("Nombre");
                    ventasTotales[indice] = 0;
                    indice++;
                }
            }

            String sqlDetalles = "SELECT ID_Cuenta, Codigo_Producto, Cantidad FROM detalle_cuenta";
            try (java.sql.PreparedStatement psDet = conn.prepareStatement(sqlDetalles); java.sql.ResultSet rsDet = psDet.executeQuery()) {
                while (rsDet.next()) {
                    int idCuenta = rsDet.getInt("ID_Cuenta");
                    String codProd = rsDet.getString("Codigo_Producto");
                    int cantidad = rsDet.getInt("Cantidad");

                    boolean cuentaValida = false;
                    String sqlCuenta = "SELECT Estado, Fecha_Hora_Liberacion FROM cuenta WHERE ID_Cuenta = " + idCuenta;
                    
                    try (java.sql.PreparedStatement psCta = conn.prepareStatement(sqlCuenta); java.sql.ResultSet rsCta = psCta.executeQuery()) {
                        if (rsCta.next() && rsCta.getString("Estado").equals("PAGADA")) {
                            
                            if (usarFiltro) {
                                String fechaHora = rsCta.getString("Fecha_Hora_Liberacion");
                                String soloFecha = fechaHora.substring(0, 10);
                                if (soloFecha.compareTo(fechaInicio) >= 0 && soloFecha.compareTo(fechaFin) <= 0) {
                                    cuentaValida = true;
                                }
                            } else {
                                cuentaValida = true; 
                            }
                        }
                    }

                    if (cuentaValida) {
                        for (int j = 0; j < cantidadProductos; j++) {
                            if (codigos[j].equals(codProd)) {
                                ventasTotales[j] = ventasTotales[j] + cantidad;
                                break; 
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < cantidadProductos - 1; i++) {
                for (int j = 0; j < cantidadProductos - 1 - i; j++) {
                    if (ventasTotales[j] < ventasTotales[j + 1]) {
                        int tempVentas = ventasTotales[j];
                        ventasTotales[j] = ventasTotales[j + 1];
                        ventasTotales[j + 1] = tempVentas;

                        String tempNombre = nombres[j];
                        nombres[j] = nombres[j + 1];
                        nombres[j + 1] = tempNombre;

                        String tempCodigo = codigos[j];
                        codigos[j] = codigos[j + 1];
                        codigos[j + 1] = tempCodigo;
                    }
                }
            }

            StringBuilder html = new StringBuilder();
            html.append("<html><head><title>Productos Más Vendidos</title></head>");
            html.append("<body style='font-family: Arial, sans-serif; margin: 20px;'>");
            
            html.append("<h2>Ranking: Productos Más Vendidos</h2>");
            html.append("<h3>Período: ").append(tituloFecha).append("</h3>");
            
            html.append("<table border='1' style='border-collapse: collapse; width: 600px; text-align: left; padding: 5px;'>");
            html.append("<tr style='background-color: #f2f2f2;'><th>Posición</th><th>Producto</th><th>Total de Unidades Vendidas</th></tr>");

            boolean hayDatos = false;
            int posicion = 1;

            for (int k = 0; k < cantidadProductos; k++) {
                if (ventasTotales[k] > 0) {
                    hayDatos = true;
                    html.append("<tr>");
                    html.append("<td><b>#").append(posicion).append("</b></td>");
                    html.append("<td>").append(nombres[k]).append("</td>");
                    html.append("<td>").append(ventasTotales[k]).append(" unidades</td>");
                    html.append("</tr>");
                    posicion++;
                }
            }
            
            if (!hayDatos) {
                html.append("<tr><td colspan='3' style='text-align:center;'>No hay ventas registradas en este período.</td></tr>");
            }

            html.append("</table></body></html>");

            java.io.File archivo = new java.io.File("Reporte_Productos_Vendidos.html");
            java.io.FileWriter writer = new java.io.FileWriter(archivo);
            writer.write(html.toString());
            writer.close();
            java.awt.Desktop.getDesktop().browse(archivo.toURI());

        } catch (java.sql.SQLException | java.io.IOException e) {
            System.err.println("Error al generar reporte: " + e.getMessage());
        }
    }
    
    
    public void generarReporteBajoStock() {
        StringBuilder html = new StringBuilder();

        html.append("<html><head><title>Alerta de Inventario</title></head>");
        html.append("<body style='font-family: Arial, sans-serif; margin: 20px;'>");
        
        html.append("<h2>Alerta: Insumos con Bajo Stock</h2>");
        html.append("<p>Los siguientes insumos han alcanzado o superado su límite mínimo. Se requiere abastecimiento inmediato.</p>");
        
        html.append("<table border='1' style='border-collapse: collapse; width: 700px; text-align: left; padding: 5px;'>");
        html.append("<tr style='background-color: #f2f2f2;'><th>Código</th><th>Insumo</th><th>Stock Actual</th><th>Mínimo Permitido</th><th>Unidad de medida</th><th>Estado</th></tr>");

        try (Connection conn = conexion.Conexion.getConexion()) {
            String sql = "SELECT Codigo_Insumo, Nombre, Unidad_Medida, Stock_Actual, Stock_Minimo " + "FROM insumo WHERE Stock_Actual <= Stock_Minimo " + "ORDER BY Stock_Actual ASC";

            try (PreparedStatement ps = conn.prepareStatement(sql); java.sql.ResultSet rs = ps.executeQuery()) {
                boolean hayDatos = false;
                
                while (rs.next()) {
                    hayDatos = true;
                    String codigo = rs.getString("Codigo_Insumo");
                    String nombre = rs.getString("Nombre");
                    String um = rs.getString("Unidad_Medida");
                    double actual = rs.getDouble("Stock_Actual");
                    double minimo = rs.getDouble("Stock_Minimo");
                    
                    html.append("<tr>");
                    html.append("<td>").append(codigo).append("</td>");
                    html.append("<td>").append(nombre).append("</td>");
                    
                    html.append("<td style='color: red;'><b>").append(actual).append("</b></td>");
                    html.append("<td>").append(minimo).append("</td>");
                    html.append("<td>").append(um).append("</td>");
                    
                    if (actual == 0) {
                        html.append("<td style='color: red;'><b>AGOTADO</b></td>");
                    } else {
                        html.append("<td style='color: orange;'><b>POR AGOTARSE</b></td>");
                    }
                    html.append("</tr>");
                }
                
                if (!hayDatos) {
                    html.append("<tr><td colspan='6' style='text-align:center; color: green;'><b>El inventario está en óptimas condiciones. Ningún insumo reporta bajo stock.</b></td></tr>");
                }
            }
        } catch (java.sql.SQLException e) {
            System.err.println("Error al extraer datos de inventario: " + e.getMessage());
        }

        html.append("</table></body></html>");


        try {
            File archivo = new File("Reporte_Bajo_Stock.html");
            FileWriter writer = new FileWriter(archivo);
            writer.write(html.toString());
            writer.close();
            
            java.awt.Desktop.getDesktop().browse(archivo.toURI());
        } catch (java.io.IOException e) {
            System.err.println("Error al generar el archivo HTML: " + e.getMessage());
        }
    }
    
    
    public void generarMenuHTML() {
        StringBuilder html = new StringBuilder();
        
        html.append("<!DOCTYPE html><html><head><meta charset='UTF-8'><title>Menú del Restaurante</title>");
        html.append("<style>");
        html.append("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f4f6f8; color: #333; margin: 0; padding: 30px 10px; }");
        html.append(".menu-container { max-width: 900px; margin: 0 auto; background: #fff; padding: 40px; border-radius: 10px; box-shadow: 0 4px 15px rgba(0,0,0,0.05); }");
        html.append(".header { text-align: center; margin-bottom: 40px; }");
        html.append("h1 { color: #2c3e50; font-size: 2.5em; margin: 0; text-transform: uppercase; letter-spacing: 1px; }");
        html.append(".subtitle { color: #7f8c8d; font-size: 1.1em; margin-top: 5px; }");
        html.append("h2 { color: #d35400; border-bottom: 2px solid #ecf0f1; padding-bottom: 8px; margin-top: 40px; font-size: 1.5em; text-transform: uppercase; }");
        
        html.append(".grid { display: flex; flex-wrap: wrap; gap: 20px; margin-top: 20px; }");
        html.append(".card { display: flex; align-items: center; background: #fff; border: 1px solid #ecf0f1; border-radius: 8px; padding: 15px; width: 48%; box-sizing: border-box; transition: transform 0.2s; }");
        html.append(".card:hover { transform: translateY(-3px); box-shadow: 0 4px 10px rgba(0,0,0,0.08); }");
        html.append(".card img { width: 90px; height: 90px; object-fit: cover; border-radius: 6px; margin-right: 15px; background: #f9f9f9; border: 1px solid #eee; }");
        
        html.append(".info { flex: 1; }");
        html.append(".name { display: block; font-size: 1.2em; font-weight: bold; color: #2c3e50; margin-bottom: 6px; }");
        html.append(".price { display: inline-block; font-size: 1.1em; color: #27ae60; font-weight: bold; background: #eafaf1; padding: 4px 8px; border-radius: 4px; }");
        
        html.append("@media (max-width: 768px) { .card { width: 100%; } }"); 
        html.append("</style></head><body>");

        html.append("<div class='menu-container'>");
        html.append("<div class='header'>");
        html.append("<h1>JavaBeans Café</h1>");
        html.append("<div class='subtitle'>Selección de calidad para nuestros clientes</div>");
        html.append("</div>");

        try (java.sql.Connection conn = conexion.Conexion.getConexion()) {
            
            String sql = "SELECT Nombre, Categoria, Precio_Venta, Fotografia FROM producto ORDER BY Categoria, Nombre";

            try (java.sql.PreparedStatement ps = conn.prepareStatement(sql); java.sql.ResultSet rs = ps.executeQuery()) {
                String categoriaActual = "";
                boolean hayDatos = false;
                
                while (rs.next()) {
                    hayDatos = true;
                    String nombre = rs.getString("Nombre");
                    String categoria = rs.getString("Categoria");
                    double precio = rs.getDouble("Precio_Venta");
                    String fotografia = rs.getString("Fotografia"); 
                    
                    if (!categoria.equals(categoriaActual)) {
                        if (!categoriaActual.isEmpty()) {
                            html.append("</div>"); 
                        }
                        categoriaActual = categoria;
                        html.append("<h2>").append(categoria).append("</h2>");
                        html.append("<div class='grid'>"); 
                    }
                    
                    html.append("<div class='card'>");
                    
                    if (fotografia != null && !fotografia.trim().isEmpty()) {
                        html.append("<img src='").append(fotografia).append("' alt='").append(nombre).append("'>");
                    } else {
                        html.append("<div style='width:90px; height:90px; margin-right:15px; background:#eee; border-radius:6px; display:flex; align-items:center; justify-content:center; color:#999; font-size:0.8em; text-align:center;'>Sin<br>Foto</div>");
                    }
                    
                    html.append("<div class='info'>");
                    html.append("<span class='name'>").append(nombre).append("</span>");
                    html.append("<span class='price'>Q ").append(String.format("%.2f", precio)).append("</span>");
                    html.append("</div>"); 
                    
                    html.append("</div>");
                }
                
                if (hayDatos) {
                    html.append("</div>"); 
                } else {
                    html.append("<p style='text-align:center; color:#7f8c8d;'>Aún no hay productos registrados en el menú.</p>");
                }
            }
        } catch (java.sql.SQLException e) {
            System.err.println("Error al extraer datos del menú: " + e.getMessage());
        }

        html.append("</div></body></html>");

        try {
            File archivo = new File("Menu_Restaurante.html");
            FileWriter writer = new FileWriter(archivo);
            writer.write(html.toString());
            writer.close();
            java.awt.Desktop.getDesktop().browse(archivo.toURI());
        } catch (java.io.IOException e) {
            System.err.println("Error al generar el menú HTML: " + e.getMessage());
        }
    }
}