package com.game.activities;

import com.game.worldlandmarkfinder.R;
import com.game.worldlandmarkfinder.R.layout;
import com.game.worldlandmarkfinder.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class ScoreActivity extends Activity {

    private TextView mTxtLevel;
    private TextView mTxtTimeRemaining;
    private TextView mTxtNumOfTry;
    private TextView mTxtMultiplier;
    private TextView mTxtScore;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("WLF", "Entered ScoreActivity onCreate");
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_activity);
        
        mTxtLevel = (TextView) findViewById(R.id.txtLevel);
        mTxtTimeRemaining = (TextView) findViewById(R.id.txtTimeRemaining);
        mTxtNumOfTry = (TextView) findViewById(R.id.txtNumOfTry);
        mTxtMultiplier = (TextView) findViewById(R.id.txtMultiplier);
        mTxtScore = (TextView) findViewById(R.id.txtScore);
        
        final int level = getIntent().getExtras().getInt("level");
        final long timeRemaining = getIntent().getExtras().getLong("timeRemaining");
        final int numOfTry = getIntent().getExtras().getInt("numOfTry");
        final int multiplier = getIntent().getExtras().getInt("multiplier");
        final int score = getIntent().getExtras().getInt("score");
        
        mTxtLevel.setText(String.valueOf(level));
        mTxtTimeRemaining.setText(getTimeFormatString(timeRemaining));
        mTxtNumOfTry.setText(String.valueOf(numOfTry));
        mTxtMultiplier.setText(String.valueOf(multiplier));
        mTxtScore.setText(String.valueOf(score));        
    }
    
    private String getTimeFormatString(final long time) {
        int secs = (int) (time / 1000);
        int msecs = (int) (time % 1000 / 10);
        return String.format("%02d:%02d", secs, msecs);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
