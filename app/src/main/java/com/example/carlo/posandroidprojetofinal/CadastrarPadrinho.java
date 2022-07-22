package com.example.carlo.posandroidprojetofinal;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.carlo.posandroidprojetofinal.bean.Pessoa;
import com.example.carlo.posandroidprojetofinal.facade.UsuarioFacade;
import com.example.carlo.posandroidprojetofinal.service.UsuarioCallback;

public class CadastrarPadrinho extends AppCompatActivity {

    private Switch switchMascPadrinho;
    private EditText edtCadPadriNome, edtCadPadriCpf, edtCadPadriEmail, edtCadPadriSenha, edtCadPadriSenhaConfirme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_padrinho);

        switchMascPadrinho=findViewById(R.id.switchMascPadrinho);

        switchMascPadrinho.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    //switchMascPadrinho.setTextOn("Masculino");
                    switchMascPadrinho.setText("Feminino");
                } else {
                    //do something when unchecked
                    switchMascPadrinho.setText("Masculino");
                }
            }
        });
    }

    public void CadastrarPessoa(View view){
        edtCadPadriNome = findViewById(R.id.edtCadPadriNome);
        edtCadPadriCpf = findViewById(R.id.edtCadPadriCpf);
        edtCadPadriEmail = findViewById(R.id.edtCadPadriEmail);
        edtCadPadriSenha = findViewById(R.id.edtCadPadriSenha);
        edtCadPadriSenhaConfirme = findViewById(R.id.edtCadPadriSenhaConfirme);

        if( edtCadPadriNome.getText().toString().equals("") ||
            edtCadPadriCpf.getText().toString().equals("") ||
            edtCadPadriEmail.getText().toString().equals("") ||
            edtCadPadriSenha.getText().toString().equals("") ||
            edtCadPadriSenhaConfirme.getText().toString().equals("")){
                Toast.makeText(this,"Preencha todos os campos",Toast.LENGTH_SHORT).show();
        }

        if( !edtCadPadriSenha.getText().toString().equals(edtCadPadriSenhaConfirme.getText().toString())){
            Toast.makeText(this,"Os campos de senha devem ser iguais.",Toast.LENGTH_SHORT).show();
        }

        Pessoa p = new Pessoa();
        p.setNome(edtCadPadriNome.getText().toString());
        p.setCcpf_cnpj(edtCadPadriCpf.getText().toString());
        p.setEmail(edtCadPadriEmail.getText().toString());
        p.setSenha(edtCadPadriSenha.getText().toString());
        p.setSexo("H".charAt(0));
        p.setPermissao("PADRINHO");

        UsuarioFacade.inserir(p, new UsuarioCallback() {
            @Override
            public void onSuccess(Object obj) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(CadastrarPadrinho.this,"Usuário cadastrado.",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                },2000);
                System.out.println("deu certo.");
                finish();
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(CadastrarPadrinho.this,"Não foi possível cadastrar.",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
