package nl.snicser.simplebroadcaster.util;

import nl.snicser.simplebroadcaster.SimpleBroadcaster;

public final class Constants {

    private Constants() {}

    public static final String CONSOLE_PREFIX = C.TAC("&f[&bSimpleBroadcaster&f] &r");
    public static final String PREFIX = C.TAC(SimpleBroadcaster.getInstance().getConfig().getString("PREFIX"));
}
