package com.example.carlo.posandroidprojetofinal.service;

import com.example.carlo.posandroidprojetofinal.bean.Evento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface EventoService {
    @GET("evento")
    Call<List<Evento>> buscarTodos();
    @POST("evento")
    Call<Evento> inserir(@Body Evento evento);
    @PUT("evento")
    Call<Evento> atualizar(@Body Evento evento);
}
