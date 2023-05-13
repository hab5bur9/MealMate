package shs.mobile01.mealmate_version11.View.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

import shs.mobile01.mealmate_version11.R;
import shs.mobile01.mealmate_version11.View.Adapter.MealAdapter;

public class CalendarFragment extends Fragment {

    private View calendarFragment;
    ArrayList<String> sampleFood1 = new ArrayList<>(Arrays.asList("닭가슴살","20","80","20","100"));
    ArrayList<String> sampleFood2 = new ArrayList<>(Arrays.asList("삼겹살", "20","30","50","200"));
    ArrayList<String> sampleFood3 = new ArrayList<>(Arrays.asList("흰쌀밥","60","10","30","150"));
    ArrayList<ArrayList> food = new ArrayList<>(Arrays.asList(sampleFood1,sampleFood2,sampleFood3));

    public CalendarFragment(){


    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        calendarFragment = inflater.inflate(R.layout.fragment_calendar,container,false);

        MealAdapter ma = new MealAdapter(food,R.layout.adapter_meal);

        ((ListView)calendarFragment.findViewById(R.id.listView_meal)).setAdapter(ma);

        ((CalendarView)calendarFragment.findViewById(R.id.calendarView)).setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String datetime = ""+month+"월 "+ dayOfMonth+"일";



            }
        });



        return calendarFragment;
    }
}
