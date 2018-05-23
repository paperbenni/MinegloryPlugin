package com.paperbenni.setup.moba;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

import com.paperbenni.setup.mobs.Minion;

import net.md_5.bungee.api.ChatColor;

public class MobaMinion {
	private static HashMap<Entity, Minion> registry = new HashMap<Entity, Minion>();

	public static void registerMinion(Entity minion, Minion values) {
		registry.put(minion, values);
	}

	public static void unregisterMinion(Entity minion) {
		registry.remove(minion);
	}

	public static Minion getMinion(Entity key) {
		return registry.get(key);
	}
	public static Boolean isMinion(Entity e) {
		return registry.containsKey(e);
	}

	public static void checkHealth() {
		for (Minion m : registry.values()) {
			if(registry.isEmpty()) {
				return;
			}
			LivingEntity e = (LivingEntity) m.getEntity();
			e.setCustomName(ChatColor.RED + "Minion: " + e.getHealth());
		}
	}
	public static void moveTick() {
		for(Minion m : registry.values()) {
			Location l  = m.getLocation();
			l.add(new Vector(-0.3, 0, 0));
			l.setYaw(90);
			l.setPitch(0);
			m.setLocation(l);
			m.getEntity().setVelocity(new Vector(0, 0, 0));
			m.move();
			
		}
	}
	
	
}
