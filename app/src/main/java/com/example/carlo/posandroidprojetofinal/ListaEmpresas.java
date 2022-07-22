package com.example.carlo.posandroidprojetofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.carlo.posandroidprojetofinal.adapter.ListCellListaEmpresas;
import com.example.carlo.posandroidprojetofinal.adapter.ListCellListaInstituicoes;
import com.example.carlo.posandroidprojetofinal.bean.Empresa;
import com.example.carlo.posandroidprojetofinal.bean.Instituicao;

import java.util.ArrayList;
import java.util.List;

public class ListaEmpresas extends AppCompatActivity {

    private ListView listViewEmpresas;
    private List<Empresa> listaEmpresas = new ArrayList<>();

    private ListCellListaEmpresas adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_empresas);
        final String nomeActivity = this.getClass().getSimpleName();

        listViewEmpresas=findViewById(R.id.listViewEmpresas);
        listViewEmpresas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                Empresa empresa = (Empresa) listViewEmpresas.getItemAtPosition(position);
                //System.out.println("pegou a carta da crianca: "+carta.getNome());

                Intent it = new Intent(ListaEmpresas.this, Carregando.class);
                //Toast.makeText(ListaCartas.this,"txt qlq: "+carta.getConteudo(),Toast.LENGTH_LONG).show();
                it.putExtra("nomeActivity",nomeActivity);
                it.putExtra("editar","EditarEmpresa");
                it.putExtra("empresa",empresa);
                startActivity(it);

            }
        });
    }

    public void CriarEmpresa(View view){
        Intent i = new Intent(ListaEmpresas.this, Carregando.class);
        i.putExtra("nomeActivity",this.getClass().getSimpleName());
        i.putExtra("criar","CriarEmpresa");
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Empresa e = new Empresa();
        e.setNomeEmpresa("Empresa 1");
        e.setTelefone("3333-3333");
        listaEmpresas.add(e);
        Empresa e1 = new Empresa();
        e1.setNomeEmpresa("Empresa 2");
        e1.setTelefone("3333-9999");
        listaEmpresas.add(e1);

        adapter = new ListCellListaEmpresas(ListaEmpresas.this, listaEmpresas);
        listViewEmpresas.setAdapter(adapter);
    }
}
