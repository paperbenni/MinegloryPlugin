package com.paperbenni.setup.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class Minion {

	private Integer level;
	private Entity entity;
	private Boolean team;
	private Location location;

	public void setLevel(Integer thislevel) {
		this.level = thislevel;
	}
	public Integer getLevel() {
		return this.level;
	}
	
	public void setTeam(Boolean tm) {
		this.team = tm;
	}
	public Boolean getTeam() {
		return this.team;
	}
	
	public Entity getEntity() {
		return this.entity;
	}
	public void setEntity(Entity e) {
		this.entity = e;
	}
	public void setLocation(Location l) {
		this.location = l;
	}
	public Location getLocation() {
		return this.location;
	}
	public void move() {
		this.entity.teleport(this.location);
	}
	
}
