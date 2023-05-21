package shs.mobile01.mealmate_version11.Model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Meal {
    private final int testValue =1;
    @PrimaryKey
    private int index = testValue;

    @ColumnInfo(name = "meal_datetime")
    private int datetime = testValue; // check needed

    @ColumnInfo(name = "meal_cnt")
    private int mealTime = testValue;

    @ColumnInfo(name = "food_index")
    private int food_index = testValue;

    @ColumnInfo(name ="meal_amount")
    private int meal_amount = testValue;

    @ColumnInfo(name ="checked")
    private boolean checked = false;

    public Meal(){

    }

}
