package com.bsb.valise.dto;

public class ProductRating {

	long likes;
	String groupLevel;
	float rating;

	public long getLikes() {
		return likes;
	}

	public void setLikes(long likes) {
		this.likes = likes;
	}

	public String getGroupLevel() {
		return groupLevel;
	}

	public void setGroupLevel(String groupLevel) {
		this.groupLevel = groupLevel;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

}
