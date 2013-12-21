package com.game.activities;

import com.game.worldlandmarkfinder.BoardManager;
import com.game.worldlandmarkfinder.BoardAdapter;
import com.game.worldlandmarkfinder.R;
import com.game.worldlandmarkfinder.WorldLandmarkFinderGame;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameActivity extends Activity {

    private WorldLandmarkFinderGame mGame;
    private TextView mTxtTimer;
    
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        Log.d("WLF", "Entered onCreate");
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        getActionBar().setTitle("World Landmark Finder");
        
        mTxtTimer = (TextView) findViewById(R.id.txtTimer);
        mGame = new WorldLandmarkFinderGame(this);
        
        final BoardAdapter boardAdapter = new BoardAdapter(this, mGame.getBoard());
        final GridView gridView = (GridView) findViewById(R.id.boardView);
        gridView.setAdapter(boardAdapter);
        
        gridView.setOnItemClickListener(new OnItemClickListener()
        {
        	@Override
			public void onItemClick(final AdapterView<?> parent, final View view, 
			        final int position, final long id) {
        	    mGame.clickCard((ImageView)view, position);
			}
        });
        
        mGame.play();
    }
    
    public void showScoreScreen() {
        final Intent intentScoreActivity = new Intent(GameActivity.this, ScoreActivity.class);
        startActivity(intentScoreActivity);
    }
    
    public void setTimerText(final String text) {
        mTxtTimer.setText(text);
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
