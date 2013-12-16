package com.game.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.game.worldlandmarkfinder.R;

public class HomeActivity extends Activity {
	
    @Override
	protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        
        Log.d("WLF", "Entered HomeActivity onCreate");
        getActionBar().setTitle("World Landmark Finder");
        
        final RelativeLayout homelayout = (RelativeLayout) findViewById(R.id.homelayout);
        
        final Button btnStartGame = (Button) findViewById(R.id.btnStartGame);
        btnStartGame.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("WLF", "Touched Start Game Button");
                final Intent intentGameActivity = new Intent(HomeActivity.this, GameActivity.class);
                startActivity(intentGameActivity);
                return false;
            }
        });
    }
	
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    
    @Override
    protected void onPause() {
        super.onPause();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
    }
    
    @Override
    protected void onStop() {
        super.onStop();
    }
    
    @Override
    protected void onStart() {
        super.onStart();        
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
