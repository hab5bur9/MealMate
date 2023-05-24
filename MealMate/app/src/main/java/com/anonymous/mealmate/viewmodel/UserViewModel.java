package com.anonymous.mealmate.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.anonymous.mealmate.model.entity.User;
import com.anonymous.mealmate.model.repository.UserRepository;

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
