package shs.mobile01.mealmate_version11.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import shs.mobile01.mealmate_version11.Model.dto.DataModel_Food;
import shs.mobile01.mealmate_version11.Model.dto.DataModel_Meal;
import shs.mobile01.mealmate_version11.R;
import shs.mobile01.mealmate_version11.View.Adapter.SetFoodAdapter;
import shs.mobile01.mealmate_version11.View.Adapter.SetMealAdapter;

public class SetMealActivity extends AppCompatActivity {
    private final int adapterNum = 3;
    DataModel_Food dm;
    ArrayList<DataModel_Food>testData1,testData2,testData3;
    ArrayList<ArrayList<DataModel_Food>> testData;
    public void loadPreset(){
        dm = new DataModel_Food(1,1,"food",100,100,100,300,0);
        testData1 = new ArrayList<>(Arrays.asList(dm,dm,dm,dm));
        testData2 = new ArrayList<>(Arrays.asList(dm,dm,dm,dm));
        testData3 = new ArrayList<>(Arrays.asList(dm,dm,dm,dm));
        testData= new ArrayList<>(Arrays.asList(testData1,testData2,testData3)); ;

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setmeal);

        loadPreset();


        Intent it = getIntent();

        SetMealAdapter sma = new SetMealAdapter(testData);
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView_setMeal);
        mRecyclerView.setAdapter(sma);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.scrollToPosition(((LinearLayoutManager)mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition());

//        sma = new SetMealAdapter(this,SetMealAdapter.IGNORE_ITEM_VIEW_TYPE,sfa);
//
//
//        ((ListView)findViewById(R.id.listView_setMeal)).setAdapter(sma);



        ((Button)findViewById(R.id.btn_addMealTime)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testData.add(new ArrayList<>(Arrays.asList(dm,dm,dm,dm)));
                sma.notifyDataSetChanged();
            }
        });

        ((Button)findViewById(R.id.btn_loadPreset)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sma.notifyDataSetChanged();
            }
        });
    }



//    ArrayList<SetFoodAdapter> sfa = new ArrayList<>();
//
//    ArrayList<String> sampleFood1 = new ArrayList<>(Arrays.asList("닭가슴살","20","80","20","100"));
//    ArrayList<String> sampleFood2 = new ArrayList<>(Arrays.asList("삼겹살", "20","30","50","200"));
//    ArrayList<String> sampleFood3 = new ArrayList<>(Arrays.asList("흰쌀밥","60","10","30","150"));
//    ArrayList<ArrayList> food1= new ArrayList<>(Arrays.asList(sampleFood1,sampleFood2,sampleFood3));
//    ArrayList<ArrayList> food2 = new ArrayList<>(Arrays.asList(sampleFood1,sampleFood2,sampleFood3));
//    ArrayList<ArrayList> food3 = new ArrayList<>(Arrays.asList(sampleFood1,sampleFood2,sampleFood3));
//    ArrayList<ArrayList<ArrayList>> preset = new ArrayList<>(Arrays.asList(food1,food2,food3));
}

