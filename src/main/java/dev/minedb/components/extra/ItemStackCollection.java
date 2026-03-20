package dev.minedb.components.extra;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Set;

@Getter
public class ItemStackCollection {

    private List<ItemStack> list;
    private Set<ItemStack> set;
    private ItemStack[] array;

    public ItemStackCollection(List<ItemStack> list) {
        this.list = list;
    }

    public ItemStackCollection(Set<ItemStack> set) {
        this.set = set;
    }

    public ItemStackCollection(ItemStack[] array) {
        this.array = array;
    }
}
