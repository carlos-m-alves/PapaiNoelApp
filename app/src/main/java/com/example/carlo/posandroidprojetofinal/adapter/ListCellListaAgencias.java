package com.example.carlo.posandroidprojetofinal.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.carlo.posandroidprojetofinal.R;
import com.example.carlo.posandroidprojetofinal.bean.Agencia;
import com.example.carlo.posandroidprojetofinal.bean.Evento;

import java.util.List;

public class ListCellListaAgencias extends BaseAdapter {
    private final Activity context;
    private final List<Agencia> agencias;

    public ListCellListaAgencias(Activity context, List<Agencia> agencias) {
        this.context = context;
        this.agencias = agencias;
    }

    @Override
    public int getCount() { return agencias.size(); }

    @Override
    public Object getItem(int i) { return agencias.get(i);  }

    @Override
    public long getItemId(int i) { return 0; }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Agencia agencia = agencias.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if( convertView == null) {
            view = inflater.inflate(R.layout.row_lista_agencias, parent,false);
        }

        TextView txtListaAgenciaNome = view.findViewById(R.id.txtListaAgenciaNome);
        TextView txtListaAgenciaEndereco = view.findViewById(R.id.txtListaAgenciaEndereco);
        txtListaAgenciaNome.setText(agencia.getNomeAgencia());
        txtListaAgenciaEndereco.setText(agencia.getRua()+", "+agencia.getNumero());

        return view;
    }
}
