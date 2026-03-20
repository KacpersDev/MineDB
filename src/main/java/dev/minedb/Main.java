package dev.minedb;

import dev.minedb.components.extra.ItemStackCollection;
import dev.minedb.components.manager.ComponentManager;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Main {

    @Getter
    private final static ComponentManager componentManager = new ComponentManager();

    public static void main(String[] args) {
        ItemStackCollection collection = new ItemStackCollection(new ArrayList<>());
        componentManager.component(ItemStackCollection.class).serialize(collection);
    }
}