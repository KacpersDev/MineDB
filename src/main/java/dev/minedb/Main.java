package dev.minedb;

import dev.minedb.components.manager.ComponentManager;
import dev.minedb.database.connector.impl.MongoConnector;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.map.MapView;

@Getter
public class Main {

    private final static String stringView = "";
    private final static String stringItem = "";
    private final static String stringLocation = "";
    private final static String stringChunk = "";

    @Getter
    private final static ComponentManager componentManager = new ComponentManager();
    private final static MongoConnector mongoDatabase = new MongoConnector(null, null);

    @SneakyThrows
    public static void main(String[] args) {
        MapView mapView = componentManager.component(MapView.class).deserialize(stringView);
        ItemStack item = componentManager.component(ItemStack.class).deserialize(stringItem);
        Location location = componentManager.component(Location.class).deserialize(stringLocation);
        Chunk chunk = componentManager.component(Chunk.class).deserialize(stringChunk);

        mongoDatabase.save("reward", item);
        mongoDatabase.save("location", location);
        mongoDatabase.save("chunk", chunk);
        mongoDatabase.save("mapView", mapView);

        mongoDatabase.load("reward", ItemStack.class);
        mongoDatabase.load("location", Location.class);
        mongoDatabase.load("chunk", Chunk.class);
        mongoDatabase.load("mapView", MapView.class);
    }
}