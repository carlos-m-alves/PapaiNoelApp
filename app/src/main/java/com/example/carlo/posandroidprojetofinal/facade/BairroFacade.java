package com.example.carlo.posandroidprojetofinal.facade;

import com.example.carlo.posandroidprojetofinal.AConexao;
import com.example.carlo.posandroidprojetofinal.bean.Bairro;
import com.example.carlo.posandroidprojetofinal.service.BairroCallback;
import com.example.carlo.posandroidprojetofinal.service.BairroService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BairroFacade {
    public static void buscarTodos(final BairroCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                //"http://192.168.25.13:18515/WsAndroidPos/webresources/"
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        BairroService service = retrofit.create(BairroService.class);
        Call<List<Bairro>> call = service.buscarTodos();
        call.enqueue(new Callback<List<Bairro>>() {
            public void onResponse(Call<List<Bairro>> call, Response<List<Bairro>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Bairro>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}
