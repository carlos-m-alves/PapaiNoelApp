package com.example.carlo.posandroidprojetofinal.bean;

import java.io.Serializable;

public class Crianca extends Endereco implements Serializable {
    private int idCrianca;
    private String nomeCrianca;
    private int idade;

    public Crianca() {
    }

    public int getIdCrianca() {
        return idCrianca;
    }

    public void setIdCrianca(int idCrianca) {
        this.idCrianca = idCrianca;
    }

    public String getNomeCrianca() {
        return nomeCrianca;
    }

    public void setNomeCrianca(String nomeCrianca) {
        this.nomeCrianca = nomeCrianca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
