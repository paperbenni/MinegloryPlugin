package com.paperbenni.setup.event.player;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.paperbenni.setup.moba.MobaTeam;

public class PlayerHitEvent implements Listener {
	@EventHandler
	public void onHit(EntityDamageByEntityEvent event) {
		Entity en = event.getEntity();
		Entity dmg = event.getDamager();
		if (!(en instanceof Player) || !(dmg instanceof Player)) {
			return;
		}
		Player victim = (Player) en;
		Player damager = (Player) dmg;

		if((MobaTeam.Orange.hasPlayer(victim) && MobaTeam.Orange.hasPlayer(damager)) || (MobaTeam.Blue.hasPlayer(victim) && MobaTeam.Blue.hasPlayer(damager))) {
			event.setCancelled(true);
			dmg.sendMessage("You can't hit your teammate");
		}
	}
}
