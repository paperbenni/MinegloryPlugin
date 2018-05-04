package com.paperbenni.setup.moba;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;

public class MobaPlayer {
	private static HashMap<Player, Integer> gold = new HashMap<Player, Integer>();

	public static ArrayList<Player> orangeplayers = new ArrayList<Player>();
	public static ArrayList<Player> blueplayers = new ArrayList<Player>();
	
	public final static Boolean ORANGE = true;
	public final static Boolean BLUE = false;
	
	
	public static void addGold(Player player, Integer ammount) {
		gold.put(player, (gold.get(player) + ammount));
	}
	
	public static Integer getGold(Player player) {
		return gold.get(player);
	}
	
	
}
