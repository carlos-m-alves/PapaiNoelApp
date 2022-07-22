package com.example.carlo.posandroidprojetofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Funcionalidades_funcionario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionalidades_funcionario);
    }

    public void ListarInstituicoes(View view) {
        final String nomeActivity = this.getClass().getSimpleName();
        Intent it = new Intent(Funcionalidades_funcionario.this, Carregando.class);
        it.putExtra("nomeActivity",nomeActivity);
        it.putExtra("funcao","listaInstituicoes");
        startActivity(it);
    }

    public void ListarEventos(View view) {
        final String nomeActivity = this.getClass().getSimpleName();
        Intent it = new Intent(Funcionalidades_funcionario.this, Carregando.class);
        it.putExtra("nomeActivity",nomeActivity);
        it.putExtra("funcao","listaEventos");
        startActivity(it);
    }

    public void ListarCartas(View view) {
        final String nomeActivity = this.getClass().getSimpleName();
        Intent it = new Intent(Funcionalidades_funcionario.this, Carregando.class);
        it.putExtra("nomeActivity",nomeActivity);
        it.putExtra("funcao","listaCartas");
        startActivity(it);
    }

    public void GerarRelatorios(View view) {

        startActivity(new Intent(this, ListaRelatorios.class));
    }
}
