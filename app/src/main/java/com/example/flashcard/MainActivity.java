package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView question = findViewById(R.id.flashcard_question);
        ImageView show = findViewById(R.id.show_hint);
        ImageView hide = findViewById(R.id.hide_hint);

        TextView option1 = findViewById(R.id.option_1);
        TextView answer = findViewById(R.id.flashcard_answer);
        TextView option2 = findViewById(R.id.option_2);

        final Boolean[] clickStatus = {Boolean.FALSE};

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickStatus[0] ==Boolean.FALSE){
                    option1.setBackgroundColor(Color.parseColor("#aa0000"));
                    answer.setBackgroundColor(Color.parseColor("#00aa00"));
                    option2.setBackgroundColor(Color.parseColor("#aa0000"));
                } else {
                    option1.setBackgroundColor(Color.parseColor("#FFA5A0"));
                    answer.setBackgroundColor(Color.parseColor("#FFA5A0"));
                    option2.setBackgroundColor(Color.parseColor("#FFA5A0"));
                }
                clickStatus[0] = ! clickStatus[0];
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickStatus[0] ==Boolean.FALSE){
                    option1.setBackgroundColor(Color.parseColor("#aa0000"));
                    answer.setBackgroundColor(Color.parseColor("#00aa00"));
                    option2.setBackgroundColor(Color.parseColor("#aa0000"));
                } else {
                    option1.setBackgroundColor(Color.parseColor("#FFA5A0"));
                    answer.setBackgroundColor(Color.parseColor("#FFA5A0"));
                    option2.setBackgroundColor(Color.parseColor("#FFA5A0"));
                }
                clickStatus[0] = ! clickStatus[0];
            }
        });
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickStatus[0]== Boolean.FALSE){
                    answer.setBackgroundColor(Color.parseColor("#00aa00"));
                } else {
                    answer.setBackgroundColor(Color.parseColor("#FFA5A0"));
                }
                clickStatus[0] = ! clickStatus[0];
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide.setVisibility(View.VISIBLE);
                show.setVisibility(View.INVISIBLE);
                option1.setVisibility(View.VISIBLE);
                option2.setVisibility(View.VISIBLE);
                answer.setVisibility(View.VISIBLE);
            }
        });
        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setVisibility(View.VISIBLE);
                hide.setVisibility(View.INVISIBLE);
                option1.setVisibility(View.INVISIBLE);
                option2.setVisibility(View.INVISIBLE);
                answer.setVisibility(View.INVISIBLE);
            }
        });
    }
}