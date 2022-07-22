package com.example.carlo.posandroidprojetofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.anychart.charts.Cartesian;
import com.example.carlo.posandroidprojetofinal.bean.Relatorio;

import java.util.ArrayList;
import java.util.List;

public class GraficoUm extends AppCompatActivity {

    AnyChartView anyChartView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico_um);

        anyChartView = findViewById(R.id.any_chart_view);
        //setypColumnChart();
    }

    public void setypColumnChart(List<Relatorio> lista){
        Cartesian column = AnyChart.column();
        //column.title("Quantidade de Brinquedos solicitados");
        column.title().fontSize(32);
        column.xAxis(0).title("Brinquedo");
        column.xAxis(0).title().fontSize(20);
        column.yAxis(0).title("Quantidade");
        column.yAxis(0).title().fontSize(20);

        List<DataEntry> dataEntries2 = new ArrayList<>();

        for(Relatorio r : lista){
            dataEntries2.add(new ValueDataEntry(r.getDescricao(),r.getValorInteiro()));
        }
        column.data(dataEntries2);
        anyChartView.setChart(column);
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("chegou no grafico UM");
        //listaCartas.removeAll(listaCartas);
        //pega os dados da tela do filtro e preenche a lista
        List<Relatorio> lista = ((List<Relatorio>) getIntent().getExtras().getSerializable("graficoUm"));
        //System.out.println("desc do rel: "+lista.get(0).getDescricao());
        setypColumnChart(lista);
    }
}
