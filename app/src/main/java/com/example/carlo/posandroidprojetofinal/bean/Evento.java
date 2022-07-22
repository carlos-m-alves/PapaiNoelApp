package com.example.carlo.posandroidprojetofinal.bean;

import java.io.Serializable;
import java.util.Date;

public class Evento implements Serializable {
    private int idEvento;
    private String nomeEvento;
    private String dtEventoString;
    private Date dtEvento;
    private Empresa empresa;
    private Endereco endereco;

    public Evento() {
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setId(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public Date getDtEvento() {
        return dtEvento;
    }

    public void setDtEvento(Date dtEvento) {
        this.dtEvento = dtEvento;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getDtEventoString() {
        return dtEventoString;
    }

    public void setDtEventoString(String dtEventoString) {
        this.dtEventoString = dtEventoString;
    }
}
