package com.example.demo.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cuota")
public class Cuota {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "fechaEmision")
    private Date fechaEmision;

    @Column(nullable = false, name = "fechaVencimiento")
    private Date fechaVencimiento;

    @Column(nullable = false, name = "montoMensual")
    private Float montoMensual;

    @JoinColumn(nullable = true, name = "pagoId")
    @ManyToOne
    private Pago pago;

    public Cuota() {
        this.pago=null;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Float getMontoMensual() {
        return montoMensual;
    }

    public void setMontoMensual(Float montoMensual) {
        this.montoMensual = montoMensual;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
    
    
}
