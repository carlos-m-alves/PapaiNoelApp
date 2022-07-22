package com.example.carlo.posandroidprojetofinal.service;

import com.example.carlo.posandroidprojetofinal.model.Produto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProdutoService {
    @GET("produto/{id}")
    Call<Produto> carregarProduto(@Path("id") int id);
    @GET("produto")
    Call<List<Produto>> carregarTodos();
    @POST("produto")
    Call<Produto> inserir(@Body Produto produto);
    @PUT("produto")
    Call<Produto> alterar(@Body Produto produto);
    @DELETE("produto/{id}")
    Call<Produto> remover(@Path("id") int id);
}
