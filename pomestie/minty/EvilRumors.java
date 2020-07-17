// 
// Decompiled by Procyon v0.5.36
// 

package pomestie.minty;

import java.util.List;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class EvilRumors extends JavaPlugin
{
    protected FileConfiguration config;
    private Spy watchdog;
    
    public EvilRumors() {
        this.watchdog = new Spy();
    }
    
    public void onEnable() {
        this.getLogger().info("Evil Rumors was launched");
        this.getLogger().info("Installing default config, if config not exists");
        this.saveDefaultConfig();
        this.getLogger().info("Trying to get configuration");
        this.config = this.getConfig();
        this.getLogger().info("Saving messages to memory");
        ConfigKeeper.messages = (List<String>)this.config.getStringList("messages");
        this.getLogger().info("Registering Event Spy");
        this.getServer().getPluginManager().registerEvents((Listener)this.watchdog, (Plugin)this);
        this.getLogger().info("Event Spy was successfully registered");
    }
    
    public void onDisable() {
        this.getLogger().warning("Evil Rumors was disabled");
    }
}
