package com.anonymous.mealmate.view.activity;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< Updated upstream
import android.view.View;
import android.widget.ListView;
=======
import android.view.LayoutInflater;
import android.view.MenuItem;
>>>>>>> Stashed changes

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

<<<<<<< Updated upstream
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
=======


        homeFragment = new HomeFragment();
        calendarFragment = new CalendarFragment();
        foodFragment = new FoodFragment();
        userFragment = new UserFragment();
        fragmentManager.beginTransaction().replace(R.id.fl_navigation, homeFragment);

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
>>>>>>> Stashed changes
            @Override
            public void onClick(View v) {

                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(frame, cf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

<<<<<<< Updated upstream
        findViewById(R.id.btn_navigation_food).setOnClickListener(new View.OnClickListener() {
=======
        binding.bottomNavigationView.setItemIconTintList(null);

        binding.fabMealModify.setOnClickListener((v) ->{
            ControlViewState.getInstance().activeIntentSignal(ControlViewState.INTENT_MAIN_TO_SETMEAL);
        });

        //observe active signal
        ControlViewState.getInstance().getStateSignalLiveData().observe(this, new Observer<Integer>() {
>>>>>>> Stashed changes
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
