package com.paperbenni.setup.mobs;

import java.util.HashMap;

import org.bukkit.entity.Entity;

public class MobaMinion {
		private static HashMap<Entity,Minion> registry = new HashMap<Entity,Minion>();
		public static void registerMinion(Entity minion, Minion values) {
			registry.put(minion, values);
		}
		public static Minion getMinion(Entity key) {
			return registry.get(key);
		}
}
