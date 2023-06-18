package me.tauntaunchewie.autonightvisionplugin;

import me.tauntaunchewie.autonightvisionplugin.utils.AutoNightVisionUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoNightVisionCommander implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Make sure a player is calling this
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Check if player has permission
            if (player.hasPermission("nightvision.set")) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("on")) {
                        AutoNightVisionUtils.setPlugin(true);
                        player.sendMessage("Night Vision plugin enabled.");
                    }
                    else if (args[0].equalsIgnoreCase("off")) {
                        AutoNightVisionUtils.setPlugin(false);
                        player.sendMessage("Night Vision plugin disabled.");
                    }
                    else if (args[0].equalsIgnoreCase("status")) {
                        player.sendMessage("Night Vision plugin is currently: " + (AutoNightVisionUtils.isEnabled() ? "ON" : "OFF"));
                    }
                    else {
                        player.sendMessage("Invalid argument.  Only on/off/status or [PLAYERNAME/@a] [on/off] allowed");
                        player.sendMessage("Example: /nightvision on");
                        player.sendMessage("Example: /nightvision @a off");
                    }
                }
                else if (args.length == 2) {

                    // Check if plugin is enabled before we allow setting for user
                    if (AutoNightVisionUtils.isEnabled()) {
                        // Make sure the 2nd param is on or off
                        if (args[1].equalsIgnoreCase("on") || args[1].equalsIgnoreCase("off")) {
                            boolean turnOnNightVision = (args[1].equalsIgnoreCase("on") ? true : false);

                            // Specially handle apply/remove from all
                            if (args[0].equals("@a")) {

                                // Loop all players on the server and set hearts
                                for (final Player target : Bukkit.getOnlinePlayers()) {
                                    AutoNightVisionUtils.setNightVisionToPlayer(target, turnOnNightVision);

                                    player.sendMessage(target.getDisplayName() + " Night Vision has been " + (turnOnNightVision ? "enabled" : "removed"));
                                    target.sendMessage(ChatColor.YELLOW + player.getDisplayName() + " has " + (turnOnNightVision ? "given you" : "removed your") + " Night Vision");
                                }
                            } else {
                                // Set for individual
                                Player target = Bukkit.getPlayerExact(args[0]);

                                // Make sure we have a valid player
                                if (target != null) {
                                    AutoNightVisionUtils.setNightVisionToPlayer(target, turnOnNightVision);

                                    player.sendMessage(target.getDisplayName() + " Night Vision has been " + (turnOnNightVision ? "enabled" : "removed"));
                                    target.sendMessage(ChatColor.YELLOW + player.getDisplayName() + " has " + (turnOnNightVision ? "given you" : "removed your") + " Night Vision");
                                } else {
                                    player.sendMessage("This player is not currently on the server");
                                }
                            }
                        }
                        else {
                            player.sendMessage("Usage: /nightvision [PLAYERNAME/@a] [on/off]");
                        }
                    }
                    else {
                        player.sendMessage("Night Vision plugin is not currently enabled. Please enable it with:");
                        player.sendMessage("/nightvision on");
                    }
                }
                else {
                    player.sendMessage("Usage: /nightvision [on/off/status]");
                    player.sendMessage("Usage: /nightvision [PLAYERNAME/@a] [on/off]");
                }
            }
            else {
                player.sendMessage("You do not have permission to execute this command.");
            }

            return true;
        }
        else {
            // Only allow players to invoke
            return false;
        }
    }
}
