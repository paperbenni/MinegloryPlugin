package com.paperbenni.setup.event.player;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.paperbenni.setup.moba.MobaPlayer;
import com.paperbenni.setup.moba.MobaTeam;
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

		if (action == Action.LEFT_CLICK_BLOCK) {

			if (event.getClickedBlock().getType() == Material.WALL_SIGN) {
				BlockState signstate = event.getClickedBlock().getState();
				Sign sign = (Sign) signstate;
				String signLine1 = sign.getLine(0);

				if (signLine1.equalsIgnoreCase("Join Orange")) {
					player.sendMessage(ChatColor.RED + player.getName() + " joined the Orange team!");
					player.sendTitle(ChatColor.RED + "Orange", "You joined the orange team", 10, 100, 10);
					MobaTeam.Orange.addPlayer(player);
					player.setBedSpawnLocation(MobaPosition.OrangeSpawn);
					player.teleport(MobaPosition.OrangeSpawn);
					return;
				}

				if (signLine1.equalsIgnoreCase("Orange Base")) {
					if (MobaTeam.Orange.hasPlayer(player)) {
						PotionEffect heal = new PotionEffect(PotionEffectType.HEAL, 1, 1);
						player.addPotionEffect(heal);
					} else if (MobaTeam.Blue.hasPlayer(player)) {
						player.setHealth(0);
					}
				}

				if (signLine1.equalsIgnoreCase("Join Blue")) {
					player.sendMessage(ChatColor.BLUE + player.getName() + " joined the Blue team!");
					player.sendTitle(ChatColor.BLUE + "Blue", "You joined the blue team", 10, 100, 10);
					MobaTeam.Blue.addPlayer(player);
					player.setBedSpawnLocation(MobaPosition.BlueSpawn);
					player.teleport(MobaPosition.BlueSpawn);
					return;
				}

				if (signLine1.equalsIgnoreCase("Blue Base")) {
					if (MobaTeam.Blue.hasPlayer(player)) {
						PotionEffect heal = new PotionEffect(PotionEffectType.HEAL, 1, 1);
						player.addPotionEffect(heal);
					} else if (MobaTeam.Orange.hasPlayer(player)) {
						player.setHealth(0);
					}
				}

			}

			if (event.getClickedBlock().getType() == Material.IRON_BLOCK) {
				if (player.getInventory().getItemInMainHand().getType() == Material.SLIME_BALL) {

					Location l = player.getLocation();
					l.setYaw(90);
					l.setPitch(0);//weiter
					Entity e = l.getWorld().spawnEntity(l, EntityType.IRON_GOLEM);
					Minion m = new Minion();
					m.setLevel(1);
					m.setTeam(MobaTeam.getTeam(player));
					player.sendMessage(ChatColor.BLUE + "Minion Level " + m.getLevel());
					MobaMinion.registerMinion(e, m);

					if (MobaTeam.getTeam(player) == MobaPlayer.ORANGE) {
						MobaTeam.Orange.addMinionPoints(-1);
						player.sendMessage(ChatColor.RED + "Minion points: " + MobaTeam.Orange.getMinionPoints());//weiter
					}

				}

			}

		}
		return;
	}

}
