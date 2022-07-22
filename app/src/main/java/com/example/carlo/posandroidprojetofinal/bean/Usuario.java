package com.example.carlo.posandroidprojetofinal.bean;

import java.io.Serializable;

public class Usuario implements Serializable {
    private int id;
    private String permissao;
    private String ccpf_cnpj;
    private String email;
    private String senha;
    private String telefone;

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public String getCcpf_cnpj() {
        return ccpf_cnpj;
    }

    public void setCcpf_cnpj(String ccpf_cnpj) {
        this.ccpf_cnpj = ccpf_cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
