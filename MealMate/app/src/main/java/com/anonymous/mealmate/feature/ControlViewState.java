package com.anonymous.mealmate.feature;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ControlViewState {

    private static ControlViewState instance = null;
    private MutableLiveData<Integer> stateSignalLiveData = new MutableLiveData<>();

    public LiveData<Integer> getStateSignalLiveData() {
        return stateSignalLiveData;
    }
    public void activeIntentSignal(Integer signal){
        //active observer signal
        stateSignalLiveData.setValue(signal);
    }
    public ControlViewState() {
        stateSignalLiveData.postValue(NONE);
    }

    public static ControlViewState getInstance() {
        if (instance == null) {
            synchronized (ControlViewState.class) {
                if (instance == null)
                    instance = new ControlViewState();
            }
        }
        return instance;
    }

    public void changeDateState(Integer signal){
        stateSignalLiveData.setValue( signal);
    }


    //intent signal
    public static final int NONE = -1;
    public static final int INTENT_FINISH = 0;
    public static final int INTENT_MAIN_TO_SETMEAL = 1;
    public static final int INTENT_MAIN_TO_USERUPDATEDATA = 2;

    public static final int INTENT_SETMEAL_TO_FOOD = 3;

    //date change signal

    public static final int DATE_CHANGED = 10;
}
