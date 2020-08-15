package tbd.lab.Models;

import java.math.BigDecimal;

public class Eme_habilidad {
    private BigDecimal id;
    private BigDecimal id_emergencia;
    private BigDecimal id_habilidad;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(BigDecimal id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    public BigDecimal getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(BigDecimal id_habilidad) {
        this.id_habilidad = id_habilidad;
    }
}
