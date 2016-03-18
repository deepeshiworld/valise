package com.bsb.valise.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bsb.valise.common.ValiseConstants;
import com.bsb.valise.dto.Offer;
import com.bsb.valise.dto.Product;
import com.bsb.valise.dto.ProductDetailDto;
import com.bsb.valise.dto.ProductRating;
import com.bsb.valise.dto.SimilarProduct;
import com.bsb.valise.utils.CommonUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class ProductService {

	private Logger logger = LoggerFactory.getLogger(getClass().getCanonicalName());

	@Autowired
	MongoManager mongoManager;

	
	public MongoManager getMongoManager() {
		return mongoManager;
	}

	public void setMongoManager(MongoManager mongoManager) {
		this.mongoManager = mongoManager;
	}

	public ProductDetailDto getProductDetail(String pid) {
		if (StringUtils.isBlank(pid)) {
			logger.error("pid is blank : " + pid);
			return null;
		}

		Product product = getProductFromDB(pid);
		if (product == null) {
			logger.error("no product found correponding to pid : " + pid);
			return null;
		}
		product.setSize(CommonUtils.getSizeMapping(product.getSize()));

		ProductDetailDto detailDto = new ProductDetailDto();
		detailDto.setProduct(product);

		List<SimilarProduct> similarList = getSimilarItems();
		detailDto.setSimilarProductsList(similarList);

		Offer offer = getOffer(product.getPrice());
		detailDto.setOffer(offer);

		detailDto.setSocialPopularity(CommonUtils.randInt(10, 1000));
		detailDto.setRating(getProductRating(product));

		return detailDto;
	}

	private ProductRating getProductRating(Product product) {
		ProductRating rating = new ProductRating();
		rating.setLikes(CommonUtils.randInt(6, 50));
		rating.setRating(CommonUtils.randInt(0, 5));

		StringBuffer buffer = new StringBuffer();
		buffer.append(product.getSection()).append(".");
		buffer.append(product.getCategory()).append(".");
		buffer.append(product.getSubcategory()).append(".");
		buffer.append(product.getBrand()).append(".");
		buffer.append(product.getTagname()).append(".");

		rating.setGroupLevel(buffer.toString());
		return rating;
	}

	private Offer getOffer(int price) {
		Offer offer = new Offer();

		int discount = CommonUtils.randInt() + CommonUtils.randInt();
		offer.setDiscount(discount+"%");

		int value = (price * discount) / 100;
		offer.setEffectivePrice(price - value);
		return offer;
	}

	private List<SimilarProduct> getSimilarItems() {

		List<String> similarPidList = CommonUtils.getSimilarPidList(CommonUtils.randInt());
		if (similarPidList == null || similarPidList.isEmpty()) {
			similarPidList.add("gufwuhrg3j");
			similarPidList.add("oz44nziiid");
			similarPidList.add("9i8ggk8aq8");
		}

		List<SimilarProduct> similarProducts = new ArrayList<>();

		for (String pid : similarPidList) {
			Product product = getProductFromDB(pid);
			SimilarProduct sProduct = new SimilarProduct();
			sProduct.setImageUrl(product.getImageUrl());
			sProduct.setPrice(product.getPrice());
			sProduct.setTitle(product.getTitle());

			similarProducts.add(sProduct);
		}

		return similarProducts;
	}

	private Product getProductFromDB(String pid) {
		try {
			if (mongoManager != null) {
				DBObject prodcutObj = mongoManager.getObject(ValiseConstants.PRODUCTS_COLLECTION,
						new BasicDBObject("pid", pid));

				Gson gson = new Gson();

				if (prodcutObj != null) {
					String procutJsonString = prodcutObj.toString();
					Product product = gson.fromJson(procutJsonString, Product.class);
					return product;
				}
			}
		} catch (JsonSyntaxException e) {
			logger.error("error in parsing json : " + e.getMessage());
			return null;
		}
		return null;
	}
}
