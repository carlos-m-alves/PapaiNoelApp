package com.example.carlo.posandroidprojetofinal.bean;

import java.io.Serializable;

public class Relatorio implements Serializable {
    private String descricao;
    private Double valor;
    private int valorInteiro;

    public Relatorio() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getValorInteiro() {
        return valorInteiro;
    }

    public void setValorInteiro(int valorInteiro) {
        this.valorInteiro = valorInteiro;
    }
}
