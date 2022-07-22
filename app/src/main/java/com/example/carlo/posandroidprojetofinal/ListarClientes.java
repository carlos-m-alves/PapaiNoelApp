package com.example.carlo.posandroidprojetofinal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.carlo.posandroidprojetofinal.adapter.ListCell;
import com.example.carlo.posandroidprojetofinal.facade.ClienteFacade;
import com.example.carlo.posandroidprojetofinal.model.Cliente;
import com.example.carlo.posandroidprojetofinal.service.ClienteCallback;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListarClientes extends AppCompatActivity {
    private ListView listCliente;
    private List<Cliente> listaClientes = new ArrayList<>();

    private ListCell adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_clientes);

        listCliente=findViewById(R.id.listCliente);


        listCliente.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                Cliente cliente = (Cliente) listCliente.getItemAtPosition(position);
                //Toast.makeText(ListarClientes.this,"click"+cliente.getNome()+ " .Id: "+cliente.getId()
                //        ,Toast.LENGTH_SHORT).show();
                System.out.println("pegou o cliente"+cliente.getNome());

                Intent it = new Intent(ListarClientes.this, EditarCliente.class);
                it.putExtra("cliente",cliente);
                startActivity(it);
            }
        });
    }

    public void CriarCliente(View view){
        startActivity(new Intent(this,CriarCliente.class));
    }

    @Override
    protected void onResume() {
        super.onResume();

        ClienteFacade.carregar(new ClienteCallback() {
            @Override
            public void onSuccess(Object obj) {
                listaClientes = (ArrayList)obj;
                //Toast.makeText(ListarClientes.this, "lista carregada.", Toast.LENGTH_LONG).show();

                adapter = new ListCell(ListarClientes.this, listaClientes);
                listCliente.setAdapter(adapter);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("nao carregou.");
                //Toast.makeText(ListarClientes.this, "n carregou.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
