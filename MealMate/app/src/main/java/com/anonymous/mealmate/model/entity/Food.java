package com.anonymous.mealmate.model.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "food")
public class Food {
    @PrimaryKey(autoGenerate = true)
    private int foodIndex;

    private String foodName;
    private float food1serving;
    private float foodKcal;
    private float foodCarbohydrates;
    private float foodProtein;
    private float foodFat;
    private String food_company;
    private int foodLike = 0;   // default value: 0

    public static final int  FOOD_NOT_LIKE = 0;

    public static final int FOOD_LIKE = 1;

    public Food(String foodName, float food1serving, float foodKcal, float foodCarbohydrates, float foodProtein, float foodFat, String food_company, int foodLike) {
        this.foodName = foodName;
        this.food1serving = food1serving;
        this.foodKcal = foodKcal;
        this.foodCarbohydrates = foodCarbohydrates;
        this.foodProtein = foodProtein;
        this.foodFat = foodFat;
        this.food_company = food_company;
        this.foodLike = foodLike;
    }
    //생성자 오버로딩
    @Ignore
    public Food(String foodName, float food1serving, float foodKcal, float foodCarbohydrates, float foodProtein, float foodFat, String food_company) {
        this.foodName = foodName;
        this.food1serving = food1serving;
        this.foodKcal = foodKcal;
        this.foodCarbohydrates = foodCarbohydrates;
        this.foodProtein = foodProtein;
        this.foodFat = foodFat;
        this.food_company = food_company;
    }

    // getter methods...
    public int getFoodIndex() { return foodIndex; }
    public String getFoodName() { return foodName; }
    public float getFood1serving() { return food1serving; }
    public float getFoodKcal() { return foodKcal; }
    public float getFoodCarbohydrates() { return foodCarbohydrates; }
    public float getFoodProtein() { return foodProtein; }
    public float getFoodFat() { return foodFat; }
    public String getFood_company() { return food_company; }
    public int getFoodLike() { return foodLike; }

    // 인덱스를 수정하는 setter method
    public void setFoodIndex(int foodIndex) {this.foodIndex = foodIndex;}

    public void setFoodLike(int foodLike) {
        this.foodLike = foodLike;
    }

    // equals method
    public boolean equals(Object o) {
        float EPSILON = 0.1f;
        if (o == this) return true;
        if (!(o instanceof Food)) return false;
        Food other = (Food) o;
        if (!this.foodName.equals(other.foodName)) return false;
        if (Math.abs(this.food1serving - other.food1serving) > EPSILON) return false;
        if (Math.abs(this.foodKcal - other.foodKcal) > EPSILON) return false;
        if (Math.abs(this.foodCarbohydrates - other.foodCarbohydrates) > EPSILON) return false;
        if (Math.abs(this.foodProtein - other.foodProtein) > EPSILON) return false;
        if (Math.abs(this.foodFat - other.foodFat) > EPSILON) return false;
        if (!this.food_company.equals(other.food_company)) return false;
        if (this.foodLike != other.foodLike) return false;
        return true;
    }
}