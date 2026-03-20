package dev.minedb.components.impl;

import dev.minedb.components.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

public class LocationComponent implements Component<Location> {

    @Override
    public String serialize(@NotNull Location location) {
        return location.getWorld().getName() + ";"
                + location.getX() + ";"
                + location.getY() + ";"
                + location.getZ() + ";"
                + location.getPitch() + ";"
                + location.getYaw();
    }

    @Override
    public Location deserialize(@NotNull String s) {
        String[] split = s.split(";");

        if (split.length != 6) {
            throw new IllegalArgumentException("Invalid serialized location: " + s);
        }

        String worldName = split[0];
        double blockX = Double.parseDouble(split[1]);
        double blockY = Double.parseDouble(split[2]);
        double blockZ = Double.parseDouble(split[3]);
        float pitch = Float.parseFloat(split[4]);
        float yaw = Float.parseFloat(split[5]);

        return new Location(Bukkit.getWorld(worldName), blockX, blockY, blockZ, pitch, yaw);
    }
}
