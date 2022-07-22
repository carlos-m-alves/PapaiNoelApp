package com.example.carlo.posandroidprojetofinal.service;

import com.example.carlo.posandroidprojetofinal.bean.Cidade;
import com.example.carlo.posandroidprojetofinal.model.ItemPedido;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CidadeService {
    @GET("cidade/")
    Call<List<Cidade>> buscarTodos();
}
