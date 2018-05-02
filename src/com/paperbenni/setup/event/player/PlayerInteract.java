package com.paperbenni.setup.event.player;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.paperbenni.setup.moba.MobaPlayer;
import com.paperbenni.setup.mobs.Minion;
import com.paperbenni.setup.mobs.MobaMinion;
import com.paperbenni.setup.positions.MobaPosition;

public class PlayerInteract implements Listener {

	@EventHandler(priority = EventPriority.HIGH)
	public void onInteract(PlayerInteractEvent event) {
		Action action = event.getAction();
		Player player = event.getPlayer();
		if (action == Action.LEFT_CLICK_BLOCK || action == Action.LEFT_CLICK_AIR) {
			if (player.getInventory().getItemInMainHand().getType() == Material.IRON_SWORD) {
				Fireball f = player.launchProjectile(Fireball.class);
				f.setIsIncendiary(false);
			}
		}

		if (action == Action.PHYSICAL && event.getClickedBlock().getType() == Material.WOOD_PLATE) {
			if (event.getClickedBlock().getLocation() == MobaPosition.OrangeSpawn) {
				if (MobaPlayer.getTeam(event.getPlayer()) == null) {
					MobaPlayer.setTeam(player, MobaPlayer.ORANGE);
					player.sendTitle(ChatColor.RED + "Orange", "You joined the orange team!", 10, 50, 10);
				} else if (MobaPlayer.getTeam(player) == MobaPlayer.ORANGE) {
					player.setHealth(player.getHealth() + 5);
				} else if (MobaPlayer.getTeam(player) == MobaPlayer.BLUE) {
					player.setHealth(0);
				}
			}

			if (event.getClickedBlock().getLocation() == MobaPosition.BlueSpawn) {
				if (MobaPlayer.getTeam(player) == null) {
					MobaPlayer.setTeam(player, MobaPlayer.BLUE);
					player.sendTitle(ChatColor.BLUE + "Blue", "You joined the blue team!", 10, 50, 10);
				} else if (MobaPlayer.getTeam(player) == MobaPlayer.BLUE) {
					player.setHealth(player.getHealth() + 5);
				} else if (MobaPlayer.getTeam(player) == MobaPlayer.ORANGE) {
					player.setHealth(0);
				}
			}
		}

		if (action == Action.LEFT_CLICK_BLOCK) {
			if (player.getInventory().getItemInMainHand().getType() == Material.SLIME_BALL) {

				Location l = player.getLocation();
				Entity e =  l.getWorld().spawnEntity(l, EntityType.IRON_GOLEM);

				Minion m = new Minion();
				m.setLevel(1);
				m.setTeam(MobaPlayer.getTeam(player));
				player.sendMessage(ChatColor.BLUE + "Minion Level " + m.getLevel());
				MobaMinion.registerMinion(e, m);

				
				
			}

		}
		return;
	}

}
