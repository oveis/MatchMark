package com.game.worldlandmarkfinder;

import java.util.Set;

public class City {
	private int mId;
	private String mName;
	private String mPictureUrl;
	private String mDescription;
	private double mLatitudeCoordinate;
	private double mLongitudeCoordinate;
	private Set<Landmark> mLandmarks;
	
	public City(final int id, final String name, final String pictureUrl, final String description,
			final double latitudeCoordinate, final double longitudeCoordinate, final Set<Landmark> landmarks) {
		
		mId = id;
		mName = name;
		mPictureUrl = pictureUrl;
		mDescription = description;
		mLatitudeCoordinate = latitudeCoordinate;
		mLongitudeCoordinate = longitudeCoordinate;
		mLandmarks = landmarks;
	}
	
}
