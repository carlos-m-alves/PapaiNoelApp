package com.example.carlo.posandroidprojetofinal.task;

import android.os.AsyncTask;

import com.example.carlo.posandroidprojetofinal.facade.ClienteFacade;
import com.example.carlo.posandroidprojetofinal.model.Cliente;
import com.example.carlo.posandroidprojetofinal.service.ClienteCallback;
import com.example.carlo.posandroidprojetofinal.service.MeuListener;

import java.util.ArrayList;
import java.util.List;

public class PegaClientes extends AsyncTask<Integer, Integer, List<Cliente> > {
    List<Cliente> lista = new ArrayList<>();

    MeuListener listener = null;

    public PegaClientes(MeuListener listener) {
        this.listener = listener;
    }

    @Override
    protected List<Cliente> doInBackground(Integer... integers) {
//        List<Cliente> lista = new ArrayList<>();

        ClienteFacade.carregar(new ClienteCallback() {
            @Override
            public void onSuccess(Object obj) {
                //variavel global
                try {
                    Thread.sleep(2000);
                    lista = (ArrayList) obj;
                    System.out.println("qtd no doInBackgroun: " + lista.size());
                    //Toast.makeText(ListarClientes.this, "lista carregada.", Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable t) {
                lista = null;
                System.out.println("nao carregou.");
                //Toast.makeText(ListarClientes.this, "n carregou.", Toast.LENGTH_LONG).show();
            }
        });



        //lista.add(new Cliente("car","alv","123"));
        return lista;
    }

    @Override
    protected void onPostExecute(List<Cliente> clientes) {
        super.onPostExecute(clientes);
        System.out.println("qtd clientes no post result da task separada: "+clientes.size());
        listener.onResult(clientes);
    }
}
