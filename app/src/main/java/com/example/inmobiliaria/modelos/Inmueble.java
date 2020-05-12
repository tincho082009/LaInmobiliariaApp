package com.example.inmobiliaria.modelos;

public class Inmueble {
    private String direccion;
    private int cantAmbientes;
    private String tipo;
    private String uso;
    private double precio;
    private boolean estado;
    private int propietarioId;
    private boolean alquilada;

    public Inmueble() {

    }
    public Inmueble(String direccion, int cantAmbientes, String tipo, String uso, double precio, boolean estado, int propietarioId, boolean alquilada) {
        this.direccion = direccion;
        this.cantAmbientes = cantAmbientes;
        this.tipo = tipo;
        this.uso = uso;
        this.precio = precio;
        this.estado = estado;
        this.propietarioId = propietarioId;
        this.alquilada = alquilada;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantAmbientes() {
        return cantAmbientes;
    }

    public void setCantAmbientes(int cantAmbientes) {
        this.cantAmbientes = cantAmbientes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getPropietarioId() {
        return propietarioId;
    }

    public void setPropietarioId(int propietarioId) {
        this.propietarioId = propietarioId;
    }

    public boolean isAlquilada() {
        return alquilada;
    }

    public void setAlquilada(boolean alquilada) {
        this.alquilada = alquilada;
    }
}
