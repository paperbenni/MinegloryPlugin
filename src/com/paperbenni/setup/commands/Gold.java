package com.paperbenni.setup.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.paperbenni.setup.moba.MobaPlayer;

public class Gold implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Only players can have gold, sorry");
			return false;
		}
		
		Player send = (Player) sender;
		
		if (!(send.isOp())) {
			send.sendMessage(ChatColor.GRAY + "You don't have permission to do that!");
			return false;
		}
		
		if (args.length == 0) {
			Player player = (Player) sender;
			sender.sendMessage(ChatColor.YELLOW + "Gold: " + MobaPlayer.getGold(player));
			return false;
		}

		if (args[0].equalsIgnoreCase("get")) {
			Player target = Bukkit.getPlayer(args[1]);
			target.sendMessage(ChatColor.GRAY + "Someone is reading out your Gold");
			sender.sendMessage(ChatColor.GREEN + "Gold: " + MobaPlayer.getGold(target));
			return true;
		}

		if (args[0].equalsIgnoreCase("set")) {
			Player target = Bukkit.getPlayer(args[1]);
			Integer amount = 0;

			if (target == null) {

				try {
					amount = Integer.parseInt(args[1]);
					MobaPlayer.setGold(send, amount);
					sender.sendMessage("Set to " + amount + " gold");
					return true;
				} catch (NumberFormatException e) {
					sender.sendMessage("please put in a number");
					return false;
				}

			} else {
				try {
					amount = Integer.parseInt(args[2]);
					MobaPlayer.setGold(target, amount);
					sender.sendMessage(ChatColor.GREEN + "Gold Balance of " + args[1] + " has been set to " + amount);
					target.sendMessage(ChatColor.GOLD + "Your gold balance has been set to " + amount);
				} catch (NumberFormatException e) {
					sender.sendMessage("Please put in a number!");
					return false;
				}

			}
		}

		if (args[0].equalsIgnoreCase("give")) {
			
			Player target = Bukkit.getPlayer(args[1]);
			Integer amount = 0;

			if (target == null) {

				try {
					amount = Integer.parseInt(args[1]);
					MobaPlayer.addGold(send, amount);
					sender.sendMessage("Given " + amount + " gold");
					return true;
				} catch (NumberFormatException e) {
					sender.sendMessage("please put in a number");
					return false;
				}

			} else {

				try {
					amount = Integer.parseInt(args[2]);
				} catch (NumberFormatException e) {
					sender.sendMessage("Please put in a number!");
					return false;
				}
				MobaPlayer.addGold(target, amount);
				sender.sendMessage(ChatColor.GREEN + "Given " + args[2] + " " + amount + " gold");
				target.sendMessage(ChatColor.GOLD + "You have been given " + amount + " gold");
				return true;
			}
		}

		return false;

	}

}
