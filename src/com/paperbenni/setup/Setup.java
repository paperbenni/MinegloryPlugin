package com.paperbenni.setup;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.paperbenni.setup.commands.Equip;
import com.paperbenni.setup.commands.Hello;
import com.paperbenni.setup.commands.TeamCommands;
import com.paperbenni.setup.event.block.BlockBreak;
import com.paperbenni.setup.event.block.BlockPlace;
import com.paperbenni.setup.event.inventory.InventoryClick;
import com.paperbenni.setup.event.player.Flytoggle;
import com.paperbenni.setup.event.player.PlayerGamemode;
import com.paperbenni.setup.event.player.PlayerInteract;
import com.paperbenni.setup.event.player.PlayerJoin;
import com.paperbenni.setup.event.player.PlayerMove;
import com.paperbenni.setup.event.projectile.ProjectileHit;

public class Setup extends JavaPlugin{
	@Override
	public void onEnable() {
		registerCommands();
		registerEvents();
		registerConfig();
	
	}



	@Override
	public void onDisable() {
		
	}
	
	
	private void registerCommands() {
		getCommand("hello").setExecutor(new Hello(this));
		getCommand("equip").setExecutor(new Equip());
		getCommand("mobateam").setExecutor(new TeamCommands());
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
		
	}
	
	private void registerConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	

}
