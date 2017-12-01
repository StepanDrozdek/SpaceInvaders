package com.example.andst.space_invaders;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Window;

// SpaceInvadersActivity is the entry point to the game.
// It will handle the lifecycle of the game by calling
// methods of spaceInvadersView when prompted to so by the OS.
public class SpaceInvadersActivity extends AppCompatActivity implements SensorEventListener {

    // spaceInvadersView will be the view of the game
    // It will also hold the logic of the game
    // and respond to screen touches as well
    SpaceInvadersView spaceInvadersView;
    private float mXTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        // Get a Display object to access screen details
        Display display = getWindowManager().getDefaultDisplay();
        // Load the resolution into a Point object
        Point size = new Point();
        display.getSize(size);

        // Initialize gameView and set it as the view
        spaceInvadersView = new SpaceInvadersView(this, size.x, size.y);
        setContentView(spaceInvadersView);


        SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor accelerometer = manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
        manager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
    }

    // This method executes when the player starts the game
    @Override
    protected void onResume() {
        super.onResume();

        // Tell the gameView resume method to execute
        spaceInvadersView.resume();
    }

    // This method executes when the player quits the game
    @Override
    protected void onPause() {
        super.onPause();

        // Tell the gameView pause method to execute
        spaceInvadersView.pause();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        mXTemp = event.values[0];

        if (event.values[0] > 1){
            spaceInvadersView.steerLeft();
        }
        else if (event.values[0] < -1){
            spaceInvadersView.steerRight();
        }else{
            spaceInvadersView.stay();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
