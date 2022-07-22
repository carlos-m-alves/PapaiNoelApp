package com.example.carlo.posandroidprojetofinal.service;

import com.example.carlo.posandroidprojetofinal.bean.Bairro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BairroService {
    @GET("bairro/")
    Call<List<Bairro>> buscarTodos();
}
