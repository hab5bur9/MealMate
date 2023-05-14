package shs.mobile01.mealmate_version11.Model.dao;

import java.util.ArrayList;

import shs.mobile01.mealmate_version11.Model.dto.DataModel_Meal;


public class Repository_Meal {

    private ArrayList<DataModel_Meal> dataModel_meals ;
    private DataBase dataBase;

    public Repository_Meal(DataBase dataBase){// init
        // 초기값 설정
        this.dataBase = dataBase;

        loadMealList(20);
    }
    public Repository_Meal(){//testing constructor
        loadMealList(3);
    }
    private void loadMealList(int datetime){ //test
        // 날짜를 입력받아서 해당 날짜의 식단정보를 로딩
        dataModel_meals = new ArrayList<>();
        for(int i=0;i<3;i++){
            dataModel_meals.add(new DataModel_Meal(0,20,1,2,3,false));
            dataModel_meals.add(new DataModel_Meal(1,20,2,5,2,false));
            dataModel_meals.add(new DataModel_Meal(2,20,3,6,2,false));
        }
    }

    public void meal_Configuration(int meal_num){
        for(int i=0;i<dataModel_meals.size();i++)
            if(dataModel_meals.get(i).getMealTime()==meal_num)
                dataModel_meals.get(i).onCheckedChange();
        dataBase.uploadDB(DataBase.DATABASE_TABLE_MEAL, DataBase.DATABASE_MODE_UPDATE,null);
    }

    public ArrayList<DataModel_Meal> getMealList(){
        return dataModel_meals;
    }

//    public String loadDBString(int datetime){
//        return "select * from meal where datetime = "+datetime;
//    }
}
