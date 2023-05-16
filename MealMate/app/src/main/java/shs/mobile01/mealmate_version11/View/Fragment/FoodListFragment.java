package shs.mobile01.mealmate_version11.View.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import shs.mobile01.mealmate_version11.Model.dto.DataModel_Food;
import shs.mobile01.mealmate_version11.R;
import shs.mobile01.mealmate_version11.View.Adapter.FoodAdapter;

public class FoodListFragment extends Fragment {


    private View foodListFragment;

    // open test data
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
    // close test data
    public FoodListFragment(){

    }
    public FoodListFragment(Context context){
        // 어디서 생성된 프래그먼트인지 검사
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        foodListFragment = inflater.inflate(R.layout.fragment_foodlist,container,false);

        FoodAdapter fa = new FoodAdapter(testData);
        ((RecyclerView)foodListFragment.findViewById(R.id.recyclerView_food)).setAdapter(fa);


        return foodListFragment;
    }
}