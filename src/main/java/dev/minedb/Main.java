package dev.minedb;

import dev.minedb.components.impl.ItemStackComponent;
import dev.minedb.components.manager.ComponentManager;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

@Getter
public class Main {

    @Getter
    private final static ComponentManager componentManager = new ComponentManager();

    public static void main(String[] args) {

    }
}