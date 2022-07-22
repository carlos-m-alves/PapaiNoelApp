package com.example.carlo.posandroidprojetofinal.service;

import com.example.carlo.posandroidprojetofinal.bean.Empresa;
import com.example.carlo.posandroidprojetofinal.bean.Evento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmpresaService {
    @GET("empresa")
    Call<List<Empresa>> buscarTodos();
}
