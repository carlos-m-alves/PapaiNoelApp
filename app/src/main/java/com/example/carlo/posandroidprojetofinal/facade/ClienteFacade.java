package com.example.carlo.posandroidprojetofinal.facade;

import com.example.carlo.posandroidprojetofinal.model.Cliente;
import com.example.carlo.posandroidprojetofinal.model.Teste;
import com.example.carlo.posandroidprojetofinal.service.ClienteCallback;
import com.example.carlo.posandroidprojetofinal.service.ClienteService;
import com.example.carlo.posandroidprojetofinal.service.TesteService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClienteFacade {

    public static void inserir(Cliente cliente, final ClienteCallback callback){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.88.1:18515/WsAndroidPos/webresources/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ClienteService service = retrofit.create(ClienteService.class);
        Call<Cliente> call = service.inserir(cliente);
        call.enqueue(new Callback<Cliente>() {
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<Cliente> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void carregar(final ClienteCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                "http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        ClienteService service = retrofit.create(ClienteService.class);
        Call<List<Cliente>> call = service.carregarTodos();
        call.enqueue(new Callback<List<Cliente>>() {
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Cliente>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void carregarCliente(int id, final ClienteCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                "http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        ClienteService service = retrofit.create(ClienteService.class);
        Call<Cliente> call = service.carregarCliente(id);
        call.enqueue(new Callback<Cliente>() {
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<Cliente> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void alterar(Cliente cliente, final ClienteCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                "http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        ClienteService service = retrofit.create(ClienteService.class);
        Call<Cliente> call = service.alterar(cliente);
        call.enqueue(new Callback<Cliente>() {
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<Cliente> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void remover(int idCliente, final ClienteCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                "http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        ClienteService service = retrofit.create(ClienteService.class);
        Call<String> call = service.remover(idCliente);
        call.enqueue(new Callback<String>() {
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<String> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}
