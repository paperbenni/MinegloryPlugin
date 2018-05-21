package com.paperbenni.setup.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.paperbenni.setup.moba.MobaPlayer;
import com.paperbenni.setup.moba.MobaTeam;

public class TeamCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {

		if (args.length == 0) {
			sender.sendMessage("get \n set \n list");
			return true;
		}

		if (args[0].equalsIgnoreCase("test")) {
			sender.sendMessage(args[1]);
		}

		if (args[0].equalsIgnoreCase("get")) {
			if (args.length == 1) {
				sender.sendMessage("Please put in a player name!");
				return false;
			}
			
			Player target = Bukkit.getServer().getPlayer(args[1]);
			if(target == null) {
				sender.sendMessage(ChatColor.RED + "Player not found!");
				return false;
			}
			
			target.sendMessage(ChatColor.GRAY + "Someone is reading out your team.");
			if (MobaTeam.Orange.hasPlayer(target)) {
				sender.sendMessage(ChatColor.RED + "Orange Team");
				return true;
			} else if (MobaTeam.Blue.hasPlayer(target)) {
				sender.sendMessage(ChatColor.BLUE + "Blue Team");
				return true;
			} else {
				sender.sendMessage("The player currently is in no team");
			}
			return false;
		}

		if (args[0].equalsIgnoreCase("list")) {
			String team = "Players: \n";
			for (Player p : Bukkit.getServer().getOnlinePlayers()) {
				if (MobaTeam.getTeam(p) == MobaPlayer.ORANGE) {
					team = team + ChatColor.RED + p.getName() + "\n llool";
				}
				sender.sendMessage(team);

			}
		}

		if (args[0].equalsIgnoreCase("set")) {
			if (args.length == 1) {
				sender.sendMessage(ChatColor.RED + "please put in a player to change team");
				return false;
			}

			Player target = Bukkit.getServer().getPlayer(args[1]);
			target.sendMessage("changing your team...");

			if (args[2].equalsIgnoreCase("orange") || args[2].equalsIgnoreCase("0")) {
				if (MobaTeam.Blue.hasPlayer(target)) {
					MobaTeam.Blue.removePlayer(target);
				}
				MobaTeam.Orange.addPlayer(target);
				target.sendMessage(ChatColor.RED + "Your team has been set to orange");
				sender.sendMessage("Team swap successfull!");
				return true;
			} else if (args[2].equalsIgnoreCase("blue") || args[2].equalsIgnoreCase("1")) {
				if (MobaTeam.Orange.hasPlayer(target)) {
					MobaTeam.Orange.removePlayer(target);
				}
				MobaTeam.Blue.addPlayer(target);
				target.sendMessage(ChatColor.BLUE + "Your team has been set to blue");
				sender.sendMessage("Team swap successfull!");
				return true;
			} else {
				sender.sendMessage(ChatColor.BLACK + "Please put in either blue  or orange");
			}

			return true;
		}

		return false;

	}
}
