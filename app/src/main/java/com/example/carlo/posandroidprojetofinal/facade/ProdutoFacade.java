package com.example.carlo.posandroidprojetofinal.facade;

import com.example.carlo.posandroidprojetofinal.model.Cliente;
import com.example.carlo.posandroidprojetofinal.model.Produto;
import com.example.carlo.posandroidprojetofinal.service.ClienteCallback;
import com.example.carlo.posandroidprojetofinal.service.ClienteService;
import com.example.carlo.posandroidprojetofinal.service.ProdutoCallback;
import com.example.carlo.posandroidprojetofinal.service.ProdutoService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProdutoFacade {
    public static void inserir(Produto produto, final ProdutoCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                "http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        ProdutoService service = retrofit.create(ProdutoService.class);
        Call<Produto> call = service.inserir(produto);
        call.enqueue(new Callback<Produto>() {
            public void onResponse(Call<Produto> call, Response<Produto> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<Produto> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void carregar(final ProdutoCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                "http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        ProdutoService service = retrofit.create(ProdutoService.class);
        Call<List<Produto>> call = service.carregarTodos();
        call.enqueue(new Callback<List<Produto>>() {
            public void onResponse(Call<List<Produto>> call, Response<List<Produto>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<List<Produto>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void carregarProduto(int id, final ProdutoCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                "http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        ProdutoService service = retrofit.create(ProdutoService.class);
        Call<Produto> call = service.carregarProduto(id);
        call.enqueue(new Callback<Produto>() {
            public void onResponse(Call<Produto> call, Response<Produto> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<Produto> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void alterar(Produto produto, final ProdutoCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                "http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        ProdutoService service = retrofit.create(ProdutoService.class);
        Call<Produto> call = service.alterar(produto);
        call.enqueue(new Callback<Produto>() {
            public void onResponse(Call<Produto> call, Response<Produto> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<Produto> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void remover(int idProduto, final ProdutoCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                "http://192.168.88.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        ProdutoService service = retrofit.create(ProdutoService.class);
        Call<Produto> call = service.remover(idProduto);
        call.enqueue(new Callback<Produto>() {
            public void onResponse(Call<Produto> call, Response<Produto> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<Produto> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}
