package com.example.carlo.posandroidprojetofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.carlo.posandroidprojetofinal.adapter.ListCellListaCartas;
import com.example.carlo.posandroidprojetofinal.adapter.ListCellListaCartasCadastradas;
import com.example.carlo.posandroidprojetofinal.bean.Bairro;
import com.example.carlo.posandroidprojetofinal.bean.Brinquedo;
import com.example.carlo.posandroidprojetofinal.bean.Carta;
import com.example.carlo.posandroidprojetofinal.bean.Crianca;
import com.example.carlo.posandroidprojetofinal.bean.Evento;
import com.example.carlo.posandroidprojetofinal.bean.Instituicao;
import com.example.carlo.posandroidprojetofinal.bean.TipoBrinquedo;
import com.example.carlo.posandroidprojetofinal.facade.BairroFacade;
import com.example.carlo.posandroidprojetofinal.facade.CartaFacade;
import com.example.carlo.posandroidprojetofinal.facade.InstituicaoFacade;
import com.example.carlo.posandroidprojetofinal.facade.TipoBrinquedoFacade;
import com.example.carlo.posandroidprojetofinal.service.BairroCallback;
import com.example.carlo.posandroidprojetofinal.service.CartaCallback;
import com.example.carlo.posandroidprojetofinal.service.InstituicaoCallback;
import com.example.carlo.posandroidprojetofinal.service.TipoBrinquedoCallback;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class ListaCartasCadastradas extends AppCompatActivity {

    private EditText edtFiltCartaPorCodigo;
    private ListView listViewCartasCadastradas;
    private List<Carta> listaCartas = new ArrayList<>();
    private List<Instituicao> listaInstituicoes = new ArrayList<>();
    private List<TipoBrinquedo> listTipoBrinquedo = new ArrayList<>();
    private List<Bairro> listBairro = new ArrayList<>();

    private ListCellListaCartasCadastradas adapter;

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cartas_cadastradas);

        edtFiltCartaPorCodigo=findViewById(R.id.edtFiltCartaPorCodigo);

        listViewCartasCadastradas=findViewById(R.id.listViewCartasCadastradas);
        listViewCartasCadastradas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                Carta carta = (Carta) listViewCartasCadastradas.getItemAtPosition(position);
                //System.out.println("pegou a carta da crianca: "+carta.getNome());

                Intent it = new Intent(ListaCartasCadastradas.this, EditarCarta.class);
                //Toast.makeText(ListaCartas.this,"txt qlq: "+carta.getConteudo(),Toast.LENGTH_LONG).show();
                System.out.println("ID CARTA DA CRIANCA(LISTACARTAS): "+carta.getCrianca().getIdCrianca());
                it.putExtra("carta",carta);
                it.putExtra("listTipoBrinquedo",(Serializable)listTipoBrinquedo);
                it.putExtra("listBairro",(Serializable)listBairro);
                it.putExtra("listInstituicoes",(Serializable)listaInstituicoes);
                //it.putExtra("listaInstituicoes",listaInstituicoes);
                startActivity(it);
            }
        });

        edtFiltCartaPorCodigo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                List<Carta> listaPesquisa = new ArrayList<>();
                //System.out.println("seq: "+charSequence);
                //System.out.println("valor do 1ª: "+listaCartas.get(0).getIdCarta());

                for(Carta c : listaCartas){
                    if( String.valueOf(c.getIdCarta()).contains(charSequence) ){
                        listaPesquisa.add(c);
                        //System.out.println("encontrou: "+charSequence);
                    }else{
                        //System.out.println("NAO encontrou: "+charSequence);
                        //System.out.println("NAO encontrou: "+c.getIdCarta());
                        //System.out.println("--");
                    }
                }
                ((ListCellListaCartasCadastradas)listViewCartasCadastradas.getAdapter()).update(listaPesquisa);

                //adapter = new ListCellListaCartasCadastradas(ListaCartasCadastradas.this, listaCartas);
                //listViewCartasCadastradas.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void CadastrarCarta(View view){
        final String nomeActivity = this.getClass().getSimpleName();
        Intent it = new Intent(ListaCartasCadastradas.this, Carregando.class);
        //Toast.makeText(ListaCartas.this,"txt qlq: "+carta.getConteudo(),Toast.LENGTH_LONG).show();
        it.putExtra("funcao","cadastro");
        it.putExtra("nomeActivity",nomeActivity);
        startActivity(it);
    }

    @Override
    protected void onResume() {
        super.onResume();

        listaCartas.removeAll(listaCartas);
        listTipoBrinquedo.removeAll(listTipoBrinquedo);
        listaInstituicoes.removeAll(listaInstituicoes);
        listBairro.removeAll(listBairro);


        CartaFacade.buscarTodos(new CartaCallback() {
            @Override
            public void onSuccess(Object obj) {
                listaCartas = (ArrayList)obj;
                TipoBrinquedoFacade.buscarTodos(new TipoBrinquedoCallback() {
                    @Override
                    public void onSuccess(Object obj) {
                        listTipoBrinquedo = (ArrayList)obj;
                        BairroFacade.buscarTodos(new BairroCallback() {
                            @Override
                            public void onSuccess(Object obj) {
                                listBairro= (ArrayList)obj;
                                InstituicaoFacade.buscarTodos(new InstituicaoCallback() {
                                    @Override
                                    public void onSuccess(Object obj) {
                                        listaInstituicoes= (ArrayList)obj;
                                        adapter = new ListCellListaCartasCadastradas(ListaCartasCadastradas.this, listaCartas);
                                        listViewCartasCadastradas.setAdapter(adapter);
                                    }

                                    @Override
                                    public void onFailure(Throwable t) {

                                    }
                                });
                            }

                            @Override
                            public void onFailure(Throwable t) {

                            }
                        });
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });


        /*
        listaCartas.removeAll(listaCartas);
        List<Carta> lista = ((List<Carta>) getIntent().getExtras().getSerializable("listCartas"));
        for(Carta e : lista){
            listaCartas.add(e);
        }

        listTipoBrinquedo.removeAll(listTipoBrinquedo);
        List<TipoBrinquedo> lista2 = ((List<TipoBrinquedo>) getIntent().getExtras().getSerializable("listTipoBrinquedo"));
        for(TipoBrinquedo i : lista2){
            //System.out.println("listaBrinq: "+i.getNomeTipoBrinquedo());
            listTipoBrinquedo.add(i);
        }
        listBairro.removeAll(listBairro);
        List<Bairro> lista3 = ((List<Bairro>) getIntent().getExtras().getSerializable("listBairro"));
        for(Bairro i : lista3){
            //System.out.println("listaBairro: "+i.getNomeBairro());
            listBairro.add(i);
        }
        listaInstituicoes.removeAll(listaInstituicoes);
        List<Instituicao> lista4 = ((List<Instituicao>) getIntent().getExtras().getSerializable("listInstituicao"));
        for(Instituicao i : lista4){
            //System.out.println("listaBairro: "+i.getNomeInstituicao());
            listaInstituicoes.add(i);
        }

        adapter = new ListCellListaCartasCadastradas(ListaCartasCadastradas.this, listaCartas);
        listViewCartasCadastradas.setAdapter(adapter);
        */
    }
}
