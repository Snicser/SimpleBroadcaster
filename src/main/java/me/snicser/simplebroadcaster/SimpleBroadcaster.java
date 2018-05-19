package me.snicser.simplebroadcaster;

import lombok.Getter;
import lombok.Setter;
import me.snicser.simplebroadcaster.command.Broadcast;
import me.snicser.simplebroadcaster.util.Constants;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleBroadcaster extends JavaPlugin {

    public static @Getter @Setter SimpleBroadcaster instance;

    @Override
        public void onEnable() {
        setInstance(this);

        loadConfig();
        registerCommand();

        getServer().getConsoleSender().sendMessage(" ");
        getServer().getConsoleSender().sendMessage(Constants.CONSOLE_PREFIX + ChatColor.GREEN + "SimpleBroadcaster enabled!");
        getServer().getConsoleSender().sendMessage(Constants.CONSOLE_PREFIX + ChatColor.GREEN + "Version: " + ChatColor.RED + getDescription().getVersion());
        getServer().getConsoleSender().sendMessage(Constants.CONSOLE_PREFIX + ChatColor.GREEN + "Created by: " + ChatColor.RED + "Snicser");
        getServer().getConsoleSender().sendMessage(" ");

    }

    @Override
    public void onDisable() {
        instance = null;

        getServer().getConsoleSender().sendMessage(" ");
        getServer().getConsoleSender().sendMessage(Constants.CONSOLE_PREFIX + ChatColor.RED + "SimpleBroadcaster disabled!");
        getServer().getConsoleSender().sendMessage(Constants.CONSOLE_PREFIX + ChatColor.RED + "Version: " + ChatColor.GREEN + getDescription().getVersion());
        getServer().getConsoleSender().sendMessage(Constants.CONSOLE_PREFIX + ChatColor.RED + "Created by: " + ChatColor.GREEN + "Snicser");
        getServer().getConsoleSender().sendMessage(" ");
    }

    private final void registerCommand() {
        getCommand("broadcast").setExecutor(new Broadcast(this));
    }

    private final void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
