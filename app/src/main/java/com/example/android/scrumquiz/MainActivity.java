package com.example.android.scrumquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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

        if (score > 60) {
            String message = "You scored " + score + " points by answering " + correctAnswers + " out of 5 questions correctly. AMAZING!";
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        } else {
            String message = "You scored " + score + " points by answering " + correctAnswers + " out of 5 questions correctly. Check out the Scrum Guide and try again.";
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }

    }

    // This method calculates the users total score on the quiz.
    private void calculateQuizScore() {
        score = 0; // reset the value back to 0 after user comes back from score view activity
        correctAnswers = 0;
        int addPoints = 20;
        RadioButton question1_answer3 = findViewById(R.id.question1_answer3_rb); // Question 1 Answer
        RadioButton question2_answer2 = findViewById(R.id.question2_answer2_rb); // Question 2 Answer

        /* Question 3 Answers */
        CheckBox question3_answer1 = findViewById(R.id.question3_answer1_cb);
        CheckBox question3_answer2 = findViewById(R.id.question3_answer2_cb);
        CheckBox question3_answer3 = findViewById(R.id.question3_answer3_cb);
        CheckBox question3_answer4 = findViewById(R.id.question3_answer4_cb);

        // Question 4 User Input
        EditText question4_user_input = findViewById(R.id.question4_answer_input);
        String question4_answer = question4_user_input.getText().toString();

        RadioButton question5_answer2 = findViewById(R.id.question5_answer2_rb); // Question 5 Answer

        // If Question 1 is correct, increment points and correct answer count
        if (question1_answer3.isChecked()) {
            score += addPoints;
            correctAnswers += 1;
        }

        // If Question 2 is correct, increment points and correct answer count
        if (question2_answer2.isChecked()) {
            score += addPoints;
            correctAnswers += 1;
        }

        /* If Question 3 has the correct checkboxes selected, increment points and correct answer count.
        Points are only incremented on selection of the correct set of checkboxes */

        if (question3_answer1.isChecked() && !question3_answer2.isChecked() &&  question3_answer3.isChecked() && question3_answer4.isChecked()) {
            score += addPoints;
            correctAnswers += 1;
        }


        // If Question 4 is correct, increment points and correct answer count.
        if (question4_answer.equalsIgnoreCase(getString(R.string.question_4_answer))) {
            score += addPoints;
            correctAnswers += 1;
        }

        // If Question 5 is correct, increment points and correct answer count.
        if (question5_answer2.isChecked()) {
            score += addPoints;
            correctAnswers += 1;
        }

    }

}
