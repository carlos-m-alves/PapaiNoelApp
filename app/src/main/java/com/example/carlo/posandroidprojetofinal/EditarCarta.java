package com.example.carlo.posandroidprojetofinal;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.carlo.posandroidprojetofinal.bean.Bairro;
import com.example.carlo.posandroidprojetofinal.bean.Brinquedo;
import com.example.carlo.posandroidprojetofinal.bean.Carta;
import com.example.carlo.posandroidprojetofinal.bean.Crianca;
import com.example.carlo.posandroidprojetofinal.bean.Endereco;
import com.example.carlo.posandroidprojetofinal.bean.Instituicao;
import com.example.carlo.posandroidprojetofinal.bean.TipoBrinquedo;
import com.example.carlo.posandroidprojetofinal.facade.CartaFacade;
import com.example.carlo.posandroidprojetofinal.service.CartaCallback;

import java.util.Arrays;
import java.util.List;

public class EditarCarta extends AppCompatActivity {
    EditText edtEdtCartaNomeCrianca, edtEdtCartaIdadeCrianca,edtEdtCartaConteudo,edtEdtCartaBrinquedoCrianca, edtEdtCartaRua,
            edtEdtCartaNumero, edtEdtCartaComplemento, edtEdtCartaCep;
    Spinner spnEdtCartaTipoBrinquedo,spnEdtCartaInstituicao, spnEdtCartaBairro;

    Carta carta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_carta);

        edtEdtCartaNomeCrianca = findViewById(R.id.edtEdtCartaNomeCrianca);
        edtEdtCartaIdadeCrianca = findViewById(R.id.edtEdtCartaIdadeCrianca);
        edtEdtCartaConteudo = findViewById(R.id.edtEdtCartaConteudo);
        edtEdtCartaBrinquedoCrianca = findViewById(R.id.edtEdtCartaBrinquedoCrianca);
        edtEdtCartaRua = findViewById(R.id.edtEdtCartaRua);
        edtEdtCartaNumero = findViewById(R.id.edtEdtCartaNumero);
        edtEdtCartaComplemento = findViewById(R.id.edtEdtCartaComplemento);
        edtEdtCartaCep = findViewById(R.id.edtEdtCartaCep);
        spnEdtCartaTipoBrinquedo = findViewById(R.id.spnEdtCartaTipoBrinquedo);
        spnEdtCartaInstituicao = findViewById(R.id.spnEdtCartaInstituicao);
        spnEdtCartaBairro = findViewById(R.id.spnEdtCartaBairro);
    }

    public void AtualizarCarta(View view){
        System.out.println("id criancaEDT: "+carta.getCrianca().getIdCrianca());
        Carta cartaAtualizar = new Carta();
        cartaAtualizar.setDescricao(edtEdtCartaConteudo.getText().toString().trim());

        Crianca crianca = new Crianca();
        crianca.setNomeCrianca(edtEdtCartaNomeCrianca.getText().toString().trim());
        crianca.setIdade(Integer.parseInt(edtEdtCartaIdadeCrianca.getText().toString().trim()));
        crianca.setIdCrianca(carta.getCrianca().getIdCrianca());
        cartaAtualizar.setCrianca(crianca);

        Brinquedo brinquedo = new Brinquedo();
        brinquedo.setIdBrinquedo(carta.getBrinquedo().getIdBrinquedo());
        brinquedo.setNomeBrinquedo(edtEdtCartaBrinquedoCrianca.getText().toString().trim());

        int idTipoBrinquedoSelecionada = (int) spnEdtCartaTipoBrinquedo.getSelectedItemId();
        System.out.println("TIPO BRINQUEDO SELECIONADO: "+idTipoBrinquedoSelecionada);
        if( idTipoBrinquedoSelecionada != 0 ) {
            brinquedo.setIdTipoBrinquedo(idTipoBrinquedoSelecionada-1);
            cartaAtualizar.setBrinquedo(brinquedo);
        }

        int idInstituicaoSelecionada = (int) spnEdtCartaInstituicao.getSelectedItemId();
        System.out.println("INSTITUICAO SELECIONADA: "+idInstituicaoSelecionada);
        Instituicao instituicao = new Instituicao();
        if( idInstituicaoSelecionada != 0 ) {
            instituicao.setIdInstituicao(idInstituicaoSelecionada - 1);
            cartaAtualizar.setInstituicao(instituicao);
        }

        int idBairroSelecionado = (int) spnEdtCartaBairro.getSelectedItemId();
        System.out.println("BAIRRO SELECIONADO: "+idBairroSelecionado);
        Bairro bairro = new Bairro();
        if( idBairroSelecionado != 0 ) {
            bairro.setIdBairro(idBairroSelecionado - 1);
        }

        Endereco endereco = new Endereco();
        if( !(edtEdtCartaRua.getText().toString().trim().equals("") &&
            edtEdtCartaComplemento.getText().toString().trim().equals("") &&
            edtEdtCartaCep.getText().toString().trim().equals("")) ){
            endereco.setRua(edtEdtCartaRua.getText().toString().trim());
            endereco.setNumero(Integer.parseInt(edtEdtCartaNumero.getText().toString().trim()));
            endereco.setComplemento(edtEdtCartaComplemento.getText().toString().trim());
            endereco.setCep(edtEdtCartaCep.getText().toString().trim());
            //endereco.setBairro(bairro);
            crianca.setRua(endereco.getRua());
            crianca.setNumero(Integer.parseInt(edtEdtCartaNumero.getText().toString().trim()));
            crianca.setComplemento(endereco.getComplemento());
            crianca.setCep(endereco.getCep());
            crianca.setIdEndereco(endereco.getIdEndereco());
            crianca.setBairro(bairro);
            cartaAtualizar.setCrianca(crianca);
        }

        System.out.println("DEPOIS D SET ENDERECO");
        System.out.println("cont "+cartaAtualizar.getDescricao());
        System.out.println("nomeCri "+cartaAtualizar.getCrianca().getNomeCrianca());
        System.out.println("idCri "+cartaAtualizar.getCrianca().getIdCrianca());
        System.out.println("idadeCri "+cartaAtualizar.getCrianca().getIdade());
        System.out.println("idBrinq "+cartaAtualizar.getBrinquedo().getIdBrinquedo());
        System.out.println("nomeBrinq "+cartaAtualizar.getBrinquedo().getNomeBrinquedo());
        System.out.println("idTipoBrinq "+cartaAtualizar.getBrinquedo().getIdTipoBrinquedo());
        System.out.println("rua "+cartaAtualizar.getCrianca().getRua());
        System.out.println("numero "+cartaAtualizar.getCrianca().getNumero());
        System.out.println("compl "+cartaAtualizar.getCrianca().getComplemento());
        System.out.println("cep: "+cartaAtualizar.getCrianca().getCep());

        //System.out.println("id inst "+cartaAtualizar.getInstituicao().getIdInstituicao());
        //System.out.println("inst "+cartaAtualizar.getInstituicao().getNomeInstituicao());

        CartaFacade.atualizar(cartaAtualizar, new CartaCallback() {
            @Override
            public void onSuccess(Object obj) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(EditarCarta.this, "Carta atualizada!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                },1000);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("FAAAILED alterar carta!");
            }
        });
    }

    public void PresenteEntregue(View view){
        //System.out.println("ID OD PADRINHO: "+carta.getPadrinho().getId());
        CartaFacade.presenteEntregue(carta, new CartaCallback() {
            @Override
            public void onSuccess(Object obj) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(EditarCarta.this, "Presente entregue!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                },1000);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    protected void onResume() {
        super.onResume();

        Bundle dados = getIntent().getExtras();
        carta = (Carta) dados.getSerializable("carta");
        System.out.println("ID CARTA DA CRIANCA: "+carta.getCrianca().getIdCrianca());



        carta = ((Carta) getIntent().getExtras().getSerializable("carta"));
        System.out.println("RESUME: id crianca: "+carta.getCrianca().getIdCrianca());
        edtEdtCartaNomeCrianca.setText(carta.getCrianca().getNomeCrianca());
        edtEdtCartaIdadeCrianca.setText(String.valueOf(carta.getCrianca().getIdade()));
        edtEdtCartaConteudo.setText(carta.getDescricao());
        edtEdtCartaBrinquedoCrianca.setText(carta.getBrinquedo().getNomeBrinquedo());
        edtEdtCartaRua.setText(carta.getCrianca().getRua());
        if( carta.getCrianca().getNumero() != 0) {
            edtEdtCartaNumero.setText(String.valueOf(carta.getCrianca().getNumero()));
        }
        edtEdtCartaComplemento.setText(carta.getCrianca().getComplemento());
        edtEdtCartaCep.setText(carta.getCrianca().getCep());

        List<Bairro> listBairro = ((List<Bairro>) getIntent().getExtras().getSerializable("listBairro"));
        String bairros[] = new String[listBairro.size()+1];
        int i=1;
        int indiceBairro=0;
        bairros[0] = "";
        for(Bairro b : listBairro){
            bairros[i] = b.getNomeBairro();
            i++;
            if( carta.getCrianca().getBairro().getIdBairro() != -1 ) {
                if ( b.getIdBairro() == carta.getCrianca().getBairro().getIdBairro() ) {
                    indiceBairro = i;
                }
            }else{System.out.println("NAO TEM BAIRRO: ");}
        }
        //System.out.println("tam: "+bairros.length);
        ArrayAdapter<String> adapterBrinquedo = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, bairros);
        adapterBrinquedo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnEdtCartaBairro.setAdapter(adapterBrinquedo);
        spnEdtCartaBairro.setSelection(indiceBairro-1);

        //spinner tipo brinquedo
        List<TipoBrinquedo> listTipoBrinquedo = ((List<TipoBrinquedo>) getIntent().getExtras().getSerializable("listTipoBrinquedo"));
        String tipoBrinquedo[] = new String[listTipoBrinquedo.size()+1];
        int j=1;
        int indiceBrinquedo=0;
        tipoBrinquedo[0] = "";
        System.out.println("brinquedo vindo: "+carta.getBrinquedo().getNomeBrinquedo());
        System.out.println("id tipo brinq vindo: "+carta.getBrinquedo().getIdTipoBrinquedo());
        for(TipoBrinquedo t : listTipoBrinquedo){
            System.out.println("LIST BRINQ: "+t.getNomeTipoBrinquedo());
            tipoBrinquedo[j] = t.getNomeTipoBrinquedo();
            j++;
            if( carta.getCrianca().getBairro().getIdBairro() != -1 ) {
                if ( t.getIdTipoBrinquedo() == carta.getBrinquedo().getIdTipoBrinquedo() ) {
                    indiceBrinquedo = j;
                }
            }else{System.out.println("NAO TEM TIPO BRINQUEDO: ");}
        }
        ArrayAdapter<String> adapterBrinquedo22 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, tipoBrinquedo);
        adapterBrinquedo22.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnEdtCartaTipoBrinquedo.setAdapter(adapterBrinquedo22);
        System.out.println("indice do brinq: "+indiceBrinquedo);
        spnEdtCartaTipoBrinquedo.setSelection(indiceBrinquedo-1);

        //spinner instituicao
        List<Instituicao> listInstituicao = ((List<Instituicao>) getIntent().getExtras().getSerializable("listInstituicoes"));
        String instituicoes[] = new String[listInstituicao.size()+1];
        int k=1;
        int indiceInstituicao=0;
        instituicoes[0] = "";
        System.out.println("instituicao vindo: "+carta.getBrinquedo().getNomeBrinquedo());
        System.out.println("id inst vindo: "+carta.getBrinquedo().getIdTipoBrinquedo());
        for(Instituicao t : listInstituicao){
            System.out.println("LIST INST: "+t.getNomeInstituicao());
            instituicoes[k] = t.getNomeInstituicao();
            k++;
            if( carta.getInstituicao().getIdInstituicao() != -1 ) {
                if ( t.getIdInstituicao() == carta.getInstituicao().getIdInstituicao() ) {
                    indiceInstituicao = k;
                }
            }else{System.out.println("NAO TEM INSTITUICAO: ");}
        }
        ArrayAdapter<String> adapterBrinquedo33 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, instituicoes);
        adapterBrinquedo33.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnEdtCartaInstituicao.setAdapter(adapterBrinquedo33);
        System.out.println("indice da inst: "+indiceInstituicao);
        spnEdtCartaInstituicao.setSelection(indiceInstituicao-1);

    }
}
