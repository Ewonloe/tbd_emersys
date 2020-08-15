package tbd.lab.Models;

import java.math.BigDecimal;

public class Tarea_habilidad {

    private BigDecimal id;
    private BigDecimal id_emeHabilidad;
    private BigDecimal id_tarea;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId_emeHabilidad() {
        return id_emeHabilidad;
    }

    public void setId_emeHabilidad(BigDecimal id_emeHabilidad) {
        this.id_emeHabilidad = id_emeHabilidad;
    }

    public BigDecimal getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(BigDecimal id_tarea) {
        this.id_tarea = id_tarea;
    }
}
