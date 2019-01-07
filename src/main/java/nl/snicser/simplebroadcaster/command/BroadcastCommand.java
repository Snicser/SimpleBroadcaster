package nl.snicser.simplebroadcaster.command;

import nl.snicser.simplebroadcaster.SimpleBroadcaster;
import nl.snicser.simplebroadcaster.util.C;
import nl.snicser.simplebroadcaster.util.Constants;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCommand implements CommandExecutor {

    private final SimpleBroadcaster plugin;

    public BroadcastCommand(SimpleBroadcaster plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Constants.CONSOLE_PREFIX + ChatColor.RED + "Only players can use this command.");
            return true;
        }
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("broadcast")) {
            if (player.hasPermission(plugin.getConfig().getString("BROADCAST_PERMISSION")) || player.isOp()) {
                if (args.length >= 1) {

                    StringBuilder input = new StringBuilder();
                    for (String arg : args) input.append(arg).append(" ");

                    Bukkit.getOnlinePlayers().forEach(onlinePlayers -> onlinePlayers.sendMessage(Constants.PREFIX + C.TAC(input.toString())));


                } else {
                    player.sendMessage(Constants.PREFIX + C.TAC("&fUse: &c/broadcast"));
                    return true;
                }
            } else {
                player.sendMessage(Constants.PREFIX + C.TAC(plugin.getConfig().getString("NO_PERMISSIONS")));
                return true;
            }
        }
        return false;
    }
}
