package com.example.carlo.posandroidprojetofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.carlo.posandroidprojetofinal.bean.Empresa;
import com.example.carlo.posandroidprojetofinal.bean.Instituicao;

public class EditarEmpresa extends AppCompatActivity {

    private EditText edtEmpresaNome, edtEmpresaTelefone, edtEmpresaEndRua, edtEmpresaEndNumero, edtEmpresaEndComplemento;
    Spinner spiEmpresaBairro, spiEmpresaCidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_empresa);

        Bundle dados = getIntent().getExtras();
        Empresa empresa = (Empresa) dados.getSerializable("empresa");

        edtEmpresaNome=findViewById(R.id.edtEmpresaNome);
        edtEmpresaTelefone=findViewById(R.id.edtEmpresaTelefone);
        edtEmpresaEndRua=findViewById(R.id.edtEmpresaEndRua);
        edtEmpresaEndNumero=findViewById(R.id.edtEmpresaEndNumero);
        edtEmpresaEndComplemento=findViewById(R.id.edtEmpresaEndComplemento);
        spiEmpresaBairro=findViewById(R.id.spiEmpresaBairro);
        spiEmpresaCidade=findViewById(R.id.spiEmpresaCidade);

        edtEmpresaNome.setText(empresa.getNomeEmpresa());
        edtEmpresaTelefone.setText(empresa.getTelefone());
    }

    public void AtualizaEmpresa(View view){

    }
}
