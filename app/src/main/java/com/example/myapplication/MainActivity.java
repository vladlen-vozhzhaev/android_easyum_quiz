package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView questionTextView;
    Question[] questions = {
            new Question(R.string.question1, true),
            new Question(R.string.question2, true),
            new Question(R.string.question3, false),
            new Question(R.string.question4, false),
            new Question(R.string.question5, true),
    };
    ArrayList<UserAnswer> userAnswers = new ArrayList<>();
    int questionIndex = 0;
    String TAG = "MyINFO: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Вызван метод onCreate()");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button yesBtn = findViewById(R.id.yesBtn);
        Button noBtn = findViewById(R.id.noBtn);
        questionTextView = findViewById(R.id.questionTextView);
        if (savedInstanceState != null){
            questionIndex = savedInstanceState.getInt("questionIndex");
        }else{
            questionIndex = 0;
        }
        questionTextView.setText(questions[questionIndex].getQuestion());
        // Слушатель события с использованием анонимного класса
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        // Слушатель события с использованием lambda
        noBtn.setOnClickListener(v->{
            checkAnswer(false);
        });


    }

    public void checkAnswer(boolean btn){
        UserAnswer userAnswer = new UserAnswer(
                questions[questionIndex].getQuestion(),
                questions[questionIndex].isCorrectAnswer(),
                btn
        );
        userAnswers.add(userAnswer);
        if((btn && questions[questionIndex].isCorrectAnswer()) || (!btn && !questions[questionIndex].isCorrectAnswer())){
            Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
        }
        //questionIndex = ++questionIndex%questions.length;
        if (questionIndex == questions.length-1){
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("userAnswers", userAnswers);
            startActivity(intent);
            userAnswers.clear();
            questionIndex = -1;
        }
        questionIndex++;
        questionTextView.setText(questions[questionIndex].getQuestion());
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG, "Вызван метод onStart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG, "Вызван метод onResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG, "Вызван метод onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG, "Вызван метод onStop()");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("questionIndex", questionIndex);
        Log.i(TAG, "Вызван метод onSaveInstanceState()");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "Вызван метод onDestroy()");
    }
}