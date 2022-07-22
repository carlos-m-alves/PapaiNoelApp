package com.example.carlo.posandroidprojetofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;
import com.example.carlo.posandroidprojetofinal.bean.Relatorio;

import java.util.ArrayList;
import java.util.List;

public class GraficoTres extends AppCompatActivity {
    AnyChartView any_chart3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico_tres);

        any_chart3 = findViewById(R.id.any_chart3);
    }

    public void setypPieChart(List<Relatorio> lista){
        Pie pie = AnyChart.pie();
        pie.title().fontSize(36);
        pie.labels().position("outside");

        pie.legend().title().enabled(true);
        pie.legend().title()
                .text("Instituições")
                .padding(0d, 0d, 10d, 0d);
        pie.legend()
                .position("left-bottom")
                .itemsLayout(LegendLayout.HORIZONTAL)
                .align(Align.CENTER);

        List<DataEntry> dataEntries = new ArrayList<>();

        for(Relatorio r : lista){
            dataEntries.add(new ValueDataEntry(r.getDescricao(),r.getValorInteiro()));
        }

        pie.data(dataEntries);
        any_chart3.setChart(pie);
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("chegou no grafico TRES");
        List<Relatorio> lista = ((List<Relatorio>) getIntent().getExtras().getSerializable("graficoTres"));
//        System.out.println("desc do rel: "+lista.get(0).getDescricao());
        setypPieChart(lista);
    }
}
