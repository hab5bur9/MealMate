package shs.mobile01.mealmate_version11.ViewModel;

import androidx.lifecycle.ViewModel;

import shs.mobile01.mealmate_version11.Model.dao.Repository_User;

public class ViewModel_UserInfo extends ViewModel {
    Repository_User repository_user ;

    public ViewModel_UserInfo(Repository_User repository_user){
        this.repository_user=repository_user;
    }
}
