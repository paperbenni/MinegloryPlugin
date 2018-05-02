package com.paperbenni.setup.event.player;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class PlayerMove implements Listener {

	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if (event.getFrom().getBlockY() > event.getTo().getBlockY()) {
			if (event.getTo().getBlock().getRelative(BlockFace.DOWN).getType().isSolid()) {
				player.setAllowFlight(true);
			}
		}
		Block block = player.getLocation().getBlock();
		if(block.getType() == Material.DOUBLE_PLANT) {
			PotionEffect effect = new PotionEffect(PotionEffectType.INVISIBILITY, 20, 1);
			player.addPotionEffect(effect);
		}
		if(player.getLocation().subtract(0, 1, 0).getBlock().getType() == Material.SLIME_BLOCK) {
			player.setVelocity(new Vector(0, 1, 0));
		}
	}

}
