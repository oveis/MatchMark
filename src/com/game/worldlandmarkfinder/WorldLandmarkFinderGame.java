package com.game.worldlandmarkfinder;

import java.util.Timer;
import java.util.TimerTask;

import com.game.activities.GameActivity;
import com.game.activities.HomeActivity;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.ImageView;
import android.widget.TextView;

public class WorldLandmarkFinderGame {
    
	private BoardManager mBoardManager;
	private String mPlayerName;
	private int mCurLevel;
	private long mTimeRemainingMillis;
	private int mNumOfTry = 0;
	private long mStartTime = 0L;
    
	private Handler mTimerHandler = new Handler();
	
	private GameActivity mGameActivity;
	
	public WorldLandmarkFinderGame(final GameActivity gameActivity) {
	    mGameActivity = gameActivity; 
	    mPlayerName = "Mario";
	    mCurLevel = 1;
	    mBoardManager = new BoardManager();
	    mBoardManager.createBoard();
	    getGameData();
	}
	
	public String getPlayerName() {
	    return mPlayerName;
	}
	
	public int getCurLevel() {
	    return mCurLevel;
	}
	
	public Board getBoard() {
	    return mBoardManager.getBoard();
	}
	
	public void getGameData() {
	    mTimeRemainingMillis = 50000L;
	}
	
	private void startTimer() {
	    mStartTime = SystemClock.uptimeMillis();
	    mTimerHandler.postDelayed(updateTimerThread, 0);
	}
	
	private void pauseTimer() {
	    mTimerHandler.removeCallbacks(updateTimerThread);
	}
	
	private Runnable updateTimerThread = new Runnable() {
	    public void run() {
	        mTimeRemainingMillis -= (SystemClock.uptimeMillis() - mStartTime);
	        mStartTime = SystemClock.uptimeMillis();
	        
	        if(mTimeRemainingMillis > 0) {
	            int secs = (int) (mTimeRemainingMillis / 1000);
	            int mins = secs / 60;
	            secs %= 60;
	            int milliseconds = (int) (mTimeRemainingMillis % 1000 / 10);
	            mGameActivity.setTimerText("" + mins + ":" + String.format("%02d", secs) 
	                    + ":" + String.format("%02d", milliseconds));
	            mTimerHandler.postDelayed(this, 0);
            } else {
                mGameActivity.setTimerText("0:00:00");
                gameOver();
            } 
	    }
	};
	
	public void clickCard(final ImageView imageView, final int position) {
        final int result = mBoardManager.clickCard(imageView, position);
        switch(result) {
            case BoardManager.ALL_CARDS_MATCHED:
                gameOver();
                break;
            case BoardManager.CARDS_MATCH_SUCCESS:
            case BoardManager.CARDS_MATCH_FAILURE:
                mNumOfTry++;
                break;
        }
	}
	
	public void setNextGame() {
	    
	}
	
	public void play() {
	    startTimer();
	}
	
	public void stop() {
		
	}
	
	public void resume() {
		
	}
	
	public void gameOver() {
	    mGameActivity.showScoreScreen();
	}
}
