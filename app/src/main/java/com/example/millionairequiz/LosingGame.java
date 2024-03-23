package com.example.millionairequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LosingGame extends AppCompatActivity {

    TextView earningTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_losing_game);
        // Get total earnings so far
        Integer finalEarnings = getIntent().getIntExtra("totalEarning", 0);
        earningTextView = findViewById(R.id.earning_content);
        earningTextView.setText("You Earned : $"+ String.format("%,d", finalEarnings));
    }
    //button functionality to restart the game
    public void restart(View view){
        Intent mainIntent = new Intent(LosingGame.this, Questionaire.class);
        LosingGame.this.startActivity(mainIntent);
        LosingGame.this.finish();
    }
}