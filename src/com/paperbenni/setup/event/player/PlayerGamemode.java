package com.paperbenni.setup.event.player;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerGamemode implements Listener {

	@EventHandler
	public void onChange(PlayerGameModeChangeEvent event) {
		Player player = event.getPlayer();
		player.sendMessage("changed gamemode");
		if (event.getNewGameMode().equals(GameMode.SURVIVAL)) {
			player.sendMessage("to survival!");
			PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, 10000, 2, false);
			player.addPotionEffect(effect);
			player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000, 1, false));			
		}
	}
}
