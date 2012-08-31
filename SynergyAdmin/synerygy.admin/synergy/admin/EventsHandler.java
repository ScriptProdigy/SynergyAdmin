package synergy.admin;

import java.util.logging.Level;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class EventsHandler implements Listener
{	
	private SynergyAdmin plugin;
	public EventsHandler(SynergyAdmin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent evt)
	{
		// This is where I do all of the logging for the commands and such.
		
		Player player = evt.getPlayer();
		
		String command = evt.getMessage().split(" ")[0];
		
		if(command.equalsIgnoreCase("/ban"))
		{
			if(player.hasPermission("bukkit.command.ban.player"))
			{
				plugin.getLogger().log(Level.INFO, "(evt-ban-perms): " + evt.getMessage());
			}
		} 
		else if(command.equalsIgnoreCase("/kick"))
		{
			if(player.hasPermission("bukkit.command.kick"))
			{
				plugin.getLogger().log(Level.INFO, "(evt-kick-perms): " + evt.getMessage());
			}
		}
		else if(command.equalsIgnoreCase("/warn"))
		{
			if(player.hasPermission("warn"))
			{
				plugin.getLogger().log(Level.INFO, "(evt-kick-perms): " + evt.getMessage());
			}
		}
	}
}
