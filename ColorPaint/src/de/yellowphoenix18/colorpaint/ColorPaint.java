package de.yellowphoenix18.colorpaint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import de.yellowphoenix18.colorpaint.listener.DefaultListener;
import de.yellowphoenix18.colorpaint.util.PluginUtils;
import de.yellowphoenix18.colorpaint.util.Utils;

public class ColorPaint extends JavaPlugin {
	
	public static int i = 0;
	
	public static List<Player> painters = new ArrayList<Player>();
	public static HashMap<Integer, Integer> painter_ids = new HashMap<Integer, Integer>();
	public static HashMap<Integer, Byte> painter_subids = new HashMap<Integer, Byte>();
	public static HashMap<Integer, Location> painter_loc = new HashMap<Integer, Location>();
	public static HashMap<Player, Integer> colors = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> kills = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> killstreak = new HashMap<Player, Integer>();
	public static HashMap<Player, String> arena = new HashMap<Player, String>();
	
	public static List<Player> cooldown = new ArrayList<Player>();
	public static List<Player> muniregen = new ArrayList<Player>();
	public static List<Player> uairstrike = new ArrayList<Player>();
	
	public static ColorPaint m;
	
	public void onEnable() {
		m = this;
		PluginUtils.setUp();
	}
	
	public void onDisable() {
		for(Location s : DefaultListener.locs_real.keySet()) {
			s.getBlock().setType(Material.AIR);
		}
		for(Player all : painters) {
			all.getInventory().clear();
			painters.remove(all);
			Utils.teleportPlayer(all, "Paintball-Quit");
		}
	}
}
