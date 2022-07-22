package com.example.carlo.posandroidprojetofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.carlo.posandroidprojetofinal.adapter.ListCell;
import com.example.carlo.posandroidprojetofinal.adapter.ListCellProd;
import com.example.carlo.posandroidprojetofinal.facade.ProdutoFacade;
import com.example.carlo.posandroidprojetofinal.model.Cliente;
import com.example.carlo.posandroidprojetofinal.model.Produto;
import com.example.carlo.posandroidprojetofinal.service.ProdutoCallback;

import java.util.ArrayList;
import java.util.List;

public class ListarProdutos extends AppCompatActivity {
    private ListView listProduto;
    private List<Produto> listaProdutos = new ArrayList<>();

    private ListCellProd adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_produtos);

        listProduto=findViewById(R.id.listProduto);

        listProduto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                Produto produto = (Produto) listProduto.getItemAtPosition(position);
                //Toast.makeText(ListarProdutos.this,"click"+produto.getDescricao()+ " .Id: "+produto.getId()
                //        ,Toast.LENGTH_SHORT).show();

                Intent it = new Intent(ListarProdutos.this, EditarProduto.class);
                it.putExtra("produto", produto);
                startActivity(it);
            }
        });
    }

    public void CriarProduto(View view){
        startActivity(new Intent(this, CriarProduto.class));
    }

    @Override
    protected void onResume() {
        super.onResume();

        ProdutoFacade.carregar(new ProdutoCallback() {
            @Override
            public void onSuccess(Object obj) {
                listaProdutos = (ArrayList)obj;
                //Toast.makeText(ListarProdutos.this, "lista carregada.", Toast.LENGTH_LONG).show();

                adapter = new ListCellProd(ListarProdutos.this, listaProdutos);
                listProduto.setAdapter(adapter);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
