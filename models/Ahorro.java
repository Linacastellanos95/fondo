package com.fondofamiliar1.fondo.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ahorros")
public class Ahorro {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private BigDecimal aporteMensual;
    private Date fechaAporte;

    @OneToOne
    @JoinColumn(name = "socio_id", referencedColumnName = "id")
    private Socio socio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAporteMensual() {
        return aporteMensual;
    }

    public void setAporteMensual(BigDecimal aporteMensual) {
        this.aporteMensual = aporteMensual;
    }

    public Date getFechaAporte() {
        return fechaAporte;
    }

    public void setFechaAporte(Date fechaAporte) {
        this.fechaAporte = fechaAporte;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}
