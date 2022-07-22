package com.example.carlo.posandroidprojetofinal.bean;

import java.io.Serializable;

public class Agencia extends Endereco implements Serializable {
    private int id;
    private String nomeAgencia;

    public Agencia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAgencia() {
        return nomeAgencia;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }
}
