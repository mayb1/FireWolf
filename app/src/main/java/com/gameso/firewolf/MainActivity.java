package com.gameso.firewolf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStartGame = findViewById(R.id.buttonStartGame);
        Button buttonPrivacyPolicy = findViewById(R.id.buttonPrivacyPolicy);
        Button buttonExit = findViewById(R.id.buttonExit);

        Button[] buttons = new Button[]{buttonStartGame, buttonPrivacyPolicy, buttonExit};
        for(Button b : buttons){
            b.setOnClickListener(onClickListener);
        }
    }

    View.OnClickListener onClickListener = view -> {
        int selectedItem = Integer.parseInt(view.getTag().toString());
        switch(selectedItem){
            case 0:
                Intent intentStartGame = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intentStartGame);
                finish();
                break;
            case 1:
                Toast.makeText(getApplicationContext(), "Policy is not yet implemented", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                finishAffinity();
                break;
        }
    };
}