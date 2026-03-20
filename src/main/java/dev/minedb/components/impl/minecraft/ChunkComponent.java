package dev.minedb.components.impl.minecraft;

import dev.minedb.components.Component;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

public class ChunkComponent implements Component<Chunk> {

    @Override
    public String serialize(@NotNull Chunk chunk) {
        return chunk.getWorld().getName() + ";" +
                chunk.getX() + ";" +
                chunk.getZ();
    }

    @Override
    public Chunk deserialize(@NotNull String s) {
        String[] split = s.split(";");

        if (split.length != 3) {
            throw new IllegalArgumentException("Invalid serialized Chunk: " + s);
        }

        String worldName = split[0];
        int x = Integer.parseInt(split[1]);
        int z = Integer.parseInt(split[2]);

        World world = Bukkit.getWorld(worldName);
        if (world == null) {
            throw new IllegalStateException("World not found: " + worldName);
        }

        return world.getChunkAt(x, z);
    }
}
