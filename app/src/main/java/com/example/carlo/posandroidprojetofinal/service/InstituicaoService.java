package com.example.carlo.posandroidprojetofinal.service;

import com.example.carlo.posandroidprojetofinal.bean.Evento;
import com.example.carlo.posandroidprojetofinal.bean.Instituicao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface InstituicaoService {
    @GET("instituicao")
    Call<List<Instituicao>> buscarTodos();
    @POST("instituicao")
    Call<Instituicao> inserir(@Body Instituicao instituicao);
    @PUT("instituicao")
    Call<Instituicao> atualizar(@Body Instituicao instituicao);
}
