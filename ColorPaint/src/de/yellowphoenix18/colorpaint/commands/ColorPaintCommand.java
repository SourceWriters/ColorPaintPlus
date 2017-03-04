package de.yellowphoenix18.colorpaint.commands;

import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;

import de.yellowphoenix18.colorpaint.ColorPaint;
import de.yellowphoenix18.colorpaint.autoupdate.UpdateChecker;
import de.yellowphoenix18.colorpaint.config.MessagesConfig;
import de.yellowphoenix18.colorpaint.kits.KitClass;
import de.yellowphoenix18.colorpaint.stats.StatsUtil;
import de.yellowphoenix18.colorpaint.util.Utils;

public class ColorPaintCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("pb") || cmd.getName().equalsIgnoreCase("paintball")) {
					if(args.length == 0) {
						p.sendMessage(MessagesConfig.prefix + "§cPlease enter /pb help.");
					} else if(args.length == 1) {
						if(args[0].equalsIgnoreCase("help")) {
							if(p.hasPermission("ColorPaint.Help")) {
								p.sendMessage("§c/pb help §7- §6For help");
								p.sendMessage("§c/pb leave §7- §6Leave the Paintball-Arena");
								p.sendMessage("§c/pb ranking §7- §6Shows your Paintball-Stats");
								p.sendMessage("§c/pb stats §7- §6Shows your Paintball-Stats");
								p.sendMessage("§c/pb update §7- §6Updates the Plugin");
								p.sendMessage("§c/pb reload §7- §6Reloads the Plugin");
								p.sendMessage("§c/pb setspawn <Arena> <0-9> §7- §6Set the Spawns of a Arena");
								p.sendMessage("§c/pb setglobalspawn §7- §6Set the Spawn for quitting");
								p.sendMessage("§c/pb setjoinsign <Arena> §7- §6Set the Sign for joinig the Arena");
								p.sendMessage("§c/pb setquitsign <Arena> §7- §6Set the Sign for quitting the Arena");
								p.sendMessage("§c/pb addkit <KitName> <Airstrikes> <UAirstrikes> <Landmines> <Paintballs> <Eggs>");
							} else {
								p.sendMessage(MessagesConfig.prefix + MessagesConfig.nop);
							}
						} else if(args[0].equalsIgnoreCase("leave")) {
							if(ColorPaint.painters.contains(p)) {
								p.getInventory().clear();
								ColorPaint.painters.remove(p);
								Utils.teleportPlayer(p, "Paintball-Quit");
								ColorPaint.colors.remove(p);
								ColorPaint.killstreak.remove(p);
								p.setGameMode(GameMode.SURVIVAL);
								p.sendMessage(MessagesConfig.prefix + MessagesConfig.qm);
								p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
							} else {
								p.sendMessage(MessagesConfig.prefix + MessagesConfig.nip);
							}
						} else if(args[0].equalsIgnoreCase("stats")) {
							StatsUtil.sendStats(p);
						} else if(args[0].equalsIgnoreCase("ranking")) {
							StatsUtil.getTOP5(p);
						} else if(args[0].equalsIgnoreCase("reload")) {
							if(p.hasPermission("ColorPaint.Admin")) {
								Bukkit.getPluginManager().disablePlugin(ColorPaint.m);
								Bukkit.getPluginManager().enablePlugin(ColorPaint.m);
								p.sendMessage(MessagesConfig.prefix + "§aPaintball susessfully reloadet.");
							}
						} else if(args[0].equalsIgnoreCase("update")) {
							if(p.hasPermission("ColorPaint.Admin")) {
								if(UpdateChecker.needUpdate()) {
									UpdateChecker.updateJar(p);
									Bukkit.reload();
								} else {
									p.sendMessage(MessagesConfig.prefix + "§cNo Update available");
								}
							}
						} else if(args[0].equalsIgnoreCase("setglobalspawn")) {
							if(p.hasPermission("ColorPaint.Admin")) {
								Utils.setLocation(p.getLocation(), "Paintball-Quit");
								p.sendMessage(MessagesConfig.prefix + "§cPaintball-GlobalSpawn sussesfully set.");
							} else {
								p.sendMessage(MessagesConfig.prefix + MessagesConfig.nop);
							}
						} else {
							p.sendMessage(MessagesConfig.prefix + MessagesConfig.nea);
						}
					} else if(args.length == 2) {
						if(args[0].equalsIgnoreCase("setjoinsign")) {
							if(p.hasPermission("ColorPaint.Admin")) {
							    Block block = p.getTargetBlock((Set<Material>)null, 10);
							    if (block != null) {
							        if (block.getType() == Material.SIGN || block.getType() == Material.SIGN_POST || block.getType() == Material.WALL_SIGN) {
							            final Sign s = (Sign) block.getState();
							            s.setLine(0, MessagesConfig.jsr1);
							            s.setLine(1, MessagesConfig.jsr2);
							            s.setLine(2, MessagesConfig.jsr3);
							            s.setLine(3, args[1]);
							            s.update();
										p.sendMessage(MessagesConfig.prefix + "§cSussesfully set the JoinSign for Arena §6" + args[1] + " §c.");
							        } else {
							            p.sendMessage(MessagesConfig.prefix + "§cYou have to look at a sign!");
							        }
							     } else {
							        p.sendMessage(MessagesConfig.prefix + "§cYou have to look at a sign!");
							    }				
							} else {
								p.sendMessage(MessagesConfig.prefix + MessagesConfig.nop);
							}
						} else if(args[0].equalsIgnoreCase("setquitsign")) {
							if(p.hasPermission("ColorPaint.Admin")) {
							    Block block = p.getTargetBlock((Set<Material>)null, 10);
							    if (block != null) {
							        if (block.getType() == Material.SIGN || block.getType() == Material.SIGN_POST || block.getType() == Material.WALL_SIGN) {
							            final Sign s = (Sign) block.getState();
							            s.setLine(0, MessagesConfig.qsr1);
							            s.setLine(1, MessagesConfig.qsr2);
							            s.setLine(2, MessagesConfig.qsr3);
							            s.setLine(3, args[1]);
							            s.update();
										p.sendMessage(MessagesConfig.prefix + "§cSussesfully set the QuitSign for Arena §6" + args[1] + " §c.");
							        } else {
							            p.sendMessage(MessagesConfig.prefix + "§cYou have to look at a sign!");
							        }
							     } else {
							        p.sendMessage(MessagesConfig.prefix + "§cYou have to look at a sign!");
							    }				
							} else {
								p.sendMessage(MessagesConfig.prefix + MessagesConfig.nop);
							}
						} else {
							p.sendMessage(MessagesConfig.prefix + MessagesConfig.nea);
						}
					} else if(args.length == 3) {
						if(args[0].equalsIgnoreCase("setspawn")) {
							if(p.hasPermission("ColorPaint.Admin")) {
								int spawn = Integer.valueOf(args[2]);
								Utils.setLocation(p.getLocation(), "Paintball-Arena." + args[1] + "." + spawn);
								p.sendMessage(MessagesConfig.prefix + "§cSussesfully set Spawn §6" + spawn + " §cin Arena §6" + args[1] + " §c.");				
							} else {
								p.sendMessage(MessagesConfig.prefix + MessagesConfig.nop);
							}
						} else {
							p.sendMessage(MessagesConfig.prefix + MessagesConfig.nea);
						}
					} else if(args.length == 7) {
						if(args[0].equalsIgnoreCase("addkit")) {
							if(p.hasPermission("ColorPaint.Admin")) {
								String kitname = args[1];
								int airstrikes = Integer.valueOf(args[2]);
								int uairstrikes = Integer.valueOf(args[3]);
								int landmines = Integer.valueOf(args[4]);
								int paintballs = Integer.valueOf(args[5]);
								int eggs = Integer.valueOf(args[6]);
								if(eggs <= 16) {
									if(paintballs <= 16) {
										if(airstrikes <= 64) {
											if(uairstrikes <= 64) {
												if(landmines <= 16) {
													KitClass.saveKit(p, kitname, airstrikes, uairstrikes, landmines, paintballs, eggs);	
												} else {
													p.sendMessage(MessagesConfig.prefix + "§cThe limit for Landmines is by 16!");
												}
											} else {
												p.sendMessage(MessagesConfig.prefix + "§cThe limit for UAirstrikes is by 64!");
											}
										} else {
											p.sendMessage(MessagesConfig.prefix + "§cThe limit for Aorstrikes is by 64!");
										}
									} else {
										p.sendMessage(MessagesConfig.prefix + "§cThe limit for Paintballs is by 16!");
									}
								} else {
									p.sendMessage(MessagesConfig.prefix + "§cThe limit for Eggs is by 16!");
								}		
							} else {
								p.sendMessage(MessagesConfig.prefix + MessagesConfig.nop);
							}
						} else {
							p.sendMessage(MessagesConfig.prefix + MessagesConfig.nea);
						}
					} else {
						p.sendMessage(MessagesConfig.prefix + MessagesConfig.nea);
					}
			}
		} else {
			System.out.println("[ColorPaintPlus]: You must be instanceof a Player!");
		}
		return true;
	}

}
