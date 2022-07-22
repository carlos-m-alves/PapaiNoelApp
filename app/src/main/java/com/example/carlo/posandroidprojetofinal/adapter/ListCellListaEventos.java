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
import com.example.carlo.posandroidprojetofinal.bean.Evento;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ListCellListaEventos extends BaseAdapter {
    private final Activity context;
    private final List<Evento> eventos;

    public ListCellListaEventos(Activity context, List<Evento> eventos) {
        this.context = context;
        this.eventos = eventos;
    }

    @Override
    public int getCount() { return eventos.size(); }

    @Override
    public Object getItem(int i) { return eventos.get(i);  }

    @Override
    public long getItemId(int i) { return 0; }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Evento evento = eventos.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if( convertView == null) {
            view = inflater.inflate(R.layout.row_lista_eventos, parent,false);
        }

        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);

        // Get the today date using Calendar object.
        Date today = Calendar.getInstance().getTime();
        String todayAsString = df.format(today);
        System.out.println("dt formatada: "+DateFormat.getDateInstance(DateFormat.SHORT).format(evento.getDtEvento()).toString());


        TextView txtListaEventoNome = view.findViewById(R.id.txtListaEventoNome);
        TextView txtListaEventoData = view.findViewById(R.id.txtListaEventoData);
        txtListaEventoNome.setText(evento.getNomeEvento());
        txtListaEventoData.setText(df.format(evento.getDtEvento()));

        return view;
    }
}
