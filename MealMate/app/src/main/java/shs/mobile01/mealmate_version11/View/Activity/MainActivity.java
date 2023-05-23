package shs.mobile01.mealmate_version11.View.Activity;

import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import shs.mobile01.mealmate_version11.R;
import shs.mobile01.mealmate_version11.View.Fragment.CalendarFragment;
import shs.mobile01.mealmate_version11.View.Fragment.FoodFragment;

import shs.mobile01.mealmate_version11.View.Fragment.HomeFragment;
import shs.mobile01.mealmate_version11.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    HomeFragment hf;
    CalendarFragment cf;
    FoodFragment flf;
    FragmentTransaction ft;

    ActivityMainBinding binding;

    final int frame = R.id.fl_navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);




        hf = new HomeFragment();
        cf = new CalendarFragment();
        flf = new FoodFragment();

        findViewById(R.id.btn_navigation_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(frame,hf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });


        findViewById(R.id.btn_navigation_calendar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(frame,cf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        findViewById(R.id.btn_navigation_food).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(frame,flf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
//
//        findViewById(R.id.btnMyPage).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        /*SetFoodAdapter sfa = new SetFoodAdapter();
        ((ListView)findViewById(R.id.textListView)).setAdapter(sfa);*/

    }
}