package com.bsb.valise.script;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bsb.valise.common.ClothingSize;
import com.bsb.valise.common.RandomString;
import com.bsb.valise.common.ValiseConstants;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoScript {

	private static final Logger logger = LoggerFactory.getLogger(MongoScript.class.getCanonicalName());
	
	public MongoClient mongo;
	public DBCollection users;
	public DBCollection products;
	public RandomString randomString;
	
	private static final String MONGODB_HOST = ValiseConstants.VALISE_DB_HOST;

	private List<String> colorList=new ArrayList<>();
	
	@SuppressWarnings("deprecation")
	public MongoScript() {

		try {
			logger.info("Intializing mongo with host [{}]", MONGODB_HOST);
			mongo = new MongoClient(MONGODB_HOST);

			users = mongo.getDB(ValiseConstants.VALISE_DB).getCollection(ValiseConstants.USERS_COLLECTION);
			products = mongo.getDB(ValiseConstants.VALISE_DB).getCollection(ValiseConstants.PRODUCTS_COLLECTION);

			randomString = new RandomString(10);
		} catch (Exception e) {
			logger.error("Error while initializing db params script [{}]  [{}] ", e, e.getMessage());
		}
	}
	
	public static void main(String[] args) {

		MongoScript script = new MongoScript();

		script.populateConstants();
		script.insertProducts("/Users/deepesh/Documents/iworld/valise/src/main/resources/input.txt");
	}

	private void populateConstants() {
		
		//Color
		colorList.add("red");
		colorList.add("blue");
		colorList.add("green");
		colorList.add("magenta");
		colorList.add("purple");
		colorList.add("black");
		colorList.add("brown");
		
	}

	private void insertProducts(String filename) {
		BufferedReader br = null;

		try {

			String currLine;

			br = new BufferedReader(new FileReader(filename));

			while ((currLine = br.readLine()) != null) {
				logger.info(currLine);

				if (StringUtils.isNotBlank(currLine)) {
					insertInMongo(currLine);
				}
			}

		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void insertInMongo(String line) {

		DBObject dbObject = new BasicDBObject();

		String[] arr = line.split("\\$");

		String section = arr[0];
		if (StringUtils.isNotBlank(section)) {
			//dbObject.put("section", Section.getSectionById(section.trim().toLowerCase()));
			dbObject.put("section", section.trim().toLowerCase());
		}

		String category = arr[1];
		if (StringUtils.isNotBlank(category)) {
			dbObject.put("category", category.trim().toUpperCase());
		}

		String subcategory = arr[2];
		if (StringUtils.isNotBlank(subcategory)) {
			dbObject.put("subcategory", subcategory.trim().toUpperCase());
		}

		String brand = arr[3];
		if (StringUtils.isNotBlank(brand)) {
			dbObject.put("brand", brand.trim().toUpperCase());
		}

		String articleType = arr[4];
		if (StringUtils.isNotBlank(articleType)) {
			dbObject.put("tagname", articleType.trim().toUpperCase());
		}

		String price = arr[5];
		if (StringUtils.isNotBlank(price)) {
			dbObject.put("price", Integer.parseInt(price));
		}

		String description = arr[6];
		if (StringUtils.isNotBlank(description)) {
			dbObject.put("description", description.trim());
		}

		List<DBObject> list = addSizeQuantity(dbObject);

		if (list.size() > 0) {
			//logger.info(list.size());
		}

	}
	
	public List<DBObject> addSizeQuantity(DBObject dbObject) {
		List<DBObject> list = new ArrayList<>();

		for (String color : colorList) {

			DBObject object = getClone(dbObject);

			object.put("color", color);

			for (String size : ClothingSize.getAllSizes()) {
				try {
					object.put("size", ClothingSize.getSizeByName(size));
					object.put("pid", randomString.nextString());
					products.insert(object);
					list.add(object);
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
			}

			// Add value in Inventory
		}
		return list;
	}
	
	
	private DBObject getClone(DBObject dbObject) {
		DBObject obj = new BasicDBObject();

		for (String key : dbObject.keySet()) {
			obj.put(key, dbObject.get(key));
		}
		return obj;
	}

	public static int randInt() {

		int min = 0;
		int max = 10;
		Random rand = new Random();

		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}
}
