package me.tauntaunchewie;

import me.tauntaunchewie.utils.AutoNightVisionUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RespawnListener implements Listener {
    private static AutoNightVisionPlugin plugin;

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {

        // Give player NightVision if plugin is enabled
        if (AutoNightVisionUtils.isEnabled()) {

            // Wait one in game tick before trying to apply an effect
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    Player player = event.getPlayer();
                    AutoNightVisionUtils.setNightVisionToPlayer(player, true);
                }
            }, 1);
        }
    }

    public RespawnListener(AutoNightVisionPlugin instance) {
        plugin = instance;
    }
}
