package com.example.carlo.posandroidprojetofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carlo.posandroidprojetofinal.facade.ClienteFacade;
import com.example.carlo.posandroidprojetofinal.model.Cliente;
import com.example.carlo.posandroidprojetofinal.service.ClienteCallback;


public class CriarCliente extends AppCompatActivity {
    private EditText edtClienteCpf,edtClienteNome,edtClienteSobreNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_cliente);
        edtClienteCpf=findViewById(R.id.edtClienteCpf);
        edtClienteNome=findViewById(R.id.edtClienteNome);
        edtClienteSobreNome=findViewById(R.id.edtClienteSobreNome);
    }

    public void inserirCliente(View view){
        if(edtClienteCpf.getText().toString().trim().equals("")) return;
        if(edtClienteNome.getText().toString().trim().equals("")) return;
        if(edtClienteSobreNome.getText().toString().trim().equals("")) return;
        String cpf = edtClienteCpf.getText().toString().trim();
        String nome = edtClienteNome.getText().toString().trim();
        String sobrenome = edtClienteSobreNome.getText().toString().trim();

        Cliente cliente = new Cliente(nome,sobrenome,cpf);

        ClienteFacade.inserir(cliente, new ClienteCallback() {
            @Override
            public void onSuccess(Object obj) {
                System.out.println("inseriu o cliente.");
                edtClienteCpf.setText("");
                edtClienteNome.setText("");
                edtClienteSobreNome.setText("");
                Toast.makeText(CriarCliente.this, "Cliente inserido.", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("NAO inseriu o cliente.");
                Toast.makeText(CriarCliente.this, "Nao inseriu.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
