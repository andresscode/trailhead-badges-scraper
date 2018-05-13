package com.andresscode.trailheadbadgesscraper.database;

import com.andresscode.trailheadbadgesscraper.model.Badge;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andres Martinez
 *
 * Class responsible for controlling MongoDB database. Handles the connection and CRUD operations. Uses Gson
 * to parse Document (Bson).
 *
 * @see MongoClient
 * @see MongoDatabase
 * @see MongoCollection
 * @see Document
 * @see Gson
 */
public class Mongo extends MongoClient {
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    /**
     * Establish the connection with the MongoDB instance from MongoLab in Heroku, then setups the database and
     * collection that will be used.
     */
    public Mongo() {
        super(new MongoClientURI("mongodb://heroku_prsc52xb:mgairgbbst9aj3d3jthe0k2p6a@ds121535.mlab.com:21535/heroku_prsc52xb"));
        this.database = this.getDatabase("heroku_prsc52xb");
        this.collection = this.database.getCollection("badges");
    }

    /**
     * Updates every badge in the database. Uses the replaceOne() method which finds a badge filtering by href to
     * check if the badge is already in the database, uses the upsert option set to true. In case that a badge
     * is not found, then will be created.
     *
     * @param   badges A list of badges to be updated
     * @return  A list of UpdateResult from MongoDB with the status of each update
     */
    public List<UpdateResult> update(final List<Badge> badges) {
        List<UpdateResult> result = new ArrayList<>();

        Gson gson = new Gson();
        for (Badge b : badges) {
            result.add(this.collection.replaceOne(new Document("href", b.getHref()), Document.parse(gson.toJson(b)), new UpdateOptions().upsert(true)));
        }

        return result;
    }
}
