package com.paperbenni.setup.event.player;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

public class Flytoggle implements Listener {

	@EventHandler
	public void onFlight(PlayerToggleFlightEvent event) {
		Player player = event.getPlayer();
		if(player.getGameMode() == GameMode.CREATIVE) {
			return;
		}
		if (player.getGameMode() == GameMode.SURVIVAL) {
			player.setVelocity(new Vector(0, 0.7, 0));
			player.setAllowFlight(false);
		}
		event.setCancelled(true);
	}
}
