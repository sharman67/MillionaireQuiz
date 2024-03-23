package com.example.millionairequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Questionaire extends AppCompatActivity {

    //Declare global variables
    TextView totalWinnings;
    final int DISPLAY_LENGTH = 3000;
    RadioGroup radioGroupBtn;
    TextView questionTextView;
    RadioButton ansA, ansB, ansC, ansD;
    Button submitBtn;
    int earnings=0;
    int totalQuestion = QuestionAnswerList.questions.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionaire);

        //Get TextView Ids to set the question and answer text, total earnings, submit button
        totalWinnings = findViewById(R.id.winnings);
        questionTextView = findViewById(R.id.question);
        radioGroupBtn = findViewById(R.id.radio_choice);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);
        // set total earnings so far
        totalWinnings.setText("You Earned : $"+ earnings);

        //Load first Question
        loadNewQuestion();
    }
    // function to check if user selected the right answer
    public void checkAnswer(View view) {
        radioGroupBtn = findViewById(R.id.radio_choice);
        int selectedBtn = radioGroupBtn.getCheckedRadioButtonId();
        RadioButton radioCheckedButton = (RadioButton) findViewById(selectedBtn);
        String correctText = "This is CORRECT Answer \n You earned $" +
                String.format("%,d", QuestionAnswerList.EarningList[currentQuestionIndex]);

        selectedAnswer  = radioCheckedButton.getText().toString();
        // Move to next question if the answer was correct
        if(selectedAnswer.equals(QuestionAnswerList.correctAnswers[currentQuestionIndex])){
            Toast toast = Toast.makeText(this, correctText, Toast.LENGTH_SHORT);
            toast.show();

            earnings = QuestionAnswerList.EarningList[currentQuestionIndex];
            currentQuestionIndex++;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    loadNewQuestion();
                }
            }, DISPLAY_LENGTH);

        // Move to losing screen if the answer was incorrecr
        } else {
            Toast toast = Toast.makeText(this, "This is INCORRECT Answer \n" +
                    "Sorry you lost the game", Toast.LENGTH_SHORT);
            toast.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    /* Create an Intent that will start the losing-Activity. */
                    Intent mainIntent = new Intent(Questionaire.this, LosingGame.class);
                    //Pass total earnings so far to next activity
                    mainIntent.putExtra("totalEarning", earnings);
                    Questionaire.this.startActivity(mainIntent);
                    Questionaire.this.finish();
                }
            }, DISPLAY_LENGTH);
        }
    }
    void loadNewQuestion(){
        //Load question and answer texts
        if(currentQuestionIndex == totalQuestion ){
            //for last question move to winning UI
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    /* Create an Intent that will start the Winning-Activity. */
                    Intent mainIntent = new Intent(Questionaire.this, WinningGame.class);
                    //Pass total earnings to next activity
                    mainIntent.putExtra("totalEarning", earnings);
                    Questionaire.this.startActivity(mainIntent);
                    Questionaire.this.finish();
                }
            }, DISPLAY_LENGTH);
            return;
        }
        //clear radio button selection for the new question
        radioGroupBtn.clearCheck();
        // set question and answer text
        totalWinnings.setText("You Earned : $"+ String.format("%,d", earnings));
        questionTextView.setText(QuestionAnswerList.questions[currentQuestionIndex]);
        ansA.setText(QuestionAnswerList.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswerList.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswerList.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswerList.choices[currentQuestionIndex][3]);

    }

}