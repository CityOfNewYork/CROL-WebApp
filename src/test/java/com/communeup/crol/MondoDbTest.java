package com.communeup.crol;

import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class MondoDbTest {

	@SuppressWarnings({ "resource", "deprecation" })
	public static void main(String[] args) {
		try {
			/**** Connect to MongoDB ****/
			// Since 2.10.0, uses MongoClient
			MongoClient mongo = new MongoClient("localhost", 27017);

			/**** Get database ****/
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("test");

			/**** Get collection / table from 'test' ****/
			// if collection doesn't exists, MongoDB will create it for you
			DBCollection table = db.getCollection("user");

			/**** Insert ****/
			// create a document to store key and value
			BasicDBObject document = new BasicDBObject();
			document.put("name", "ravindra");
			document.put("age", 30);
			document.put("createdDate", new Date());
			table.insert(document);

			/**** Find and display ****/
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", "ravindra");

			DBCursor cursor = table.find(searchQuery);

			System.out.println("Finding a saved Object ....");
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
			System.out.println("Finding a saved Object Done ....");

			/**** Update ****/
			// search document where name="mkyong" and update it with new values
			BasicDBObject query = new BasicDBObject();
			query.put("name", "ravindra");

			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("name", "ravindra-updated");

			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$set", newDocument);

			table.update(query, updateObj);

			/**** Find and display ****/
			BasicDBObject searchQuery2 = new BasicDBObject().append("name", "ravindra-updated");

			DBCursor cursor2 = table.find(searchQuery2);

			System.out.println("Finding an updated Object ....");
			while (cursor2.hasNext()) {
				System.out.println(cursor2.next());
			}
			System.out.println("Finding an updated Object Done ....");

			/**** Done ****/
			System.out.println("Done");
		} catch (MongoException e) {
			e.printStackTrace();
		}

	}
}
