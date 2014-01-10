package com.game.worldlandmarkfinder;

public class Card {
	private final int mId;
	private final String mName;
	
	public Card(final int id, final String name) {
		mId = id;
		mName = name;
	}
	
	public int getId() {
	    return mId;
	}
	
	public String getName() {
	    return mName;
	}
}
