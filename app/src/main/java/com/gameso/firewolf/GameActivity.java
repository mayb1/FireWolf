package com.gameso.firewolf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class GameActivity extends AppCompatActivity {

    private int clickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView gameTimer = (TextView) findViewById(R.id.textTimer);
        TextView gameHits = (TextView) findViewById(R.id.textHits);

        ImageView gameButton = (ImageView) findViewById(R.id.imageButton);




        new CountDownTimer(30000, 1000){

            @Override
            public void onTick(long timeUntilFinish) {
                gameTimer.setText(String.format(Locale.getDefault(), "Time left : %d", timeUntilFinish / 1000));

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gameButton.setOnClickListener(new View.OnClickListener(){

                            @Override
                            public void onClick(View view) {
                                clickCount += 1;
                                gameHits.setText(String.format(Locale.getDefault(), "Hits : %d", clickCount));
                            }
                        });
                    }
                });
            }

            @Override
            public void onFinish() {
                Intent intentStartGame = new Intent(GameActivity.this, ResultsActivity.class);
                intentStartGame.putExtra ("clickCount", clickCount);
                startActivity(intentStartGame);
                finish();
            }
        }.start();
    }

}