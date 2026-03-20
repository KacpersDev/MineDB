package dev.minedb.database;

import dev.minedb.database.connector.Connector;
import lombok.Getter;

@Getter
public class DatabaseConfig {

    private final Connector connector;

    public DatabaseConfig(Connector connector) {
        this.connector = connector;
    }
}
