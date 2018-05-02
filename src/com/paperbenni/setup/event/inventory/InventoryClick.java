package com.paperbenni.setup.event.inventory;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {

		Inventory inv = event.getInventory();
		if (!inv.getTitle().equals("Menu")) {
			return;
		}
		if (!(inv == null)) {
			Player player = (Player) event.getWhoClicked();
			ItemStack item = event.getCurrentItem();
			if (item.getType() == Material.COMPASS) {
				player.teleport(new Location(player.getWorld(), player.getLocation().getX(),
						player.getLocation().getY() + 10, player.getLocation().getZ()));
				;
				player.sendMessage("you have been teleported to your base");

				player.getWorld().playEffect(player.getLocation(), Effect.BLAZE_SHOOT, 1);
				player.sendTitle("Hello", "hello", 10, 50, 10);

			}
			event.setCancelled(true);
			player.closeInventory();
		}


	}
}
