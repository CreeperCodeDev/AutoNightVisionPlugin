package me.tauntaunchewie;

import me.tauntaunchewie.utils.AutoNightVisionUtils;
import org.bukkit.plugin.java.JavaPlugin;

public class AutoNightVisionPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Populate configs
        AutoNightVisionUtils.loadDefaults(this);

        // Enable plugins
        getServer().getPluginManager().registerEvents(new WelcomeListener(), this);
        getServer().getPluginManager().registerEvents(new RespawnListener(this), this);
        this.getCommand("nightvision").setExecutor(new AutoNightVisionCommander());
    }
}
