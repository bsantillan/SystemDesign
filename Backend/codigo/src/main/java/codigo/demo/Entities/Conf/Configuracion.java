package codigo.demo.Entities.Conf;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Configuracion")
public class Configuracion {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "descuento")
    public Float descuento;

    @Column(nullable = false, name = "interes")
    public Float interes;

    @Column(nullable = false, name = "interesAfiliado")
    public Float interesAfiliado;

    @Column(nullable = false, name = "montoAnual")
    public Float montoAnual;

    public Configuracion() {}

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public Float getInteres() {
        return interes;
    }

    public void setInteres(Float interes) {
        this.interes = interes;
    }

    public Float getInteresAfiliado() {
        return interesAfiliado;
    }

    public void setInteresAfiliado(Float interesAfiliado) {
        this.interesAfiliado = interesAfiliado;
    }

    public Float getMontoAnual() {
        return montoAnual;
    }

    public void setMontoAnual(Float montoAnual) {
        this.montoAnual = montoAnual;
    }
    
}
