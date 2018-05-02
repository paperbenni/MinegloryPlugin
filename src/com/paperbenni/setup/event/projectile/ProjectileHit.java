package com.paperbenni.setup.event.projectile;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ProjectileHit implements Listener {

	@EventHandler
	public void onProjectileHit(ProjectileHitEvent event) {
		Projectile p = event.getEntity();

		if (p.getType() != EntityType.SNOWBALL) {
			return;
		}

		if (!(p.getShooter() instanceof Player)) {
			return;
		}
		Player player = (Player) p.getShooter();

		if (player.isOp()) {
			Location l = p.getLocation();
			World world = l.getWorld();

			for (int i = 0; i < 10; i++) {
				Creeper c = (Creeper) world.spawnEntity(l, EntityType.CREEPER);
				c.setPowered(true);
			}
		}
	}

}
