package com.game.activities;

import com.game.worldlandmarkfinder.BoardManager;
import com.game.worldlandmarkfinder.BoardAdapter;
import com.game.worldlandmarkfinder.R;
import com.game.worldlandmarkfinder.WorldLandmarkFinderGame;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;

public class GameActivity extends Activity {

    private WorldLandmarkFinderGame mGame;
    
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        Log.d("WLF", "Entered onCreate");
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        getActionBar().setTitle("World Landmark Finder");
        
        mGame = new WorldLandmarkFinderGame();
        
        final BoardAdapter boardAdapter = new BoardAdapter(this, mGame.getBoard());
        final GridView gridView = (GridView) findViewById(R.id.boardView);
        gridView.setAdapter(boardAdapter);
        
        gridView.setOnItemClickListener(new OnItemClickListener()
        {
        	@Override
			public void onItemClick(final AdapterView<?> parent, final View view, 
			        final int position, final long id) {
        	    mGame.clickCard((ImageView)view, position);
        	    //mGame.clickCard((ImageView)boardAdapter.getView(1, null, parent), 1);
        	   
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
