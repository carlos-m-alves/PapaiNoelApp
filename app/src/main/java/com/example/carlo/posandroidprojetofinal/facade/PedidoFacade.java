package com.example.carlo.posandroidprojetofinal.facade;

import com.example.carlo.posandroidprojetofinal.model.Cliente;
import com.example.carlo.posandroidprojetofinal.model.Pedido;
import com.example.carlo.posandroidprojetofinal.service.ClienteCallback;
import com.example.carlo.posandroidprojetofinal.service.ClienteService;
import com.example.carlo.posandroidprojetofinal.service.PedidoCallback;
import com.example.carlo.posandroidprojetofinal.service.PedidoService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PedidoFacade {

    public static void inserir(Pedido pedido, final PedidoCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                "http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        PedidoService service = retrofit.create(PedidoService.class);
        Call<Pedido> call = service.inserir(pedido);
        System.out.println("chegou pra inserir"+pedido.getCliente().getCpf());
        call.enqueue(new Callback<Pedido>() {
            public void onResponse(Call<Pedido> call, Response<Pedido> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<Pedido> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void buscarPedidosPorCliente(String cpf, final PedidoCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                "http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        PedidoService service = retrofit.create(PedidoService.class);
        Call<List<Pedido>> call = service.buscarPedidosPorCliente(cpf);
        call.enqueue(new Callback<List<Pedido>>() {
            public void onResponse(Call<List<Pedido>> call, Response<List<Pedido>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Pedido>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}
