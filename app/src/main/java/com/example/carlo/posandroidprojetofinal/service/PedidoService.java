package com.example.carlo.posandroidprojetofinal.service;

import com.example.carlo.posandroidprojetofinal.model.Pedido;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PedidoService {
    @GET("pedido/{cpf}")
    Call<List<Pedido>> buscarPedidosPorCliente(@Path("cpf") String cpf);
    @GET("pedido")
    Call<List<Pedido>> carregarTodos();
    @Headers("Content-Type: application/json")
    @POST("pedido")
    Call<Pedido> inserir(@Body Pedido pedido);
    @PUT("pedido")
    Call<Pedido> alterar(@Body Pedido pedido);
    @DELETE("pedido/{id}")
    Call<Pedido> remover(@Path("id") int id);
}
