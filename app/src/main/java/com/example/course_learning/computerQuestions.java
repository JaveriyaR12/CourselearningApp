package com.example.course_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class computerQuestions extends AppCompatActivity {
    String[] question_list = {"Which one among the following is an integer ?",
            "Which one of the following is an object oriented language ?",
            " Which of the following computer language is written in binary codes only? ?",
            " Which of the following is the smallest unit of data in a computer? ?",
            " What does CPU stand for ?",
            " What does URL stand for ?",
            "Which data type is used to store whole numbers in programming ?"
    };
    String[] choose_list = {"5.0","5","0.5","0.05",
            "C++","Java","Python","Ruby",
            "Pascal","Machine language","C","C#",
            "Bit","KB","Nibble","Byte",
            "Central Processing Unit","Central Process Unit","Computer Personal Unit","Central Processor Unit",
            "Uniform Resource Link", "Universal Record Locator","Uniform Registered Locator", "Uniform Resource Locator",
            " Float","Integer","Char","Double",

    };
    String[] correct_list = {"5","Java","Machine Language","Bit","Central Processing Unit",
            "Uniform Resource Locator","Integer"
    };


    TextView cpt_question , text_question;
    Button btn_choose1 , btn_choose2 , btn_choose3 , btn_choose4 , btn_next;





    int currentQuestion =  0  ;
    int scorePlayer =  0  ;
    boolean isclickBtn = false;
    String valueChoose = "";
    Button btn_click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_questions);
        cpt_question = findViewById(R.id.cpt_question);
        text_question = findViewById(R.id.text_question);

        btn_choose1 = findViewById(R.id.btn_choose1);
        btn_choose2 = findViewById(R.id.btn_choose2);
        btn_choose3 = findViewById(R.id.btn_choose3);
        btn_choose4 = findViewById(R.id.btn_choose4);
        btn_next = findViewById(R.id.btn_next);

        findViewById(R.id.image_back).setOnClickListener(
                a-> finish()
        );
        remplirData();
        btn_next.setOnClickListener(
                view -> {
                    if (isclickBtn){
                        isclickBtn = false;

                        if(!valueChoose.equals(correct_list[currentQuestion])){
                            Toast.makeText(computerQuestions.this , "Wrong",Toast.LENGTH_LONG).show();
                            btn_click.setBackgroundResource(R.drawable.background_btn_erreur);

                        }else {
                            Toast.makeText(computerQuestions.this , "Correct",Toast.LENGTH_LONG).show();
                            btn_click.setBackgroundResource(R.drawable.background_btn_choose_color);

                            scorePlayer++;
                        }
                        new Handler().postDelayed(() -> {
                            if(currentQuestion!=question_list.length-1){
                                currentQuestion = currentQuestion + 1;
                                remplirData();
                                valueChoose = "";
                                btn_choose1.setBackgroundResource(R.drawable.background_btn_choose_color);
                                btn_choose2.setBackgroundResource(R.drawable.background_btn_choose_color);
                                btn_choose3.setBackgroundResource(R.drawable.background_btn_choose_color);
                                btn_choose4.setBackgroundResource(R.drawable.background_btn_choose_color);

                            }else {
                                Intent intent  = new Intent(computerQuestions.this , ResulteActivity.class);
                                intent.putExtra("Resute" , scorePlayer);
                                startActivity(intent);
                                finish();

                            }

                        },2000);

                    }else {
                        Toast.makeText(computerQuestions.this ,  "Please select an option",Toast.LENGTH_LONG).show();
                    }
                }
        );


    }

    void remplirData(){
        cpt_question.setText((currentQuestion+1) + "/" + question_list.length);
        text_question.setText(question_list[currentQuestion]);

        btn_choose1.setText(choose_list[4 * currentQuestion]);
        btn_choose2.setText(choose_list[4 * currentQuestion+1]);
        btn_choose3.setText(choose_list[4 * currentQuestion+2]);
        btn_choose4.setText(choose_list[4 * currentQuestion+3]);

    }

    public void ClickChoose(View view) {
        btn_click = (Button)view;

        if (isclickBtn) {
            btn_choose1.setBackgroundResource(R.drawable.background_btn_choose_color);
            btn_choose2.setBackgroundResource(R.drawable.background_btn_choose_color);
            btn_choose3.setBackgroundResource(R.drawable.background_btn_choose_color);
            btn_choose4.setBackgroundResource(R.drawable.background_btn_choose_color);
        }
        chooseBtn();


    }
    void chooseBtn(){

        btn_click.setBackgroundResource(R.drawable.background_btn_choose_color);
        isclickBtn = true;
        valueChoose = btn_click.getText().toString();
    }
}