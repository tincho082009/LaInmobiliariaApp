package com.example.inmobiliaria.modelos;

import java.time.LocalDate;

public class Pago {
    private int nroPago;
    private String fechaPago;
    private double importe;
    private int contratoId;

    public Pago(int nroPago, String fechaPago, double importe, int contratoId) {
        this.nroPago = nroPago;
        this.fechaPago = fechaPago;
        this.importe = importe;
        this.contratoId = contratoId;
    }

    public int getNroPago() {
        return nroPago;
    }

    public void setNroPago(int nroPago) {
        this.nroPago = nroPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getContratoId() {
        return contratoId;
    }

    public void setContratoId(int contratoId) {
        this.contratoId = contratoId;
    }
}
