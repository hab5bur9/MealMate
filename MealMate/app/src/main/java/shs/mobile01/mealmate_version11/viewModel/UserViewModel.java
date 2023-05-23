package shs.mobile01.mealmate_version11.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;


import shs.mobile01.mealmate_version11.Model.entity.User;
import shs.mobile01.mealmate_version11.Model.repository.UserRepository;

public class UserViewModel extends AndroidViewModel {
    private final UserRepository repository;

    public UserViewModel (Application application) {
        super(application);
        repository = UserRepository.getInstance(application);

    }

    public void insert(User user) { repository.insertUser(user); }

    public void update(User user) { repository.updateUser(user); }

    public void delete(User user) { repository.deleteUser(user); }
}
