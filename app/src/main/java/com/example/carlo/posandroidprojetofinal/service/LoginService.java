package com.example.carlo.posandroidprojetofinal.service;

import com.example.carlo.posandroidprojetofinal.bean.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryName;

public interface LoginService {
    @GET("usuario/{email}/{senha}")
    //Call<Usuario> verificarLogin(@Path("usu") Usuario usuario);
    Call<Usuario> verificarLogin(@Path("email") String email, @Path("senha") String senha);
}
