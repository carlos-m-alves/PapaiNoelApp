package com.example.carlo.posandroidprojetofinal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlo.posandroidprojetofinal.adapter.ListCell;
import com.example.carlo.posandroidprojetofinal.adapter.ListCellListaCartas;
import com.example.carlo.posandroidprojetofinal.bean.Brinquedo;
import com.example.carlo.posandroidprojetofinal.bean.Carta;
import com.example.carlo.posandroidprojetofinal.bean.Crianca;
import com.example.carlo.posandroidprojetofinal.bean.Usuario;
import com.example.carlo.posandroidprojetofinal.model.Cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaCartas extends AppCompatActivity {

    Usuario usuario = new Usuario();
    private ListView listViewCartas;
    private List<Carta> listaCartas = new ArrayList<>();

    private ListCellListaCartas adapter;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cartas);

        listViewCartas=findViewById(R.id.listViewCartas);
        listViewCartas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
            Carta carta = (Carta) listViewCartas.getItemAtPosition(position);
            //System.out.println("pegou a carta da crianca: "+carta.getNome());

            Intent it = new Intent(ListaCartas.this, LerCarta.class);
            //Toast.makeText(ListaCartas.this,"txt qlq: "+carta.getConteudo(),Toast.LENGTH_LONG).show();
            it.putExtra("carta",carta);
            it.putExtra("usuario", (Serializable) usuario);
            startActivity(it);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        listaCartas.removeAll(listaCartas);
        //pega os dados da tela do filtro e preenche a lista
        List<Carta> lista = ((List<Carta>) getIntent().getExtras().getSerializable("listaCartas"));
        //System.out.println("desc da carta: "+lista.get(0).getDescricao());
        for(Carta c : lista){
            listaCartas.add(c);
            //System.out.println("carta2: "+c.getDescricao());
        }
        adapter = new ListCellListaCartas(ListaCartas.this, listaCartas);
        listViewCartas.setAdapter(adapter);

        Usuario usu = (Usuario) getIntent().getExtras().getSerializable("usuario");
        usuario = usu;

    }
}
