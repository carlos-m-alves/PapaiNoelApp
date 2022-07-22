package com.example.carlo.posandroidprojetofinal;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlo.posandroidprojetofinal.bean.Bairro;
import com.example.carlo.posandroidprojetofinal.bean.Carta;
import com.example.carlo.posandroidprojetofinal.bean.Cidade;
import com.example.carlo.posandroidprojetofinal.bean.Endereco;
import com.example.carlo.posandroidprojetofinal.bean.Instituicao;
import com.example.carlo.posandroidprojetofinal.facade.InstituicaoFacade;
import com.example.carlo.posandroidprojetofinal.service.InstituicaoCallback;

import java.util.List;

public class EditarInstituicao extends AppCompatActivity {
    Instituicao instituicao;
    private EditText edtInstituicaoNome, edtInstituicaoTelefone, edtInstituicaoEndRua, edtInstituicaoEndNumero, edtInstituicaoEndComplemento;
    Spinner spiInstituicaoBairro, spiInstituicaoCidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_instituicao);

        edtInstituicaoNome=findViewById(R.id.edtInstituicaoNome);
        edtInstituicaoTelefone=findViewById(R.id.edtInstituicaoTelefone);
        edtInstituicaoEndRua=findViewById(R.id.edtInstituicaoEndRua);
        edtInstituicaoEndNumero=findViewById(R.id.edtInstituicaoEndNumero);
        edtInstituicaoEndComplemento=findViewById(R.id.edtInstituicaoEndComplemento);
        spiInstituicaoBairro=findViewById(R.id.spiInstituicaoBairro);
        spiInstituicaoCidade=findViewById(R.id.spiInstituicaoCidade);
    }

    public void AtualizaInstituicao(View view){
        Bairro bairro = new Bairro();
        bairro.setIdBairro((int)spiInstituicaoBairro.getSelectedItemId());
        System.out.println("id end edtInst: "+instituicao.getIdEndereco());

        Instituicao ins = new Instituicao();
        ins.setIdInstituicao(instituicao.getIdInstituicao());
        ins.setNomeInstituicao(edtInstituicaoNome.getText().toString().trim());
        ins.setTelefone(edtInstituicaoTelefone.getText().toString().trim());
        ins.setIdEndereco(instituicao.getIdEndereco());
        ins.setRua(edtInstituicaoEndRua.getText().toString().trim());
        ins.setNumero(Integer.parseInt(edtInstituicaoEndNumero.getText().toString()));
        ins.setComplemento(edtInstituicaoEndComplemento.getText().toString().trim());
        ins.setCep("12345678");
        ins.setBairro(bairro);
        InstituicaoFacade.atualizar(ins, new InstituicaoCallback() {
            @Override
            public void onSuccess(Object obj) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(EditarInstituicao.this,"Instituição atualizada!",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }, 2000);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Bundle dados = getIntent().getExtras();
        instituicao = (Instituicao) dados.getSerializable("instituicao");

        edtInstituicaoNome.setText(instituicao.getNomeInstituicao());
        edtInstituicaoTelefone.setText(instituicao.getTelefone());
        edtInstituicaoEndRua.setText(instituicao.getRua());
        edtInstituicaoEndNumero.setText(String.valueOf(instituicao.getNumero()));
        edtInstituicaoEndComplemento.setText(instituicao.getComplemento());

        //spinner bairro
        List<Bairro> listBairro = ((List<Bairro>) getIntent().getExtras().getSerializable("listBairro"));
        String bairros[] = new String[listBairro.size()+1];
        int i=1;
        int indiceInstituicao=0;
        bairros[0] = "";
        for(Bairro b : listBairro){
            bairros[i] = b.getNomeBairro();
            System.out.println("bairro: "+b.getNomeBairro());
            i++;
            if( instituicao.getBairro().getNomeBairro() != "" ) {
                if ( b.getIdBairro() == instituicao.getBairro().getIdBairro() ) {
                    indiceInstituicao = i;
                }
            }else{System.out.println("NAO TEM INSTITUICAO: ");}
        }
        System.out.println("indiceBairro: "+indiceInstituicao);
        ArrayAdapter<String> adapterBrinquedo = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, bairros);
        adapterBrinquedo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiInstituicaoBairro.setAdapter(adapterBrinquedo);
        spiInstituicaoBairro.setSelection(indiceInstituicao-1);

        //spinner Cidade
        List<Cidade> listCidade = ((List<Cidade>) getIntent().getExtras().getSerializable("listCidade"));
        String cidades[] = new String[listCidade.size()+1];
        int j=1;
        int indiceCidade=0;
        cidades[0] = "";
        for(Cidade b : listCidade){
            cidades[j] = b.getNomeCidade();
            System.out.println("cidade: "+b.getNomeCidade());
            j++;
            if( instituicao.getBairro().getNomeBairro() != "" ) {
                if ( b.getIdCidade() == instituicao.getBairro().getIdCidade() ) {
                    indiceCidade = j;
                }
            }else{System.out.println("NAO TEM INSTITUICAO: ");}
        }
        ArrayAdapter<String> adapterCidade = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, cidades);
        adapterCidade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiInstituicaoCidade.setAdapter(adapterCidade);
        spiInstituicaoCidade.setSelection(indiceCidade-1);
    }
}
