package tbd.lab.Models;

import java.math.BigDecimal;

public class Tarea_voluntario {

    private BigDecimal id;
    private BigDecimal id_voluntario;
    private BigDecimal id_tarea;
    private int flg_accepted;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(BigDecimal id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public BigDecimal getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(BigDecimal id_tarea) {
        this.id_tarea = id_tarea;
    }

    public int getFlg_accepted() {
        return flg_accepted;
    }

    public void setFlg_accepted(int flg_accepted) {
        this.flg_accepted = flg_accepted;
    }
}
