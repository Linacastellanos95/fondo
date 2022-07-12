package com.fondofamiliar1.fondo.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "rendimientos")
public class Rendimiento {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "prestamo_id", referencedColumnName = "id")
    private Prestamo prestamo;

    private BigDecimal rendimiento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public BigDecimal getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(BigDecimal rendimiento) {
        this.rendimiento = rendimiento;
    }
}
