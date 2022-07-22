package com.example.carlo.posandroidprojetofinal;

import android.app.DatePickerDialog;
import android.os.Handler;
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
import com.example.carlo.posandroidprojetofinal.bean.Evento;
import com.example.carlo.posandroidprojetofinal.facade.EventoFacade;
import com.example.carlo.posandroidprojetofinal.service.EventoCallback;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class EditarEvento extends AppCompatActivity {
    Evento evento;
    private EditText edtEdtEvtNomeEmpresa,edEdtEvtRua, edtEdtEvtNumero, edtEdtEvtComplemento, edtEdtEvtCep;
    private TextView txtEdtEventoData;
    private Spinner spnEdtEvtNomeEmpresa, spnEdtEvtBairro, spnEdtEvtCidade;
    Calendar c;
    DatePickerDialog dt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_evento);

        edtEdtEvtNomeEmpresa=findViewById(R.id.edtEdtEvtNomeEmpresa);
        txtEdtEventoData=findViewById(R.id.txtEdtEventoData);
        spnEdtEvtNomeEmpresa=findViewById(R.id.spnEdtEvtNomeEmpresa);
        edEdtEvtRua=findViewById(R.id.edEdtEvtRua);
        edtEdtEvtNumero=findViewById(R.id.edtEdtEvtNumero);
        edtEdtEvtComplemento=findViewById(R.id.edtEdtEvtComplemento);
        edtEdtEvtCep=findViewById(R.id.edtEdtEvtCep);
        spnEdtEvtBairro=findViewById(R.id.spnEdtEvtBairro);
        spnEdtEvtCidade=findViewById(R.id.spnEdtEvtCidade);
    }

    public void dtPickerEdt(View view){
        c= Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        dt = new DatePickerDialog(EditarEvento.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                txtEdtEventoData.setText(day+"/"+(month+1)+"/"+year);
            }
        },day,month,year);
        dt.show();
    }

    public void AtualizarEvento(View view){

        EventoFacade.atualizar(evento, new EventoCallback() {
            @Override
            public void onSuccess(Object obj) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(EditarEvento.this,"Evento atualizado!",Toast.LENGTH_SHORT).show();
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

        evento = ((Evento) getIntent().getExtras().getSerializable("evento"));
        edtEdtEvtNomeEmpresa.setText(evento.getNomeEvento());

        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        //Date today = Calendar.getInstance().getTime();
        String todayAsString = df.format(evento.getDtEvento());
        System.out.println("data evt: "+todayAsString);
        txtEdtEventoData.setText(todayAsString);
        edEdtEvtRua.setText(evento.getEndereco().getRua());
        edtEdtEvtNumero.setText(String.valueOf(evento.getEndereco().getNumero()));
        edtEdtEvtComplemento.setText(evento.getEndereco().getComplemento());
        edtEdtEvtCep.setText(evento.getEndereco().getCep());

        //spinner bairro
        List<Bairro> listBairro = ((List<Bairro>) getIntent().getExtras().getSerializable("listBairro"));
        String bairros[] = new String[listBairro.size()+1];
        int i=1;
        int indBairro=0;
        bairros[0] = "";
        for(Bairro b : listBairro){
            bairros[i] = b.getNomeBairro();
            i++;
            if( evento.getEndereco().getBairro().getIdBairro() != -1 ) {
                if ( evento.getEndereco().getBairro().getIdBairro() == b.getIdBairro() ) {
                    indBairro = i;
                }
            }else{System.out.println("NAO TEM EMPRESA: ");}
        }
        ArrayAdapter<String> adapterBrinquedo = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, bairros);
        adapterBrinquedo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnEdtEvtBairro.setAdapter(adapterBrinquedo);
        spnEdtEvtBairro.setSelection(indBairro-1);

        //spinner Cidade
        List<Cidade> listCidade = ((List<Cidade>) getIntent().getExtras().getSerializable("listCidade"));
        String cidades[] = new String[listCidade.size()+1];
        int j=1;
        int indCidade=0;
        cidades[0] = "";
        for(Cidade b : listCidade){
            cidades[j] = b.getNomeCidade();
            j++;
            if( evento.getEndereco().getBairro().getIdCidade() != -1 ) {
                if ( evento.getEndereco().getBairro().getIdCidade() == b.getIdCidade() ) {
                    indCidade = j;
                }
            }else{System.out.println("NAO TEM EMPRESA: ");}
        }
        ArrayAdapter<String> adapterCidade = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, cidades);
        adapterCidade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnEdtEvtCidade.setAdapter(adapterCidade);
        spnEdtEvtCidade.setSelection(indCidade-1);

        //spinner Empresa
        List<Empresa> listEmpresa = ((List<Empresa>) getIntent().getExtras().getSerializable("listEmpresa"));
        System.out.println("tam lista emp: "+listEmpresa.size());
        String empresas[] = new String[listEmpresa.size()+1];
        int k=1;
        int indEmpresa=0;
        empresas[0] = "";
        for(Empresa b : listEmpresa){
            empresas[k] = b.getNomeEmpresa();
            k++;
            System.out.println("idEmpr no vet: "+b.getIdEmpresa());
            if( evento.getEmpresa().getIdEmpresa() != -1 ) {
                if ( b.getIdEmpresa() == evento.getEmpresa().getIdEmpresa() ) {
                    indEmpresa = k;

                }
            }else{System.out.println("NAO TEM EMPRESA: ");}
        }
        System.out.println("vet empresas: "+empresas.length);
        ArrayAdapter<String> adapterCidade2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, empresas);
        adapterCidade2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnEdtEvtNomeEmpresa.setAdapter(adapterCidade2);
        System.out.println("idEmpresa EVT: "+evento.getEmpresa().getIdEmpresa());
        System.out.println("idEmpresa : "+indEmpresa);

        spnEdtEvtNomeEmpresa.setSelection(indEmpresa-1);
    }
}
