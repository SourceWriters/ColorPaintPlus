package de.yellowphoenix18.colorpaint.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class MainConfig {
	
	public static File f = new File("plugins/ColorPaintPlus", "config.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
	
	public static List<Integer> allowed_painter_ids = new ArrayList<Integer>();
	
	public static boolean globalspawn = false;
	public static boolean autoupdate = false;
	public static int seconds = 7;
	
	public static void loadConfig() {		
		if(cfg.getStringList("AllowedBlocks") == null) {
			List<String> blocks = new ArrayList<String>();
			blocks.add("155");
			blocks.add("24");
			blocks.add("17");
			blocks.add("35");
			blocks.add("5");
			blocks.add("7");
			cfg.set("AllowedBlocks", blocks);
		}
		if(cfg.getBoolean("PaintballGlobalSpawn")) {
			cfg.set("PaintballGlobalSpawn", false);
		}
		
		if(cfg.getInt("NewItemsEverySeconds") == 0) {
	 		cfg.set("NewItemsEverySeconds", 7);	
		}
		
		if(cfg.getBoolean("AutoUpdates") == false) {
	 		cfg.set("AutoUpdates", false);	
		}
		
		try {
			cfg.save(f);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		for(String ix : cfg.getStringList("AllowedBlocks")) {
			int x = Integer.parseInt(ix);
			if(x != 159) {
			   allowed_painter_ids.add(x);
			}
		}
		seconds = cfg.getInt("NewItemsEverySeconds");
		autoupdate = cfg.getBoolean("AutoUpdates");
		globalspawn = cfg.getBoolean("PaintballGlobalSpawn");
		
	}

}
