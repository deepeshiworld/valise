package com.bsb.valise.dto;

import java.util.List;

public class ProductDetailDto {

	Product product;
	List<SimilarProduct> similarProductsList;
	long socialPopularity;
	Offer offer;
	ProductRating rating;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<SimilarProduct> getSimilarProductsList() {
		return similarProductsList;
	}

	public void setSimilarProductsList(List<SimilarProduct> similarProductsList) {
		this.similarProductsList = similarProductsList;
	}

	public long getSocialPopularity() {
		return socialPopularity;
	}

	public void setSocialPopularity(long socialPopularity) {
		this.socialPopularity = socialPopularity;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public ProductRating getRating() {
		return rating;
	}

	public void setRating(ProductRating rating) {
		this.rating = rating;
	}

}
