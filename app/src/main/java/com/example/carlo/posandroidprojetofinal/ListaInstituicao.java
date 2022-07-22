package com.example.carlo.posandroidprojetofinal;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.carlo.posandroidprojetofinal.adapter.ListCellListaCartas;
import com.example.carlo.posandroidprojetofinal.adapter.ListCellListaInstituicoes;
import com.example.carlo.posandroidprojetofinal.bean.Bairro;
import com.example.carlo.posandroidprojetofinal.bean.Carta;
import com.example.carlo.posandroidprojetofinal.bean.Evento;
import com.example.carlo.posandroidprojetofinal.bean.Instituicao;
import com.example.carlo.posandroidprojetofinal.bean.TipoBrinquedo;
import com.example.carlo.posandroidprojetofinal.facade.InstituicaoFacade;
import com.example.carlo.posandroidprojetofinal.service.InstituicaoCallback;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class ListaInstituicao extends AppCompatActivity {

    private ListView listViewInstituicoes;
    private List<Instituicao> listaInstituicoes = new ArrayList<>();
    private ListCellListaInstituicoes adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_instituicao);

        //System.out.println("QUAL o NOME: "+this.getClass().getSimpleName());
        final String nomeActivity = this.getClass().getSimpleName();

        listViewInstituicoes=findViewById(R.id.listViewInstituicoes);
        listViewInstituicoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                Instituicao instituicao = (Instituicao) listViewInstituicoes.getItemAtPosition(position);
                //System.out.println("pegou a carta da crianca: "+carta.getNome());

                Intent i = new Intent(ListaInstituicao.this, Carregando.class);

                i.putExtra("nomeActivity",nomeActivity);
                i.putExtra("funcao","EditarInstituicao");
                i.putExtra("instituicao",instituicao);
                startActivity(i);
            }
        });
    }

    public void CriarInstituicao(View view){
        Intent i = new Intent(ListaInstituicao.this, Carregando.class);
        i.putExtra("nomeActivity",this.getClass().getSimpleName());
        i.putExtra("funcao","CriarInstituicao");
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();

        listaInstituicoes.removeAll(listaInstituicoes);

        InstituicaoFacade.buscarTodos(new InstituicaoCallback() {
            @Override
            public void onSuccess(Object obj) {
                List<Instituicao> lista=(ArrayList)obj;
                for(Instituicao i : lista){
                    //System.out.println("listaEvt: "+i.getNomeInstituicao());
                    listaInstituicoes.add(i);
                }
                adapter = new ListCellListaInstituicoes(ListaInstituicao.this, listaInstituicoes);
                listViewInstituicoes.setAdapter(adapter);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
        /*
        List<Instituicao> lista = ((List<Instituicao>) getIntent().getExtras().getSerializable("listInst"));
        for(Instituicao i : lista){
            System.out.println("listaEvt: "+i.getNomeInstituicao());
            listaInstituicoes.add(i);
        }

        adapter = new ListCellListaInstituicoes(ListaInstituicao.this, listaInstituicoes);
        listViewInstituicoes.setAdapter(adapter);
*/
    }
}
