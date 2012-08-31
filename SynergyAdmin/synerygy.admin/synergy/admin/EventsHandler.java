package synergy.admin;

import java.util.logging.Level;

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
		String command = evt.getMessage().split(" ")[0];
		plugin.getLogger().log(Level.INFO, "SYA (evt-cmd): " + command);
		
		if(command.equalsIgnoreCase("/ban"))
		{
			plugin.getLogger().log(Level.INFO, "SYA (evt-ban): " + evt.getMessage());
		} 
		else if(command.equalsIgnoreCase("/kick"))
		{
			plugin.getLogger().log(Level.INFO, "SYA (evt-kick): " + evt.getMessage());
		}
		else if(command.equalsIgnoreCase("/warn"))
		{
			plugin.getLogger().log(Level.INFO, "SYA (evt-warn): " + evt.getMessage());
		}
	}
}
