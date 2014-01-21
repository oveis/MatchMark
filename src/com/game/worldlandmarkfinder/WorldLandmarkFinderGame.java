package com.game.worldlandmarkfinder;

import com.game.activities.GameActivity;

import android.os.Handler;
import android.os.SystemClock;
import android.widget.ImageView;

public class WorldLandmarkFinderGame {
    
    private static final long INIT_GAME_TIME = 30000L;
    
	private BoardManager mBoardManager;
	private String mPlayerName;
	private int mCurLevel;
	private long mTimeRemainingMillis;
	private int mNumOfTry = 0;
	private long mStartTime = 0L;
	private int mScore = 0;
	private int mMultiplier;
    
	private Handler mTimerHandler = new Handler();
	
	private GameActivity mGameActivity;
	
	public WorldLandmarkFinderGame(final GameActivity gameActivity) {
	    mGameActivity = gameActivity; 
	    mPlayerName = "Mario";
	    mCurLevel = 1;
	    mBoardManager = new BoardManager();
	    mBoardManager.createBoard();
	    getGameData();
	    mTimeRemainingMillis = INIT_GAME_TIME;
	    mMultiplier = 0;
	}
	
	public String getPlayerName() {
	    return mPlayerName;
	}
	
	public int getCurLevel() {
	    return mCurLevel;
	}
	
	public long getTimeRemainingMillis() {
	    return mTimeRemainingMillis;
	}
	
	public int getNumOfTry() {
	    return mNumOfTry;
	}
	
	public int getMultiplier() {
	    return mMultiplier;
	}
	
	public Board getBoard() {
	    return mBoardManager.getBoard();
	}
	
	public int getScore() {
        return mScore;
    }
    
	public void getGameData() {
	    // Get Game Data from DB
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
	            int msecs = (int) (mTimeRemainingMillis % 1000 / 10);
	            mGameActivity.setTimerText(String.format("%02d:%02d", secs, msecs));
	            mTimerHandler.postDelayed(this, 0);
	            if(mTimeRemainingMillis <= 10000L) {
	                mGameActivity.changeTimerColor("#FF0000");
	            }
            } else {
                mTimeRemainingMillis = 0;
                mGameActivity.setTimerText("00:00");
                mScore = 0;
                gameOver();
            } 
	    }
	};
	
	public void clickCard(final ImageView imageView, final int position) {
        final int result = mBoardManager.clickCard(imageView, position);
        switch(result) {
            case BoardManager.ALL_CARDS_MATCHED:
                calculateScore();
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
	
	private void gameOver() {
	    mGameActivity.showScoreScreen();
	}
	
	private void calculateScore() {
	    final int numOfRemainTries = (30 - mNumOfTry > 0) ? (30 - mNumOfTry) : 0;
	    mScore = (int)(INIT_GAME_TIME- mTimeRemainingMillis) + numOfRemainTries * 1000;
	}
}
