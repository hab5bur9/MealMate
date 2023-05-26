package com.anonymous.mealmate.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.anonymous.mealmate.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class ChartFragment extends Fragment {
private BarChart barChart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_chart, container, false);

        // 데이터 리스트 생성 (각 요일의 완료도 퍼센트)
        // 완료도를 나타내는 값을 저장하기 위한 Float 타입의 리스트입니다. 각각의 값은 해당 날짜의 완료도를 나타냅니다.
        List<Float> completionPercentages = new ArrayList<>();
        completionPercentages.add(90f);
        completionPercentages.add(80f);
        completionPercentages.add(70f);
        completionPercentages.add(60f);
        completionPercentages.add(50f);
        completionPercentages.add(40f);
        // ...

        // BarEntry 리스트 생성
        List<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < completionPercentages.size(); i++) {
            float completionPercentage = completionPercentages.get(i);
            entries.add(new BarEntry(i, completionPercentage));
        }

        // BarDataSet 생성
        BarDataSet dataSet = new BarDataSet(entries, "Completion");
        dataSet.setColor(Color.BLUE);

        // BarData 생성
        BarData barData = new BarData(dataSet);//데이터베이스에서 가져옴 :(완료된 식단/총 식단)*100
        barData.setBarWidth(0.5f);

        // X축 설정 (일주일 요일 표시)
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new ValueFormatter() {
            private final String[] days = new String[]{"일", "월", "화", "수", "목", "금", "토"};

            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                int index = (int) value;
                if (index >= 0 && index < days.length) {
                    return days[index];
                }
                return "";
            }
        });
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);

        // Y축 설정 (완료도 퍼센트)
        YAxis yAxisLeft = barChart.getAxisLeft();
        yAxisLeft.setAxisMinimum(0f);
        yAxisLeft.setAxisMaximum(100f);

        // 오른쪽 Y축은 비활성화
        YAxis yAxisRight = barChart.getAxisRight();
        yAxisRight.setEnabled(false);

        // Barchart에 데이터 설정
        barChart.setData(barData);
        barChart.setFitBars(true);
        barChart.getDescription().setEnabled(false);
        barChart.setDrawGridBackground(false);
        barChart.setDrawBorders(false);
        barChart.animateY(1000);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
