package me.tauntaunchewie;

import me.tauntaunchewie.utils.AutoNightVisionUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class WelcomeListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // Give player NightVision if plugin is enabled
        if (AutoNightVisionUtils.isEnabled()) {
            AutoNightVisionUtils.setNightVisionToPlayer(player, true);
        }
    }
}
