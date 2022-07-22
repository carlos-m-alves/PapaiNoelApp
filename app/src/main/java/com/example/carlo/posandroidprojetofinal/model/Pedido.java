package com.example.carlo.posandroidprojetofinal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Pedido implements Serializable {
    private int id;
    private Date data;
    private Cliente cliente;
    private List<ItemPedido> itemPedido;

    public Pedido(int id, Date data, Cliente cliente, List<ItemPedido> itemPedido) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.itemPedido = itemPedido;
    }

    public Pedido(Date data, Cliente cliente, List<ItemPedido> itemPedido) {
        this.data = data;
        this.cliente = cliente;
        this.itemPedido = itemPedido;
    }

    public Pedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(List<ItemPedido> itemPedido) {
        this.itemPedido = itemPedido;
    }
}
