package de.yellowphoenix18.colorpaint.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.Dye;

import de.yellowphoenix18.colorpaint.config.MessagesConfig;

public class Utils {
	
	public static File f = new File("plugins/ColorPaintPlus" , "locations.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
	
	public static void setLocation(Location loc, String path) {
		cfg.set("loc." + path + ".world", loc.getWorld().getName());
		cfg.set("loc." + path + ".x", loc.getX());
		cfg.set("loc." + path + ".y", loc.getY());
		cfg.set("loc." + path + ".z", loc.getZ());
		cfg.set("loc." + path + ".yaw", loc.getYaw());
		cfg.set("loc." + path + ".pitch", loc.getPitch());		
		try {
			cfg.save(f);
		} catch (IOException e) {
			Bukkit.broadcastMessage("§cError");
			e.printStackTrace();
		}
	}
	
	public static void teleportPlayer(Player p, String path) {
		if(cfg.getString("loc." + path + ".world") != null) {
			World w =  Bukkit.getWorld(cfg.getString("loc." + path + ".world"));
			double x = cfg.getDouble("loc." + path + ".x");
			double y = cfg.getDouble("loc." + path + ".y");
			double z = cfg.getDouble("loc." + path + ".z");
			double yaw = cfg.getDouble("loc." + path + ".yaw");
			double pitch = cfg.getDouble("loc." + path + ".pitch");
			Location loc = new Location(w, x, y, z, (float) yaw, (float) pitch);
			p.teleport(loc);
		} else {
			p.sendMessage(MessagesConfig.name + "§4Error§7: §cLocation §4" + path + "§c is not valid!");
		}
	}
	
	public static Location getLocation(String path) {
		World w =  Bukkit.getWorld(cfg.getString("loc." + path + ".world"));
		double x = cfg.getDouble("loc." + path + ".x");
		double y = cfg.getDouble("loc." + path + ".y");
		double z = cfg.getDouble("loc." + path + ".z");
		double yaw = cfg.getDouble("loc." + path + ".yaw");
		double pitch = cfg.getDouble("loc." + path + ".pitch");
		Location loc = new Location(w, x, y, z, (float) yaw, (float) pitch);
		return loc;
	}
	
	public static void setLastLocation(Player p) {
		Location loc = p.getLocation();
		cfg.set("Lastloc." + p.getUniqueId().toString() + ".world", loc.getWorld().getName());
		cfg.set("Lastloc." + p.getUniqueId().toString() + ".x", loc.getX());
		cfg.set("Lastloc." + p.getUniqueId().toString() + ".y", loc.getY());
		cfg.set("Lastloc." + p.getUniqueId().toString() + ".z", loc.getZ());
		cfg.set("Lastloc." + p.getUniqueId().toString() + ".yaw", loc.getYaw());
		cfg.set("Lastloc." + p.getUniqueId().toString() + ".pitch", loc.getPitch());		
		try {
			cfg.save(f);
		} catch (IOException e) {
			Bukkit.broadcastMessage("§cError");
			e.printStackTrace();
		}		
	}
	
	public static void teleportSpawn(Player p) {
			teleportPlayer(p, "Spawn");
	}
	
	public static ItemStack ItemStackCreator(String name, String lore1, String lore2, Material m, int a) {	
		List<String> list = new ArrayList<String>();
		if(lore1 != null) {
			list.add(lore1);
		}
		if(lore2 != null) {
			list.add(lore2);
		}
		ItemStack i = new ItemStack(m);
		ItemMeta imeta = i.getItemMeta();
		imeta.setDisplayName(name);
		if(!(lore1 == null && lore2 == null)) {
		imeta.setLore(list);
		}
		i.setItemMeta(imeta);
		i.setAmount(a);
		return i;
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack SkullCreator(String name, String owner, String lore1, String lore2, int a) {	
		List<String> list = new ArrayList<String>();
		if(lore1 != null) {
			list.add(lore1);
		}
		if(lore2 != null) {
			list.add(lore2);
		}
		
		ItemStack i = new ItemStack(397,1, (short) 3);
		SkullMeta imeta = (SkullMeta)i.getItemMeta();
		imeta.setOwner(owner);
		imeta.setDisplayName(name);
		if(!(lore1 == null && lore2 == null)) {
		imeta.setLore(list);
		}
		i.setItemMeta(imeta);
		i.setAmount(a);
		return i;
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack ItemStackCreatorID(String name, String lore1, String lore2, int typeid, int data, int a) {		
		List<String> list = new ArrayList<String>();
		if(lore1 != null) {
			list.add(lore1);
		}
		if(lore2 != null) {
			list.add(lore2);
		}
		ItemStack i = new ItemStack(typeid, 1, (short) data);
		ItemMeta imeta = i.getItemMeta();
		imeta.setDisplayName(name);
		if(!(lore1 == null && lore2 == null)) {
		imeta.setLore(list);
		}
		i.setItemMeta(imeta);
		i.setAmount(a);
		return i;
	}
	
	public static ItemStack LeatherCreator(String name, String lore1, String lore2, Material m, int a, Color c) {	
		List<String> list = new ArrayList<String>();
		if(lore1 != null) {
			list.add(lore1);
		}
		if(lore2 != null) {
			list.add(lore2);
		}
		ItemStack i = new ItemStack(m);
		LeatherArmorMeta imeta = (LeatherArmorMeta) i.getItemMeta();
		imeta.setDisplayName(name);
		imeta.setColor(c);
		if(!(lore1 == null && lore2 == null)) {
		imeta.setLore(list);
		}
		i.setItemMeta(imeta);
		i.setAmount(a);
		return i;		
	}
	
	public static ItemStack DyeCreator(String name, String lore1, String lore2, int a, DyeColor c) {		
		List<String> list = new ArrayList<String>();
		if(lore1 != null) {
			list.add(lore1);
		}
		if(lore2 != null) {
			list.add(lore2);
		}
		Dye d = new Dye();
		d.setColor(c);
		ItemStack i = d.toItemStack();
		ItemMeta imeta = i.getItemMeta();
		imeta.setDisplayName(name);
		if(!(lore1 == null && lore2 == null)) {
		imeta.setLore(list);
		}
		i.setItemMeta(imeta);
		i.setAmount(a);
		return i;		
	}
}
