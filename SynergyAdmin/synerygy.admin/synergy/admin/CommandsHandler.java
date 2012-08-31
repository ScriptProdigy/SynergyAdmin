package synergy.admin;

import java.util.logging.Level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandsHandler implements CommandExecutor
{
		 
		private SynergyAdmin plugin;
	 
		public CommandsHandler(SynergyAdmin plugin) {
			this.plugin = plugin;
		}
	 
		@Override
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
		{
			if(cmd.getName().equalsIgnoreCase("ban"))
			{
				plugin.getLogger().log(Level.INFO, "SYA (cm-ban)");
				
				return true;
			}
			
			if(cmd.getName().equalsIgnoreCase("kick"))
			{
				plugin.getLogger().log(Level.INFO, "SYA (cm-kick)");
				
				return true;
			}
			
			if(cmd.getName().equalsIgnoreCase("warn"))
			{
				plugin.getLogger().log(Level.INFO, "SYA (cm-warn)");
				
				return true;
			}
			
			return false;
		}
}
