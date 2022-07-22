package com.example.carlo.posandroidprojetofinal.bean;

import java.io.Serializable;

public class Cidade implements Serializable {
    private int idCidade;
    private String nomeCidade;

    public Cidade() {
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }
}
