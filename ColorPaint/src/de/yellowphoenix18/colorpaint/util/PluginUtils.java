package de.yellowphoenix18.colorpaint.util;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

import de.yellowphoenix18.colorpaint.ColorPaint;
import de.yellowphoenix18.colorpaint.autoupdate.UpdateChecker;
import de.yellowphoenix18.colorpaint.commands.ColorPaintCommand;
import de.yellowphoenix18.colorpaint.config.MainConfig;
import de.yellowphoenix18.colorpaint.config.MessagesConfig;
import de.yellowphoenix18.colorpaint.listener.DamageListener;
import de.yellowphoenix18.colorpaint.listener.DefaultListener;
import de.yellowphoenix18.colorpaint.listener.InteractListener;
import de.yellowphoenix18.colorpaint.listener.JoinListener;
import de.yellowphoenix18.colorpaint.listener.KillListener;
import de.yellowphoenix18.colorpaint.listener.PaintListener;
import de.yellowphoenix18.colorpaint.listener.QuitListener;
import de.yellowphoenix18.colorpaint.scoreboard.ScoreboardClass;

public class PluginUtils {
	
	public static void setUp() {
		loadListener();
		loadCommands();
		
		sendPackets();
		updateScoreboard();		
		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		console.sendMessage("§cThank you for using the Plugin ColorPaint!");
		console.sendMessage(UpdateChecker.checkVersion());
		if(UpdateChecker.needUpdate()) {
			if(MainConfig.autoupdate == true) {
				UpdateChecker.updateJar();
			}
		}
		
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			if(all.isOp()) {
				all.sendMessage(MessagesConfig.name + UpdateChecker.checkVersion());
			}
		}
	}
	
	public static void loadListener() {		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new DefaultListener(), ColorPaint.m);
		pm.registerEvents(new InteractListener(), ColorPaint.m);
		pm.registerEvents(new KillListener(), ColorPaint.m);
		pm.registerEvents(new PaintListener(), ColorPaint.m);
		pm.registerEvents(new QuitListener(), ColorPaint.m);
		pm.registerEvents(new JoinListener(), ColorPaint.m);
		pm.registerEvents(new DamageListener(), ColorPaint.m);
	}
	
	public static void loadCommands() {
		ColorPaint.m.getCommand("pb").setExecutor(new ColorPaintCommand());
		ColorPaint.m.getCommand("paintball").setExecutor(new ColorPaintCommand());
	}
	
	public static void updateScoreboard() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(ColorPaint.m, new Runnable() {
			@Override
			public void run() {
				ScoreboardClass.getBests();
				for(Player all : ColorPaint.painters) {
					ScoreboardClass.updateScoreboard(all);
				}
			}		
		}, 10, 10);
	}
	
	public static void sendPackets() {	
		Bukkit.getScheduler().scheduleSyncRepeatingTask(ColorPaint.m, new Runnable() {
			@SuppressWarnings("unused")
			@Override
			public void run() {
				Random rnd = new Random();
				int m = rnd.nextInt(5)+1;
				int i = rnd.nextInt(100)+1;
				
				
				
				for(Player all : ColorPaint.painters) {
					if(i >= 99) {
						if(all.getInventory().getItem(2) != null) {
							if(all.getInventory().getItem(2).getAmount() + m <= 16) {
								int a = all.getInventory().getItem(2).getAmount();
								all.getInventory().addItem(Utils.ItemStackCreator(MessagesConfig.iuat, MessagesConfig.iuast1, MessagesConfig.iuast2, Material.REDSTONE_BLOCK, m));
							} else {
								all.getInventory().setItem(2,Utils.ItemStackCreator(MessagesConfig.iuat, MessagesConfig.iuast1, MessagesConfig.iuast2, Material.REDSTONE_BLOCK, 16));
							}
						} else {
							all.getInventory().setItem(2,Utils.ItemStackCreator(MessagesConfig.iuat, MessagesConfig.iuast1, MessagesConfig.iuast2, Material.REDSTONE_BLOCK, m));
						}
					} else if(i >= 90) {
						if(all.getInventory().getItem(4) != null) {
							if(all.getInventory().getItem(4).getAmount() + m <= 16) {
								int a = all.getInventory().getItem(4).getAmount();
								all.getInventory().addItem(Utils.ItemStackCreator(MessagesConfig.ilat, MessagesConfig.ilast1, MessagesConfig.ilast2, Material.STONE_PLATE, m));
							} else {
								all.getInventory().setItem(4,Utils.ItemStackCreator(MessagesConfig.ilat, MessagesConfig.ilast1, MessagesConfig.ilast2, Material.STONE_PLATE, 16));
							}
						} else {
							all.getInventory().setItem(4,Utils.ItemStackCreator(MessagesConfig.ilat, MessagesConfig.ilast1, MessagesConfig.ilast2, Material.STONE_PLATE, m));
						}
					} else if(i >= 75) {
						if(all.getInventory().getItem(7) != null) {
							if(all.getInventory().getItem(7).getAmount() + m <= 16) {
								int a = all.getInventory().getItem(7).getAmount();
								all.getInventory().addItem(Utils.ItemStackCreator(MessagesConfig.isat, MessagesConfig.isast1, MessagesConfig.isast2, Material.SNOW_BALL, m));
							} else {
								all.getInventory().setItem(7,Utils.ItemStackCreator(MessagesConfig.isat, MessagesConfig.isast1, MessagesConfig.isast2, Material.SNOW_BALL, 16));
							}
						} else {
							all.getInventory().setItem(7,Utils.ItemStackCreator(MessagesConfig.isat, MessagesConfig.isast1, MessagesConfig.isast2, Material.SNOW_BALL, m));
						}
					} else if(i >= 63) {
						if(all.getInventory().getItem(3) != null) {
							if(all.getInventory().getItem(3).getAmount() + m <= 16) {
								int a = all.getInventory().getItem(3).getAmount();
								all.getInventory().addItem(Utils.ItemStackCreator(MessagesConfig.iat, MessagesConfig.iast1, MessagesConfig.iast2, Material.REDSTONE_COMPARATOR, m));
							} else {
								all.getInventory().setItem(3, Utils.ItemStackCreator(MessagesConfig.iat, MessagesConfig.iast1, MessagesConfig.iast2, Material.REDSTONE_COMPARATOR, 16));
							}
						} else {
							all.getInventory().setItem(3, Utils.ItemStackCreator(MessagesConfig.iat, MessagesConfig.iast1, MessagesConfig.iast2, Material.REDSTONE_COMPARATOR, m));
						}	
					} else {
						if(all.getInventory().getItem(8) != null) {
							if(all.getInventory().getItem(8).getAmount() + m <= 16) {
								int a = all.getInventory().getItem(8).getAmount();
								all.getInventory().addItem(Utils.ItemStackCreator(MessagesConfig.ieat, MessagesConfig.ieast1, MessagesConfig.ieast2, Material.EGG, m));
							} else {
								all.getInventory().setItem(8,Utils.ItemStackCreator(MessagesConfig.ieat, MessagesConfig.ieast1, MessagesConfig.ieast2, Material.EGG, 16));
							}
						} else {
							all.getInventory().setItem(8,Utils.ItemStackCreator(MessagesConfig.ieat, MessagesConfig.ieast1, MessagesConfig.ieast2, Material.EGG, m));
						}
					}
				}				
			}			
		}, 50, MainConfig.seconds*20);	
	}

}
