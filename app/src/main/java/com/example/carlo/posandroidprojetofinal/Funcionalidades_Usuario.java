package com.example.carlo.posandroidprojetofinal;

import android.content.Context;
import android.content.Intent;
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

import com.example.carlo.posandroidprojetofinal.bean.Usuario;

import java.io.Serializable;
import java.util.List;

public class Funcionalidades_Usuario extends AppCompatActivity {

    Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionalidades__usuario);
    }

    public void PesquisarCartas(View view){
        final String nomeActivity = this.getClass().getSimpleName();
        Intent it = new Intent(Funcionalidades_Usuario.this, Carregando.class);
        it.putExtra("nomeActivity",nomeActivity);
        it.putExtra("funcao","pesquisarCartas");
        it.putExtra("usuario", (Serializable) usuario);
        startActivity(it);
    }

    public void ListarCartasApadrinhadas(View view){
        final String nomeActivity = this.getClass().getSimpleName();
        Intent it = new Intent(Funcionalidades_Usuario.this, Carregando.class);
        it.putExtra("nomeActivity",nomeActivity);
        it.putExtra("funcao","ListaCartasApadrinhadas");
        it.putExtra("usuario", (Serializable) usuario);
        startActivity(it);
    }

    public void PesquisarAgencia(View view){
        final String nomeActivity = this.getClass().getSimpleName();
        Intent it = new Intent(Funcionalidades_Usuario.this, ListaAgencias.class);
        it.putExtra("nomeActivity",nomeActivity);
        startActivity(it);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Usuario usu = (Usuario) getIntent().getExtras().getSerializable("usuario");
        usuario = usu;
        //usuario = new Usuario(usu);
    }
}
