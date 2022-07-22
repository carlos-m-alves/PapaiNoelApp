package com.example.carlo.posandroidprojetofinal.facade;

import com.example.carlo.posandroidprojetofinal.AConexao;
import com.example.carlo.posandroidprojetofinal.bean.Carta;
import com.example.carlo.posandroidprojetofinal.bean.Evento;
import com.example.carlo.posandroidprojetofinal.service.CartaCallback;
import com.example.carlo.posandroidprojetofinal.service.CartaService;
import com.example.carlo.posandroidprojetofinal.service.EventoCallback;
import com.example.carlo.posandroidprojetofinal.service.EventoService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventoFacade {

    public static void buscarTodos(final EventoCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        EventoService service = retrofit.create(EventoService.class);
        Call<List<Evento>> call = service.buscarTodos();
        call.enqueue(new Callback<List<Evento>>() {
            public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Evento>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void inserir(Evento evento, final EventoCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        EventoService service = retrofit.create(EventoService.class);
        Call<Evento> call = service.inserir(evento);
        call.enqueue(new Callback<Evento>() {
            public void onResponse(Call<Evento> call, Response<Evento> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<Evento> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
    public static void atualizar(Evento evento, final EventoCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        EventoService service = retrofit.create(EventoService.class);
        Call<Evento> call = service.atualizar(evento);
        call.enqueue(new Callback<Evento>() {
            public void onResponse(Call<Evento> call, Response<Evento> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<Evento> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}
