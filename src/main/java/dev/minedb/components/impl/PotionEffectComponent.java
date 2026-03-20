package dev.minedb.components.impl;

import dev.minedb.components.Component;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class PotionEffectComponent implements Component<PotionEffect> {

    @Override
    public String serialize(@NotNull PotionEffect effect) {
        return effect.getType().getName() + ";" +
                effect.getDuration() + ";" +
                effect.getAmplifier() + ";" +
                effect.isAmbient() + ";" +
                effect.hasParticles() + ";" +
                effect.hasIcon();
    }

    @Override
    public PotionEffect deserialize(@NotNull String s) {
        String[] split = s.split(";");

        if (split.length != 6) {
            throw new IllegalArgumentException("Invalid PotionEffect: " + s);
        }

        PotionEffectType type = PotionEffectType.getByName(split[0]);
        if (type == null) {
            throw new IllegalStateException("Unknown PotionEffectType: " + split[0]);
        }

        int duration = Integer.parseInt(split[1]);
        int amplifier = Integer.parseInt(split[2]);
        boolean ambient = Boolean.parseBoolean(split[3]);
        boolean particles = Boolean.parseBoolean(split[4]);
        boolean icon = Boolean.parseBoolean(split[5]);

        return new PotionEffect(type, duration, amplifier, ambient, particles, icon);
    }
}
