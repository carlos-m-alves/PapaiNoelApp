package com.example.carlo.posandroidprojetofinal.facade;

import com.example.carlo.posandroidprojetofinal.AConexao;
import com.example.carlo.posandroidprojetofinal.bean.Bairro;
import com.example.carlo.posandroidprojetofinal.bean.Empresa;
import com.example.carlo.posandroidprojetofinal.service.BairroCallback;
import com.example.carlo.posandroidprojetofinal.service.BairroService;
import com.example.carlo.posandroidprojetofinal.service.EmpresaCallback;
import com.example.carlo.posandroidprojetofinal.service.EmpresaService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmpresaFacade {
    public static void buscarTodos(final EmpresaCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        EmpresaService service = retrofit.create(EmpresaService.class);
        Call<List<Empresa>> call = service.buscarTodos();
        call.enqueue(new Callback<List<Empresa>>() {
            public void onResponse(Call<List<Empresa>> call, Response<List<Empresa>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Empresa>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}
