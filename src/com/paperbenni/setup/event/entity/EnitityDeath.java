package com.paperbenni.setup.event.entity;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import com.paperbenni.setup.moba.MobaMinion;
import com.paperbenni.setup.moba.MobaPlayer;

public class EnitityDeath implements Listener {

	@EventHandler
	public void onDeath(EntityDeathEvent event) {
		Entity e = event.getEntity();
		if (MobaMinion.isMinion(e)) {
			MobaMinion.unregisterMinion(e);
			if (e.getLastDamageCause() instanceof Player) {
				Player player = (Player) e.getLastDamageCause();
				MobaPlayer.addGold(player, 10);
				player.sendMessage(ChatColor.GOLD + "You got 10 gold");//weiter und damagehook etc
			}
		}
	}

}
