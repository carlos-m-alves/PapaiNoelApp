package com.example.carlo.posandroidprojetofinal.facade;

import com.example.carlo.posandroidprojetofinal.AConexao;
import com.example.carlo.posandroidprojetofinal.bean.TipoBrinquedo;
import com.example.carlo.posandroidprojetofinal.service.TipoBrinquedoCallback;
import com.example.carlo.posandroidprojetofinal.service.TipoBrinquedoService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TipoBrinquedoFacade {
    public static void buscarTodos(final TipoBrinquedoCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        TipoBrinquedoService service = retrofit.create(TipoBrinquedoService.class);
        Call<List<TipoBrinquedo>> call = service.buscarTodos();
        call.enqueue(new Callback<List<TipoBrinquedo>>() {
            public void onResponse(Call<List<TipoBrinquedo>> call, Response<List<TipoBrinquedo>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<TipoBrinquedo>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}
