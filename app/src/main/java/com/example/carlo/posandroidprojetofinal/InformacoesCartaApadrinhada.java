package com.example.carlo.posandroidprojetofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.carlo.posandroidprojetofinal.bean.Carta;

public class InformacoesCartaApadrinhada extends AppCompatActivity {

    TextView txtInfCartaConteudo, txtInfCartaBrinquedoCrianca, txtInfCartaIdadeCrianca, txtInfCartaNomeCrianca, txtInfCartaIdCarta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes_carta_apadrinhada);

        txtInfCartaNomeCrianca=findViewById(R.id.txtInfCartaNomeCrianca);
        txtInfCartaIdadeCrianca=findViewById(R.id.txtInfCartaIdadeCrianca);
        txtInfCartaBrinquedoCrianca=findViewById(R.id.txtInfCartaBrinquedoCrianca);
        txtInfCartaConteudo=findViewById(R.id.txtInfCartaConteudo);
        txtInfCartaIdCarta=findViewById(R.id.txtInfCartaIdCarta);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Carta carta = (Carta) getIntent().getExtras().getSerializable("carta");
        txtInfCartaNomeCrianca.setText(carta.getCrianca().getNomeCrianca());
        txtInfCartaIdadeCrianca.setText(String.valueOf(carta.getCrianca().getIdade())+" anos");
        txtInfCartaBrinquedoCrianca.setText(carta.getBrinquedo().getNomeBrinquedo());
        txtInfCartaConteudo.setText(carta.getDescricao());
        txtInfCartaIdCarta.setText("Id: #"+String.valueOf(carta.getIdCarta()));
    }
}
