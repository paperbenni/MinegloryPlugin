package com.paperbenni.setup;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.paperbenni.setup.commands.Equip;
import com.paperbenni.setup.commands.Gold;
import com.paperbenni.setup.commands.Hello;
import com.paperbenni.setup.commands.MinionCommands;
import com.paperbenni.setup.commands.TeamCommands;
import com.paperbenni.setup.event.block.BlockBreak;
import com.paperbenni.setup.event.block.BlockPlace;
import com.paperbenni.setup.event.entity.EnitityDeath;
import com.paperbenni.setup.event.entity.EntityDamage;
import com.paperbenni.setup.event.inventory.InventoryClick;
import com.paperbenni.setup.event.player.Flytoggle;
import com.paperbenni.setup.event.player.PlayerGamemode;
import com.paperbenni.setup.event.player.PlayerHitEvent;
import com.paperbenni.setup.event.player.PlayerInteract;
import com.paperbenni.setup.event.player.PlayerJoin;
import com.paperbenni.setup.event.player.PlayerMove;
import com.paperbenni.setup.event.projectile.ProjectileHit;
import com.paperbenni.setup.moba.MobaMinion;
import com.paperbenni.setup.moba.MobaPlayer;
import com.paperbenni.setup.moba.MobaTeam.Blue;
import com.paperbenni.setup.moba.MobaTeam.Orange;

public class Setup extends JavaPlugin {
	@Override
	public void onEnable() {
		registerCommands();
		registerEvents();
		registerConfig();
		runnable();
	}

	@Override
	public void onDisable() {

	}

	private void registerCommands() {
		getCommand("hello").setExecutor(new Hello(this));
		getCommand("equip").setExecutor(new Equip());
		getCommand("mobateam").setExecutor(new TeamCommands());
		getCommand("gold").setExecutor(new Gold());
		getCommand("minion").setExecutor(new MinionCommands());
	}

	private void registerEvents() {
		PluginManager pm = getServer().getPluginManager();

		pm.registerEvents(new BlockBreak(), this);
		pm.registerEvents(new Flytoggle(), this);
		pm.registerEvents(new PlayerJoin(this), this);
		pm.registerEvents(new PlayerInteract(), this);
		pm.registerEvents(new PlayerGamemode(), this);
		pm.registerEvents(new PlayerMove(), this);
		pm.registerEvents(new InventoryClick(), this);
		pm.registerEvents(new ProjectileHit(), this);
		pm.registerEvents(new BlockPlace(), this);
		pm.registerEvents(new PlayerHitEvent(), this);
		pm.registerEvents(new EntityDamage(), this);
		pm.registerEvents(new EnitityDeath(), this);

	}

	private void registerConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	private void runnable() {
		new BukkitRunnable() {

			@Override
			public void run() {
				MobaMinion.moveTick();
			}

		}.runTaskTimerAsynchronously(this, 0, 4);

		new BukkitRunnable() {

			@Override
			public void run() {
				MobaMinion.checkHealth();
				MobaPlayer.updateScoreboard();
				Blue.addMinionPoints(1);
				Orange.addMinionPoints(1);
			}
		}.runTaskTimerAsynchronously(this, 0, 20);
	}

}
