package com.example.carlo.posandroidprojetofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carlo.posandroidprojetofinal.facade.ProdutoFacade;
import com.example.carlo.posandroidprojetofinal.model.Produto;
import com.example.carlo.posandroidprojetofinal.service.ProdutoCallback;

public class CriarProduto extends AppCompatActivity {
    private EditText edtProdutoDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_produto);

        edtProdutoDescricao=findViewById(R.id.edtProdutoDescricao);
    }

    public void inserirProduto(View view){
        if(edtProdutoDescricao.getText().toString().trim() == "") return;
        String descricao = edtProdutoDescricao.getText().toString().trim();

        Produto produto = new Produto(descricao);
        System.out.println("nome prod: "+descricao);
        ProdutoFacade.inserir(produto, new ProdutoCallback() {
            @Override
            public void onSuccess(Object obj) {
                System.out.println("inseriu o produto.");
                edtProdutoDescricao.setText("");
                Toast.makeText(CriarProduto.this, "Produto inserido.", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("nao inseriu o produto.");
                Toast.makeText(CriarProduto.this, "Não foi possível inserir.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
