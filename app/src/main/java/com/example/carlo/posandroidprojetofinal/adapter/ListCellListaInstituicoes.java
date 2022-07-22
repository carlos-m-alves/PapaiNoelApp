package com.example.carlo.posandroidprojetofinal.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.carlo.posandroidprojetofinal.R;
import com.example.carlo.posandroidprojetofinal.bean.Instituicao;

import java.util.List;

public class ListCellListaInstituicoes extends BaseAdapter {

    private final Activity context;
    private final List<Instituicao> instituicoes;

    public ListCellListaInstituicoes(Activity context, List<Instituicao> instituicoes) {
        this.context = context;
        this.instituicoes = instituicoes;
    }

    @Override
    public int getCount() { return instituicoes.size(); }

    @Override
    public Object getItem(int i) { return instituicoes.get(i);  }

    @Override
    public long getItemId(int i) { return 0; }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Instituicao instituicao = instituicoes.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if( convertView == null) {
            view = inflater.inflate(R.layout.row_lista_instituicoes, parent,false);
        }

        TextView txtListaInstituicaoNome = view.findViewById(R.id.txtListaInstituicaoNome);
        txtListaInstituicaoNome.setText(instituicao.getNomeInstituicao());

        return view;
    }
}
