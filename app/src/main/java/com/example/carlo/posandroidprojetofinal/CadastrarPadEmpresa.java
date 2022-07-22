package com.example.carlo.posandroidprojetofinal;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.carlo.posandroidprojetofinal.bean.Bairro;
import com.example.carlo.posandroidprojetofinal.bean.Cidade;
import com.example.carlo.posandroidprojetofinal.bean.Empresa;
import com.example.carlo.posandroidprojetofinal.bean.Endereco;
import com.example.carlo.posandroidprojetofinal.facade.UsuarioFacade;
import com.example.carlo.posandroidprojetofinal.service.UsuarioCallback;

import java.io.Serializable;
import java.util.List;

public class CadastrarPadEmpresa extends AppCompatActivity {

    private EditText edtCadEmpNome, edtCadEmpCnpj, edtCadEmpEmail, edtCadEmpSenha, edtCadEmpSenhaConfirme;
    private EditText edtEmpEndRua, edtEmpEndNumero, edtEmpEndComplemento, edtEmpEndCep;
    private Spinner spnEmpEndBairro, spnEmpEndCidade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_pad_empresa);

        spnEmpEndBairro=findViewById(R.id.spnEmpEndBairro);
        spnEmpEndCidade=findViewById(R.id.spnEmpEndCidade);

    }

    public void CadastrarEmpresa(View view){
        edtCadEmpNome=findViewById(R.id.edtCadEmpNome);
        edtCadEmpCnpj=findViewById(R.id.edtCadEmpCnpj);
        edtEmpEndRua=findViewById(R.id.edtEmpEndRua);
        edtEmpEndNumero=findViewById(R.id.edtEmpEndNumero);
        edtEmpEndComplemento=findViewById(R.id.edtEmpEndComplemento);
        edtEmpEndCep=findViewById(R.id.edtEmpEndCep);
        edtCadEmpEmail=findViewById(R.id.edtCadEmpEmail);
        edtCadEmpSenha=findViewById(R.id.edtCadEmpSenha);
        edtCadEmpSenhaConfirme=findViewById(R.id.edtCadEmpSenhaConfirme);

        int idBairro = (int)spnEmpEndBairro.getSelectedItemId()+1;
        int idCidade = (int)spnEmpEndCidade.getSelectedItemId()+1;

        if( edtCadEmpNome.getText().toString().equals("") ||
                edtCadEmpCnpj.getText().toString().equals("") ||
                edtEmpEndRua.getText().toString().equals("") ||
                edtEmpEndNumero.getText().toString().equals("") ||
                edtEmpEndCep.getText().toString().equals("") ||
                edtCadEmpEmail.getText().toString().equals("") ||
                edtCadEmpSenha.getText().toString().equals("") ||
                edtCadEmpSenhaConfirme.getText().toString().equals("") ){
            Toast.makeText(this,"Preencha todos os campos",Toast.LENGTH_SHORT).show();
            return;
        }
        if( !edtCadEmpSenha.getText().toString().equals(edtCadEmpSenhaConfirme.getText().toString())){
            Toast.makeText(this,"Os campos de senha devem ser iguais.",Toast.LENGTH_SHORT).show();
            return;
        }

        Bairro bairro = new Bairro();
        bairro.setIdBairro(idBairro);
        bairro.setIdCidade(idCidade);

        Endereco endereco = new Endereco();
        endereco.setRua(edtEmpEndRua.getText().toString().trim());
        endereco.setNumero(Integer.parseInt(edtEmpEndNumero.getText().toString().trim()));
        endereco.setComplemento(edtEmpEndComplemento.getText().toString().trim());
        endereco.setCep(edtEmpEndCep.getText().toString().trim());
        endereco.setBairro(bairro);

        Empresa empresa = new Empresa();
        empresa.setNomeEmpresa(edtCadEmpNome.getText().toString().trim());
        empresa.setPermissao("PADRINHO");
        empresa.setCcpf_cnpj(edtCadEmpCnpj.getText().toString().trim());
        empresa.setEmail(edtCadEmpEmail.getText().toString().trim());
        empresa.setSenha(edtCadEmpSenha.getText().toString().trim());
        empresa.setEndereco(endereco);


        UsuarioFacade.inserir(empresa, new UsuarioCallback() {
            @Override
            public void onSuccess(Object obj) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(CadastrarPadEmpresa.this,"Usuário cadastrado.",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                },2000);

            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(CadastrarPadEmpresa.this,"Não foi possível cadastrar.",Toast.LENGTH_SHORT).show();
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
        spnEmpEndBairro.setAdapter(adapterBrinquedo);

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
        spnEmpEndCidade.setAdapter(adapterCidade);
    }
}
