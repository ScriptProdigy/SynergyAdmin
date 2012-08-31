package synergy.admin;

import org.bukkit.plugin.java.JavaPlugin;

public class SynergyAdmin extends JavaPlugin
{
	public EventsHandler evtHandler;
	public CommandsHandler cmdHandler;
	
	 @Override
	 public void onEnable()
	 {
		 getLogger().info("SynergyAdmin Enabled!");
	     getServer().getPluginManager().registerEvents(new EventsHandler(this), this);
	 }
	 
	 @Override
	 public void onDisable()
	 {
		 getLogger().info("SynergyAdmin Disabled!");
	 }
} 
