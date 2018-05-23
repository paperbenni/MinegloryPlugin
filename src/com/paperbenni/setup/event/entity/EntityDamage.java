package com.paperbenni.setup.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.paperbenni.setup.moba.MobaMinion;
import com.paperbenni.setup.moba.MobaTeam;
import com.paperbenni.setup.mobs.Minion;

public class EntityDamage implements Listener {

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		Entity e = event.getEntity();
		Player player = null;
		Entity damager = event.getDamager();
			if(damager instanceof Player) {
				player = (Player) damager;
			}
		if(MobaMinion.isMinion(e)) {
			Minion m = MobaMinion.getMinion(e);
			if(m.getTeam() == MobaTeam.getTeam(player)) {
				player.sendMessage("You can't hit your minion");
				event.setCancelled(true);
			}
		}
		if(MobaMinion.isMinion(damager)) {
			if(e instanceof Player) {
				Player victim = (Player) e;
				Minion m = MobaMinion.getMinion(damager);
				if(m.getTeam() == MobaTeam.getTeam(victim)) {
					event.setCancelled(true);
				}
			}
		}
	}
}
