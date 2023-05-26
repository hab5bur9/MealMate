package com.anonymous.mealmate.view.activity;


import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import androidx.appcompat.app.AlertDialog;

class user_info{

    //사용자 정보
    String user_name;
    double user_kcal;
    int user_age;
    float user_height;
    float user_weight;
    char user_gender;
    String user_purpose;

    //사용자의 탄단지 비율 칼로리  변수들
    int user_carbohydrate;//탄수화물
    int user_protien;//단백질
    int user_fat;//지방

}

public class ResearchActivity extends AppCompatActivity {

    user_info user=new user_info();//사용자 정보가 들어가는 객체

    TextView p;
    TextView test;
    ViewFlipper View;
    Button Next,Prev,Start,Restart;
    EditText user_height,user_weight,user_name,user_age;
    RadioGroup gender,user_work,user_purpose;

    final int END_PAGE=6;//끝 페이지
    int index=1; //페이지를 알아볼수 있는 index값

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research);

        //마지막 페이지이면 완료 레이아웃이 뜨고 다른 엑티비티로 넘어간다

        test=findViewById(R.id.test);
        p=findViewById(R.id.purpose_text);
        gender=findViewById(R.id.gender);

        setTitle("Meal Mate");
        View=findViewById(R.id.view);
        Next=findViewById(R.id.next);
        Prev=findViewById(R.id.prev);
        Start=findViewById(R.id.startMealMate);
        Restart=findViewById(R.id.reStart);
        user_height=findViewById(R.id.user_height);
        user_weight=findViewById(R.id.user_weight);
        user_age=findViewById(R.id.user_age);
        user_name=findViewById(R.id.user_name);
        user_work=findViewById(R.id.user_work);
        user_purpose=findViewById(R.id.user_purpose);

        gender.check(R.id.male);
        user_work.check(R.id.user_work_index1);
        user_purpose.check(R.id.bulk);

        Prev.setVisibility(View.INVISIBLE);
        //이전버튼 클릭시 ---->firstPage에선 Prev버튼이 나타나지 않는다.
        Prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                if(index==1){
                    Prev.setVisibility(View.INVISIBLE);
                    index=1;
                } else{
                    View.showPrevious();
                    index--;
                }
            }
        });
        //다음 버튼 클릭시
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 라디오 버튼 선택 여부 확인

                if (index == END_PAGE) {
                    View.showNext();
                    Next.setVisibility(View.INVISIBLE);
                    Prev.setVisibility(View.INVISIBLE);
                    Start.setVisibility(View.VISIBLE);
                    Restart.setVisibility(View.VISIBLE);
                } else {
                    View.showNext();
                    Prev.setVisibility(View.VISIBLE);
                    index++;
                }
            }
        });

        //사용자 정보 받아와서 객체에 저장
        // Start 버튼 클릭시 계산시작
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                user.user_name=user_name.getText().toString();//이름
                user.user_height=Float.parseFloat(user_height.getText().toString());//키
                user.user_weight=Float.parseFloat(user_weight.getText().toString());//몸무게
                user.user_age=Integer.parseInt(user_age.getText().toString());//나이

                CheckState();
                Calculate(user.user_kcal);
                p.setText(user.user_name+"님의 하루 필요 칼로리는"+String.valueOf(user.user_kcal)+"kcal 입니다."); // 계산 결과를 화면에 표시
                Toast.makeText(MainActivity.this, "하루 필요 칼로리는"+user.user_kcal + "Kcal 입니다", Toast.LENGTH_SHORT).show();
                Start.setText("Meal Mate 시작하기");


                Start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {

                        CheckState();
                        Calculate(user.user_kcal);

                        p.setVisibility(View.VISIBLE);
                        test.setVisibility(View.VISIBLE);

                        p.setText(user.user_name+"님의 하루 필요 칼로리는"+String.valueOf(user.user_kcal)+"kcal 입니다."); // 계산 결과를 화면에 표시
                        Toast.makeText(MainActivity.this, "하루 필요 칼로리는"+user.user_kcal + "Kcal 입니다", Toast.LENGTH_SHORT).show();
                        Start.setText("Meal Mate 시작하기");
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("저장")
                                .setMessage("계산 결과를 저장하시겠습니까?")


                                .setPositiveButton("저장", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // 사용자의 정보들을 DB에 저장하는 코드 작성
                                        Toast.makeText(MainActivity.this, "저장되었습니다.", Toast.LENGTH_SHORT).show();
                                        //홈화면으로 넘어감 StartActivity
                                    }
                                })
                                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                    }
                });
            }
        });

        //다시 작성하기
        Restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                index=1;
                Next.setVisibility(View.VISIBLE);
                Prev.setVisibility(View.INVISIBLE);
                Start.setVisibility(View.INVISIBLE);
                Restart.setVisibility(View.INVISIBLE);
                View.showNext();
                Start.setText("계산하기");
                p.setVisibility(View.INVISIBLE);
                test.setVisibility(View.INVISIBLE);

                CheckState();
                Calculate(user.user_kcal);


            }
        });
    }

    // 사용자 탄,단,지 비율 결정 메소드-->저장할 목록들을 띄워주는 역할도함
    public void Calculate(double user_kcal) {
        user.user_carbohydrate=Integer.parseInt(String.valueOf(Math.round(user_kcal*0.5)));
        user.user_protien=Integer.parseInt(String.valueOf(Math.round(user_kcal*0.3)));
        user.user_fat=Integer.parseInt(String.valueOf(Math.round(user_kcal*0.2)));
        test.setText("\n 목적:"+user.user_purpose+"\n"+"\n 탄수화물:"+String.valueOf( user.user_carbohydrate)+"Kcal\n"+"\n 단백질:"+String.valueOf(user.user_protien)+"Kcal"+
                "\n"+" \n 지방:"+String.valueOf(user.user_fat)+"Kcal");
    }
    //라디오버튼 클릭 상태를 확인하는 메소드
    public void CheckState(){
        int checkedGenderId = gender.getCheckedRadioButtonId();
        if (checkedGenderId == R.id.male) {
            user.user_gender = 'M';
            user.user_kcal = 66 + (13.7 * user.user_weight) + (5 * user.user_height) - (6.8 - user.user_age);
        } else if (checkedGenderId == R.id.female) {
            user.user_gender = 'F';
            user.user_kcal = 655 + (9.6 * user.user_weight) + (1.7 * user.user_height) - (4.7 * user.user_age);
        }

        // 활동량 체크 여부
        int checkedWorkId = user_work.getCheckedRadioButtonId();
        switch (checkedWorkId) {
            case R.id.user_work_index1:
                user.user_kcal *= 1.2;
                break;
            case R.id.user_work_index2:
                user.user_kcal *= 1.375;
                break;
            case R.id.user_work_index3:
                user.user_kcal *= 1.55;
                break;
            case R.id.user_work_index4:
                user.user_kcal *= 1.725;
                break;
            case R.id.user_work_index5:
                user.user_kcal *= 1.9;
                break;
        }
        //목표 체크 여부
        int checkedPurposeId = user_purpose.getCheckedRadioButtonId();
        switch (checkedPurposeId){
            case R.id.diet:
                user.user_kcal=Integer.parseInt(String.valueOf(Math.round(user.user_kcal*0.8)));
                user.user_purpose="Diet(다어이트)";
                break;
            case R.id.bulk:
                user.user_kcal=Integer.parseInt(String.valueOf(Math.round(user.user_kcal*1.2)));
                user.user_purpose="Bulk(벌크업)";
                break;
            case R.id.maintain:
                user.user_kcal=Integer.parseInt(String.valueOf(Math.round(user.user_kcal)));
                user.user_purpose="Maintain(유지,관리)";
                break;
            default:
                Toast.makeText(MainActivity.this,"식단, 목적을 선택해야합니다",Toast.LENGTH_SHORT).show();
        }
    }

}




