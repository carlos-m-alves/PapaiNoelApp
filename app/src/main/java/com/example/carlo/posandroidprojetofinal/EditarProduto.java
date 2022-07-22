package com.example.carlo.posandroidprojetofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carlo.posandroidprojetofinal.facade.ProdutoFacade;
import com.example.carlo.posandroidprojetofinal.model.Cliente;
import com.example.carlo.posandroidprojetofinal.model.Produto;
import com.example.carlo.posandroidprojetofinal.service.ProdutoCallback;

public class EditarProduto extends AppCompatActivity {
    private EditText edtEditarProdNome;
    private Produto p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_produto);

        edtEditarProdNome=findViewById(R.id.edtEditarProdNome);
    }

    public void EditarProduto(View view){
        Bundle dados = getIntent().getExtras();
        Produto prod = (Produto) dados.getSerializable("produto");
        int id = prod.getId();

        if(edtEditarProdNome.getText().toString().trim() == "") return;
        String descricao = edtEditarProdNome.getText().toString().trim();
        Produto produto = new Produto(id, descricao);
        System.out.println("id prod: "+id);
        ProdutoFacade.alterar(produto, new ProdutoCallback() {
            @Override
            public void onSuccess(Object obj) {
                Toast.makeText(EditarProduto.this, "Produto alterado", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(EditarProduto.this, "Falha ao alterar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void RemoverProduto(View view){
        Bundle dados = getIntent().getExtras();
        Produto prod = (Produto) dados.getSerializable("produto");
        int id = prod.getId();

        ProdutoFacade.remover(id, new ProdutoCallback() {
            @Override
            public void onSuccess(Object obj) {
                Toast.makeText(EditarProduto.this, "Produto removido", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(EditarProduto.this, "Falha ao remover", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Bundle dados = getIntent().getExtras();
        Produto prod = (Produto) dados.getSerializable("produto");
        int id = prod.getId();

        ProdutoFacade.carregarProduto(id, new ProdutoCallback() {
            @Override
            public void onSuccess(Object obj) {
                p = (Produto)obj;
                carregaCampos();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void carregaCampos() {
        edtEditarProdNome.setText(p.getDescricao());
    }
}
