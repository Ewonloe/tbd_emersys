package tbd.lab.Models;

import java.math.BigDecimal;
import java.sql.Date;

public class Tarea {

    private BigDecimal id;
    private String nombre;
    private String descrip;
    private Integer cant_vol_requeridos;
    private Integer cant_vol_inscritos;
    private Date finicio;
    private Date ffin;
    private BigDecimal id_emergencia;
    private BigDecimal id_estado;

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

    public Integer getCant_vol_requeridos() {
        return cant_vol_requeridos;
    }

    public void setCant_vol_requeridos(Integer cant_vol_requeridos) {
        this.cant_vol_requeridos = cant_vol_requeridos;
    }

    public Integer getCant_vol_inscritos() {
        return cant_vol_inscritos;
    }

    public void setCant_vol_inscritos(Integer cant_vol_inscritos) {
        this.cant_vol_inscritos = cant_vol_inscritos;
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

    public BigDecimal getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(BigDecimal id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    public BigDecimal getId_estado() {
        return id_estado;
    }

    public void setId_estado(BigDecimal id_estado) {
        this.id_estado = id_estado;
    }
}
