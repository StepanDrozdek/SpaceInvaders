package com.example.andst.space_invaders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu);
    }

    public void NewGame(View v) {
        Intent intent = new Intent(Menu.this, SpaceInvadersActivity.class);
        startActivity(intent);
    }

    public void goToHighScore(View v){
        Intent intent = new Intent(Menu.this, HighScore.class);
        startActivity(intent);
    }

    public void ExitApp(View view) {
        finish();

        System.exit(0);
    }

    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
    }



}
