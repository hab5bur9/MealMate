package shs.mobile01.mealmate_version11.View.Activity;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import shs.mobile01.mealmate_version11.Model.dao.DataBase;
import shs.mobile01.mealmate_version11.Model.dao.Repository_Food;
import shs.mobile01.mealmate_version11.Model.dao.Repository_Meal;
import shs.mobile01.mealmate_version11.Model.dao.Repository_User;
import shs.mobile01.mealmate_version11.R;
import shs.mobile01.mealmate_version11.View.Fragment.CalendarFragment;
import shs.mobile01.mealmate_version11.View.Fragment.FoodListFragment;

import shs.mobile01.mealmate_version11.View.Fragment.HomeFragment;
import shs.mobile01.mealmate_version11.ViewModel.ViewModel_CheckMeal;
import shs.mobile01.mealmate_version11.ViewModel.ViewModel_SetMeal;
import shs.mobile01.mealmate_version11.ViewModel.ViewModel_UserInfo;

public class MainActivity extends AppCompatActivity {

    HomeFragment hf;
    CalendarFragment cf;
    FoodListFragment flf;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init process
//        DataBase dataBase = new DataBase(this,null,null, 1); // 수정 필요
//
//        Repository_Meal repository_meal = new Repository_Meal(dataBase);
//        Repository_Food repository_food = new Repository_Food(dataBase);
//        Repository_User repository_user = new Repository_User(dataBase);

//        new ViewModel_CheckMeal(repository_meal);
//        new ViewModel_SetMeal(repository_meal,repository_food);
//        new ViewModel_UserInfo(repository_user);

        Repository_Meal repository_meal = new Repository_Meal();
        new ViewModel_CheckMeal(repository_meal);


        hf = new HomeFragment();
        cf = new CalendarFragment();
        flf = new FoodListFragment();

        findViewById(R.id.btnHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame1,hf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });


        findViewById(R.id.btnCalendar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame1,cf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        findViewById(R.id.btnFood).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame1,flf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        findViewById(R.id.btnMyPage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /*SetFoodAdapter sfa = new SetFoodAdapter();
        ((ListView)findViewById(R.id.textListView)).setAdapter(sfa);*/

    }
    public void onClickToStartActivity(View view){ // 수정필요
        Intent it = new Intent(MainActivity.this,SetMealActivity.class);
        startActivity(it);
    }
}
