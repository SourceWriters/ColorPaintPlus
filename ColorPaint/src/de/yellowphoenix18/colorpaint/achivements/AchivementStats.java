package de.yellowphoenix18.colorpaint.achivements;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class AchivementStats {

	public static File f = new File("plugins/ColorPaintPlus", "achivements.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
	
	
	//Total Kills
	public static void addKill(Player p) {
		cfg.set("Stats.Total." + p.getUniqueId().toString() + ".Kills", getKills(p) + 1);
		try {
			cfg.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int getKills(Player p) {
		if(cfg.getInt("Stats.Total." + p.getUniqueId().toString() + ".Kills") == 0) {
			cfg.set("Stats.Total." + p.getUniqueId().toString() + ".Kills", 0);
		}
		return cfg.getInt("Stats.Total" + p.getUniqueId().toString() + ".Kills");
	}	
	//Total Uses
	
	public static void addUse(Player p) {
		cfg.set("Stats.Total." + p.getUniqueId().toString() + ".Uses", getUses(p) + 1);
		try {
			cfg.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int getUses(Player p) {
		if(cfg.getInt("Stats.Total." + p.getUniqueId().toString() + ".Uses") == 0) {
			cfg.set("Stats.Total." + p.getUniqueId().toString() + ".Uses", 0);
		}
		return cfg.getInt("Stats.Total" + p.getUniqueId().toString() + ".Uses");
	}
	//Total Deaths
	
	public static void addDeath(Player p) {
		cfg.set("Stats.Total." + p.getUniqueId().toString() + ".Deaths", getDeaths(p) + 1);
		try {
			cfg.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int getDeaths(Player p) {
		if(cfg.getInt("Stats.Total." + p.getUniqueId().toString() + ".Deaths") == 0) {
			cfg.set("Stats.Total." + p.getUniqueId().toString() + ".Deaths", 0);
		}
		return cfg.getInt("Stats.Total" + p.getUniqueId().toString() + ".Deaths");
	}
	
	//Airstrike Kills
	
	public static void addAirstrikeKill(Player p) {
		cfg.set("Stats.Airstrike." + p.getUniqueId().toString() + ".Kills", getAirstrikeKills(p) + 1);
		try {
			cfg.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int getAirstrikeKills(Player p) {
		if(cfg.getInt("Stats.Airstrike." + p.getUniqueId().toString() + ".Kills") == 0) {
			cfg.set("Stats.Airstrike." + p.getUniqueId().toString() + ".Kills", 0);
		}
		return cfg.getInt("Stats.Airstrike" + p.getUniqueId().toString() + ".Kills");
	}
	//Airstrike Uses
	
	public static void addAirstrikeUses(Player p) {
		cfg.set("Stats.Airstrike." + p.getUniqueId().toString() + ".Uses", getAirstrikeUses(p) + 1);
		try {
			cfg.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int getAirstrikeUses(Player p) {
		if(cfg.getInt("Stats.Airstrike." + p.getUniqueId().toString() + ".Uses") == 0) {
			cfg.set("Stats.Airstrike." + p.getUniqueId().toString() + ".Uses", 0);
		}
		return cfg.getInt("Stats.Airstrike" + p.getUniqueId().toString() + ".Uses");
	}
	
	//UAirstrike Kills
	//UAirstrike Uses
	
	//Landmine Deaths
	//Landmine Kills
	//Landmine Uses
	
	//MachineGun Kills
	//MachineGun Uses
	
	//PaintballGun Kills
	//PaintballGun Uses
	
	

}
