package com.example.carlo.posandroidprojetofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.carlo.posandroidprojetofinal.adapter.ListCellListaCartas;
import com.example.carlo.posandroidprojetofinal.adapter.ListCellListaEventos;
import com.example.carlo.posandroidprojetofinal.bean.Carta;
import com.example.carlo.posandroidprojetofinal.bean.Evento;
import com.example.carlo.posandroidprojetofinal.bean.Relatorio;
import com.example.carlo.posandroidprojetofinal.facade.EventoFacade;
import com.example.carlo.posandroidprojetofinal.service.EventoCallback;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaEventos extends AppCompatActivity {

    private ListView listViewEventos;
    private List<Evento> listaEventos = new ArrayList<>();

    private ListCellListaEventos adapter;

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_eventos);

        final String nomeActivity = this.getClass().getSimpleName();

        listViewEventos=findViewById(R.id.listViewEventos);
        listViewEventos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                Evento evento = (Evento) listViewEventos.getItemAtPosition(position);
                //System.out.println("pegou a carta da crianca: "+carta.getNome());

                System.out.println("idBairro ListEvento: "+evento.getNomeEvento());

                Intent it = new Intent(ListaEventos.this, Carregando.class);
                //Toast.makeText(ListaCartas.this,"txt qlq: "+carta.getConteudo(),Toast.LENGTH_LONG).show();
                it.putExtra("nomeActivity",nomeActivity);
                it.putExtra("funcao","editar");
                it.putExtra("evento",evento);
                startActivity(it);
            }
        });
    }

    public void CriarEvento(View view){
        Intent i = new Intent(ListaEventos.this, Carregando.class);
        i.putExtra("nomeActivity",this.getClass().getSimpleName());
        i.putExtra("funcao","criar");
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();

        listaEventos.removeAll(listaEventos);
        List<Evento> lista = ((List<Evento>) getIntent().getExtras().getSerializable("eventos"));

        EventoFacade.buscarTodos(new EventoCallback() {
             @Override
             public void onSuccess(Object obj) {
                 System.out.println("buscou eventos");
                 List<Evento> lista = (ArrayList)obj;
                 for(Evento e : lista){
                     System.out.println("listaEvt: "+e.getNomeEvento());
                     System.out.println("listaEvt: "+e.getDtEvento().toString());
                     listaEventos.add(e);

                     //DateFormat.getDateInstance(DateFormat.SHORT).format(e.getDtEvento());
                 }
                 adapter = new ListCellListaEventos(ListaEventos.this, listaEventos);
                 listViewEventos.setAdapter(adapter);
             }

             @Override
             public void onFailure(Throwable t) {

             }
        });
        /*
        listaEventos.removeAll(listaEventos);
        List<Evento> lista = ((List<Evento>) getIntent().getExtras().getSerializable("eventos"));
        for(Evento e : lista){
            System.out.println("listaEvt: "+e.getNomeEvento());
            System.out.println("listaEvt: "+e.getDtEvento().toString());
            listaEventos.add(e);
            DateFormat.getDateInstance(DateFormat.SHORT).format(e.getDtEvento());
        }

        adapter = new ListCellListaEventos(ListaEventos.this, listaEventos);
        listViewEventos.setAdapter(adapter);
        */
    }
}
