package com.example.carlo.posandroidprojetofinal.facade;

import com.example.carlo.posandroidprojetofinal.model.ItemPedido;
import com.example.carlo.posandroidprojetofinal.service.ItemPedidoCallback;
import com.example.carlo.posandroidprojetofinal.service.ItemPedidoService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ItemPedidoFacade {

    public static void buscarItens(int id, final ItemPedidoCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                "http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        ItemPedidoService service = retrofit.create(ItemPedidoService.class);
        Call<List<ItemPedido>> call = service.buscarItens(id);
        call.enqueue(new Callback<List<ItemPedido>>() {
            public void onResponse(Call<List<ItemPedido>> call, Response<List<ItemPedido>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<ItemPedido>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}
