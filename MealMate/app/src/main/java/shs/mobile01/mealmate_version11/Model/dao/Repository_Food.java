package shs.mobile01.mealmate_version11.Model.dao;

import java.util.ArrayList;

import shs.mobile01.mealmate_version11.Model.dto.DataModel_Food;

public class Repository_Food {

    private ArrayList<DataModel_Food> df;
    private DataBase dataBase;

    public Repository_Food(DataBase dataBase){ // init
        this.dataBase= dataBase;
    }
}
