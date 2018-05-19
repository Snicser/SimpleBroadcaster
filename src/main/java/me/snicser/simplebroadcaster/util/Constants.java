package me.snicser.simplebroadcaster.util;

import me.snicser.simplebroadcaster.SimpleBroadcaster;
import org.bukkit.ChatColor;

public class Constants {

    public static final String CONSOLE_PREFIX = ChatColor.WHITE + "[" + ChatColor.AQUA + "SimpleBroadcaster" + ChatColor.WHITE + "] " + ChatColor.RESET;
    public static final String PREFIX = C.TAC(SimpleBroadcaster.getInstance().getConfig().getString("PREFIX"));
}
