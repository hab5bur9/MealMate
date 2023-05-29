package com.anonymous.mealmate.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import com.anonymous.mealmate.viewmodel.UserInfoViewModel;

public class UserSurveyActivity {
    package com.example.user_dataset;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.ViewFlipper;

    public class UserSurveyActivity extends AppCompatActivity {

        private ViewFlipper viewFlipper;
        private Button btnPrevious;
        private Button btnNext;
        private Button btnPrev;
        private EditText height;
        private EditText weight;
        private EditText name;
        private EditText Age;
        private RadioGroup radioGroupPurpose;
        private RadioGroup radioGroupGender;
        private RadioGroup radioGroupActivity;
        private UserInfoViewModel userInfoViewModel;
        int page=1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_survey);

            userInfoViewModel = new UserInfoViewModel();

            btnNext = findViewById(R.id.btnNext);
            btnPrev = findViewById(R.id.btnPrevious);
            viewFlipper = findViewById(R.id.viewFlipper);
            height = findViewById(R.id.editTextHeight);
            weight = findViewById(R.id.editTextWeight);
            radioGroupPurpose = findViewById(R.id.radioGroupPurpose);
            radioGroupGender=findViewById(R.id.radioGroupGender);
            radioGroupActivity=findViewById(R.id.radioGroupActivityLevel);
            Age=findViewById(R.id.editTextAge);
            name=findViewById(R.id.etNickname);


            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewFlipper.showNext();
                    saveUserInfo();
                    page++;

                    if(page == 6){
                        btnNext.setVisibility(View.INVISIBLE);
                        btnPrev.setVisibility(View.INVISIBLE);
                    }

                }
            });

            btnPrev.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewFlipper.showPrevious();
                    page--;
                }
            });
        }

        private void saveUserInfo() {
            String userName=name.getText().toString();
            String userHeight = height.getText().toString();
            double heightValue = Double.parseDouble(userHeight);
            double weightValue = Double.parseDouble(weight.getText().toString());
            String userGender = getSelectedGender(); // 사용자 성별을 가져오는 로직 필요
            int userAge = Integer.parseInt(Age.getText().toString()); // 사용자 나이를 가져오는 로직 필요
            int userActivity = getSelectedActivity(); // 사용자 활동량을 가져오는 로직 필요
            int userPurpose = getSelectedPurpose();
            //액티비티에서 받은 값들을 뷰모델에 전달
            userInfoViewModel.saveUserInfo(userName, heightValue, weightValue, userGender, userAge, userActivity, userPurpose);
        }

        private int getSelectedPurpose() {
            int selectedId = radioGroupPurpose.getCheckedRadioButtonId();

            switch (selectedId) {
                case R.id.radioButtonDiet:
                    return 1; // 다이어트
                case R.id.radioButtonBulkUp:
                    return 2; // 벌크업
                case R.id.radioButtonMaintain:
                    return 3; // 유지, 관리
                default:
                    return 0; // 기본값
            }
        }

        private String getSelectedGender(){
            int selectedId=radioGroupGender.getCheckedRadioButtonId();

            switch (selectedId){
                case R.id.radioButtonMale:
                    return "남자";
                case R.id.radioButtonFemale:
                    return "여자";
                default:
                    return "";
            }
        }

        private int getSelectedActivity(){
            int selectedId=radioGroupActivity.getCheckedRadioButtonId();

            switch(selectedId){
                case R.id.radioButtonSedentary:
                    return 1;//정적인 활동(거의 운동안함)
                case R.id.radioButtonLight:
                    return 2;//가벼운 활동(1-2회 운동)
                case R.id.radioButtonModerate:
                    return 3;//보통 활동(3-4회 운동)
                case R.id.radioButtonActive:
                    return 4;//적극적인 활동(5-6회 운동)
                case R.id.radioButtonVeryActive://매우 활동
                    return 5;
                default:  return 0;

            }
        }
    }

}
