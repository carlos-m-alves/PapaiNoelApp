package com.example.carlo.posandroidprojetofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;

public class EscolheTipoPadrinho extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolhe_tipo_padrinho);
    }

    public void PessoaPad(View view){
        startActivity(new Intent(this, CadastrarPadrinho.class));
        finish();
    }

    public void EmpresaPad(View view){
        final String nomeActivity = this.getClass().getSimpleName();
        Intent it = new Intent(EscolheTipoPadrinho.this, Carregando.class);
        it.putExtra("nomeActivity",nomeActivity);
        it.putExtra("funcao", "criarPadEmpresa");
        startActivity(it);
        finish();
    }
}
