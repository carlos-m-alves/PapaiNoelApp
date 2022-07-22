package com.example.carlo.posandroidprojetofinal.bean;

import java.io.Serializable;

public class TipoBrinquedo implements Serializable {
    private int idTipoBrinquedo;
    private String nomeTipoBrinquedo;

    public TipoBrinquedo() {
    }

    public int getIdTipoBrinquedo() {
        return idTipoBrinquedo;
    }

    public void setIdTipoBrinquedo(int idTipoBrinquedo) {
        this.idTipoBrinquedo = idTipoBrinquedo;
    }

    public String getNomeTipoBrinquedo() {
        return nomeTipoBrinquedo;
    }

    public void setNomeTipoBrinquedo(String nomeTipoBrinquedo) {
        this.nomeTipoBrinquedo = nomeTipoBrinquedo;
    }
}
