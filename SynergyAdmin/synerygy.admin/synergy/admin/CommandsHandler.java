package synergy.admin;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandsHandler implements CommandExecutor
{
		 
		private SynergyAdmin plugin;
	 
		public CommandsHandler(SynergyAdmin plugin) {
			this.plugin = plugin;
		}
	 
		@Override
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
		{
			if(label.equalsIgnoreCase("warn"))
			{
				if(args.length >= 2)
				{
					Player warn = Bukkit.getPlayer(args[0]);
					Player from = (Player)sender;
					if(from.hasPermission("warn"))
					{
						if(warn != null)
						{
							warn.sendMessage("You have been warned by " + from.getDisplayName() + " for " + args[1]);
							from.sendMessage("You have warned " + warn.getDisplayName() + " for " + args[1]);
							
							plugin.getLogger().log(Level.INFO, from.getDisplayName() + " has warned " + warn.getDisplayName() + " for " + args[1]);
						} else {
							from.sendMessage("That user could not be found online!");
						}
					} else {
						from.sendMessage("You do not have that permission!");
					}
					
					
				return true;
				}
			}
			
			return false;
		}
}
