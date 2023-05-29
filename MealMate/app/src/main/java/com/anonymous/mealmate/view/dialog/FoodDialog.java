package com.anonymous.mealmate.view.dialog;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

import com.anonymous.mealmate.viewmodel.FoodViewModel;
import com.anonymous.mealmate.viewmodel.MealSetViewModel;

public class FoodDialog extends Dialog {

    private MealSetViewModel mealSetViewModel;

    private FoodViewModel foodViewModel;
    public FoodDialog(@NonNull Context context) {

        super(context);
    }

}
