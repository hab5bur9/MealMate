package com.anonymous.mealmate.view.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChartFragment extends AppCompatActivity {

    private BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_chart);

        barChart = findViewById(R.id.chart);
        createBarChart();
    }

    private void createBarChart() {

        List<String> daysOfWeek = new ArrayList<>();
        daysOfWeek.add("일");
        daysOfWeek.add("월");
        daysOfWeek.add("화");
        daysOfWeek.add("수");
        daysOfWeek.add("목");
        daysOfWeek.add("금");
        daysOfWeek.add("토");


        List<Float> completionPercentages = new ArrayList<>();
        completionPercentages.add(100f);
        completionPercentages.add(100f);
        completionPercentages.add(100f);
        completionPercentages.add(100f);
        completionPercentages.add(100f);
        completionPercentages.add(100f);
        completionPercentages.add(100f);


        List<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < completionPercentages.size(); i++) {
            float completionPercentage = completionPercentages.get(i);
            entries.add(new BarEntry(i, completePercent()));
        }

        BarDataSet dataSet = new BarDataSet(entries, "완료도");
        dataSet.setColor(Color.rgb(208, 112, 251));
        dataSet.setDrawValues(false);

        BarData barData = new BarData(dataSet);

        // 막대의 너비 조정
        float barWidth = 0.4f; // 막대의 너비 설정
        barData.setBarWidth(barWidth);

        barChart.setData(barData);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setEnabled(false);

        YAxis leftYAxis = barChart.getAxisLeft();
        leftYAxis.setDrawAxisLine(false);
        leftYAxis.setDrawGridLines(false);
        leftYAxis.setDrawLabels(false);

        YAxis rightYAxis = barChart.getAxisRight();
        rightYAxis.setEnabled(false);

        barChart.getDescription().setEnabled(false);
        barChart.setDrawValueAboveBar(false);
        barChart.setDrawGridBackground(false);
        barChart.setTouchEnabled(false);

        // 막대 차트 회전 및 크기 조정
        barChart.setRotation(-90);
        barChart.getLayoutParams().width = (int) (barWidth * completionPercentages.size() * 200); // 적절한 크기 조정

        barChart.invalidate();
    }
    public float completePercent() {
        //임의 값을 넣음
        int minKcal = 2000; // 최소 칼로리
        int maxKcal = 2300; // 최대 칼로리

        Random random = new Random();
        int randomKcal = random.nextInt(maxKcal - minKcal + 1) + minKcal;

        float percent = (float) randomKcal / maxKcal * 100;
        return percent;
    }

}
