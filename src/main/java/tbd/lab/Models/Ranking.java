package tbd.lab.Models;

import java.math.BigDecimal;

public class Ranking {
    private BigDecimal id;
    private int puntaje;
    private int flg_invitado;
    private int flg_participa;
    private BigDecimal id_voluntario;
    private BigDecimal id_tarea;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id){
        this.id=id;
    }

    public int getPuntaje(){
        return puntaje;
    }

    public void setPuntaje(int puntaje){
        this.puntaje=puntaje;
    }

    public int getFlg_invitado(){
        return flg_invitado;
    }

    public void setFlg_invitado(int flg_invitado){
        this.flg_invitado=flg_invitado;
    }

    public int getFlg_participa(){
        return flg_invitado;
    }

    public void setFlg_participa(int flg_participa){
        this.flg_participa=flg_participa;
    }

    public BigDecimal getId_voluntario(){
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
}
