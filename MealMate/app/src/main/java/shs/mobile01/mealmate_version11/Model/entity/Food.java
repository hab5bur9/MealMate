package shs.mobile01.mealmate_version11.Model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Food {

    private final int testValue= 1;

    @PrimaryKey
    @ColumnInfo(name = "food_index")
    private int index = testValue;

    @ColumnInfo(name = "food_like")
    private int like = testValue;

    @ColumnInfo (name = "food_API_code")
    private int API_code = testValue;

    @ColumnInfo(name ="food_name")
    private String food_name = "testValue";

    @ColumnInfo(name = "food_carbohydrates")
    private int carbohydrates = testValue;

    @ColumnInfo(name = "food_protein")
    private int protein = testValue;

    @ColumnInfo(name = "food_fat")
    private int fat= testValue;

    @ColumnInfo(name = "food_kcal")
    private int kcal = testValue;



    public final int FOOD_LIKE = 1;
    public final int FOOD_DISLIKE = 0;

    public int getIndex(){return index;}
    public int getAPI_code(){return API_code;}
    public String getFood_name(){return food_name;}
    public int getCarbohydrates(){return carbohydrates;}
    public int getProtein(){return protein;}
    public int getFat(){return fat;}
    public int getKcal(){return kcal;}
    public int getLike(){return like;}

//    public Food(int index,int API_code, String food_name,int carbohydrates,int protein,int fat,int kcal, int like){
//        this.index=index;
//        this.API_code=API_code;
//        this.food_name=food_name;
//        this.carbohydrates=carbohydrates;
//        this.protein=protein;
//        this.fat=fat;
//        this.kcal=kcal;
//        this.like=like;
//    }
}
