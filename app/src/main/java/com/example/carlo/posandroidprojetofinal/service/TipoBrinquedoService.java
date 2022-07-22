package com.example.carlo.posandroidprojetofinal.service;

import com.example.carlo.posandroidprojetofinal.bean.Carta;
import com.example.carlo.posandroidprojetofinal.bean.TipoBrinquedo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TipoBrinquedoService {
    @GET("tipobrinquedo/")
    Call<List<TipoBrinquedo>> buscarTodos();
}
