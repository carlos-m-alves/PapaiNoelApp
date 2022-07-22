package com.example.carlo.posandroidprojetofinal.facade;

import com.example.carlo.posandroidprojetofinal.AConexao;
import com.example.carlo.posandroidprojetofinal.bean.Bairro;
import com.example.carlo.posandroidprojetofinal.bean.Cidade;
import com.example.carlo.posandroidprojetofinal.service.BairroCallback;
import com.example.carlo.posandroidprojetofinal.service.BairroService;
import com.example.carlo.posandroidprojetofinal.service.CidadeCallback;
import com.example.carlo.posandroidprojetofinal.service.CidadeService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CidadeFacade {
    public static void buscarTodos(final CidadeCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.25.13:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        CidadeService service = retrofit.create(CidadeService.class);
        Call<List<Cidade>> call = service.buscarTodos();
        call.enqueue(new Callback<List<Cidade>>() {
            public void onResponse(Call<List<Cidade>> call, Response<List<Cidade>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Cidade>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}
