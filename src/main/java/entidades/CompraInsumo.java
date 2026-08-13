package entidades;

public class CompraInsumo {
    private int idCompra;
    private String codigoInsumo;
    private double cantidad;
    private double totalCompra;
    private String fechaCompra;

    public CompraInsumo() {}

    public CompraInsumo(int idCompra, String codigoInsumo, double cantidad, double totalCompra, String fechaCompra) {
        this.idCompra = idCompra;
        this.codigoInsumo = codigoInsumo;
        this.cantidad = cantidad;
        this.totalCompra = totalCompra;
        this.fechaCompra = fechaCompra;
    }

    public int getIdCompra() {
        return idCompra;
    }
    
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra; 
    }

    public String getCodigoInsumo() {
        return codigoInsumo;
    }
    
    public void setCodigoInsumo(String codigoInsumo) { 
        this.codigoInsumo = codigoInsumo;
    }
    
    public double getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(double cantidad) { 
        this.cantidad = cantidad; 
    }

    public double getTotalCompra() {
        return totalCompra;
    }
    
    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra; 
    }

    public String getFechaCompra() {
        return fechaCompra; 
    }
    
    public void setFechaCompra(String fechaCompra) { 
        this.fechaCompra = fechaCompra; 
    }
    
}