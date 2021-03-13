package com.example.flashcard;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView question = findViewById(R.id.flashcard_question);

        TextView answer = findViewById(R.id.flashcard_answer);

        TextView option1 = findViewById(R.id.option_1);
        TextView option2 = findViewById(R.id.option_2);
        TextView option3 = findViewById(R.id.option_3);

        ImageView addTask = findViewById(R.id.addBtn);

        ImageView show = findViewById(R.id.show_hint);
        ImageView hide = findViewById(R.id.hide_hint);

        final Boolean[] clickStatus = {Boolean.FALSE}; //for finding the status of OPTIONS


        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question.setVisibility(View.INVISIBLE);
                answer.setVisibility(View.VISIBLE);
                // hide the options and show/hide icon when viewing the main answers
                show.setVisibility(View.INVISIBLE);
                hide.setVisibility(View.INVISIBLE);
                option1.setVisibility(View.INVISIBLE);
                option2.setVisibility(View.INVISIBLE);
                option3.setVisibility(View.INVISIBLE);
            }
        }); //for toggling the question to view answer
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question.setVisibility(View.VISIBLE);
                answer.setVisibility(View.INVISIBLE);
                // show the show/hide icon when going back to question
                show.setVisibility(View.VISIBLE);
                hide.setVisibility(View.INVISIBLE);
            }
        }); // for returning back to question

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickStatus[0] == Boolean.FALSE) {
                    option1.setBackgroundColor(Color.parseColor("#aa0000"));
                    option2.setBackgroundColor(Color.parseColor("#00aa00"));
//                    option3.setBackgroundColor(Color.parseColor("#aa0000"));
                } else {
                    option1.setBackgroundColor(Color.parseColor("#FFA5A0"));
                    option2.setBackgroundColor(Color.parseColor("#FFA5A0"));
//                    option3.setBackgroundColor(Color.parseColor("#FFA5A0"));
                }
                clickStatus[0] = !clickStatus[0];
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickStatus[0] == Boolean.FALSE) {
                    option2.setBackgroundColor(Color.parseColor("#00aa00"));
                } else {
                    option2.setBackgroundColor(Color.parseColor("#FFA5A0"));
                }
                clickStatus[0] = !clickStatus[0];
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickStatus[0] == Boolean.FALSE) {
//                    option1.setBackgroundColor(Color.parseColor("#aa0000"));
                    option2.setBackgroundColor(Color.parseColor("#00aa00"));
                    option3.setBackgroundColor(Color.parseColor("#aa0000"));
                } else {
//                    option1.setBackgroundColor(Color.parseColor("#FFA5A0"));
                    option2.setBackgroundColor(Color.parseColor("#FFA5A0"));
                    option3.setBackgroundColor(Color.parseColor("#FFA5A0"));
                }
                clickStatus[0] = !clickStatus[0];
            }
        });


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide.setVisibility(View.VISIBLE);
                show.setVisibility(View.INVISIBLE);
                option1.setVisibility(View.VISIBLE);
                option2.setVisibility(View.VISIBLE);
                option3.setVisibility(View.VISIBLE);
            }
        });
        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setVisibility(View.VISIBLE);
                hide.setVisibility(View.INVISIBLE);
                option1.setVisibility(View.INVISIBLE);
                option2.setVisibility(View.INVISIBLE);
                option3.setVisibility(View.INVISIBLE);
            }
        });

        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                MainActivity.this.startActivityForResult(intent,100);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode==RESULT_OK) {
            String questionReceived = data.getExtras().getString("string1");
            String answerReceived = data.getExtras().getString("string2");

            ((TextView) findViewById(R.id.flashcard_question)).setText(questionReceived);
            ((TextView) findViewById(R.id.flashcard_answer)).setText(answerReceived);
            ((TextView) findViewById(R.id.option_2)).setText(answerReceived);

        }
    }
}