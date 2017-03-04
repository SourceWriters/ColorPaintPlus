package de.yellowphoenix18.colorpaint.kits;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.yellowphoenix18.colorpaint.util.Utils;
import de.yellowphoenix18.colorpaint.config.MessagesConfig;

public class KitClass {
	
	public static File f = new File("plugins/ColorPaintPlus", "kits.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
	
	
	public static void saveKit(Player p, String kitname, int airstrikes, int uairstrikes, int landmines, int paintballs, int eggs) {
		if(cfg.getStringList("AllKits") != null) {
			List<String> kits = cfg.getStringList("AllKits");
			if(!kits.contains(kitname)) {
				kits.add(kitname);	
			}
			cfg.set("AllKits", kits);
		} else {
			List<String> kits =new ArrayList<String>();
		    kits.add(kitname);	
			cfg.set("AllKits", kits);
		}
		
		cfg.set("Kits." + kitname + ".Airstrikes", airstrikes);
		cfg.set("Kits." + kitname + ".UAirstrikes", uairstrikes);
		cfg.set("Kits." + kitname + ".Landmines", landmines);
		cfg.set("Kits." + kitname + ".Paintballs", paintballs);
		cfg.set("Kits." + kitname + ".Eggs", eggs);		
		try {
			cfg.save(f);
			p.sendMessage(MessagesConfig.prefix + "§aKit susessfully saved");
		} catch (IOException e) {
			p.sendMessage(MessagesConfig.prefix + "§cError§7: §4Can't save Kit!");
			e.printStackTrace();
		}	
	}
	
	public static String getKit(Player p) {
		if(cfg.getStringList("AllKits") != null) {
			List<String> kits = cfg.getStringList("AllKits");
			for(String kit : kits) {
				if(p.hasPermission("ColorPaint.Kit." + kit)) {
					return kit;
				}
			}
			return null;
		} else {
			return null;
		}
	}
	
	public static void addKit(Player p) {
		if(getKit(p) == null) {
			p.getInventory().addItem(Utils.ItemStackCreatorID(MessagesConfig.igt, MessagesConfig.igst1, MessagesConfig.igst2, 419, 0, 1));
			p.getInventory().addItem(Utils.ItemStackCreatorID(MessagesConfig.imgt, MessagesConfig.imgst1, MessagesConfig.imgst2, 418, 0, 1));
			p.getInventory().setItem(8, Utils.ItemStackCreator(MessagesConfig.ieat, MessagesConfig.ieast1, MessagesConfig.ieast2, Material.EGG, 16));
			p.getInventory().setItem(7, Utils.ItemStackCreator(MessagesConfig.isat, MessagesConfig.isast1, MessagesConfig.isast2, Material.SNOW_BALL, 2));
		} else {
			p.getInventory().addItem(Utils.ItemStackCreatorID(MessagesConfig.igt, MessagesConfig.igst1, MessagesConfig.igst2, 419, 0, 1));
			p.getInventory().addItem(Utils.ItemStackCreatorID(MessagesConfig.imgt, MessagesConfig.imgst1, MessagesConfig.imgst2, 418, 0, 1));
			if(cfg.getInt("Kits." + getKit(p) + ".Airstrikes") > 0) {
				p.getInventory().setItem(3, Utils.ItemStackCreator(MessagesConfig.iat, MessagesConfig.iast1, MessagesConfig.iast2, Material.REDSTONE_COMPARATOR, cfg.getInt("Kits." + getKit(p) + ".Airstrikes")));
			}
			
			if(cfg.getInt("Kits." + getKit(p) + ".UAirstrikes") > 0) {
				p.getInventory().setItem(2, Utils.ItemStackCreator(MessagesConfig.iuat, MessagesConfig.iuast1, MessagesConfig.iuast2, Material.REDSTONE_BLOCK, cfg.getInt("Kits." + getKit(p) + ".UAirstrikes")));
			}
			
			if(cfg.getInt("Kits." + getKit(p) + ".Landmines") > 0) {
				p.getInventory().setItem(4, Utils.ItemStackCreator(MessagesConfig.ilat, MessagesConfig.ilast1, MessagesConfig.ilast2, Material.STONE_PLATE, cfg.getInt("Kits." + getKit(p) + ".Landmines")));
			}
			
			if(cfg.getInt("Kits." + getKit(p) + ".Paintballs") > 0) {
				p.getInventory().setItem(7, Utils.ItemStackCreator(MessagesConfig.isat, MessagesConfig.isast1, MessagesConfig.isast2, Material.SNOW_BALL, cfg.getInt("Kits." + getKit(p) + ".Paintballs")));
			}
			
			if(cfg.getInt("Kits." + getKit(p) + ".Eggs") > 0) {
				p.getInventory().setItem(8, Utils.ItemStackCreator(MessagesConfig.ieat, MessagesConfig.ieast1, MessagesConfig.ieast2, Material.EGG, cfg.getInt("Kits." + getKit(p) + ".Eggs")));
			}
		}
	}
	
	
	
	
	

}
