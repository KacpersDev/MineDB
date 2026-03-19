package dev.minedb.components.impl;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import dev.minedb.components.Component;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.Map;

public class ItemStackComponent implements Component<ItemStack> {

    private static final Gson GSON = new Gson();
    private static final Type MAP_TYPE = new TypeToken<Map<String, Object>>() {}.getType();

    @Override
    public String serialize(@NotNull ItemStack itemStack) {
        Map<String, Object> serialized = itemStack.serialize();
        return GSON.toJson(serialized);
    }

    @Override
    public ItemStack deserialize(@NotNull String s) {
        Map<String, Object> map = GSON.fromJson(s, MAP_TYPE);
        return ItemStack.deserialize(map);
    }
}
