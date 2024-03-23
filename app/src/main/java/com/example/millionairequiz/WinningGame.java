package com.example.millionairequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WinningGame extends AppCompatActivity {

    TextView earningTextView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning_game);
        //Get total earnings for the winner
        Integer finalEarnings = getIntent().getIntExtra("totalEarning", 0);
        earningTextView = findViewById(R.id.earning_content);
        earningTextView.setText("You Earned : $"+ String.format("%,d", finalEarnings));
    }
    // button functionality to restart the game
    public void restart(View view){
        Intent mainIntent = new Intent(WinningGame.this, Questionaire.class);
        WinningGame.this.startActivity(mainIntent);
        WinningGame.this.finish();
    }
}