package dev.minedb.components.manager;

import dev.minedb.components.Component;
import dev.minedb.components.impl.minecraft.ItemStackComponent;
import dev.minedb.components.impl.minecraft.LocationComponent;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.function.Supplier;

public class ComponentManager {

    private final Map<Class<?>, Supplier<?>> components = Map.of(
            ItemStack.class, ItemStackComponent::new,
            Location.class, LocationComponent::new
    );

    public <T, C extends Component<T>> C component(Class<T> input) {
        Supplier<?> supplier = components.get(input);
        return supplier != null ? (C) supplier.get() : null;
    }
}
