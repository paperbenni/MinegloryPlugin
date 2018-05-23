package com.paperbenni.setup.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.paperbenni.setup.moba.MobaTeam.Blue;
import com.paperbenni.setup.moba.MobaTeam.Orange;

import net.md_5.bungee.api.ChatColor;

public class MinionCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {

		if(!(sender instanceof Player)) {
			sender.sendMessage("you need to be a player to do this!");
			return false;
		}
		
		Player player = (Player) sender;
		
		if (args.length == 0) {
			player.sendMessage("no args found");
			return false;
		}

		if (args[0].equalsIgnoreCase("points") || args[0].equalsIgnoreCase("p")) {
			if(args.length == 1) {
				sender.sendMessage("points: get set give");
				return true;
			}
			if (args[1].equalsIgnoreCase("get") || args[1].equalsIgnoreCase("g")) {
				if (args[2].equalsIgnoreCase("orange") || args[2].equalsIgnoreCase("o")) {
					sender.sendMessage(ChatColor.RED + "Minionpoints: " + Orange.getMinionPoints());
				}else if (args[2].equalsIgnoreCase("blue") || args[2].equalsIgnoreCase("b")) {
					sender.sendMessage(ChatColor.BLUE + "Minionpoints: " + Blue.getMinionPoints());
				}else {
					sender.sendMessage("put in a team name");
				}
			}

			if (args[1].equalsIgnoreCase("set") || args[1].equalsIgnoreCase("s")) {
				Integer amount = 0;
				if (args[2].equalsIgnoreCase("orange") || args[2].equalsIgnoreCase("o")) {
					try {
						amount = Integer.parseInt(args[3]);
						Orange.setMinionPoints(amount);
						sender.sendMessage(ChatColor.GREEN + "Orange minion points set to " + amount);
					}catch (NumberFormatException e) {
						sender.sendMessage(ChatColor.GRAY + "Please put in a number");
					}
				}
				
				if (args[2].equalsIgnoreCase("blue") || args[2].equalsIgnoreCase("b")) {
					try {
						amount = Integer.parseInt(args[3]);
						Blue.setMinionPoints(amount);
						sender.sendMessage(ChatColor.GREEN + "Blue minion points set to " + amount);
					}catch (NumberFormatException e) {
						sender.sendMessage(ChatColor.GRAY + "Please put in a number");
					}
				}
			}
		}
		return false;
		

	}
}
