package tbd.lab.Models;

import java.math.BigDecimal;
import java.sql.Date;

public class Habilidad {

    private BigDecimal id;
    private String descripcion;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}