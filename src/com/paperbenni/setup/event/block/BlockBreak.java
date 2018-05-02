package com.paperbenni.setup.event.block;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();

		Block block = event.getBlock();
		Material material = block.getType();

		if (player.getGameMode().equals(GameMode.SURVIVAL)) {
			if (material != Material.ORANGE_GLAZED_TERRACOTTA && material != Material.BLUE_GLAZED_TERRACOTTA) {
				event.setCancelled(true);
			}
		}
	}
}
