package com.example.carlo.posandroidprojetofinal;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.carlo.posandroidprojetofinal.facade.ClienteFacade;
import com.example.carlo.posandroidprojetofinal.facade.ItemPedidoFacade;
import com.example.carlo.posandroidprojetofinal.model.Cliente;
import com.example.carlo.posandroidprojetofinal.model.ItemPedido;
import com.example.carlo.posandroidprojetofinal.model.Pedido;
import com.example.carlo.posandroidprojetofinal.service.ClienteCallback;
import com.example.carlo.posandroidprojetofinal.service.ItemPedidoCallback;

import java.util.ArrayList;
import java.util.List;

public class ListarPedido extends AppCompatActivity {
    private ProgressBar progressBar;
    private ListView listItens;
    private TextView txtItens;

    private List<ItemPedido> listaItens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_pedido);

        txtItens=findViewById(R.id.txtItens);
        progressBar=findViewById(R.id.progressBar);
        listItens=findViewById(R.id.listItens);
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("passando pelo resumeee");

        int id = -1;
        if( getIntent().getExtras() != null ){
            id = (int) getIntent().getExtras().getSerializable("id_pedido");
        }

        ItemPedidoFacade.buscarItens(id, new ItemPedidoCallback() {
            @Override
            public void onSuccess(Object obj) {
                listaItens = (ArrayList) obj;
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
        class PegaItensTask extends AsyncTask<Void, Integer, List<ItemPedido>> {
            @Override
            protected List<ItemPedido> doInBackground(Void... voids) {
                for(int inc=0;inc<=100; inc+=2){
                    //progressBar.setProgress(inc);
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("entrou no doInBack");
                //pega o id do pedido para buscar no banco de dados
                int id = -1;
                if( getIntent().getExtras() != null ){
                    id = (int) getIntent().getExtras().getSerializable("id_pedido");
                }

                ItemPedidoFacade.buscarItens(id, new ItemPedidoCallback() {
                    @Override
                    public void onSuccess(Object obj) {
                        listaItens = (ArrayList) obj;
                    }
                    @Override
                    public void onFailure(Throwable t) {
                    }
                });

                return listaItens;
            }

            @Override
            protected void onPostExecute(List<ItemPedido> itens) {
                super.onPostExecute(itens);
                //progressBar.setVisibility(View.INVISIBLE);
                System.out.println("ta invisivel");

                String[] listaFinal = new String[itens.size()];
                Integer[] listaQtd = new Integer[itens.size()];
                String[] listaDesc = new String[itens.size()];
                for(int i = 0; i< itens.size(); i ++){
                    listaQtd[i] = Integer.valueOf(itens.get(i).getQuantidade());
                    listaDesc[i] = itens.get(i).getProduto().getDescricao();
                    System.out.println("qtd: "+listaQtd[i]);
                    System.out.println("desc: "+listaDesc[i]);
                    String itemDoPedido = "Produto: ";
                    itemDoPedido+= itens.get(i).getProduto().getDescricao();
                    itemDoPedido+= ". Quantidade: ";
                    itemDoPedido+= itens.get(i).getQuantidade();
                    listaFinal[i] = itemDoPedido;
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListarPedido.this,
                        android.R.layout.simple_dropdown_item_1line, listaFinal);
                listItens.setAdapter(adapter);

                txtItens.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.GONE);
            }
        }
        PegaItensTask pegaItensTask = new PegaItensTask();
        pegaItensTask.execute();
    }
}
