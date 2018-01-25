package com.example.android.scrumquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    int correctAnswers = 0;
    public static final String EXTRA_MESSAGE = "com.example.android.scrumquiz.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This method is called when the Submit button is pressed.
    public void showQuizScore(View view) {
        calculateQuizScore();
        Intent intent = new Intent(this, DisplayScoreActivity.class);
        String message = "You scored " + score + " points by answering " + correctAnswers + " out of 5 questions correctly.";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    // This method calculates the users total score on the quiz.
    private void calculateQuizScore() {
        RadioButton question1_answer3 = findViewById(R.id.question1_answer3);

        if (question1_answer3.isChecked()) {
            score += 25;
            correctAnswers += 1;
        }
    }

}
