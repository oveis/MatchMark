package com.game.worldlandmarkfinder;

public class Landmark {
	private int mLandmarkId;
	private String mName;
	private String mPictureUrl;
	private String mDescription;
	private double mLatitudeCoordinate;
	private double mLongitudeCoordinate;
	
	public Landmark(final int landmarkId, final String name, final String pictureUrl, 
			final String description, final double latitudeCoordinate, final double longitudeCoordinate) {
		
		mLandmarkId = landmarkId;
		mName = name;
		mPictureUrl = pictureUrl;
		mDescription = description;
		mLatitudeCoordinate = latitudeCoordinate;
		mLongitudeCoordinate = longitudeCoordinate;
	}
	
}
