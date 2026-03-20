package dev.minedb.components.impl.collections;

import dev.minedb.components.Component;
import dev.minedb.components.extra.ItemStackCollection;
import dev.minedb.components.impl.minecraft.ItemStackComponent;
import org.jetbrains.annotations.NotNull;

public class ItemStackCollectionComponent implements Component<ItemStackCollection> {

    private final ItemStackComponent itemStackComponent = new ItemStackComponent();

    @Override
    public String serialize(@NotNull ItemStackCollection itemStackCollection) {
        return "";
    }

    @Override
    public ItemStackCollection deserialize(@NotNull String s) {
        return null;
    }
}
