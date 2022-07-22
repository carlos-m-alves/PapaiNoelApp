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
import com.example.carlo.posandroidprojetofinal.bean.Cidade;
import com.example.carlo.posandroidprojetofinal.bean.Endereco;
import com.example.carlo.posandroidprojetofinal.bean.Instituicao;
import com.example.carlo.posandroidprojetofinal.facade.InstituicaoFacade;
import com.example.carlo.posandroidprojetofinal.service.InstituicaoCallback;

import java.io.Serializable;
import java.util.List;

public class CriarInstituicao extends AppCompatActivity {

    private EditText edtInstituicaoNomeCriar, edtInstituicaoTelefoneCriar, edtInstituicaoEndRuaCriar, edtInstituicaoEndNumeroCriar, edtInstituicaoEndComplementoCriar, edtInstituicaoEndCepCriar;
    Spinner spiInstituicaoBairroCriar, spiInstituicaoCidadeCriar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_instituicao);

        edtInstituicaoNomeCriar=findViewById(R.id.edtInstituicaoNomeCriar);
        edtInstituicaoTelefoneCriar=findViewById(R.id.edtInstituicaoTelefoneCriar);
        edtInstituicaoEndRuaCriar=findViewById(R.id.edtInstituicaoEndRuaCriar);
        edtInstituicaoEndNumeroCriar=findViewById(R.id.edtInstituicaoEndNumeroCriar);
        edtInstituicaoEndComplementoCriar=findViewById(R.id.edtInstituicaoEndComplementoCriar);
        edtInstituicaoEndCepCriar=findViewById(R.id.edtInstituicaoEndCepCriar);
        spiInstituicaoBairroCriar=findViewById(R.id.spiInstituicaoBairroCriar);
        spiInstituicaoCidadeCriar=findViewById(R.id.spiInstituicaoCidadeCriar);
    }

    public void CriaInstituicao(View view){
        Endereco endereco = new Endereco();
        Instituicao instituicao = new Instituicao();
        instituicao.setRua(edtInstituicaoEndRuaCriar.getText().toString().trim());
        instituicao.setNumero(Integer.parseInt(edtInstituicaoEndNumeroCriar.getText().toString().trim()));
        instituicao.setComplemento(edtInstituicaoEndComplementoCriar.getText().toString().trim());
        instituicao.setCep(edtInstituicaoEndCepCriar.getText().toString().trim());

        Bairro bairro = new Bairro();
        int idBairro = (int) spiInstituicaoBairroCriar.getSelectedItemId();
        int idCidade = (int) spiInstituicaoCidadeCriar.getSelectedItemId()+1;
        bairro.setIdBairro(idBairro);
        bairro.setIdCidade(idCidade);
        instituicao.setBairro(bairro);

        instituicao.setNomeInstituicao(edtInstituicaoNomeCriar.getText().toString().trim());
        instituicao.setTelefone(edtInstituicaoTelefoneCriar.getText().toString().trim());

        InstituicaoFacade.inserir(instituicao, new InstituicaoCallback() {
            @Override
            public void onSuccess(Object obj) {
                Toast.makeText(CriarInstituicao.this,"Instituição criada!",Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                    finish();
                    }
                }, 2000);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("NAO inseriu instituicao");
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
            System.out.println("bairro: "+b.getNomeBairro());
            i++;
        }
        ArrayAdapter<String> adapterBrinquedo = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, bairros);
        adapterBrinquedo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiInstituicaoBairroCriar.setAdapter(adapterBrinquedo);

        //spinner Cidade
        List<Cidade> listCidade = ((List<Cidade>) getIntent().getExtras().getSerializable("listCidade"));
        String cidades[] = new String[listCidade.size()+1];
        int j=1;
        cidades[0] = "";
        for(Cidade b : listCidade){
            cidades[j] = b.getNomeCidade();
            System.out.println("cidade: "+b.getNomeCidade());
            j++;
        }
        ArrayAdapter<String> adapterCidade = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, cidades);
        adapterCidade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiInstituicaoCidadeCriar.setAdapter(adapterCidade);
    }
}
