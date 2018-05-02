package com.paperbenni.setup.commands;


import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.paperbenni.setup.Setup;

import net.md_5.bungee.api.ChatColor;

public class Hello implements CommandExecutor{

	private Setup plugin;
	
	public Hello(Setup pl) {
		plugin = pl;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.GREEN + "you must be a player to use this!");
				return false;
			}
			Player player = (Player) sender;
			Vector vel = new Vector(0, 1, 0);
			player.setVelocity(vel);
			player.sendMessage("Hello " + player.getName() + "!");
			
			List<String> serverAdmins = plugin.getConfig().getStringList("Server Admins");
			player.sendMessage("the admins are");
			for(String admin : serverAdmins) {
				player.sendMessage(admin);
			}
			
			
		return true;
	}
}
