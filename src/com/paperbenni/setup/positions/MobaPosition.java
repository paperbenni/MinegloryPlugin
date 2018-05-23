package com.paperbenni.setup.positions;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class MobaPosition {
	public static World world = Bukkit.getWorld("world");
	public static Location OrangeSpawn = new Location(world, 218, 45, -114);
	public static Location SpawnBall = new Location(world, 14, 78, -114);
	public static Location BlueSpawn = new Location(world, 106, 43, -115);
	
	public static Integer OrangeMinionX = 176;
	public static Integer BlueMinionX = 174;

}
