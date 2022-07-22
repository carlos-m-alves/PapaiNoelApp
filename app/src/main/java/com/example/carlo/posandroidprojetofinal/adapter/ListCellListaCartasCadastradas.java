package com.example.carlo.posandroidprojetofinal.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.carlo.posandroidprojetofinal.R;
import com.example.carlo.posandroidprojetofinal.bean.Carta;

import java.util.List;

public class ListCellListaCartasCadastradas extends BaseAdapter {

    private final Activity context;
    private List<Carta> cartas;

    public ListCellListaCartasCadastradas(Activity context, List<Carta> cartas) {
        this.context = context;
        this.cartas = cartas;
    }

    public void update(List<Carta> lista){
        this.cartas=lista;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() { return cartas.size(); }

    @Override
    public Object getItem(int i) { return cartas.get(i);  }

    @Override
    public long getItemId(int i) { return 0; }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Carta carta = cartas.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if( convertView == null) {
            view = inflater.inflate(R.layout.row_lista_cartas_cadastradas, parent,false);
        }

        TextView txtListaCartasCadastradasNome = view.findViewById(R.id.txtListaCartasCadastradasNome);
        TextView txtListaCartasCadastradasIdade = view.findViewById(R.id.txtListaCartasCadastradasIdade);
        TextView txtListaCartasCadastradasBrinquedo = view.findViewById(R.id.txtListaCartasCadastradasBrinquedo);
        TextView txtListaCartasCadastradasEntregue = view.findViewById(R.id.txtListaCartasCadastradasEntregue);
        txtListaCartasCadastradasNome.setText(carta.getCrianca().getNomeCrianca());
        txtListaCartasCadastradasIdade.setText(String.valueOf(carta.getCrianca().getIdade())+" anos");
        txtListaCartasCadastradasBrinquedo.setText(carta.getBrinquedo().getNomeBrinquedo());
        txtListaCartasCadastradasEntregue.setText(carta.isEntregue() ? "Entregue" : "");

        return view;
    }
}
