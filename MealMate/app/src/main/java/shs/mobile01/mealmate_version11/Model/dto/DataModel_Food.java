package shs.mobile01.mealmate_version11.Model.dto;

public class DataModel_Food {

    private int API_code;
    private String food_name;
    private int carbohydrates;
    private int protein;
    private int fat;
    private int kcal;

    private int index;
    private int like;

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

    public DataModel_Food(int index,int API_code, String food_name,int carbohydrates,int protein,int fat,int kcal, int like){
        this.index=index;
        this.API_code=API_code;
        this.food_name=food_name;
        this.carbohydrates=carbohydrates;
        this.protein=protein;
        this.fat=fat;
        this.kcal=kcal;
        this.like=like;
    }
}
