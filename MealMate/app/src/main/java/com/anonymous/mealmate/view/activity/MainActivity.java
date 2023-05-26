package com.anonymous.mealmate.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import com.anonymous.mealmate.R;
import com.anonymous.mealmate.databinding.ActivityMainBinding;
import com.anonymous.mealmate.view.fragment.CalendarFragment;
import com.anonymous.mealmate.view.fragment.FoodFragment;
import com.anonymous.mealmate.view.fragment.HomeFragment;

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
                ft.replace(frame, hf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });


        findViewById(R.id.btn_navigation_calendar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(frame, cf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        findViewById(R.id.btn_navigation_food).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(frame, flf);
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


    }


    public void onStartActivity(View view){
        Intent intent = new Intent(MainActivity.this,SetMealItemActivity.class);
        startActivity(intent);
    }
}
