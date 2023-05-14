package shs.mobile01.mealmate_version11.Model.dto;



public class DataModel_Meal {

    private int index;
    private int datetime; // check needed
    private int mealTime;
    private int food_index;
    private int meal_amount;
    private boolean checked;

    public int getIndex(){return index;}
    public int getDatetime(){return datetime;}
    public int getMealTime(){return mealTime;}
    public int getFood_index(){return food_index;}
    public int getMeal_amount(){return meal_amount;}
    public boolean getChecked(){return checked;}

    public void setIndex(int index){this.index = index;}
    public void setDatetime(int datetime){this.datetime=datetime;}
    public void setMealTime(int mealTime){this.mealTime=mealTime;}
    public void setFood_index(int food_index){this.food_index=food_index;}
    public void setMeal_amount(int meal_amount){this.meal_amount=meal_amount;}
    public void setChecked(boolean checked){this.checked=checked;}

    // 안녕하세요 존잘남입니다.
    // 안녕하세요 멋쟁이입니다.
    public DataModel_Meal(int index,int datetime, int mealTime, int food_index,int meal_amount ,boolean checked){
        this.index=index;
        this.datetime=datetime;
        this.food_index=food_index;
        this.meal_amount=meal_amount;
        this.checked=checked;
    }
    public void onCheckedChange(){
        if (checked==false)
            checked=true;
        else
            checked=false;
    }
}
