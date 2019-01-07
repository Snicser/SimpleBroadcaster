package nl.snicser.simplebroadcaster.util;

import org.bukkit.ChatColor;

public final class C {

    private C() {}

    public static String TAC(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
}
