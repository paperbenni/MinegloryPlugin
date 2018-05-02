package com.paperbenni.setup.event.block;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {

	@EventHandler
	public void onPlaceBlock(BlockPlaceEvent event) {
		if(event.getPlayer().getGameMode() == GameMode.CREATIVE) {
			return;
		}
		if(event.getBlock().getType() != Material.BLUE_GLAZED_TERRACOTTA && event.getBlock().getType() != Material.ORANGE_GLAZED_TERRACOTTA) {
			event.setCancelled(true);	
		}
		
	}
	
}
