package com.example.android.scrumquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This method is called when the Submit button is pressed.
    public void scoreQuiz(View view) {
        calculateQuizScore();
    }

    // This method calculates the users total score on the quiz.
    private void calculateQuizScore() {
        int score = 100;
        Toast.makeText(this, "You scored " + score + " by answering 5 out of 5 questions correctly.", Toast.LENGTH_SHORT).show();
    }
}
