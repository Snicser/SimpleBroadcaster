package nl.snicser.simplebroadcaster;

import lombok.Getter;

import nl.snicser.simplebroadcaster.command.CommandManager;
import nl.snicser.simplebroadcaster.util.C;
import nl.snicser.simplebroadcaster.util.Constants;

import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleBroadcaster extends JavaPlugin {

    @Getter private static SimpleBroadcaster instance;

    private CommandManager commandManager;

    @Override
        public void onEnable() {
        instance = this;

        loadConfig();
        init();

        commandManager.registerAll();

        getServer().getConsoleSender().sendMessage(Constants.CONSOLE_PREFIX + C.TAC("&aSimpleBroadcaster enabled!"));
        getServer().getConsoleSender().sendMessage(Constants.CONSOLE_PREFIX + C.TAC("&aVersion: &c" + getDescription().getVersion()));
        getServer().getConsoleSender().sendMessage(Constants.CONSOLE_PREFIX + C.TAC("&aCreated by: &cSnicser"));
    }

    @Override
    public void onDisable() {
        instance = null;

        getServer().getConsoleSender().sendMessage(Constants.CONSOLE_PREFIX + C.TAC("&cSimpleBroadcaster disabled!"));
        getServer().getConsoleSender().sendMessage(Constants.CONSOLE_PREFIX + C.TAC("&cVersion: &a" + getDescription().getVersion()));
        getServer().getConsoleSender().sendMessage(Constants.CONSOLE_PREFIX + C.TAC("&cCreated by: &aSnicser"));
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

    private void init() {
        commandManager = new CommandManager(this);
    }
}
