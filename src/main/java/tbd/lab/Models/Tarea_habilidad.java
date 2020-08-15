package tbd.lab.Models;

import java.math.BigDecimal;

public class Tarea_habilidad {

    private BigDecimal id;
    private BigDecimal id_habilidad;
    private BigDecimal id_tarea;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(BigDecimal id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    public BigDecimal getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(BigDecimal id_tarea) {
        this.id_tarea = id_tarea;
    }
}
