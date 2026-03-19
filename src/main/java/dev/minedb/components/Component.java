package dev.minedb.components;

import org.jetbrains.annotations.NotNull;

public interface Component<T> {

    String serialize(@NotNull T t);
    T deserialize(@NotNull String s);
}
