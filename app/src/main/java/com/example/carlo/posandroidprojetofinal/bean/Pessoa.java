package com.example.carlo.posandroidprojetofinal.bean;

import java.io.Serializable;

public class Pessoa extends Padrinho implements Serializable {
    private String nome;
    private char sexo;

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
}
