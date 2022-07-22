package com.example.carlo.posandroidprojetofinal;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.carlo.posandroidprojetofinal.facade.ClienteFacade;
import com.example.carlo.posandroidprojetofinal.facade.PedidoFacade;
import com.example.carlo.posandroidprojetofinal.model.Cliente;
import com.example.carlo.posandroidprojetofinal.model.Pedido;
import com.example.carlo.posandroidprojetofinal.service.ClienteCallback;
import com.example.carlo.posandroidprojetofinal.service.PedidoCallback;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ListaItensPedidos extends AppCompatActivity {
    private ListView listItemPedido;
    private AutoCompleteTextView acvListaPedidoCpf;
    private ProgressBar progressBar;
    private TextView txtlistaPedidos;
    private Button btnNovoPedido;

    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Pedido> listaPedidos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_itens_pedidos);

        //nao mostra a activity com o teclado aberto
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        txtlistaPedidos=findViewById(R.id.txtlistaPedidos);
        progressBar=findViewById(R.id.progressBar);
        listItemPedido=findViewById(R.id.listItemPedido);
        acvListaPedidoCpf=findViewById(R.id.acvListaPedidoCpf);
        btnNovoPedido=findViewById(R.id.btnNovoPedido);

        listItemPedido.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long l) {
                System.out.println("n do item: " + listaPedidos.get(position).getId());

                Intent it = new Intent(ListaItensPedidos.this, ListarPedido.class);
                it.putExtra("id_pedido",listaPedidos.get(position).getId());
                startActivity(it);
            }
        });
    }

    public void BuscarCpf(View view){
        String cpf = acvListaPedidoCpf.getText().toString().trim();
        //System.out.println("cpf q vindo da view: "+cpf);
        PedidoFacade.buscarPedidosPorCliente(cpf, new PedidoCallback() {
            @Override
            public void onSuccess(Object obj) {
                //carrega listView
                listaPedidos = (ArrayList)obj;
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                //SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                //String dateString = format.format(listaPedidos.get(0).getData());
                //System.out.println("data do primeiro item: " + listaPedidos.get(0).getData() +
                //". Dt formatada: "+dateString);

                //pegar pedido por data e fazer um for
                List<String> listaData = new ArrayList<>();
                for(Pedido p : listaPedidos){
                    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                    //SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String date = fmt.format(p.getData());
                    listaData.add(date);
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListaItensPedidos.this,
                        android.R.layout.simple_dropdown_item_1line, listaData);
                listItemPedido.setAdapter(adapter);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("nao conectou. "+t.getMessage());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("passando pelo resumeee");
        ClienteFacade.carregar(new ClienteCallback() {
            @Override
            public void onSuccess(Object obj) {
                listaClientes = (ArrayList) obj;
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("passando pelo startee");
        class PegaClientesTask extends AsyncTask<Void, Integer, List<Cliente>> {
            @Override
            protected List<Cliente> doInBackground(Void... voids) {
                for(int inc=0;inc<=100; inc+=2){
                    //progressBar.setProgress(inc);
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("entrou no doInBack");
                ClienteFacade.carregar(new ClienteCallback() {
                    @Override
                    public void onSuccess(Object obj) {
                        listaClientes = (ArrayList)obj;
                        System.out.println("qtd d clientes no bd: " + listaClientes.size());
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });

                return listaClientes;
            }

            @Override
            protected void onPostExecute(List<Cliente> clientes) {
                super.onPostExecute(clientes);
                //progressBar.setVisibility(View.INVISIBLE);
                System.out.println("ta invisivel");

                String[] listaCpf = new String[clientes.size()];
                for(int i = 0; i< clientes.size(); i ++){
                    listaCpf[i] = clientes.get(i).getCpf();
                    System.out.println("cpf do cara indo pra lista: "+listaCpf[i]);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListaItensPedidos.this,
                        android.R.layout.simple_dropdown_item_1line, listaCpf);
                acvListaPedidoCpf.setAdapter(adapter);


                progressBar.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.GONE);
                acvListaPedidoCpf.setVisibility(View.VISIBLE);
                txtlistaPedidos.setVisibility(View.VISIBLE);
                btnNovoPedido.setVisibility(View.VISIBLE);
            }
        }
        PegaClientesTask pegaClientesTask = new PegaClientesTask();
        pegaClientesTask.execute();
    }
}
