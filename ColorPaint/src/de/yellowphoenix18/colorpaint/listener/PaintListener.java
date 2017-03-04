package de.yellowphoenix18.colorpaint.listener;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import de.yellowphoenix18.colorpaint.ColorPaint;
import de.yellowphoenix18.colorpaint.config.MainConfig;

public class PaintListener implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void on(final ProjectileHitEvent e) {
		if(e.getEntity() instanceof Egg) {
			Egg egg = (Egg) e.getEntity();
			Player shooter = (Player) egg.getShooter();
			if(shooter != null) {
				if(ColorPaint.painters.contains(shooter)) {
					final Location loc = e.getEntity().getLocation();
					Location loc1 = new Location(loc.getWorld(), loc.getX() + 1, loc.getY() + 1, loc.getZ() + 1);
					Location loc2 = new Location(loc.getWorld(), loc.getX() - 1, loc.getY() - 1, loc.getZ() - 1);
					final List<Integer> ints = new ArrayList<Integer>();
					for(Location locx : locationsFromTwoPoints(loc1,loc2)) {
						if(locx.getBlock().getType() != Material.AIR) {
							if(MainConfig.allowed_painter_ids.contains(locx.getBlock().getTypeId())) {
								ColorPaint.painter_ids.put(ColorPaint.i, locx.getBlock().getTypeId());
								ColorPaint.painter_subids.put(ColorPaint.i, locx.getBlock().getData());
								ColorPaint.painter_loc.put(ColorPaint.i, locx);
								ints.add(ColorPaint.i);
								ColorPaint.i ++;
								locx.getBlock().setTypeId(159);
								Player p = (Player) egg.getShooter();
								int x = ColorPaint.colors.get(p);
								locx.getBlock().setData((byte)x);
							}
						}
					}
					Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
						@Override
						public void run() {
							for(Integer intx : ints) {
								ColorPaint.painter_loc.get(intx).getBlock().setTypeId(ColorPaint.painter_ids.get(intx));
								ColorPaint.painter_loc.get(intx).getBlock().setData(ColorPaint.painter_subids.get(intx));
							}
						}		
					},20);
				}
			}
		} else if(e.getEntity() instanceof Snowball) {
			Snowball egg = (Snowball) e.getEntity();
			Player shooter = (Player) egg.getShooter();
			if(shooter != null) {
				if(ColorPaint.painters.contains(shooter)) {
					final Location loc = e.getEntity().getLocation();
					Location loc1 = new Location(loc.getWorld(), loc.getX() + 1, loc.getY() + 1, loc.getZ() + 1);
					Location loc2 = new Location(loc.getWorld(), loc.getX() - 1, loc.getY() - 1, loc.getZ() - 1);
					final List<Integer> ints = new ArrayList<Integer>();
					for(Location locx : locationsFromTwoPoints(loc1,loc2)) {
						if(locx.getBlock().getType() != Material.AIR) {
							if(MainConfig.allowed_painter_ids.contains(locx.getBlock().getTypeId())) {
								ColorPaint.painter_ids.put(ColorPaint.i, locx.getBlock().getTypeId());
								ColorPaint.painter_subids.put(ColorPaint.i, locx.getBlock().getData());
								ColorPaint.painter_loc.put(ColorPaint.i, locx);
								ints.add(ColorPaint.i);
								ColorPaint.i ++;
								locx.getBlock().setTypeId(159);
								Player p = (Player) egg.getShooter();
								int x = ColorPaint.colors.get(p);
								locx.getBlock().setData((byte)x);
							}
						}
					}
					Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
						@Override
						public void run() {
							for(Integer intx : ints) {
								ColorPaint.painter_loc.get(intx).getBlock().setTypeId(ColorPaint.painter_ids.get(intx));
								ColorPaint.painter_loc.get(intx).getBlock().setData(ColorPaint.painter_subids.get(intx));
							}
						}		
					},20);	
				}
			}
		}
	}
	
	public static List<Location> locationsFromTwoPoints(Location loc1, Location loc2) {
		List<Location> blocks = new ArrayList<Location>();

		int topBlockX = (loc1.getBlockX() < loc2.getBlockX() ? loc2.getBlockX()
				: loc1.getBlockX());
		int bottomBlockX = (loc1.getBlockX() > loc2.getBlockX() ? loc2
				.getBlockX() : loc1.getBlockX());

		int topBlockY = (loc1.getBlockY() < loc2.getBlockY() ? loc2.getBlockY()
				: loc1.getBlockY());
		int bottomBlockY = (loc1.getBlockY() > loc2.getBlockY() ? loc2
				.getBlockY() : loc1.getBlockY());

		int topBlockZ = (loc1.getBlockZ() < loc2.getBlockZ() ? loc2.getBlockZ()
				: loc1.getBlockZ());
		int bottomBlockZ = (loc1.getBlockZ() > loc2.getBlockZ() ? loc2
				.getBlockZ() : loc1.getBlockZ());

		for (int x = bottomBlockX; x <= topBlockX; x++) {
			for (int z = bottomBlockZ; z <= topBlockZ; z++) {
				for (int y = bottomBlockY; y <= topBlockY; y++) {

					blocks.add(new Location(loc1.getWorld(), x, y, z));
				}
			}
		}

		return blocks;
	}

}
