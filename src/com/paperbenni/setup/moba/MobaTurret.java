package com.paperbenni.setup.moba;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class MobaTurret {

	public static Boolean checkHealth(Location l, Boolean team) {

		Boolean alive = false;
		for (int x = 0; x < 13; x++) {
			for (int z = 0; z < 13; z++) {
				Location check = l.add(x, 0, z);
				World world = Bukkit.getWorld("world");
				Block block = world.getBlockAt(check);
				if(team == MobaPlayer.ORANGE && block.getType() == Material.ORANGE_GLAZED_TERRACOTTA) {
					alive = true;
					break;
				}
				if(team == MobaPlayer.BLUE && block.getType() == Material.BLUE_GLAZED_TERRACOTTA) {
					alive = true;
					break;
				}

			}
		}
		return alive;
	}
}
