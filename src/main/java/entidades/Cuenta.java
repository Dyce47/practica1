package entidades;

public class Cuenta {
    
    private int idCuenta;
    private int numeroMesa;
    private String dpiMesero;
    private String fechaHoraOcupacion;
    private String fechaHoraLiberacion;
    private EstadoCuenta estado;
    private double totalPagar;
    private double propina;

    public Cuenta() {
    }

    public Cuenta(int idCuenta, int numeroMesa, String dpiMesero, String fechaHoraOcupacion, String fechaHoraLiberacion, EstadoCuenta estado, double totalPagar, double propina) {
        this.idCuenta = idCuenta;
        this.numeroMesa = numeroMesa;
        this.dpiMesero = dpiMesero;
        this.fechaHoraOcupacion = fechaHoraOcupacion;
        this.fechaHoraLiberacion = fechaHoraLiberacion;
        this.estado = estado;
        this.totalPagar = totalPagar;
        this.propina = propina;
    }


    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public String getDpiMesero() {
        return dpiMesero;
    }

    public void setDpiMesero(String dpiMesero) {
        this.dpiMesero = dpiMesero;
    }

    public String getFechaHoraOcupacion() {
        return fechaHoraOcupacion;
    }

    public void setFechaHoraOcupacion(String fechaHoraOcupacion) {
        this.fechaHoraOcupacion = fechaHoraOcupacion;
    }

    public String getFechaHoraLiberacion() {
        return fechaHoraLiberacion;
    }

    public void setFechaHoraLiberacion(String fechaHoraLiberacion) {
        this.fechaHoraLiberacion = fechaHoraLiberacion;
    }

    public EstadoCuenta getEstado() {
        return estado;
    }

    public void setEstado(EstadoCuenta estado) {
        this.estado = estado;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public double getPropina() {
        return propina;
    }

    public void setPropina(double propina) {
        this.propina = propina;
    }
}