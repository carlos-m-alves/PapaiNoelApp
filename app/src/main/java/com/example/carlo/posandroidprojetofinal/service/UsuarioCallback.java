package com.example.carlo.posandroidprojetofinal.service;

public interface UsuarioCallback<T> {
    public void onSuccess(T obj);
    public void onFailure(Throwable t);
}
