package com.example.demo.Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.Entities.Conf.Configuracion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Agremiacion")
public class Agremiacion {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, name = "fechaDeAlta")
    private Date fechaDeAlta;

    @Column(nullable = true, name = "fechaDeBaja")
    private Date fechaDeBaja;

    @Column(nullable = false, name = "matricula")
    private String matricula;

    @JoinColumn(nullable = false, name = "agremiadoId")
    @ManyToOne
    private Agremiado odontologo;

    @JoinColumn(nullable = false, name = "agremiacionId")
    @OneToMany
    private List<Cuota> cuotas;

    public Agremiacion() {
        this.fechaDeBaja=null;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(Date fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public Date getFechaDeBaja() {
        return fechaDeBaja;
    }

    public void setFechaDeBaja(Date fechaDeBaja) {
        this.fechaDeBaja = fechaDeBaja;
    }

    public String getMatricula(){
        return matricula;
    }

    public void setMatricula(String matricula){
        this.matricula=matricula;
    }

    public Agremiado getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Agremiado odontologo) {
        this.odontologo = odontologo;
    }

    public List<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<Cuota> cuotas) {
        this.cuotas = cuotas;
    }

    public void cargarCuotas(List<Cuota> cuotas){
        for(int i=0;i<cuotas.size();i++){
            this.cuotas.add(cuotas.get(i));
        }
    }

    public List<Cuota> crearCuotas(){
        Configuracion conf=new Configuracion();
        List<Cuota> cuotas=new ArrayList<>();
        int cantCuotas=12-new Date().getMonth();
        Float montoMensual=conf.getMontoAnual()/12;

        for(int i=0;i<cantCuotas;i++){
            Cuota cuota=new Cuota();
            cuota.setFechaEmision(new Date(new Date().getYear(), i, new Date().getDay()));
            cuota.setFechaVencimiento(new Date(new Date().getYear(), i, new Date().getDay()+10));
            cuota.setMontoMensual(montoMensual);
            cuotas.add(cuota);
        }
        return cuotas;
    }

}
