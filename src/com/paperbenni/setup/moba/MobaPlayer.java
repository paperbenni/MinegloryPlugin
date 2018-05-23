package com.paperbenni.setup.moba;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import com.paperbenni.setup.moba.MobaTeam.Blue;

import net.md_5.bungee.api.ChatColor;

public class MobaPlayer {
	private static HashMap<Player, Integer> gold = new HashMap<Player, Integer>();

	public final static Boolean ORANGE = true;
	public final static Boolean BLUE = false;

	public static void addGold(Player player, Integer amount) {
		if (gold.containsKey(player)) {
			gold.put(player, (gold.get(player) + amount));
			return;
		}
		gold.put(player, amount);
	}

	public static void setGold(Player player, Integer amount) {
		gold.put(player, amount);
	}

	public static Integer getGold(Player player) {
		return gold.get(player);
	}

	public static void updateScoreboard() {
		for (Player player : Bukkit.getOnlinePlayers()) {
			Scoreboard s = player.getScoreboard();
			Objective o = s.getObjective("Mineglory");
			Score gold = o.getScore(ChatColor.GOLD + "Gold");
			gold.setScore(MobaPlayer.getGold(player));

			Score minionpoints = o.getScore(ChatColor.GREEN + "MinionPoints");
			if(MobaTeam.Orange.hasPlayer(player)) {
				minionpoints.setScore(MobaTeam.Orange.getMinionPoints());
			} else if(Blue.hasPlayer(player)){
				minionpoints.setScore(MobaTeam.Blue.getMinionPoints());
			} else {
				minionpoints.setScore(0);
			}
			
			player.setScoreboard(s);
		}

	}

}
