package com.bsb.valise.script;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bsb.valise.common.ValiseConstants;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoScript {

	private static final Logger logger = LoggerFactory.getLogger(MongoScript.class.getCanonicalName());
	
	public MongoClient mongo;
	public DBCollection users;
	public DBCollection products;

	private static final String MONGODB_HOST = ValiseConstants.VALISE_DB_HOST;

	public MongoScript() {
		
		try {
			logger.info("Intializing mongo with host [{}]", MONGODB_HOST);
			mongo = new MongoClient(MONGODB_HOST);

			users = mongo.getDB(ValiseConstants.VALISE_DB).getCollection(ValiseConstants.USERS_COLLECTION);
			products = mongo.getDB(ValiseConstants.VALISE_DB).getCollection(ValiseConstants.PRODUCTS_COLLECTION);
			
		} catch (Exception e) {
			logger.error("Error while initializing db params script [{}]  [{}] ", e, e.getMessage());
		}
	}
	
	public static void main(String[] args) {

		MongoScript script = new MongoScript();

		script.insertProducts("");
	}

	private void insertProducts(String filename) {
		BufferedReader br = null;

		try {

			String currLine;

			br = new BufferedReader(new FileReader(filename));

			while ((currLine = br.readLine()) != null) {
				System.out.println(currLine);
				
				if(StringUtils.isNotBlank(currLine)){
					insertInMongo();
				}
			}

		} catch (IOException e) {
			
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void insertInMongo() {
		
	}
}
