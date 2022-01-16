package me.tauntaunchewie.utils;

import me.tauntaunchewie.AutoNightVisionPlugin;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AutoNightVisionUtils {
    private static AutoNightVisionPlugin plugin;

    /**
     * Enables or disables the usage of the plugin and saves to config on server
     * @param status true or false
     */
    public static void setPlugin(Boolean status) {
        plugin.getConfig().set("enabled", status);
        plugin.saveConfig();
    }

    /**
     * Return status of plugin enabled/disabled
     * @return
     */
    public static boolean isEnabled() {
        return plugin.getConfig().getBoolean("enabled");
    }

    /**
     * Add ore remove night vision from a specific player
     * @param player player object to add/remove
     * @param onOff true = turn on, false = off
     */
    public static void setNightVisionToPlayer(Player player, Boolean onOff) {
        if (onOff) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 100000, 1));
        }
        else {
            player.removePotionEffect(PotionEffectType.NIGHT_VISION);
        }
    }

    /**
     * Create reference to plugin and retrieve enabled status
     * @param instance
     */
    public static void loadDefaults(AutoNightVisionPlugin instance) {
        plugin = instance;
    }
}