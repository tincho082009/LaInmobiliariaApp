package com.example.inmobiliaria.modelos;

public class Inquilino {
    private String dni;
    private String apellido;
    private String nombre;
    private String trabajo;
    private String dniGarante;
    private String nombreGarante;

    public Inquilino(String dni, String apellido, String nombre, String trabajo, String dniGarante, String nombreGarante) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.trabajo = trabajo;
        this.dniGarante = dniGarante;
        this.nombreGarante = nombreGarante;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getDniGarante() {
        return dniGarante;
    }

    public void setDniGarante(String dniGarante) {
        this.dniGarante = dniGarante;
    }

    public String getNombreGarante() {
        return nombreGarante;
    }

    public void setNombreGarante(String nombreGarante) {
        this.nombreGarante = nombreGarante;
    }
}
