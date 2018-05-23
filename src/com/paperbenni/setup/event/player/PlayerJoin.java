package com.paperbenni.setup.event.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.paperbenni.setup.Setup;
import com.paperbenni.setup.moba.MobaPlayer;
import com.paperbenni.setup.positions.MobaPosition;

import net.md_5.bungee.api.ChatColor;

public class PlayerJoin implements Listener {
	
	private Setup plugin;
	
	public PlayerJoin(Setup pl) {
		plugin = pl;
	}
    
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		 String welcomeMessage = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Welcome Message"));
		 Player player = event.getPlayer();
		 player.sendMessage(welcomeMessage);
		 player.teleport(MobaPosition.SpawnBall);
		 MobaPlayer.setGold(player, 1000);
		 
		 Bukkit.getServer().broadcastMessage(ChatColor.GREEN + player.getName() + "has joined the game!");
		 ScoreboardManager manager = Bukkit.getScoreboardManager();
		 Scoreboard score = manager.getNewScoreboard();
		 
		 Objective o = score.registerNewObjective("Mineglory", "");
		 o.setDisplaySlot(DisplaySlot.SIDEBAR);
		 o.setDisplayName(ChatColor.AQUA + "Mineglory");
		 player.setScoreboard(score);
	}
}
