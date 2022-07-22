package com.example.carlo.posandroidprojetofinal.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.carlo.posandroidprojetofinal.R;
import com.example.carlo.posandroidprojetofinal.bean.Empresa;

import java.util.List;

public class ListCellListaEmpresas extends BaseAdapter {

    private final Activity context;
    private final List<Empresa> empresas;

    public ListCellListaEmpresas(Activity context, List<Empresa> empresas) {
        this.context = context;
        this.empresas = empresas;
    }

    @Override
    public int getCount() { return empresas.size(); }

    @Override
    public Object getItem(int i) { return empresas.get(i);  }

    @Override
    public long getItemId(int i) { return 0; }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Empresa empresa = empresas.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if( convertView == null) {
            view = inflater.inflate(R.layout.row_lista_empresas, parent,false);
        }

        TextView txtListaEmpresaNome = view.findViewById(R.id.txtListaEmpresaNome);
        txtListaEmpresaNome.setText(empresa.getNomeEmpresa());

        return view;
    }
}
