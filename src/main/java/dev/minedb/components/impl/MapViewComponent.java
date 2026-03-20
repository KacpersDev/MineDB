package dev.minedb.components.impl;

import dev.minedb.components.Component;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.map.MapView;
import org.jetbrains.annotations.NotNull;

public class MapViewComponent implements Component<MapView> {

    @Override
    public String serialize(@NotNull MapView mapView) {
        String worldName = mapView.getWorld() != null
                ? mapView.getWorld().getName()
                : "null";

        return mapView.getId() + ";" + worldName;
    }

    @Override
    public MapView deserialize(@NotNull String s) {
        String[] split = s.split(";");

        if (split.length != 2) {
            throw new IllegalArgumentException("Invalid serialized MapView: " + s);
        }

        int id = Integer.parseInt(split[0]);
        String worldName = split[1];

        World world = worldName.equals("null") ? null : Bukkit.getWorld(worldName);

        MapView mapView = Bukkit.getMap(id);

        if (mapView == null) {
            throw new IllegalStateException("MapView not found for id: " + id);
        }

        return mapView;
    }
}
