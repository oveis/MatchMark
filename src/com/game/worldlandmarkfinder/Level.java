package com.game.worldlandmarkfinder;

public class Level {
	private int mLevelNum;
	private City mCity;
	private long mTimeLimitMillis;
	private int mBoardHeight;
	private int mBoardWidth;
	private boolean mMatchPicAndName;
	private long mLengthOfShowTimeMillis;
	private boolean mSwapPicAndName;
	
	public Level(final int levelNum, final City city, final long timeLimitMillis, 
			final int boardHeight, final int boardWidth, final boolean matchPicAndName, 
			final long lengthOfShowTimeMillis, final boolean swapPicAndName) {
		
		mLevelNum = levelNum;
		mCity = city;
		mTimeLimitMillis = timeLimitMillis;
		mBoardHeight = boardHeight;
		mBoardWidth = boardWidth;
		mMatchPicAndName = matchPicAndName;
		mLengthOfShowTimeMillis = lengthOfShowTimeMillis;
		mSwapPicAndName = swapPicAndName;
	}
	
}
