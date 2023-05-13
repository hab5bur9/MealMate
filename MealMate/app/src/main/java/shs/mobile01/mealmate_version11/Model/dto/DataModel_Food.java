package shs.mobile01.mealmate_version11.Model.dto;

public class DataModel_Food {
    private int index;
    private int API_code;
    private int food_name;
    private int carbohydrates;
    private int protein;
    private int fat;
    private int kcal;
    private int like;

    public int getIndex(){return index;}
    public int getAPI_code(){return API_code;}
    public int getFood_name(){return food_name;}
    public int getCarbohydrates(){return carbohydrates;}
    public int getProtein(){return protein;}
    public int getFat(){return fat;}
    public int getKcal(){return kcal;}
    public int getLike(){return like;}

    public DataModel_Food(int index,int API_code, int food_name,int carbohydrates,int protein,int fat,int kcal,int like){
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
