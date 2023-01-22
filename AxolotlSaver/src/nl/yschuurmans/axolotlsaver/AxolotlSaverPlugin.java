package nl.yschuurmans.axolotlsaver;

import nl.yschuurmans.axolotlsaver.EventListeners.AxolotlDamageHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class AxolotlSaverPlugin extends JavaPlugin {

    public static AxolotlSaverPlugin Instance;

    @Override
    public void onEnable() {
        Instance = this;

        var config = this.getConfig();
        config.addDefault("version", "0.1");
        saveDefaultConfig();
        
        this.getServer().getPluginManager().registerEvents(new AxolotlDamageHandler(), this);

    }

    @Override
    public void onDisable() {
    }
}
