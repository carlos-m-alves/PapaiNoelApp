package com.example.carlo.posandroidprojetofinal;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.carlo.posandroidprojetofinal.bean.Carta;
import com.example.carlo.posandroidprojetofinal.bean.TipoBrinquedo;
import com.example.carlo.posandroidprojetofinal.bean.Usuario;
import com.example.carlo.posandroidprojetofinal.facade.CartaFacade;
import com.example.carlo.posandroidprojetofinal.service.CartaCallback;

import java.io.Serializable;
import java.util.List;

public class FiltrarCartas extends AppCompatActivity {
    Usuario usuario = new Usuario();
    Spinner spnFiltBrinquedo, spnFiltQtdCarta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtrar_cartas);

        spnFiltBrinquedo=findViewById(R.id.spnFiltBrinquedo);
        spnFiltQtdCarta=findViewById(R.id.spnFiltQtdCarta);

        String[] arraySpinner = new String[] {"1", "2", "3", "4", "5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnFiltQtdCarta.setAdapter(adapter);
    }

    public void PesquisarCarta(View view){
        int idTipoBrinquedo = (int)spnFiltBrinquedo.getSelectedItemId();
        System.out.println("id do tipo brinquedo: "+idTipoBrinquedo);
        final String nomeActivity = this.getClass().getSimpleName();
        Intent it = new Intent(FiltrarCartas.this, Carregando.class);
        it.putExtra("nomeActivity",nomeActivity);
        it.putExtra("funcao","pesquisaCartasPorBrinquedo");
        it.putExtra("idTipoBrinquedo",idTipoBrinquedo);
        it.putExtra("usuario", (Serializable) usuario);
        //System.out.println("nome da activity q esta no filtrar: "+nomeActivity);
        startActivity(it);
    }

    public void ApadrinharVariasCartasPessoa(View view){
        final int qtdCartas = (int)spnFiltQtdCarta.getSelectedItemId()+1;
        CartaFacade.insereVariasCartas(usuario.getId(), qtdCartas, new CartaCallback() {
            @Override
            public void onSuccess(Object obj) {
                Toast.makeText(FiltrarCartas.this,
                        "Cartas apadrinhadas. Vá para o menu Cartas Apadrinhadas para visualizá-las.",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Throwable t) {
                CartaFacade.insereVariasCartas(usuario.getId(), qtdCartas, new CartaCallback() {
                    @Override
                    public void onSuccess(Object obj) {
                        Toast.makeText(FiltrarCartas.this,"Cartas apadrinhadas.", Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                            }
                        },1000);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Toast.makeText(FiltrarCartas.this,
                                "Não foi possível apadrinhar a quantidade de cartas desejadas.",
                                Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Usuario usu = (Usuario) getIntent().getExtras().getSerializable("usuario");
        usuario = usu;

        //spinner tipoBrinquedo
        List<TipoBrinquedo> tipoBrinquedos = (List<TipoBrinquedo>) getIntent().getExtras().getSerializable("listTipoBrinquedo");
        String tiposBrinquedos[] = new String[tipoBrinquedos.size()+1];
        int k=1;
        int indiceInstituicao=0;
        tiposBrinquedos[0] = "";
        for(TipoBrinquedo t : tipoBrinquedos){
            tiposBrinquedos[k] = t.getNomeTipoBrinquedo();
            k++;
        }
        ArrayAdapter<String> adapterBrinquedo33 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, tiposBrinquedos);
        adapterBrinquedo33.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnFiltBrinquedo.setAdapter(adapterBrinquedo33);
    }
}
