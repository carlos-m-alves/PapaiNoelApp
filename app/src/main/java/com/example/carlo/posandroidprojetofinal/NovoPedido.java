package com.example.carlo.posandroidprojetofinal;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlo.posandroidprojetofinal.facade.ClienteFacade;
import com.example.carlo.posandroidprojetofinal.facade.PedidoFacade;
import com.example.carlo.posandroidprojetofinal.facade.ProdutoFacade;
import com.example.carlo.posandroidprojetofinal.model.Cliente;
import com.example.carlo.posandroidprojetofinal.model.ItemPedido;
import com.example.carlo.posandroidprojetofinal.model.Pedido;
import com.example.carlo.posandroidprojetofinal.model.Produto;
import com.example.carlo.posandroidprojetofinal.service.ClienteCallback;
import com.example.carlo.posandroidprojetofinal.service.PedidoCallback;
import com.example.carlo.posandroidprojetofinal.service.ProdutoCallback;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NovoPedido extends AppCompatActivity {
    private TextView txtNovoPedido;
    private Button btnAdicionarSpinner, btnRemoverSpinner, btnNovoPedido;
    private AutoCompleteTextView acvNovoPedidoCpf;
    private ProgressBar progressBar;
    private LinearLayout llNovoPedido;
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Produto> listaProdutos = new ArrayList<>();

    private int i = 2;//seta a posicao q sera inserido o editText
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_pedido);

        txtNovoPedido=findViewById(R.id.txtNovoPedido);
        btnAdicionarSpinner=findViewById(R.id.btnAdicionarSpinner);
        btnRemoverSpinner=findViewById(R.id.btnRemoverSpinner);
        btnNovoPedido=findViewById(R.id.btnNovoPedido);

        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        acvNovoPedidoCpf=findViewById(R.id.acvNovoPedidoCpf);
        llNovoPedido=findViewById(R.id.llNovoPedido);

        //nao mostra a activity com o teclado aberto
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //Integer[] q = new Integer[]{1,2,3,4,5,6};
        //ArrayAdapter<Integer> arrayAdapter2 =
        //        new ArrayAdapter<Integer>(this,R.layout.support_simple_spinner_dropdown_item, q);
        //spNovoPedidoQtd.setAdapter(arrayAdapter2);

        //CARREGA CPF NO AUTOCOMPLETETEXT
        /*
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                //System.out.println("qtd de clientes vindo no CREATE "+ listaClientes.size());
                //Integer[] COUNTRIES = new Integer[] {112,232,133,334,2235,641};
                Integer[] listaCpf = new Integer[listaClientes.size()];
                for(int i = 0; i< listaClientes.size(); i ++){
                    listaCpf[i] = Integer.valueOf(listaClientes.get(i).getCpf());
                //    System.out.println("cpf do cara indo pra lista: "+listaCpf[i]);
                }

                ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(NovoPedido.this,
                        android.R.layout.simple_dropdown_item_1line, listaCpf);
                acvNovoPedidoCpf.setAdapter(adapter);
            }
        },2000);
*/

        //insere os spinner quando a tela é criada
        /*Handler p = new Handler();
        p.postDelayed(new Runnable() {
            @Override
            public void run() {
                insereEditTextHabilidade();
            }
        },2000);*/
        //insereEditTextHabilidade();

        //System.out.println("qtd items: "+ llNovoPedido.getChildCount());
        for(int ind = 2; ind < llNovoPedido.getChildCount()-2; ind++){
            LinearLayout teste = (LinearLayout) llNovoPedido.getChildAt(2);
            //colocar dentro de um laço
            System.out.println("id do elemento: " + teste.getId());
            Spinner spnTeste = (Spinner) teste.getChildAt(0);
            spnTeste.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    System.out.println("Axoooooooooooo");
                    System.out.println("item selecionado: " + adapterView.getSelectedItem().toString().trim());
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
        //System.out.println("qtd filhos: " + llNovoPedido.getChildCount());
    }

    public void insereEditTextHabilidade(){
        LinearLayout llSpiners = new LinearLayout(NovoPedido.this);
        llSpiners.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        final Spinner spnProduto = new Spinner(NovoPedido.this);
        spnProduto.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1.0f
        ));

        //Handler h = new Handler();
        //h.postDelayed(new Runnable() {
        //      @Override
        //      public void run() {
        //          System.out.println("qts produtos estao vindo: " +listaProdutos.size());
                  String[] listaProd = new String[listaProdutos.size()];
                  for(int i=0; i < listaProdutos.size(); i++){
                      listaProd[i] = listaProdutos.get(i).getDescricao();
                  }

                  ArrayAdapter <String> arrayAdapter1 =
                          new ArrayAdapter<String>(NovoPedido.this, R.layout.support_simple_spinner_dropdown_item, listaProd);
                  spnProduto.setAdapter(arrayAdapter1);
        //      }
        //},2000);
/*
                ArrayAdapter < String > arrayAdapter1 =
                        new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, s);
        spnProduto.setAdapter(arrayAdapter1);
*/

        Spinner spnQtd = new Spinner(NovoPedido.this);
        spnQtd.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1.0f
        ));

        //QTD ITENS PERMITIDOS
        Integer[] q = new Integer[]{1,2,3,4,5,6};
        ArrayAdapter<Integer> arrayAdapter2 =
                new ArrayAdapter<Integer>(this,R.layout.support_simple_spinner_dropdown_item, q);
        spnQtd.setAdapter(arrayAdapter2);

        int nomeId = i ;
        //System.out.println("valor do i: "+i);
        spnProduto.setId(nomeId);
        //System.out.println("id criado Prod: "+spnProduto.getId());
        //System.out.println("Nome do produto criado: " + spnProduto.getSelectedItem().toString().trim());
        spnQtd.setId(nomeId+2);
        //System.out.println("id criado Qtd: "+spnQtd.getId());
        llNovoPedido.addView(llSpiners,i);
        llSpiners.addView(spnProduto,0);
        llSpiners.addView(spnQtd,1);
        i++;
    }

    public void NovoPedido(View view){
        if(acvNovoPedidoCpf.getText().toString() == "") return;
        String cpf = acvNovoPedidoCpf.getText().toString().trim();

        List<ItemPedido> items = new ArrayList<>();
        ItemPedido itemPedido;
        for(int ind = 2; ind < llNovoPedido.getChildCount()-2; ind++) {
            LinearLayout primLl = (LinearLayout) llNovoPedido.getChildAt(ind);
            //System.out.println("tipo classe: " + primLl.getChildAt(0).getClass());
            Spinner spnProduto = (Spinner) primLl.getChildAt(0);
            System.out.println("spinner produto: "+spnProduto.getSelectedItem().toString());
            Spinner spnQuantidade = (Spinner) primLl.getChildAt(1);
            System.out.println("spinner qtd: "+spnQuantidade.getSelectedItem().toString());
            System.out.println("----------------------");

            //pega o id do produto do bd
            Produto produto = new Produto();
            for(Produto p : listaProdutos){
                if(p.getDescricao().equals(spnProduto.getSelectedItem().toString().trim())){
                    //System.out.println("cpf do cliente: " + c.getCpf());
                    //produto.setDescricao(spnProduto.getSelectedItem().toString());
                    produto.setId(p.getId());
                    produto = p;
                    break;
                }
            }

            itemPedido = new ItemPedido(produto, Integer.parseInt(spnQuantidade.getSelectedItem().toString()));
            items.add(itemPedido);
        }

        Cliente cliente = new Cliente();
        for(Cliente c : listaClientes){
            if(c.getCpf().equals(cpf)){
                //System.out.println("cpf do cliente: " + c.getCpf());
                cliente = c;
                break;
            }
        }
        System.out.println("cpf do cliente NP: "+cliente.getCpf());

        //data,cliente,lista
        Pedido pedido = new Pedido(new Date(), cliente, items);
        PedidoFacade.inserir(pedido, new PedidoCallback() {
            @Override
            public void onSuccess(Object obj) {
                Toast.makeText(NovoPedido.this, "Pedido inserido.", Toast.LENGTH_SHORT).show();
                System.out.println("retornou ok");
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(NovoPedido.this, "Não foi possível inserir o pedido.", Toast.LENGTH_SHORT).show();
                System.out.println("deu erro aki");
            }
        });
    }

    public void AdicionarSpinner(View view){
        insereEditTextHabilidade();
    }

    public void RemoverSpinner(View view){
        if(i>3) {
            //System.out.println("valor do I: "+i);
            llNovoPedido.removeViewAt(i - 1);
            i--;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("passando pelo resumeee");
        ClienteFacade.carregar(new ClienteCallback() {
            @Override
            public void onSuccess(Object obj) {
                listaClientes = (ArrayList)obj;
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        ProdutoFacade.carregar(new ProdutoCallback() {
            @Override
            public void onSuccess(Object obj) {
                listaProdutos= (ArrayList)obj;
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("passando pelo starteeee");

        class PegaClientesTask extends AsyncTask<Void, Integer, List<Cliente>> {
            @Override
            protected List<Cliente> doInBackground(Void... voids) {
                for(int inc=0;inc<=100; inc+=2){
                    progressBar.setProgress(inc);
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //System.out.println("entrou no doInBack");
                ClienteFacade.carregar(new ClienteCallback() {
                    @Override
                    public void onSuccess(Object obj) {
                        listaClientes = (ArrayList)obj;
                        //System.out.println("qtd d clientes no bd: " + listaClientes.size());
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
                //System.out.println("ta invisivel");

                String[] listaCpf = new String[clientes.size()];
                for(int i = 0; i< clientes.size(); i ++){
                    listaCpf[i] = clientes.get(i).getCpf();
                    //System.out.println("cpf do cara indo pra lista: "+listaCpf[i]);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(NovoPedido.this,
                        android.R.layout.simple_dropdown_item_1line, listaCpf);
                acvNovoPedidoCpf.setAdapter(adapter);
            }
        }
        PegaClientesTask pegaClientesTask = new PegaClientesTask();
        pegaClientesTask.execute();

        class PegaProdutosTask extends AsyncTask<Void, Integer, List<Produto>> {

            @Override
            protected List<Produto> doInBackground(Void... voids) {
                /*
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }*/
                ProdutoFacade.carregar(new ProdutoCallback() {
                    @Override
                    public void onSuccess(Object obj) {
                        listaProdutos= (ArrayList)obj;
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });

                return listaProdutos;
            }

            @Override
            protected void onPostExecute(List<Produto> produtos) {
                super.onPostExecute(produtos);
                listaProdutos=produtos;
                insereEditTextHabilidade();
                progressBar.setVisibility(View.INVISIBLE);
                txtNovoPedido.setVisibility(View.VISIBLE);
                acvNovoPedidoCpf.setVisibility(View.VISIBLE);
                btnAdicionarSpinner.setVisibility(View.VISIBLE);
                btnRemoverSpinner.setVisibility(View.VISIBLE);
                btnNovoPedido.setVisibility(View.VISIBLE);
            }
        }
        PegaProdutosTask pegaProdutosTask = new PegaProdutosTask();
        pegaProdutosTask.execute();
    }
}
