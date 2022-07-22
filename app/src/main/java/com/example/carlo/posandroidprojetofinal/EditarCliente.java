package com.example.carlo.posandroidprojetofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carlo.posandroidprojetofinal.facade.ClienteFacade;
import com.example.carlo.posandroidprojetofinal.model.Cliente;
import com.example.carlo.posandroidprojetofinal.service.ClienteCallback;

public class EditarCliente extends AppCompatActivity {
    private EditText edtEditarCliNome, edtEditarCliSobreNome, edtEditarCliCpf;
    private Cliente c = new Cliente();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_cliente);

        edtEditarCliNome=findViewById(R.id.edtEditarCliNome);
        edtEditarCliSobreNome=findViewById(R.id.edtEditarCliSobreNome);
        edtEditarCliCpf=findViewById(R.id.edtEditarCliCpf);
    }

    public void EditarCliente(View view){
        Bundle dados = getIntent().getExtras();
        Cliente cli = (Cliente) dados.getSerializable("cliente");
        int id = cli.getId();

        if(edtEditarCliNome.getText().toString().trim() == "") return;
        if(edtEditarCliSobreNome.getText().toString().trim() == "") return;
        if(edtEditarCliCpf.getText().toString().trim() == "") return;
        String nome = edtEditarCliNome.getText().toString().trim();
        String sobreNome = edtEditarCliSobreNome.getText().toString().trim();
        String cpf = edtEditarCliCpf.getText().toString().trim();

        Cliente cliente = new Cliente(id, nome,sobreNome,cpf);

        ClienteFacade.alterar(cliente, new ClienteCallback() {
            @Override
            public void onSuccess(Object obj) {
                finish();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
    public void RemoverCliente(View view){
        Bundle dados = getIntent().getExtras();
        Cliente cli = (Cliente) dados.getSerializable("cliente");
        int id = cli.getId();

        ClienteFacade.remover(id, new ClienteCallback() {
            @Override
            public void onSuccess(Object obj) {
                String resposta = (String) obj;
                System.out.println("RESPOSTA DELETAR: " + resposta);
                if(resposta.equals("n")){
                    Toast.makeText(EditarCliente.this, "Nao foi possivel deletar.", Toast.LENGTH_SHORT).show();
                }else{
                    System.out.println("nao deu certo");
                    Toast.makeText(EditarCliente.this, "Deletado.", Toast.LENGTH_SHORT).show();
                }
                finish();
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("nao deu certo, Throwable");
                Toast.makeText(EditarCliente.this, "Nao foi possivel deletar.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("passou no onResume??");
        Bundle dados = getIntent().getExtras();
        Cliente cli = (Cliente) dados.getSerializable("cliente");
        int id = cli.getId();

        ClienteFacade.carregarCliente(id, new ClienteCallback() {
            @Override
            public void onSuccess(Object obj) {
                System.out.println("pegou o carinha222");
                c = (Cliente)obj;
                System.out.println("oq tem aqui?? "+c.getNome());
                System.out.println("oq tem aqui?? "+c.getCpf());
                carregaCampos();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void carregaCampos() {
        edtEditarCliNome.setText(c.getNome());
        edtEditarCliSobreNome.setText(c.getSobreNome());
        edtEditarCliCpf.setText(c.getCpf());
    }
}
