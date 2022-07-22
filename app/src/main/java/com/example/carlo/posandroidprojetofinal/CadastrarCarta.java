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

import java.io.Serializable;
import java.util.List;

public class CadastrarCarta extends AppCompatActivity {

    EditText edtCadCartaNomeCrianca, edtCadCartaIdadeCrianca, edtCadCartaConteudo, edtCadCartaBrinquedoCrianca,
            edtCadCartaRua, edtCadCartaNumero, edtCadCartaComplemento, edtCadCartaCep;
    Spinner spnCadCartaTipoBrinquedo, spnCadCartaInstituicao, spnCadCartaBairro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_carta);

        spnCadCartaTipoBrinquedo=findViewById(R.id.spnCadCartaTipoBrinquedo);
        spnCadCartaInstituicao=findViewById(R.id.spnCadCartaInstituicao);
        spnCadCartaBairro=findViewById(R.id.spnCadCartaBairro);
    }

    public void CadCarta(View view){
        edtCadCartaNomeCrianca=findViewById(R.id.edtCadCartaNomeCrianca);
        edtCadCartaIdadeCrianca=findViewById(R.id.edtCadCartaIdadeCrianca);
        edtCadCartaConteudo=findViewById(R.id.edtCadCartaConteudo);
        edtCadCartaBrinquedoCrianca=findViewById(R.id.edtCadCartaBrinquedoCrianca);
        edtCadCartaRua=findViewById(R.id.edtCadCartaRua);
        edtCadCartaNumero=findViewById(R.id.edtCadCartaNumero);
        edtCadCartaComplemento=findViewById(R.id.edtCadCartaComplemento);
        edtCadCartaCep=findViewById(R.id.edtCadCartaCep);

        spnCadCartaTipoBrinquedo.getSelectedItemId();

        Carta cartaCadastrar = new Carta();
        cartaCadastrar.setDescricao(edtCadCartaConteudo.getText().toString().trim());

        Crianca crianca = new Crianca();
        crianca.setNomeCrianca(edtCadCartaNomeCrianca.getText().toString().trim());
        crianca.setIdade(Integer.parseInt(edtCadCartaIdadeCrianca.getText().toString().trim()));
        cartaCadastrar.setCrianca(crianca);

        Brinquedo brinquedo = new Brinquedo();
        brinquedo.setNomeBrinquedo(edtCadCartaBrinquedoCrianca.getText().toString().trim());

        int idTipoBrinquedoSelecionada = (int) spnCadCartaTipoBrinquedo.getSelectedItemId();
        System.out.println("TIPO BRINQUEDO SELECIONADO: "+idTipoBrinquedoSelecionada);
        if( idTipoBrinquedoSelecionada != 0 ) {
            brinquedo.setIdTipoBrinquedo(idTipoBrinquedoSelecionada);
            cartaCadastrar.setBrinquedo(brinquedo);
        }

        int idInstituicaoSelecionada = (int) spnCadCartaInstituicao.getSelectedItemId();
        System.out.println("INSTITUICAO SELECIONADA: "+idInstituicaoSelecionada);
        Instituicao instituicao = new Instituicao();
        if( idInstituicaoSelecionada != 0 ) {
            instituicao.setIdInstituicao(idInstituicaoSelecionada);
            cartaCadastrar.setInstituicao(instituicao);
        }

        int idBairroSelecionado = (int) spnCadCartaBairro.getSelectedItemId();
        System.out.println("BAIRRO SELECIONADO: "+idBairroSelecionado);
        Bairro bairro = new Bairro();
        if( idBairroSelecionado != 0 ) {
            bairro.setIdBairro(idBairroSelecionado);
        }

        Endereco endereco = new Endereco();
        if( !(edtCadCartaRua.getText().toString().trim().equals("") &&
                edtCadCartaComplemento.getText().toString().trim().equals("") &&
                edtCadCartaCep.getText().toString().trim().equals("")) ){
            endereco.setRua(edtCadCartaRua.getText().toString().trim());
            endereco.setNumero(Integer.parseInt(edtCadCartaNumero.getText().toString().trim()));
            endereco.setComplemento(edtCadCartaComplemento.getText().toString().trim());
            endereco.setCep(edtCadCartaCep.getText().toString().trim());
            //endereco.setBairro(bairro);
            crianca.setRua(endereco.getRua());
            crianca.setNumero(Integer.parseInt(edtCadCartaNumero.getText().toString().trim()));
            crianca.setComplemento(endereco.getComplemento());
            crianca.setCep(endereco.getCep());
            crianca.setIdEndereco(endereco.getIdEndereco());
            crianca.setBairro(bairro);
            cartaCadastrar.setCrianca(crianca);
        }


        System.out.println("DEPOIS D SET ENDERECO");
        System.out.println("cont "+cartaCadastrar.getDescricao());
        System.out.println("nomeCri "+cartaCadastrar.getCrianca().getNomeCrianca());
        System.out.println("idadeCri "+cartaCadastrar.getCrianca().getIdade());
        System.out.println("id tipo brinq "+cartaCadastrar.getBrinquedo().getIdTipoBrinquedo());
        System.out.println("nomeBrinq "+cartaCadastrar.getBrinquedo().getNomeBrinquedo());
        System.out.println("rua "+cartaCadastrar.getCrianca().getRua());
        System.out.println("numero "+cartaCadastrar.getCrianca().getNumero());
        System.out.println("compl "+cartaCadastrar.getCrianca().getComplemento());
        System.out.println("cep: "+cartaCadastrar.getCrianca().getCep());
        //System.out.println("id inst "+cartaCadastrar.getInstituicao().getIdInstituicao());

        CartaFacade.inserir(cartaCadastrar, new CartaCallback() {
            @Override
            public void onSuccess(Object obj) {
                Toast.makeText(CadastrarCarta.this,"Carta cadastrada!",Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                },2000);
                //System.out.println("CHEGOU NA FUNCAO PRA INSERIR");
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(CadastrarCarta.this,"Não foi possível cadastrar a carta.",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        //spinner bairro
        List<Bairro> listBairro = ((List<Bairro>) getIntent().getExtras().getSerializable("listBairro"));
        String bairros[] = new String[listBairro.size()+1];
        int i=1;
        bairros[0] = "";
        for(Bairro b : listBairro){
            bairros[i] = b.getNomeBairro();
            i++;
        }
        //System.out.println("tam: "+bairros.length);
        ArrayAdapter<String> adapterBrinquedo = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, bairros);
        adapterBrinquedo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCadCartaBairro.setAdapter(adapterBrinquedo);

        //spinner tipo brinquedo
        List<TipoBrinquedo> listTipoBrinquedo = ((List<TipoBrinquedo>) getIntent().getExtras().getSerializable("listTipoBrinquedo"));
        String tipoBrinquedo[] = new String[listTipoBrinquedo.size()+1];
        int j=1;
        tipoBrinquedo[0] = "";
        for(TipoBrinquedo t : listTipoBrinquedo){
            tipoBrinquedo[j] = t.getNomeTipoBrinquedo();
            j++;
        }
        ArrayAdapter<String> adapterBrinquedo22 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, tipoBrinquedo);
        adapterBrinquedo22.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCadCartaTipoBrinquedo.setAdapter(adapterBrinquedo22);

        //spinner instituicao
        List<Instituicao> listInstituicao = ((List<Instituicao>) getIntent().getExtras().getSerializable("listInstituicao"));
        String instituicoes[] = new String[listInstituicao.size()+1];
        int k=1;
        instituicoes[0] = "";
        for(Instituicao t : listInstituicao){
            instituicoes[k] = t.getNomeInstituicao();
            k++;
        }
        ArrayAdapter<String> adapterBrinquedo33 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, instituicoes);
        adapterBrinquedo33.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCadCartaInstituicao.setAdapter(adapterBrinquedo33);
    }
}
