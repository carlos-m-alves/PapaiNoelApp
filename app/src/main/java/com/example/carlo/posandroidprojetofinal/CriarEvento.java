package com.example.carlo.posandroidprojetofinal;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlo.posandroidprojetofinal.bean.Bairro;
import com.example.carlo.posandroidprojetofinal.bean.Cidade;
import com.example.carlo.posandroidprojetofinal.bean.Empresa;
import com.example.carlo.posandroidprojetofinal.bean.Endereco;
import com.example.carlo.posandroidprojetofinal.bean.Evento;
import com.example.carlo.posandroidprojetofinal.facade.EventoFacade;
import com.example.carlo.posandroidprojetofinal.service.EventoCallback;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CriarEvento extends AppCompatActivity {

    Spinner spnCriaEvtCidade, spnCriaEvtBairro, spnCriaEvtNomeEmpresa;
    EditText edtEvtEndCep, edtEvtEndComplemento, edtEvtEndNumero, edtEvtEndRua, edtCriarEventoNome;
    private TextView txtCriaEventoData;
    Calendar c;
    DatePickerDialog dt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_evento);

        edtCriarEventoNome=findViewById(R.id.edtCriarEventoNome);
        edtEvtEndRua=findViewById(R.id.edtEvtEndRua);
        edtEvtEndNumero=findViewById(R.id.edtEvtEndNumero);
        edtEvtEndComplemento=findViewById(R.id.edtEvtEndComplemento);
        edtEvtEndCep=findViewById(R.id.edtEvtEndCep);
        spnCriaEvtCidade=findViewById(R.id.spnCriaEvtCidade);
        spnCriaEvtBairro=findViewById(R.id.spnCriaEvtBairro);
        spnCriaEvtNomeEmpresa=findViewById(R.id.spnCriaEvtNomeEmpresa);

        txtCriaEventoData=findViewById(R.id.txtCriaEventoData);


    }

    public void dtPicker(View view){
        c=Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        dt = new DatePickerDialog(CriarEvento.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                txtCriaEventoData.setText(day+"/"+(month+1)+"/"+year);
            }
        },day,month,year);
        dt.show();
    }

    public void CadastrarEvento(View view){
        Bairro bairro = new Bairro();
        bairro.setIdBairro((int)spnCriaEvtBairro.getSelectedItemId());
        bairro.setIdCidade((int)spnCriaEvtCidade.getSelectedItemId());

        Endereco endereco = new Endereco();
        endereco.setRua(edtEvtEndRua.getText().toString().trim());
        endereco.setNumero(Integer.parseInt(edtEvtEndNumero.getText().toString().trim()));
        endereco.setComplemento(edtEvtEndComplemento.getText().toString().trim());
        endereco.setCep(edtEvtEndCep.getText().toString().trim());
        endereco.setBairro(bairro);

        Empresa empresa = new Empresa();
        empresa.setId((int)spnCriaEvtNomeEmpresa.getSelectedItemId()+1);

        Evento evento = new Evento();
        evento.setNomeEvento(edtCriarEventoNome.getText().toString().trim());
        evento.setEndereco(endereco);
        evento.setEmpresa(empresa);

        evento.setDtEventoString(txtCriaEventoData.getText().toString().trim());

        EventoFacade.inserir(evento, new EventoCallback() {
            @Override
            public void onSuccess(Object obj) {
                Toast.makeText(CriarEvento.this, "Evento cadastrado",Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("NAO FOI POSSIVEL CADASTRAR O EVENTO");
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
        ArrayAdapter<String> adapterBrinquedo = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, bairros);
        adapterBrinquedo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCriaEvtBairro.setAdapter(adapterBrinquedo);

        //spinner Cidade
        List<Cidade> listCidade = ((List<Cidade>) getIntent().getExtras().getSerializable("listCidade"));
        String cidades[] = new String[listCidade.size()+1];
        int j=1;
        cidades[0] = "";
        for(Cidade b : listCidade){
            cidades[j] = b.getNomeCidade();
            j++;
        }
        ArrayAdapter<String> adapterCidade = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, cidades);
        adapterCidade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCriaEvtCidade.setAdapter(adapterCidade);

        //spinner Empresa
        List<Empresa> listEmpresa = ((List<Empresa>) getIntent().getExtras().getSerializable("listEmpresa"));
        System.out.println("tam lista emp: "+listEmpresa.size());
        String empresas[] = new String[listEmpresa.size()+1];
        int k=1;
        empresas[0] = "";
        for(Empresa b : listEmpresa){
            empresas[k] = b.getNomeEmpresa();
            k++;
        }
        System.out.println("vet empresas: "+empresas.length);
        ArrayAdapter<String> adapterCidade2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, empresas);
        adapterCidade2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCriaEvtNomeEmpresa.setAdapter(adapterCidade2);
    }
}
