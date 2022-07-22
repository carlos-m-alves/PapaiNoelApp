package com.example.carlo.posandroidprojetofinal.bean;

import java.io.Serializable;

public class Bairro extends Cidade implements Serializable {
    private int idBairro;
    private String nomeBairro;

    public Bairro() {
    }

    public int getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(int idBairro) {
        this.idBairro = idBairro;
    }


    public String getNomeBairro() {
        return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }
}
