package entidades;

import java.sql.Date;

public class Empleado {
    
    private String dpi;
    private String nombreCompleto;
    private String correo;
    private RolEmpleado rol;   
    private Jornada jornada;  
    private double salario;
    private Date fechaContratacion;
    private int estado;           
    
    
    public Empleado() {
    }

    public Empleado(String dpi, String nombreCompleto, String correo, RolEmpleado rol,Jornada jornada, double salario, Date fechaContratacion, int estado) {
        this.dpi = dpi;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.rol = rol;
        this.jornada = jornada;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
        this.estado = estado;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public RolEmpleado getRol() {
        return rol;
    }

    public void setRol(RolEmpleado rol) {
        this.rol = rol;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}