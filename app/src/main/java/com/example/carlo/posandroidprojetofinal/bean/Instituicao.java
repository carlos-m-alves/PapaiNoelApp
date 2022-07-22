package com.example.carlo.posandroidprojetofinal.bean;

import java.io.Serializable;

public class Instituicao extends Endereco implements Serializable {
    private int idInstituicao;
    private String nomeInstituicao;
    private String telefone;

    public Instituicao() {
    }

    public int getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(int idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
