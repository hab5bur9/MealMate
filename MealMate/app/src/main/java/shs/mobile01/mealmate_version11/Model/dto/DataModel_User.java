package shs.mobile01.mealmate_version11.Model.dto;

public class DataModel_User {
    private String name;
    private int gender;
    private int height;
    private int weight;
    private int activityRatio;
    private int purpose;

    public final int GENDER_MALE = 1;
    public final int GENDER_FEMALE = 2;

    public final int ACTIVITY_RATIO_NONE=1;
    public final int ACTIVITY_RATIO_ROW=2;
    public final int ACTIVITY_RATIO_MIDDLE=3;
    public final int ACTIVITY_RATIO_HIGH=4;
    public final int ACTIVITY_RATIO_MAX= 5;

    public final int PURPOSE_DIET = 1;
    public final int PURPOSE_MAINTAIN=2;
    public final int PURPOSE_BURK=3;

    public String getName(){return name;}
    public int getGender(){return gender;}
    public int getHeight(){return height;}
    public int getWeight(){return weight;}
    public int getActivityRatio(){return activityRatio;}
    public int getPurpose(){return purpose;}

    public void setName(String name){this.name = name;}
    public void setGender(int gender){this.gender=gender;}
    public void setHeight(int height){this.height=height;}
    public void setWeight(int weight){this.weight=weight;}
    public void setActivityRatio(int activityRatio){this.activityRatio=activityRatio;}
    public void setPurpose(int purpose){this.purpose=purpose;}

    public DataModel_User(String name,int gender,int height,int weight, int activityRatio,int purpose){
        this.name=name;
        this.gender=gender;
        this.height=height;
        this.weight=weight;
        this.activityRatio=activityRatio;
        this.purpose=purpose;
    }
}
