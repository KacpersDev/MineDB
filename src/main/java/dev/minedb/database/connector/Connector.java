package dev.minedb.database.connector;

import dev.minedb.components.Component;

public interface Connector {

    void connect();
    void disconnect();
    <T> void save(String key, T value) throws Exception;

    /**
     * Load a value by key and type
     * @param key unique identifier
     * @param type object type
     * @param <T> object type
     * @return deserialized object or null if not found
     */
    <T> T load(String key, Class<T> type) throws Exception;

    /**
     * Delete a stored object by key and type
     */
    <T> void delete(String key, Class<T> type) throws Exception;
}
