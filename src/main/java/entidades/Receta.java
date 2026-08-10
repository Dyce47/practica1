package entidades;

public class Receta {
    private String codigoProducto;
    private String codigoInsumo;
    private String nombreInsumo; 
    private String unidadMedida; 
    private double cantidad;

    public Receta() {
    }

    public Receta(String codigoProducto, String codigoInsumo, String nombreInsumo, String unidadMedida, double cantidad) {
        this.codigoProducto = codigoProducto;
        this.codigoInsumo = codigoInsumo;
        this.nombreInsumo = nombreInsumo;
        this.unidadMedida = unidadMedida;
        this.cantidad = cantidad;
    }

    
    public String getCodigoProducto() { 
        return codigoProducto; 
    }
    
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto; 
    }
    

    public String getCodigoInsumo() {
        return codigoInsumo; 
    }
    
    public void setCodigoInsumo(String codigoInsumo) {
        this.codigoInsumo = codigoInsumo; 
    }
    

    public String getNombreInsumo() { 
        return nombreInsumo;
    }
    
    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo; 
    }
    
    public String getUnidadMedida() {
        return unidadMedida; 
    }
    
    public void setUnidadMedida(String unidadMedida) { 
        this.unidadMedida = unidadMedida; 
    }

    public double getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}
