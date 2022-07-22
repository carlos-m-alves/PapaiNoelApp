package com.example.carlo.posandroidprojetofinal.facade;

import com.example.carlo.posandroidprojetofinal.AConexao;
import com.example.carlo.posandroidprojetofinal.bean.Instituicao;
import com.example.carlo.posandroidprojetofinal.service.InstituicaoCallback;
import com.example.carlo.posandroidprojetofinal.service.InstituicaoService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InstituicaoFacade {
    public static void buscarTodos(final InstituicaoCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        InstituicaoService service = retrofit.create(InstituicaoService.class);
        Call<List<Instituicao>> call = service.buscarTodos();
        call.enqueue(new Callback<List<Instituicao>>() {
            public void onResponse(Call<List<Instituicao>> call, Response<List<Instituicao>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Instituicao>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
    public static void inserir(Instituicao instituicao, final InstituicaoCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        InstituicaoService service = retrofit.create(InstituicaoService.class);
        Call<Instituicao> call = service.inserir(instituicao);
        call.enqueue(new Callback<Instituicao>() {
            public void onResponse(Call<Instituicao> call, Response<Instituicao> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<Instituicao> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
    public static void atualizar(Instituicao instituicao, final InstituicaoCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        InstituicaoService service = retrofit.create(InstituicaoService.class);
        Call<Instituicao> call = service.atualizar(instituicao);
        call.enqueue(new Callback<Instituicao>() {
            public void onResponse(Call<Instituicao> call, Response<Instituicao> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<Instituicao> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}
