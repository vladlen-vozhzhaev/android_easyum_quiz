package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ArrayList<UserAnswer> userAnswers = (ArrayList<UserAnswer>) getIntent().getSerializableExtra("userAnswers");
        TextView resultTextView = findViewById(R.id.resultTextView);
        for (int i = 0; i < userAnswers.size(); i++) {
            UserAnswer userAnswer = userAnswers.get(i);
            Log.i("STRING ID", String.valueOf(userAnswers.get(i).getQuestion()));
            String result = getResources().getString(userAnswer.getQuestion())+" - "+userAnswer.isUserAnswer()+" - "+userAnswer.isCorrectAnswer()+"\n";
            resultTextView.append(result);
        }
    }
}