package com.example.flashcard;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        ImageView closeTask = findViewById(R.id.close);
        ImageView saveTask = findViewById(R.id.save);

        saveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = ((EditText) findViewById(R.id.question)).getText().toString();
                String answer = ((EditText) findViewById(R.id.answer)).getText().toString();
                Intent data = new Intent();
                data.putExtra("string1",question);
                data.putExtra("string2",answer);
                setResult(RESULT_OK,data);
                finish();
            }
        });
        closeTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("string1","Cancelled");
                data.putExtra("string2","Cancelled");
                setResult(RESULT_CANCELED, data);
                finish();
            }
        });
    }

}