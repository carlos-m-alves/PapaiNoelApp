package com.example.carlo.posandroidprojetofinal;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlo.posandroidprojetofinal.bean.Carta;
import com.example.carlo.posandroidprojetofinal.bean.Usuario;
import com.example.carlo.posandroidprojetofinal.facade.CartaFacade;
import com.example.carlo.posandroidprojetofinal.service.CartaCallback;

import org.w3c.dom.Text;

import java.io.Serializable;

public class LerCarta extends AppCompatActivity {
    Usuario usuario = new Usuario();
    private TextView txtLeCartaNome, txtLeCartaBrinquedo, txtLeCartaCartinha, txtLerCartaIdCarta;
    Carta carta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ler_carta);

        txtLeCartaNome = findViewById(R.id.txtLeCartaNome);
        txtLeCartaBrinquedo = findViewById(R.id.txtLeCartaBrinquedo);
        txtLeCartaCartinha = findViewById(R.id.txtLeCartaCartinha);
        txtLerCartaIdCarta= findViewById(R.id.txtLerCartaIdCarta);
    }

    public void Apadrinhar(View view){
        System.out.println("ID PADRINHO: "+usuario.getId());
        System.out.println("ID CARTA: "+carta.getIdCarta());
        CartaFacade.apadrinharCarta(usuario.getId(), carta.getIdCarta(), new CartaCallback() {
            @Override
            public void onSuccess(Object obj) {
                Toast.makeText(LerCarta.this, "Carta apadrinhada!", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                },1000);

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Usuario usu = (Usuario) getIntent().getExtras().getSerializable("usuario");
        usuario = usu;

        Bundle dados = getIntent().getExtras();
        carta = (Carta) dados.getSerializable("carta");

        System.out.println("dados da carta: "+carta.getCrianca().getNomeCrianca());
        txtLeCartaNome.setText("Carta do "+carta.getCrianca().getNomeCrianca());
        txtLeCartaBrinquedo.setText(carta.getBrinquedo().getNomeBrinquedo());
        txtLeCartaCartinha.setText(carta.getDescricao());
        txtLerCartaIdCarta.setText("Id: #"+String.valueOf(carta.getIdCarta()));
    }
}
