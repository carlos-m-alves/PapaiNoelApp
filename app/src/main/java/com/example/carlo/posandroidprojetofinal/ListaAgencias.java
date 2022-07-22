package com.example.carlo.posandroidprojetofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.carlo.posandroidprojetofinal.adapter.ListCellListaAgencias;
import com.example.carlo.posandroidprojetofinal.adapter.ListCellListaCartas;
import com.example.carlo.posandroidprojetofinal.bean.Agencia;
import com.example.carlo.posandroidprojetofinal.bean.Carta;

import java.util.ArrayList;
import java.util.List;

public class ListaAgencias extends AppCompatActivity {

    private ListView listViewAgencias;
    private List<Agencia> listaAgencias = new ArrayList<>();

    private ListCellListaAgencias adapter;

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_agencias);

        listViewAgencias=findViewById(R.id.listViewAgencias);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Agencia c = new Agencia();
        c.setNomeAgencia("Agência Marechal");
        c.setRua("Av Marechal Floriano Peixoto");
        c.setNumero(254);
        listaAgencias.add(c);
        Agencia c1 = new Agencia();
        c1.setNomeAgencia("Agência João Negrão");
        c1.setRua("Rua João Negrão");
        c1.setNumero(9);
        listaAgencias.add(c1);

        adapter = new ListCellListaAgencias(ListaAgencias.this, listaAgencias);
        listViewAgencias.setAdapter(adapter);
    }
}
