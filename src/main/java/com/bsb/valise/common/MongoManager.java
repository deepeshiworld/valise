package com.bsb.valise.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class MongoManager {

	DB getDB() {
        try {
            Mongo mongo = new MongoClient("127.0.0.1", 27017);
            DB metadataDB = mongo.getDB("myairtelappdb");
            return metadataDB;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

	public List<DBObject> getObjects(String collectionName, Map queryParams, Map keys) throws Exception {
		DBCollection collection = getDB().getCollection(collectionName);

        BasicDBObject query = new BasicDBObject(queryParams);
        BasicDBObject dbkeys = new BasicDBObject(keys);

        DBCursor results = collection.find(query, dbkeys);
        List<DBObject> resultsList = new ArrayList<DBObject>();
        
        while(results.hasNext()) {
        	resultsList.add(results.next());
        }
        
        return resultsList;
	}
	
	public void addObjects(String collectionName, List<DBObject> objects) {
		DBCollection collection = getDB().getCollection(collectionName);
		
		collection.insert(objects);
	}
}
