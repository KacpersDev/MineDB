package dev.minedb.components.impl;

import dev.minedb.components.Component;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class InventoryComponent implements Component<ItemStack[]> {

    private final ItemStackComponent itemStackComponent = new ItemStackComponent();

    @Override
    public String serialize(ItemStack @NotNull [] itemStacks) {
        StringBuilder serialized = new StringBuilder();
        for (int i = 0; i < itemStacks.length; i++) {
            if (itemStacks[i] == null) continue;
            String item = itemStackComponent.serialize(itemStacks[i]);
            String index = i + "§" + item;

            if (serialized.isEmpty()) {
                serialized = new StringBuilder(index);
            } else {
                serialized.append(";").append(index);
            }
        }

        return serialized.toString();
    }

    @Override
    public ItemStack[] deserialize(@NotNull String s) {
        ItemStack[] content = new ItemStack[54];

        for (final String originalSplit : s.split(";")) {
            String[] split = originalSplit.split("§");

            int index = Integer.parseInt(split[0]);
            ItemStack itemStack = itemStackComponent.deserialize(split[1]);
            content[index] = itemStack;
        }

        return content;
    }
}
