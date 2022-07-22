package com.example.carlo.posandroidprojetofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.carlo.posandroidprojetofinal.adapter.ListCellListaCartasApadrinhadas;
import com.example.carlo.posandroidprojetofinal.adapter.ListCellListaCartasCadastradas;
import com.example.carlo.posandroidprojetofinal.bean.Brinquedo;
import com.example.carlo.posandroidprojetofinal.bean.Carta;
import com.example.carlo.posandroidprojetofinal.bean.Crianca;
import com.example.carlo.posandroidprojetofinal.bean.Usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaCartasApadrinhadas extends AppCompatActivity {
    Usuario usuario = new Usuario();
    private ListView listViewCartasApadrinhadas;
    private List<Carta> listaCartas = new ArrayList<>();

    private ListCellListaCartasApadrinhadas adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cartas_apadrinhadas);

        listViewCartasApadrinhadas=findViewById(R.id.listViewCartasApadrinhadas);
        listViewCartasApadrinhadas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
            Carta carta = (Carta) listViewCartasApadrinhadas.getItemAtPosition(position);
            //System.out.println("pegou a carta da crianca: "+carta.getNome());

            //VISUALIZAR CARTA APENAS
            Intent it = new Intent(ListaCartasApadrinhadas.this, InformacoesCartaApadrinhada.class);
            it.putExtra("carta",carta);
            startActivity(it);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        listaCartas.removeAll(listaCartas);
        List<Carta> lista = ((List<Carta>) getIntent().getExtras().getSerializable("listCartas"));
        for(Carta e : lista){
            listaCartas.add(e);
        }

        adapter = new ListCellListaCartasApadrinhadas(ListaCartasApadrinhadas.this, listaCartas);
        listViewCartasApadrinhadas.setAdapter(adapter);

        Usuario usu = (Usuario) getIntent().getExtras().getSerializable("usuario");
        usuario = usu;
    }
}
