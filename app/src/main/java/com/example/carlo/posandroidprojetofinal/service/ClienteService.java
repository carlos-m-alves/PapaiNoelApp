package com.example.carlo.posandroidprojetofinal.service;

import com.example.carlo.posandroidprojetofinal.model.Cliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ClienteService {
    @GET("cliente/{id}")
    Call<Cliente> carregarCliente(@Path("id") int id);
    @GET("cliente")
    Call<List<Cliente>> carregarTodos();
    @POST("cliente")
    Call<Cliente> inserir(@Body Cliente cliente);
    @PUT("cliente")
    Call<Cliente> alterar(@Body Cliente cliente);
    @DELETE("cliente/{id}")
    Call<String> remover(@Path("id") int id);
}
