package com.example.carlo.posandroidprojetofinal.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.carlo.posandroidprojetofinal.R;
import com.example.carlo.posandroidprojetofinal.model.Produto;

import java.util.List;

public class ListCellProd extends BaseAdapter{
    private final Activity context;
    private final List<Produto> produtos;

    public ListCellProd(Activity context, List<Produto> produtos) {
//        super(context, resource);
        this.context = context;
        this.produtos = produtos;
    }

    @Override
    public int getCount() { return produtos.size(); }

    @Override
    public Object getItem(int i) { return produtos.get(i);  }

    @Override
    public long getItemId(int i) { return 0; }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Produto produto = produtos.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if( convertView == null) {
            view = inflater.inflate(R.layout.list_cell, parent,false);
        }

        TextView txtListCellNome = view.findViewById(R.id.txtListCellNome);
        txtListCellNome.setText(produto.getDescricao());

        return view;
    }
}

