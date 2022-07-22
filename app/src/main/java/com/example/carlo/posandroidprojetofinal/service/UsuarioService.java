package com.example.carlo.posandroidprojetofinal.service;

import com.example.carlo.posandroidprojetofinal.bean.Empresa;
import com.example.carlo.posandroidprojetofinal.bean.Pessoa;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsuarioService {
    @POST("usuario")
    Call<Pessoa> inserir(@Body Pessoa pessoa);
    @POST("usuario/emp")
    Call<Empresa> inserir(@Body Empresa empresa);
}
