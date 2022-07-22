package com.example.carlo.posandroidprojetofinal;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.carlo.posandroidprojetofinal.adapter.ListCell;
import com.example.carlo.posandroidprojetofinal.bean.Usuario;
import com.example.carlo.posandroidprojetofinal.facade.ClienteFacade;
import com.example.carlo.posandroidprojetofinal.facade.UsuarioFacade;
import com.example.carlo.posandroidprojetofinal.model.Cliente;
import com.example.carlo.posandroidprojetofinal.model.Teste;
import com.example.carlo.posandroidprojetofinal.service.ClienteCallback;
import com.example.carlo.posandroidprojetofinal.service.LoginCallback;
import com.example.carlo.posandroidprojetofinal.service.MeuListener;
import com.example.carlo.posandroidprojetofinal.task.PegaClientes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);
    }

    public void PaginaPrincipal(View view){
        String email = etUsername.getText().toString().trim();
        String senha = etPassword.getText().toString().trim();
        //System.out.println("EMAIL: "+email);
        Usuario u = new Usuario();
        u.setEmail(etUsername.getText().toString().trim());
        u.setSenha(etPassword.getText().toString().trim());
        UsuarioFacade.verificarLogin(email, senha, new LoginCallback() {
            @Override
            public void onSuccess(Object obj) {
                Usuario a = (Usuario)obj;
                //System.out.println("retorno: "+a.getId());
                //System.out.println("retorno: "+a.getPermissao());

                if(a.getPermissao().equals("PADRINHO")) {
                    Intent it = new Intent(MainActivity.this, Funcionalidades_Usuario.class);
                    it.putExtra("usuario", (Serializable) a);
                    startActivity(it);
                }else{
                    System.out.println("FUNCIONARIO LOGADO");
                    Intent it = new Intent(MainActivity.this, Funcionalidades_funcionario.class);
                    it.putExtra("usuario", (Serializable) a);
                    startActivity(it);
                }


                finish();
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("erro: "+t.toString());
                Toast.makeText(MainActivity.this,"Login incorreto!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void CadastrarPadrinho(View view) {
        startActivity(new Intent(this, EscolheTipoPadrinho.class));
    }

    public void FuncionarioUsuario(View view) {
        startActivity(new Intent(this, Funcionalidades_funcionario.class));
    }
}
