package com.example.carlo.posandroidprojetofinal.bean;

import java.io.Serializable;
import java.util.Date;

public class Carta implements Serializable{
    private int idCarta;
    private String descricao;
    private Crianca crianca;
    private Instituicao instituicao;
    private Brinquedo brinquedo;
    private Evento evento;
    private Padrinho padrinho;
    private Date dtApadrinhada;
    private boolean entregue;

    public Carta() {
    }

    public int getIdCarta() {
        return idCarta;
    }

    public void setId(int idCarta) {
        this.idCarta = idCarta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Crianca getCrianca() {
        return crianca;
    }

    public void setCrianca(Crianca crianca) {
        this.crianca = crianca;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public Brinquedo getBrinquedo() {
        return brinquedo;
    }

    public void setBrinquedo(Brinquedo brinquedo) {
        this.brinquedo = brinquedo;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Padrinho getPadrinho() {
        return padrinho;
    }

    public void setPadrinho(Padrinho padrinho) {
        this.padrinho = padrinho;
    }

    public Date getDtApadrinhada() {
        return dtApadrinhada;
    }

    public void setDtApadrinhada(Date dtApadrinhada) {
        this.dtApadrinhada = dtApadrinhada;
    }

    public boolean isEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }
}
