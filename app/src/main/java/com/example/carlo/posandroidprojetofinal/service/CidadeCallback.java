package com.example.carlo.posandroidprojetofinal.service;

public interface CidadeCallback<T> {
    public void onSuccess(T obj);
    public void onFailure(Throwable t);
}