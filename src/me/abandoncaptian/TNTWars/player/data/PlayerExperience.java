package me.abandoncaptian.TNTWars.player.data;

import org.bukkit.entity.Player;

public class PlayerExperience {
    private final int level;
    private final float progress;

    private PlayerExperience(int level, float progress) {
        this.level = level;
        this.progress = progress;
    }

    public static PlayerExperience fromPlayer(Player player) {
        return new PlayerExperience(player.getLevel(), player.getExp());
    }

    public int getLevel() {
        return level;
    }

    public float getProgress() {
        return progress;
    }
}
