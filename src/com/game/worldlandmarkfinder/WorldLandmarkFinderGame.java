package com.game.worldlandmarkfinder;

import android.widget.ImageView;

public class WorldLandmarkFinderGame {
    
	private BoardManager mBoardManager;
	private String mPlayerName;
	private int mCurLevel;
	private long mTimeRemainingMillis;
	private int mNumOfTry = 0;
	
	public WorldLandmarkFinderGame() {
		mPlayerName = "Mario";
	    mCurLevel = 1;
	    mBoardManager = new BoardManager();
	    mBoardManager.createBoard();
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
	    mTimeRemainingMillis = 100000;
	    
	}
	
	public void clickCard(final ImageView imageView, final int position) {
        final boolean isFlipped = mBoardManager.clickCard(imageView, position);
        if(isFlipped) {
            mNumOfTry++;
        }
	}
	
	public void setNextGame() {
		
	}
	
	public void play() {
		
	}
	
	public void stop() {
		
	}
	
	public void resume() {
		
	}
}
