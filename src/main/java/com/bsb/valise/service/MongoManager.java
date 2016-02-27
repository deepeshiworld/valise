package com.bsb.valise.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bsb.valise.common.ValiseConstants;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class MongoManager {

	private Logger logger = LoggerFactory.getLogger(getClass().getCanonicalName());
	private DB metadataDB;

	@SuppressWarnings({ "deprecation", "resource" })
	public MongoManager() {
		Mongo mongo = null;
		try {
			mongo = new MongoClient(ValiseConstants.VALISE_DB_HOST);
			this.metadataDB = mongo.getDB(ValiseConstants.VALISE_DB);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}finally {
			//mongo.close();
		}
	}

	DB getDB() {
		return metadataDB;
	}

	public List<DBObject> getObjects(String collectionName, Map queryParams, Map keys) throws Exception {
		DBCollection collection = getDB().getCollection(collectionName);

		BasicDBObject query = new BasicDBObject(queryParams);
		BasicDBObject dbkeys = new BasicDBObject(keys);

		DBCursor results = collection.find(query, dbkeys);
		List<DBObject> resultsList = new ArrayList<DBObject>();

		while (results.hasNext()) {
			resultsList.add(results.next());
		}

		return resultsList;
	}

	public DBObject getObject(String collectionName, DBObject findQuery) {
		try {
			DBCollection collection = getDB().getCollection(collectionName);
			return collection.findOne(findQuery);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	public void addObjects(String collectionName, List<DBObject> objects) {
		DBCollection collection = getDB().getCollection(collectionName);

		collection.insert(objects);
	}
}
