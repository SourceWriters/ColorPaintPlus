package de.yellowphoenix18.colorpaint.stats;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import de.yellowphoenix18.colorpaint.config.MessagesConfig;

public class StatsUtil {
	
	public static File f = new File("plugins/ColorPaint", "stats.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
	
	public static void addStringList(Player p) {
		if(cfg.getStringList("RankingPlayers") != null) {
			List<String> ranking = cfg.getStringList("RankingPlayers");
			if(!ranking.contains(p.getUniqueId().toString())) {
				ranking.add(p.getUniqueId().toString());
			}
			cfg.set("UUIDtoName." + p.getUniqueId().toString(), p.getName());
			cfg.set("RankingPlayers", ranking);
			try {
				cfg.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			List<String> ranking = new ArrayList<String>();
		    ranking.add(p.getUniqueId().toString());
		    cfg.set("RankingPlayers", ranking);
		    cfg.set("UUIDtoName." + p.getUniqueId().toString(), p.getName());
			try {
				cfg.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String getName(String uuid) {
		return cfg.getString("UUIDtoName." + uuid);
	}
	
	public static void getTOP5(Player p) {
		String uuid1 = null;
		int kills_1 = -1;
		String uuid2 = null;
		int kills_2 = -1;
		String uuid3 = null;
		int kills_3 = -1;
		String uuid4 = null;
		int kills_4 = -1;
		String uuid5 = null;
		int kills_5 = -1;
		List<String> ranking = cfg.getStringList("RankingPlayers");
		for(String uuid : ranking) {
			if(getKills(uuid) >= kills_1) {
				uuid5 = uuid4;
				uuid4 = uuid3;
				uuid3 = uuid2;
				uuid2 = uuid1;
				uuid1 = uuid;
				kills_5 = kills_4;
				kills_4 = kills_3;
				kills_3 = kills_2;
				kills_2 = kills_1;
				kills_1 = getKills(uuid);					
			} else if(getKills(uuid) >= kills_2) {
				uuid5 = uuid4;
				uuid4 = uuid3;
				uuid3 = uuid2;
				uuid2 = uuid;
				kills_5 = kills_4;
				kills_4 = kills_3;
				kills_3 = kills_2;
				kills_2 = getKills(uuid);				
			} else if(getKills(uuid) >= kills_3) {
				uuid5 = uuid4;
				uuid4 = uuid3;
				uuid3 = uuid;
				kills_5 = kills_4;
				kills_4 = kills_3;
				kills_3 = getKills(uuid);				
			} else if(getKills(uuid) >= kills_4) {
				uuid5 = uuid4;
				uuid4 = uuid;
				kills_5 = kills_4;
				kills_4 = getKills(uuid);			
			} else if(getKills(uuid) >= kills_5) {
				uuid5 = uuid;
				kills_5 = getKills(uuid);			
			}
		}
		if(uuid1 != null) {
			p.sendMessage("§7<>-----<§bRanking§7>-----<>");
			p.sendMessage("§6" + getName(uuid1) + " §7- §b" + getKills(uuid1));
			if(uuid2 != null) {
				p.sendMessage("§6" + getName(uuid2) + " §7- §b" + getKills(uuid2));	
			}
			if(uuid3 != null) {
				p.sendMessage("§6" + getName(uuid3) + " §7- §b" + getKills(uuid3));	
			}
			if(uuid4 != null) {
				p.sendMessage("§6" + getName(uuid4) + " §7- §b" + getKills(uuid4));	
			}
			if(uuid5 != null) {
				p.sendMessage("§6" + getName(uuid5) + " §7- §b" + getKills(uuid5));	
			}
			p.sendMessage("§7<>-----<§bRanking§7>-----<>");
		} else {
			p.sendMessage(MessagesConfig.prefix + "Can not load Ranking");
		}
		
		
	}
	
	public static void sendStats(Player p) {
		p.sendMessage("§7<>-----<§bStats§7>-----<>");
		p.sendMessage("§7Kills: §b" + getKills(p));
		p.sendMessage("§7Deaths: §b" + getDeaths(p));
		p.sendMessage("§7<>-----<§bStats§7>-----<>");
	}
	
	public static void setKills(Player p, int kills) {
		addStringList(p);
		cfg.set("Stats." + p.getUniqueId().toString() + ".Kills", kills);
		try {
			cfg.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setDeaths(Player p, int deaths) {
		cfg.set("Stats." + p.getUniqueId().toString() + ".Deaths", deaths);
		try {
			cfg.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int getDeaths(Player p) {
		if(cfg.getInt("Stats." + p.getUniqueId().toString() + ".Deaths") == 0) {
			cfg.set("Stats." + p.getUniqueId().toString() + ".Deaths", 0);
		}
		return cfg.getInt("Stats." + p.getUniqueId().toString() + ".Deaths");
	}
	
	public static int getKills(Player p) {
		if(cfg.getInt("Stats." + p.getUniqueId().toString() + ".Kills") == 0) {
			cfg.set("Stats." + p.getUniqueId().toString() + ".Kills", 0);
		}
		return cfg.getInt("Stats." + p.getUniqueId().toString() + ".Kills");
	}
	
	public static int getKills(String uuid) {
		if(cfg.getInt("Stats." + uuid + ".Kills") == 0) {
			cfg.set("Stats." + uuid + ".Kills", 0);
		}
		return cfg.getInt("Stats." + uuid + ".Kills");
	}
	
	
	

}
