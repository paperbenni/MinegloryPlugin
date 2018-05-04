package com.paperbenni.setup.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Equip implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this");
			return false;
		}
		Player player = (Player) sender;

		Inventory inv = Bukkit.createInventory(null, 9, "Menu");	
		
		ItemStack spawnItem = nameItem(Material.COMPASS, ChatColor.AQUA + "Teleport to spawn");
		
		inv.setItem(4, spawnItem);
		
		player.openInventory(inv);
		
		player.setAllowFlight(true);

		player.sendMessage("You got equipment");
		return true;
	}
	
	private ItemStack nameItem(ItemStack item, String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		return item;
	}
	
	private ItemStack nameItem(Material item, String name) {
		return nameItem(new ItemStack(item), name);
	}

}
