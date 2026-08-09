package entidades;

public class Insumo {
    
    private String codigoInsumo;
    private String nombre;
    private String unidadMedida;
    private double costo;
    private double stockActual;
    private double stockMinimo;

    public Insumo() {
    }

    public Insumo(String codigoInsumo, String nombre, String unidadMedida, double costo, double stockActual, double stockMinimo) {
        this.codigoInsumo = codigoInsumo;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.costo = costo;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
    }


    public String getCodigoInsumo() {
        return codigoInsumo;
    }

    public void setCodigoInsumo(String codigoInsumo) {
        this.codigoInsumo = codigoInsumo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getStockActual() {
        return stockActual;
    }

    public void setStockActual(double stockActual) {
        this.stockActual = stockActual;
    }

    public double getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(double stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
}