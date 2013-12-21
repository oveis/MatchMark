package com.game.activities;

import com.game.worldlandmarkfinder.R;
import com.game.worldlandmarkfinder.R.layout;
import com.game.worldlandmarkfinder.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ScoreActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
