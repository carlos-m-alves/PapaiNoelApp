package com.example.carlo.posandroidprojetofinal.bean;

import java.io.Serializable;

public class Brinquedo extends TipoBrinquedo implements Serializable {
    private int idBrinquedo;
    private String nomeBrinquedo;

    public Brinquedo() {
    }

    public int getIdBrinquedo() {
        return idBrinquedo;
    }

    public void setIdBrinquedo(int idBrinquedo) {
        this.idBrinquedo = idBrinquedo;
    }

    public String getNomeBrinquedo() {
        return nomeBrinquedo;
    }

    public void setNomeBrinquedo(String nomeBrinquedo) {
        this.nomeBrinquedo = nomeBrinquedo;
    }
}
