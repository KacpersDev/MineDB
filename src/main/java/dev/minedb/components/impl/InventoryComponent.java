package dev.minedb.components.impl;

import dev.minedb.components.Component;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class InventoryComponent implements Component<ItemStack[]> {

    private final ItemStackComponent itemStackComponent = new ItemStackComponent();

    @Override
    public String serialize(ItemStack @NotNull [] itemStacks) {
        return null;
    }

    @Override
    public ItemStack[] deserialize(@NotNull String s) {
        return new ItemStack[0];
    }
}
