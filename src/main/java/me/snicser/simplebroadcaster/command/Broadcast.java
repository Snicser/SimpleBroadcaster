package me.snicser.simplebroadcaster.command;

import me.snicser.simplebroadcaster.SimpleBroadcaster;
import me.snicser.simplebroadcaster.util.C;
import me.snicser.simplebroadcaster.util.Constants;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast implements CommandExecutor {

    private final SimpleBroadcaster plugin;

    public Broadcast(SimpleBroadcaster plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "The console has no access to this plugin.");
        }
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("broadcast")) {
            if (player.hasPermission(plugin.getConfig().getString("BROADCAST_PERMISSION"))) {
                if (args.length >= 1) {

                    String input = "";
                    for (int i = 0; i < args.length; i++) {
                        input += args[i] + " ";
                    }

                    for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                        onlinePlayers.sendMessage(Constants.PREFIX + ChatColor.WHITE + input);
                        break;
                    }
                } else {
                    player.sendMessage(Constants.PREFIX + ChatColor.WHITE + "Use: " + ChatColor.RED + "/broadcast");
                }
            } else {
                player.sendMessage(Constants.PREFIX + C.TAC(plugin.getConfig().getString("NO_PERMISSION")));
            }
        }
        return false;
    }
}
