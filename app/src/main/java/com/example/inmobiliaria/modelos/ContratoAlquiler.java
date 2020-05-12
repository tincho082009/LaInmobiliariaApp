package com.example.inmobiliaria.modelos;

public class ContratoAlquiler {
    private double monto;
    private String fechaInicio;
    private String fechaFinalizacion;
    private boolean estado;
    private int inmuebleId;
    private int inquilinoId;

    public ContratoAlquiler(double monto, String fechaInicio, String fechaFinalizacion, boolean estado, int inmuebleId, int inquilinoId) {
        this.monto = monto;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.estado = estado;
        this.inmuebleId = inmuebleId;
        this.inquilinoId = inquilinoId;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getInmuebleId() {
        return inmuebleId;
    }

    public void setInmuebleId(int inmuebleId) {
        this.inmuebleId = inmuebleId;
    }

    public int getInquilinoId() {
        return inquilinoId;
    }

    public void setInquilinoId(int inquilinoId) {
        this.inquilinoId = inquilinoId;
    }
}
