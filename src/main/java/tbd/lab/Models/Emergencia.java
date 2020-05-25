package tbd.lab.Models;

import java.math.BigDecimal;
import java.sql.Date;

public class Emergencia {

    private BigDecimal id;
    private String nombre;
    private String descrip;
    private Date finicio;
    private Date ffin;
    private BigDecimal id_institucion;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Date getFinicio() {
        return finicio;
    }

    public void setFinicio(Date finicio) {
        this.finicio = finicio;
    }

    public Date getFfin() {
        return ffin;
    }

    public void setFfin(Date ffin) {
        this.ffin = ffin;
    }

    public BigDecimal getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(BigDecimal id_institucion) {
        this.id_institucion = id_institucion;
    }
}
