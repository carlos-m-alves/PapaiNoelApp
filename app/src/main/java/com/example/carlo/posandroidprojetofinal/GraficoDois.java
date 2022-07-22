package com.example.carlo.posandroidprojetofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.charts.Pie;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;
import com.example.carlo.posandroidprojetofinal.bean.Relatorio;

import java.util.ArrayList;
import java.util.List;

public class GraficoDois extends AppCompatActivity {

    TextView txtQtdCartas, txtCartasApadrinhadas, txtCartasApadPorEmpresas, txtQtdEventos, txtQtdPadrinhos, txtQtdInstituicoes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico_dois);

        txtQtdCartas=findViewById(R.id.txtQtdCartas);
        txtCartasApadrinhadas=findViewById(R.id.txtCartasApadrinhadas);
        txtCartasApadPorEmpresas=findViewById(R.id.txtCartasApadPorEmpresas);
        txtQtdEventos=findViewById(R.id.txtQtdEventos);
        txtQtdPadrinhos=findViewById(R.id.txtQtdPadrinhos);
        txtQtdInstituicoes=findViewById(R.id.txtQtdInstituicoes);
    }

    @Override
    protected void onResume() {
        super.onResume();
        int qtdEventos = (int) getIntent().getExtras().getInt("qtdEventos");
        int qtdInstituicoes = (int) getIntent().getExtras().getInt("qtdInstituicoes");
        int qtdPadrinhos = (int) getIntent().getExtras().getInt("qtdPadrinhos");
        int quantidadeCartasApadrinhadas = (int) getIntent().getExtras().getInt("quantidadeCartasApadrinhadas");
        int qtdCartasApadrinhadasPorEmpresa = (int) getIntent().getExtras().getInt("qtdCartasApadrinhadasPorEmpresa");
        int qtdTotalCartas = (int) getIntent().getExtras().getInt("qtdTotalCartas");

        txtQtdCartas.setText(String.valueOf(qtdTotalCartas));

        Double percQtdApadrinhada = Double.valueOf(Math.round(((double)quantidadeCartasApadrinhadas / qtdTotalCartas)*100));
        Double percQtdApadrinhadaEmpresa = Double.valueOf(Math.round(((double)qtdCartasApadrinhadasPorEmpresa / qtdTotalCartas)*100));

        System.out.println("res div: "+String.valueOf(percQtdApadrinhada));
        System.out.println("res div: "+String.valueOf(percQtdApadrinhadaEmpresa));
        String msgCartApad = String.valueOf(quantidadeCartasApadrinhadas)+"/" +
                String.valueOf(qtdTotalCartas)+" - ("+
                String.valueOf(percQtdApadrinhada)+
                "%)";
        String msgCartApadEmpresa = String.valueOf(qtdCartasApadrinhadasPorEmpresa)+"/" +
                String.valueOf(qtdTotalCartas)+" - ("+
                String.valueOf(percQtdApadrinhadaEmpresa)+
                "%)";

        txtCartasApadrinhadas.setText(msgCartApad);
        txtCartasApadPorEmpresas.setText(msgCartApadEmpresa);

        txtQtdEventos.setText(String.valueOf(qtdEventos));
        txtQtdPadrinhos.setText(String.valueOf(qtdPadrinhos));
        txtQtdInstituicoes.setText(String.valueOf(qtdInstituicoes));
    }
}
