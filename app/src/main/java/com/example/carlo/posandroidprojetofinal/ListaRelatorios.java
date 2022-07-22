package com.example.carlo.posandroidprojetofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ListaRelatorios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_relatorios);
    }
    public void GraficoUm(View view) {
        Intent i = new Intent(ListaRelatorios.this, Carregando.class);
        i.putExtra("nomeActivity",this.getClass().getSimpleName());
        i.putExtra("grafico","GraficoUm");
        startActivity(i);
    }

    public void GraficoDois(View view) {
        Intent i = new Intent(ListaRelatorios.this, Carregando.class);
        i.putExtra("nomeActivity",this.getClass().getSimpleName());
        i.putExtra("grafico","GraficoDois");
        startActivity(i);
    }

    public void GraficoTres(View view) {
        Intent i = new Intent(ListaRelatorios.this, Carregando.class);
        i.putExtra("nomeActivity",this.getClass().getSimpleName());
        i.putExtra("grafico","GraficoTres");
        startActivity(i);
    }

    public void GraficoQuatro(View view) {
        Intent i = new Intent(ListaRelatorios.this, Carregando.class);
        i.putExtra("nomeActivity",this.getClass().getSimpleName());
        i.putExtra("grafico","GraficoQuatro");
        startActivity(i);
    }
}
