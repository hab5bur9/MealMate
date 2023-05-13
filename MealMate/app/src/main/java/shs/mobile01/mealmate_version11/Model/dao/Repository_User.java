package shs.mobile01.mealmate_version11.Model.dao;

import java.util.ArrayList;

import shs.mobile01.mealmate_version11.Model.dto.DataModel_Food;
import shs.mobile01.mealmate_version11.Model.dto.DataModel_User;

public class Repository_User {

    private DataBase dataBase;
    private DataModel_User dataModel_user;

    public Repository_User(DataBase dataBase){
        this.dataBase= dataBase;
    }
}
