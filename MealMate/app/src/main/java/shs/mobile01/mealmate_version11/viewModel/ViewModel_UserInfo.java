package shs.mobile01.mealmate_version11.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import shs.mobile01.mealmate_version11.Model.dao.Repository_User;
import shs.mobile01.mealmate_version11.Model.entity.User;

public class ViewModel_UserInfo extends AndroidViewModel {
    private Repository_User repository_user ;

    private LiveData<ArrayList<User>> userListLiveData;
    public ViewModel_UserInfo(@NonNull Application application) {
        super(application);

        repository_user = new Repository_User(application);
        userListLiveData = repository_user.getListLiveData();
    }

    public LiveData<ArrayList<User>> getUserListLiveData(){
        return userListLiveData;
    }

}
