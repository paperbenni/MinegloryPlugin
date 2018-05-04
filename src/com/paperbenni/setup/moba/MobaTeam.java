package com.paperbenni.setup.moba;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class MobaTeam {

	public static class Orange {

		private static ArrayList<Player> list= new ArrayList<Player>();
		private static int minionpoints = 100;
		
		public static ArrayList<Player> getPlayers() {
			return list;
		}
		
		public static void addPlayer(Player player) {
			list.add(player);
		}
		
		public static void removePlayer(Player player) {
			list.remove(player);
		}
		
		public static ChatColor getColor() {
			return ChatColor.RED;
		}
		
		public static void addMinionPoints(Integer points) {
			minionpoints+=points;
		}
		public static Integer getMinionPoints() {
			return minionpoints;
		}
		
		public static Boolean hasPlayer(Player player) {
			if(list.contains(player)) {
				return true;
			} else {
				return false;
			}
		}

	}
	
	public static class Blue {

		private static ArrayList<Player> list= new ArrayList<Player>();
		private static int minionpoints = 100;

		
		public static ArrayList<Player> getPlayers() {
			return list;
		}
		
		public static void addPlayer(Player player) {
			list.add(player);
		}
		
		public static void removePlayer(Player player) {
			list.remove(player);
		}
		
		public static ChatColor getColor() {
			return ChatColor.BLUE;
		}
		
		
		public static void addMinionPoints(Integer points) {
			minionpoints+=points;
		}
		public static Integer getMinionPoints() {
			return minionpoints;
		}
		public static Boolean hasPlayer(Player player) {
			if(list.contains(player)) {
				return true;
			} else {
				return false;
			}
		}


	}
	
	public static Boolean getTeam(Player player) {
		if(Orange.list.contains(player)) {
			return MobaPlayer.ORANGE;
		} else {
			return MobaPlayer.BLUE;
		}
	}
}
