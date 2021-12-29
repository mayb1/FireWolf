package com.gameso.firewolf;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        int resultCount;
        int defaultValue = 0;

        TextView resultView = findViewById(R.id.resultView);

        Button buttonStartAgain = findViewById(R.id.buttonTryAgain);
        Button buttonExit = findViewById(R.id.buttonEndThis);
        Button[] resultButtons = new Button[] {buttonStartAgain, buttonExit};
        for (Button bb : resultButtons){
            bb.setOnClickListener(onClickListener);
        }
        Intent intentStartGame = getIntent();
        resultCount = intentStartGame.getIntExtra("clickCount", defaultValue);
        resultView.setText("Your score is : " + resultCount);
    }

    View.OnClickListener onClickListener = view -> {
        int selectedButton = Integer.parseInt(view.getTag().toString());
        switch (selectedButton){
            case 3:
                Intent intentTryAgain = new Intent(ResultsActivity.this, GameActivity.class);
                startActivity(intentTryAgain);
                finish();
                break;
            case 4:
                finishAffinity();
                break;
        }
    };
}