package com.example.carlo.posandroidprojetofinal.model;

import java.io.Serializable;

public class Cliente implements Serializable {
    private int id;
    private String nome;
    private String sobreNome;
    private String cpf;

    public Cliente(String cpf){
        this.cpf = cpf;
    }

    public Cliente(int id, String nome, String sobreNome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.cpf = cpf;
    }

    public Cliente(String nome, String sobreNome, String cpf) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.cpf = cpf;
    }

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
