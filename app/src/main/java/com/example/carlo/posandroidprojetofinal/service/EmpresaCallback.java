package com.example.carlo.posandroidprojetofinal.service;

public interface EmpresaCallback<T> {
    public void onSuccess(T obj);
    public void onFailure(Throwable t);
}
