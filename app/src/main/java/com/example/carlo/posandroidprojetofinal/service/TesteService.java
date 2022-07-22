package com.example.carlo.posandroidprojetofinal.service;

import com.example.carlo.posandroidprojetofinal.model.Cliente;
import com.example.carlo.posandroidprojetofinal.model.Teste;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TesteService {
    @POST("cliente")
    Call<Teste> inserir(@Body Teste teste);
}
