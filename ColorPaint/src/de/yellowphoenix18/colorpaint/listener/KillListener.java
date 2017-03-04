package de.yellowphoenix18.colorpaint.listener;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.yellowphoenix18.colorpaint.kits.KitClass;
import de.yellowphoenix18.colorpaint.stats.StatsUtil;
import de.yellowphoenix18.colorpaint.util.Utils;
import de.yellowphoenix18.colorpaint.ColorPaint;
import de.yellowphoenix18.colorpaint.config.MessagesConfig;

public class KillListener implements Listener {
	
	@EventHandler
	public void on(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Player) {
			Player x = (Player) e.getEntity();
			if(ColorPaint.painters.contains(x)) {
				if(e.getDamager() instanceof Egg && e.getEntity() instanceof Player) {
					Player p = (Player) e.getEntity();
					Egg egg = (Egg) e.getDamager();
					Player k = (Player) egg.getShooter();
					if(k != p) {
						if(k != null) {
							StatsUtil.setKills(k, StatsUtil.getKills(k) + 1);
							StatsUtil.setDeaths(p, StatsUtil.getDeaths(p) + 1);

							if(ColorPaint.kills.containsKey(k)) {
								ColorPaint.kills.put(k, ColorPaint.kills.get(k) + 1);
							} else {
								ColorPaint.kills.put(k, 1);
							}
							ColorPaint.killstreak.put(k, ColorPaint.killstreak.get(k) + 1);
							ColorPaint.killstreak.put(p, 0);
							if(ColorPaint.killstreak.get(k) == 5) {
								for(Player all : ColorPaint.painters) {
									all.sendMessage(MessagesConfig.prefix + MessagesConfig.gak.replace("%KillStreak%", "5er").replace("%Player%", k.getName()));
								}
							} else if(ColorPaint.killstreak.get(k) == 10) {
								for(Player all : ColorPaint.painters) {
									all.sendMessage(MessagesConfig.prefix + MessagesConfig.gak.replace("%KillStreak%", "10er").replace("%Player%", k.getName()));
								}
							} else if(ColorPaint.killstreak.get(k) == 15) {
								for(Player all : ColorPaint.painters) {
									all.sendMessage(MessagesConfig.prefix + MessagesConfig.gak.replace("%KillStreak%", "15er").replace("%Player%", k.getName()));
								}
							} else if(ColorPaint.killstreak.get(k) == 20) {
								for(Player all : ColorPaint.painters) {
									all.sendMessage(MessagesConfig.prefix + MessagesConfig.gak.replace("%KillStreak%", "20er").replace("%Player%", k.getName()));
								}
							} else if(ColorPaint.killstreak.get(k) == 25) {
								for(Player all : ColorPaint.painters) {
									all.sendMessage(MessagesConfig.prefix + MessagesConfig.gak.replace("%KillStreak%", "25er").replace("%Player%", k.getName()));
								}
							} else if(ColorPaint.killstreak.get(k) == 50) {
								for(Player all : ColorPaint.painters) {
									all.sendMessage(MessagesConfig.prefix + MessagesConfig.gak.replace("%KillStreak%", "50er").replace("%Player%", k.getName()));
								}
							} else if(ColorPaint.killstreak.get(k) == 75) {
								for(Player all : ColorPaint.painters) {
									all.sendMessage(MessagesConfig.prefix + MessagesConfig.gak.replace("%KillStreak%", "75er").replace("%Player%", k.getName()));
								}
							} else if(ColorPaint.killstreak.get(k) == 100) {
								for(Player all : ColorPaint.painters) {
									all.sendMessage(MessagesConfig.prefix + MessagesConfig.gak.replace("%KillStreak%", "100er").replace("%Player%", k.getName()));
								}
							}
							k.playSound(k.getLocation(), Sound.LEVEL_UP, 1F, 1F);
							k.sendMessage(MessagesConfig.prefix + MessagesConfig.dmk.replace("%Player%", p.getName()));
							if(k.getInventory().getItem(8).getAmount() < 15) {
								k.getInventory().addItem(Utils.ItemStackCreator(MessagesConfig.ieat, MessagesConfig.ieast1, MessagesConfig.ieast2, Material.EGG, 2));
							}
							p.sendMessage(MessagesConfig.prefix + MessagesConfig.dmp.replace("%Killer%", k.getName()));
						}
						p.getInventory().clear();
						KitClass.addKit(p);
						Random rnd = new Random();
						Utils.teleportPlayer(p, "Paintball-Arena." + ColorPaint.arena.get(p) + "." + rnd.nextInt(10));
					} else {
						e.setCancelled(true);
					}
				} else if(e.getDamager() instanceof Snowball && e.getEntity() instanceof Player) {
					Player p = (Player) e.getEntity();
					Snowball egg = (Snowball) e.getDamager();
					Player k = (Player) egg.getShooter();
					if(k != p) {
						if(k != null) {
							StatsUtil.setKills(k, StatsUtil.getKills(k) + 1);
							StatsUtil.setDeaths(p, StatsUtil.getDeaths(p) + 1);
							if(ColorPaint.kills.containsKey(k)) {
								ColorPaint.kills.put(k, ColorPaint.kills.get(k) + 1);
							} else {
								ColorPaint.kills.put(k, 1);
							}
							ColorPaint.killstreak.put(k, ColorPaint.killstreak.get(k) + 1);
							ColorPaint.killstreak.put(p, 0);
							if(ColorPaint.killstreak.get(k) == 5) {
								for(Player all : ColorPaint.painters) {
									all.sendMessage(MessagesConfig.prefix + MessagesConfig.gak.replace("%KillStreak%", "5er").replace("%Player%", k.getName()));
								}
							} else if(ColorPaint.killstreak.get(k) == 10) {
								for(Player all : ColorPaint.painters) {
									all.sendMessage(MessagesConfig.prefix + MessagesConfig.gak.replace("%KillStreak%", "10er").replace("%Player%", k.getName()));
								}
							} else if(ColorPaint.killstreak.get(k) == 15) {
								for(Player all : ColorPaint.painters) {
									all.sendMessage(MessagesConfig.prefix + MessagesConfig.gak.replace("%KillStreak%", "15er").replace("%Player%", k.getName()));
								}
							} else if(ColorPaint.killstreak.get(k) == 20) {
								for(Player all : ColorPaint.painters) {
									all.sendMessage(MessagesConfig.prefix + MessagesConfig.gak.replace("%KillStreak%", "20er").replace("%Player%", k.getName()));
								}
							} else if(ColorPaint.killstreak.get(k) == 25) {
								for(Player all : ColorPaint.painters) {
									all.sendMessage(MessagesConfig.prefix + MessagesConfig.gak.replace("%KillStreak%", "25er").replace("%Player%", k.getName()));
								}
							} else if(ColorPaint.killstreak.get(k) == 50) {
								for(Player all : ColorPaint.painters) {
									all.sendMessage(MessagesConfig.prefix + MessagesConfig.gak.replace("%KillStreak%", "50er").replace("%Player%", k.getName()));
								}
							} else if(ColorPaint.killstreak.get(k) == 75) {
								for(Player all : ColorPaint.painters) {
									all.sendMessage(MessagesConfig.prefix + MessagesConfig.gak.replace("%KillStreak%", "75er").replace("%Player%", k.getName()));
								}
							} else if(ColorPaint.killstreak.get(k) == 100) {
								for(Player all : ColorPaint.painters) {
									all.sendMessage(MessagesConfig.prefix + MessagesConfig.gak.replace("%KillStreak%", "100er").replace("%Player%", k.getName()));
								}
							}
							k.playSound(k.getLocation(), Sound.LEVEL_UP, 1F, 1F);
							k.sendMessage(MessagesConfig.prefix + MessagesConfig.dmk.replace("%Player%", p.getName()));
							if(k.getInventory().getItem(7) != null) {
								if(k.getInventory().getItem(7).getAmount() < 15) {
									k.getInventory().addItem(Utils.ItemStackCreator(MessagesConfig.isat, MessagesConfig.isast1, MessagesConfig.isast2, Material.SNOW_BALL, 2));
								}	
							}
							p.sendMessage(MessagesConfig.prefix + MessagesConfig.dmp.replace("%Killer%", k.getName()));
						}
						p.getInventory().clear();
						KitClass.addKit(p);
						Random rnd = new Random();
						Utils.teleportPlayer(p, "Paintball-Arena." + ColorPaint.arena.get(p) + "." + rnd.nextInt(10));
					} else {
						e.setCancelled(true);
					}
				} else if(e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
					e.setCancelled(true);
				}
			}
		}
	}

}
