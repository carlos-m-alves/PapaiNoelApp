package com.example.carlo.posandroidprojetofinal.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.carlo.posandroidprojetofinal.R;
import com.example.carlo.posandroidprojetofinal.model.Cliente;

import java.util.List;

public class ListCell extends BaseAdapter{
    private final Activity context;
    private final List<Cliente> clientes;

    public ListCell(Activity context, List<Cliente> clientes) {
//        super(context, resource);
        this.context = context;
        this.clientes = clientes;
    }

    @Override
    public int getCount() { return clientes.size(); }

    @Override
    public Object getItem(int i) { return clientes.get(i);  }

    @Override
    public long getItemId(int i) { return 0; }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Cliente cliente = clientes.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if( convertView == null) {
            view = inflater.inflate(R.layout.list_cell, parent,false);
        }

        TextView txtListCellNome = view.findViewById(R.id.txtListCellNome);
        txtListCellNome.setText(cliente.getNome());

        return view;
    }
}

