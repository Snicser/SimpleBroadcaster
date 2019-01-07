package nl.snicser.simplebroadcaster.command;

import nl.snicser.simplebroadcaster.SimpleBroadcaster;

/**
 * Created by: Snicser
 * Date: 7-1-2019
 */
public class CommandManager {

    private final SimpleBroadcaster plugin;

    public CommandManager(SimpleBroadcaster plugin) {
        this.plugin = plugin;
    }

    public void registerAll() {
        plugin.getCommand("broadcast").setExecutor(new BroadcastCommand(plugin));
    }

}
