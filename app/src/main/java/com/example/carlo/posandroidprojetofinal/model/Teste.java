package com.example.carlo.posandroidprojetofinal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Teste implements Serializable {
    private int id;
    private Date data;
    private Cliente cliente;
    private List<ItemPedido> itemPedido;

    public Teste() {
    }

    public Teste(int id, Date data, Cliente cliente) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
    }

    public Teste(int id, Date data, Cliente cliente, List<ItemPedido> itemPedido) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.itemPedido = itemPedido;
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
        //return (ArrayList<ItemPedido>)itemPedido.toArray();
        // return Arrays.asList(itemPedido).toArray(new ArrayList<ItemPedido>[itemPedido.length]);
        //return TypeConverter.convert(itemPedido, (ArrayList<ItemPedido>[]).class);
        //ArrayList<ItemPedido> array = itemPedido.toArray((T[]) new ArrayList[itemPedido.size()]);
        //return (ArrayList<ItemPedido>) itemPedido.toArray();
        return itemPedido;
    }

    public void setItemPedido(List<ItemPedido> itemPedido) {
        this.itemPedido = itemPedido;
    }
}
