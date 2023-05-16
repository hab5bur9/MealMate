package shs.mobile01.mealmate_version11.View.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

import shs.mobile01.mealmate_version11.R;
import shs.mobile01.mealmate_version11.View.Adapter.MealAdapter;

public class HomeFragment extends Fragment {

    private View home;

    ArrayList<String> sampleFood1 = new ArrayList<>(Arrays.asList("닭가슴살","20","80","20","100"));
    ArrayList<String> sampleFood2 = new ArrayList<>(Arrays.asList("삼겹살", "20","30","50","200"));
    ArrayList<String> sampleFood3 = new ArrayList<>(Arrays.asList("흰쌀밥","60","10","30","150"));
    ArrayList<ArrayList> food = new ArrayList<>(Arrays.asList(sampleFood1,sampleFood2,sampleFood3));

    public HomeFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        home = inflater.inflate( R.layout.fragment_home,container,false);

        ((TextView)home.findViewById(R.id.dateTimeTextView)).setText("00월 00일 0요일");


        // 데베에서 오늘날짜 식단 정보 받아와서 arraylist에 저장하는 코드 작성

        MealAdapter ma = new MealAdapter(food);

        return home;
    }
}
