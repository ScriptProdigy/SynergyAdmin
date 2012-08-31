package synergy.admin;

import org.bukkit.plugin.java.JavaPlugin;

public class SynergyAdmin extends JavaPlugin
{
	public EventsHandler evtHandler;
	public CommandsHandler cmdHandler;
	public MySqlHandler mysql;
	
	 @Override
	 public void onEnable()
	 {
		 getLogger().info("SynergyAdmin Enabled!");
		 
		 String sql_server = (String) getConfig().get("mysql.server");
		 int sql_port = Integer.valueOf((String) getConfig().get("mysql.port"));
		 String sql_user = (String) getConfig().get("mysql.user");
		 String sql_pass = (String) getConfig().get("mysql.pass");

		 getLogger().info("Using SQL server " + sql_server + ":" + String.valueOf(sql_port) + " with User " + sql_user + " and hidden password.");
		 mysql = new MySqlHandler(sql_server, sql_port, sql_user, sql_pass);
		 
	     getServer().getPluginManager().registerEvents(new EventsHandler(this), this);
	     getCommand("warn").setExecutor(new CommandsHandler(this));
	     getCommand("record").setExecutor(new CommandsHandler(this));
	 }
	 
	 @Override
	 public void onDisable()
	 {
		 getLogger().info("SynergyAdmin Disabled!");
	 }
} 
