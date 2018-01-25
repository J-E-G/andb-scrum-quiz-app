package com.example.android.scrumquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    int score = 99;
    public static final String EXTRA_MESSAGE = "com.example.android.scrumquiz.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This method is called when the Submit button is pressed.
    public void scoreQuiz(View view) {
        calculateQuizScore();
        Intent intent = new Intent(this, DisplayScoreActivity.class);
        String message = "You scored " + score + " by answering 5 out of 5 questions correctly.";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    // This method calculates the users total score on the quiz.
    private void calculateQuizScore() {

        Toast.makeText(this, "New Activity Triggered", Toast.LENGTH_SHORT).show();
    }
}
