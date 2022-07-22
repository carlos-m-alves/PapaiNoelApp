package com.example.carlo.posandroidprojetofinal.facade;

import com.example.carlo.posandroidprojetofinal.AConexao;
import com.example.carlo.posandroidprojetofinal.bean.Empresa;
import com.example.carlo.posandroidprojetofinal.bean.Pessoa;
import com.example.carlo.posandroidprojetofinal.bean.Usuario;
import com.example.carlo.posandroidprojetofinal.service.LoginCallback;
import com.example.carlo.posandroidprojetofinal.service.LoginService;
import com.example.carlo.posandroidprojetofinal.service.UsuarioCallback;
import com.example.carlo.posandroidprojetofinal.service.UsuarioService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsuarioFacade {

    public static void verificarLogin(String email, String senha, final LoginCallback callback){

        Retrofit retrofit = new Retrofit.Builder().baseUrl(AConexao.DATABASE_CONNECTION
                //"http://192.168.43.176:18515/WsAndroidPos/webresources/"
                //"http://192.168.43.176:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        LoginService service = retrofit.create(LoginService.class);
        Call<Usuario> call = service.verificarLogin(email, senha);
        call.enqueue(new Callback<Usuario>() {
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<Usuario> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void inserir(Pessoa pessoa, final UsuarioCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.31.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        UsuarioService service = retrofit.create(UsuarioService.class);
        Call<Pessoa> call = service.inserir(pessoa);
        call.enqueue(new Callback<Pessoa>() {
            public void onResponse(Call<Pessoa> call, Response<Pessoa> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<Pessoa> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void inserir(Empresa empresa, final UsuarioCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                AConexao.DATABASE_CONNECTION//"http://192.168.31.1:18515/WsAndroidPos/webresources/"
        ).addConverterFactory(GsonConverterFactory.create()).build();

        UsuarioService service = retrofit.create(UsuarioService.class);
        Call<Empresa> call = service.inserir(empresa);
        call.enqueue(new Callback<Empresa>() {
            public void onResponse(Call<Empresa> call, Response<Empresa> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println("STATUS CODE = " + response.code());
                    callback.onFailure(new Exception(response.errorBody().toString()));
                }
            }

            public void onFailure(Call<Empresa> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}
