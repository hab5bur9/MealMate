package shs.mobile01.mealmate_version11.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

import shs.mobile01.mealmate_version11.R;
import shs.mobile01.mealmate_version11.View.Adapter.SetFoodAdapter;
import shs.mobile01.mealmate_version11.View.Adapter.SetMealAdapter;

public class SetMealActivity extends AppCompatActivity {
    private final int adapterNum = 3;
    SetMealAdapter sma;
    ArrayList<SetFoodAdapter> sfa = new ArrayList<>();

    ArrayList<String> sampleFood1 = new ArrayList<>(Arrays.asList("닭가슴살","20","80","20","100"));
    ArrayList<String> sampleFood2 = new ArrayList<>(Arrays.asList("삼겹살", "20","30","50","200"));
    ArrayList<String> sampleFood3 = new ArrayList<>(Arrays.asList("흰쌀밥","60","10","30","150"));
    ArrayList<ArrayList> food1= new ArrayList<>(Arrays.asList(sampleFood1,sampleFood2,sampleFood3));
    ArrayList<ArrayList> food2 = new ArrayList<>(Arrays.asList(sampleFood1,sampleFood2,sampleFood3));
    ArrayList<ArrayList> food3 = new ArrayList<>(Arrays.asList(sampleFood1,sampleFood2,sampleFood3));
    ArrayList<ArrayList<ArrayList>> preset = new ArrayList<>(Arrays.asList(food1,food2,food3));
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setmeal);

        Intent it = getIntent();


        sma = new SetMealAdapter(this,SetMealAdapter.IGNORE_ITEM_VIEW_TYPE,sfa);


        ((ListView)findViewById(R.id.listView_setMeal)).setAdapter(sma);



        ((Button)findViewById(R.id.btn_addMealTime)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfa.add(new SetFoodAdapter(SetMealActivity.this,SetFoodAdapter.IGNORE_ITEM_VIEW_TYPE));
                sma.notifyDataSetChanged();
            }
        });

        ((Button)findViewById(R.id.btn_loadPreset)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPreset();
            }
        });
    }
    public void loadPreset(){
        if(preset.size()!=0) {
            for(int i=0;i<preset.size();i++) {
                sfa.add(new SetFoodAdapter(SetMealActivity.this, SetFoodAdapter.IGNORE_ITEM_VIEW_TYPE, preset.get(i)));
            }
            sma.notifyDataSetChanged();
        }
    }
}
