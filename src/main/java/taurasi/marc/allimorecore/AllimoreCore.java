package taurasi.marc.allimorecore;

import org.bukkit.plugin.java.JavaPlugin;

public final class AllimoreCore extends JavaPlugin {
    public static AllimoreCore INSTANCE;

    @Override
    public void onEnable() {
        // Plugin startup logic
        INSTANCE = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
