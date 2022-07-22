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

public class ListCellListaCartasApadrinhadas extends BaseAdapter {
    private final Activity context;
    private final List<Carta> cartas;

    public ListCellListaCartasApadrinhadas(Activity context, List<Carta> cartas) {
        this.context = context;
        this.cartas = cartas;
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
            view = inflater.inflate(R.layout.row_lista_cartas_apadrinhadas, parent,false);
        }

        TextView txtListaCartasApadrinhadasNome = view.findViewById(R.id.txtListaCartasApadrinhadasNome);
        TextView txtListaCartasApadrinhadasIdade = view.findViewById(R.id.txtListaCartasApadrinhadasIdade);
        TextView txtListaCartasApadrinhadasBrinquedo = view.findViewById(R.id.txtListaCartasApadrinhadasBrinquedo);
        txtListaCartasApadrinhadasNome.setText(carta.getCrianca().getNomeCrianca());
        txtListaCartasApadrinhadasIdade.setText(String.valueOf(carta.getCrianca().getIdade())+" anos");
        txtListaCartasApadrinhadasBrinquedo.setText(carta.getBrinquedo().getNomeBrinquedo());

        return view;
    }
}
