package me.snicser.simplebroadcaster.util;

import org.bukkit.ChatColor;

public final class C {

    private C() {}

    public static final String TAC(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
}
