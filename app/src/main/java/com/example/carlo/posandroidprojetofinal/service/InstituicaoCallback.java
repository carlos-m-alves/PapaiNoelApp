package com.example.carlo.posandroidprojetofinal.service;

public interface InstituicaoCallback<T> {
    public void onSuccess(T obj);
    public void onFailure(Throwable t);
}
