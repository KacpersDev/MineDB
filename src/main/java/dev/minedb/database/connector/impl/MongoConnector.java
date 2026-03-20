package dev.minedb.database.connector.impl;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import dev.minedb.components.Component;
import dev.minedb.database.connector.Connector;
import lombok.Getter;

@Getter
public class MongoConnector implements Connector {

    private final String uri, databaseName;
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;

    public MongoConnector(String uri, String databaseName) {
        this.uri = uri;
        this.databaseName = databaseName;
    }

    @Override
    public void connect() {
        this.mongoClient = MongoClients.create(uri);
        this.mongoDatabase = mongoClient.getDatabase(databaseName);
    }

    @Override
    public void disconnect() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    @Override
    public <T> void save(String key, T value) throws Exception {

    }

    @Override
    public <T> T load(String key, Class<T> type) throws Exception {
        return null;
    }

    @Override
    public <T> void delete(String key, Class<T> type) throws Exception {

    }
}
