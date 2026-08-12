package entidades;

public class Nomina {
    
    private int codigoNomina;
    private String dpiEmpleado;
    private String fechaEmision;
    private TipoPago tipoPago;
    private double monto;
    private EstadoPago estadoPago;

    public Nomina() {
    }

    public Nomina(int codigoNomina, String dpiEmpleado, String fechaEmision, TipoPago tipoPago, double monto, EstadoPago estadoPago) {
        this.codigoNomina = codigoNomina;
        this.dpiEmpleado = dpiEmpleado;
        this.fechaEmision = fechaEmision;
        this.tipoPago = tipoPago;
        this.monto = monto;
        this.estadoPago = estadoPago;
    }

    public int getCodigoNomina() {
        return codigoNomina;
    }

    public void setCodigoNomina(int codigoNomina) {
        this.codigoNomina = codigoNomina;
    }

    public String getDpiEmpleado() {
        return dpiEmpleado;
    }

    public void setDpiEmpleado(String dpiEmpleado) {
        this.dpiEmpleado = dpiEmpleado;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public EstadoPago getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }
}