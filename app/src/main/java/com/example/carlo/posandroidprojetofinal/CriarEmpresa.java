package com.example.carlo.posandroidprojetofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class CriarEmpresa extends AppCompatActivity {

    private EditText edtEmpresaNomeCriar, edtEmpresaTelefoneCriar, edtEmpresaEndRuaCriar, edtEmpresaEndNumeroCriar, edtEmpresaEndComplementoCriar;
    Spinner spiEmpresaBairroCriar, spiEmpresaCidadeCriar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_empresa);

        edtEmpresaNomeCriar=findViewById(R.id.edtEmpresaNomeCriar);
        edtEmpresaTelefoneCriar=findViewById(R.id.edtEmpresaTelefoneCriar);
        edtEmpresaEndRuaCriar=findViewById(R.id.edtEmpresaEndRuaCriar);
        edtEmpresaEndNumeroCriar=findViewById(R.id.edtEmpresaEndNumeroCriar);
        edtEmpresaEndComplementoCriar=findViewById(R.id.edtEmpresaEndComplementoCriar);
        spiEmpresaBairroCriar=findViewById(R.id.spiEmpresaBairroCriar);
        spiEmpresaCidadeCriar=findViewById(R.id.spiEmpresaCidadeCriar);
    }

    public void CriarEmpresa(View view){

    }
}
