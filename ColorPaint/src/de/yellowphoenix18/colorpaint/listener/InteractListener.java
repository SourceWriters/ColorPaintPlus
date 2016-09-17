package de.yellowphoenix18.colorpaint.listener;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Sign;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scoreboard.DisplaySlot;

import de.yellowphoenix18.colorpaint.kits.KitClass;
import de.yellowphoenix18.colorpaint.util.Utils;
import de.yellowphoenix18.colorpaint.ColorPaint;
import de.yellowphoenix18.colorpaint.config.MessagesConfig;

public class InteractListener implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void on(PlayerInteractEvent e) {
		final Player p = e.getPlayer();		
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(ColorPaint.painters.contains(p)) {
				if(p.getItemInHand().getTypeId() == 419) {
					if(ColorPaint.painters.contains(p)) {
						if(p.getInventory().contains(Material.EGG)) {
							e.setCancelled(true);
							p.throwEgg();
							p.playSound(p.getLocation(), Sound.SHEEP_SHEAR, 1F, 1F);
							if(p.getInventory().getItem(8).getAmount() > 1) {
								int a = p.getInventory().getItem(8).getAmount();
								p.getInventory().setItem(8, Utils.ItemStackCreator(MessagesConfig.ieat, MessagesConfig.ieast1, MessagesConfig.ieast2, Material.EGG, a-1));
							} else {
								p.getInventory().setItem(8, null);
							}
						} else {
							if(!ColorPaint.muniregen.contains(p)) {
								p.playSound(p.getLocation(), Sound.BURP, 1F, 1F);
								p.sendMessage(MessagesConfig.prefix + MessagesConfig.ooa);
								ColorPaint.muniregen.add(p);
								Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
									@Override
									public void run() {
										ColorPaint.muniregen.remove(p);
									}		
								}, 50);
							}
						}
					}
				} else if(p.getItemInHand().getTypeId() == 418) {
					if(ColorPaint.painters.contains(p)) {
						if(p.getInventory().contains(Material.SNOW_BALL)) {
							if(!ColorPaint.cooldown.contains(p)) {
								e.setCancelled(true);
								if(p.getInventory().getItem(7).getAmount() > 1) {
									int a = p.getInventory().getItem(7).getAmount();
									p.getInventory().setItem(7, Utils.ItemStackCreator(MessagesConfig.isat, MessagesConfig.isast1, MessagesConfig.isast2, Material.SNOW_BALL, a-1));
								} else {
									p.getInventory().setItem(7, null);
								}
								ColorPaint.cooldown.add(p);
								Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
									@Override
									public void run() {
										p.throwSnowball();
										p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
										Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
											@Override
											public void run() {
												p.throwSnowball();
												p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
												Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
													@Override
													public void run() {
														p.throwSnowball();
														p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
														Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
															@Override
															public void run() {
																p.throwSnowball();
																p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
																Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																	@Override
																	public void run() {
																		p.throwSnowball();
																		p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
																		Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																			@Override
																			public void run() {
																				p.throwSnowball();
																				p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
																				Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																					@Override
																					public void run() {
																						p.throwSnowball();
																						p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
																						Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																							@Override
																							public void run() {
																								p.throwSnowball();
																								p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
																								Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																									@Override
																									public void run() {
																										p.throwSnowball();
																										p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
																										Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																											@Override
																											public void run() {
																												p.throwSnowball();
																												p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
																												Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																													@Override
																													public void run() {
																														p.throwSnowball();
																														p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
																														Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																															@Override
																															public void run() {
																																p.throwSnowball();
																																p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
																																Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																																	@Override
																																	public void run() {
																																		p.throwSnowball();
																																		p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
																																		Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																																			@Override
																																			public void run() {
																																				p.throwSnowball();
																																				p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
																																				Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																																					@Override
																																					public void run() {
																																						p.throwSnowball();
																																						p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
																																						Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																																							@Override
																																							public void run() {
																																								p.throwSnowball();
																																								p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
																																								Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																																									@Override
																																									public void run() {
																																										p.throwSnowball();
																																										p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
																																										Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																																											@Override
																																											public void run() {
																																												p.throwSnowball();
																																												p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
																																												Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																																													@Override
																																													public void run() {
																																														p.throwSnowball();
																																														p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
																																														Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																																															@Override
																																															public void run() {
																																																p.throwSnowball();
																																																p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
																																																Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																																																	@Override
																																																	public void run() {
																																																		p.throwSnowball();
																																																		p.playSound(p.getLocation(), Sound.BAT_DEATH, 1F, 1F);
																																																		ColorPaint.cooldown.remove(p);
																																																	}	
																																																},1);
																																															}	
																																														},1);
																																													}	
																																												},1);
																																											}	
																																										},1);
																																									}	
																																								},1);
																																							}	
																																						},1);
																																					}	
																																				},1);
																																			}	
																																		},1);
																																	}	
																																},1);
																															}	
																														},1);
																													}	
																												},1);
																											}	
																										},1);
																									}	
																								},1);
																							}	
																						},1);
																					}	
																				},1);
																			}	
																		},1);
																	}	
																},1);
															}	
														},1);
													}	
												},1);
											}	
										},1);
									}	
								},1);	
							}
						} else {
							if(!ColorPaint.muniregen.contains(p)) {
								p.playSound(p.getLocation(), Sound.BURP, 1F, 1F);
								p.sendMessage(MessagesConfig.prefix + MessagesConfig.ooa);
								ColorPaint.muniregen.add(p);
								Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
									@Override
									public void run() {
										ColorPaint.muniregen.remove(p);
									}		
								}, 50);
							}
						}
					}
				} else if(p.getItemInHand().getType() == Material.REDSTONE_COMPARATOR) {
					e.setCancelled(true);
					if(ColorPaint.painters.size() >= 2) {
						if(p.getInventory().getItem(3).getAmount() > 1) {
							int a = p.getInventory().getItem(3).getAmount();
							p.getInventory().setItem(3, Utils.ItemStackCreator(MessagesConfig.iat, MessagesConfig.iast1, MessagesConfig.iast2, Material.REDSTONE_COMPARATOR, a-1));
						} else {
							p.getInventory().setItem(3, null);
						}
						Random rnd = new Random();
						final int x = rnd.nextInt(ColorPaint.painters.size());
						final Location loc = ColorPaint.painters.get(x).getLocation();
						final Location loc3 = new Location(loc.getWorld(), loc.getX(), loc.getY() + 3, loc.getZ());
						final Location loc25 = new Location(loc.getWorld(), loc.getX(), loc.getY() + 2.5, loc.getZ());
						final Location loc2 = new Location(loc.getWorld(), loc.getX(), loc.getY() + 2, loc.getZ());
						final Location loc15 = new Location(loc.getWorld(), loc.getX(), loc.getY() + 1.5, loc.getZ());
						final Location loc1 = new Location(loc.getWorld(), loc.getX(), loc.getY() + 1, loc.getZ());
						final Location loc05 = new Location(loc.getWorld(), loc.getX(), loc.getY() + 0.5, loc.getZ());
						
						Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
							@Override
							public void run() {
								loc3.getWorld().playEffect(loc3, Effect.LAVA_POP, 20);
								loc3.getWorld().playEffect(loc3, Effect.LAVA_POP, 20);
								loc3.getWorld().playEffect(loc3, Effect.LAVA_POP, 20);
								loc3.getWorld().playEffect(loc3, Effect.LAVA_POP, 20);
								loc.getWorld().playSound(loc, Sound.LEVEL_UP, 1F, 1F);
								Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
									@Override
									public void run() {
										loc25.getWorld().playEffect(loc25, Effect.LAVA_POP, 20);
										loc25.getWorld().playEffect(loc25, Effect.LAVA_POP, 20);
										loc25.getWorld().playEffect(loc25, Effect.LAVA_POP, 20);
										loc25.getWorld().playEffect(loc25, Effect.LAVA_POP, 20);
										loc.getWorld().playSound(loc, Sound.LEVEL_UP, 1F, 1F);
										Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
											@Override
											public void run() {
												loc2.getWorld().playEffect(loc2, Effect.LAVA_POP, 20);
												loc2.getWorld().playEffect(loc2, Effect.LAVA_POP, 20);
												loc2.getWorld().playEffect(loc2, Effect.LAVA_POP, 20);
												loc2.getWorld().playEffect(loc2, Effect.LAVA_POP, 20);
												loc.getWorld().playSound(loc, Sound.LEVEL_UP, 1F, 1F);
												Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
													@Override
													public void run() {
														loc15.getWorld().playEffect(loc15, Effect.LAVA_POP, 20);
														loc15.getWorld().playEffect(loc15, Effect.LAVA_POP, 20);
														loc15.getWorld().playEffect(loc15, Effect.LAVA_POP, 20);
														loc15.getWorld().playEffect(loc15, Effect.LAVA_POP, 20);
														loc.getWorld().playSound(loc, Sound.LEVEL_UP, 1F, 1F);
														Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
															@Override
															public void run() {
																loc1.getWorld().playEffect(loc1, Effect.LAVA_POP, 20);
																loc1.getWorld().playEffect(loc1, Effect.LAVA_POP, 20);
																loc1.getWorld().playEffect(loc1, Effect.LAVA_POP, 20);
																loc1.getWorld().playEffect(loc1, Effect.LAVA_POP, 20);
																loc.getWorld().playSound(loc, Sound.LEVEL_UP, 1F, 1F);
																Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																	@Override
																	public void run() {
																		loc05.getWorld().playEffect(loc05, Effect.LAVA_POP, 20);
																		loc05.getWorld().playEffect(loc05, Effect.LAVA_POP, 20);
																		loc05.getWorld().playEffect(loc05, Effect.LAVA_POP, 20);
																		loc05.getWorld().playEffect(loc05, Effect.LAVA_POP, 20);
																		loc.getWorld().playSound(loc, Sound.LEVEL_UP, 1F, 1F);
																		Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																			@Override
																			public void run() {
																				loc.getWorld().playEffect(loc, Effect.LAVA_POP, 20);
																				loc.getWorld().playEffect(loc, Effect.LAVA_POP, 20);
																				loc.getWorld().playEffect(loc, Effect.LAVA_POP, 20);
																				loc.getWorld().playEffect(loc, Effect.LAVA_POP, 20);
																				loc.getWorld().playSound(loc, Sound.LEVEL_UP, 1F, 1F);
																				Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																					@Override
																					public void run() {
																						int i = 0;
																						while(i <= 10) {
																							i++;
																							Snowball s = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
																							s.setShooter(p);
																							s.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
																							Snowball s1 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
																							s1.setShooter(p);
																							s1.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
																							Snowball s2 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
																							s2.setShooter(p);
																							s2.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
																							Snowball s3 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
																							s3.setShooter(p);
																							s3.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
																							Snowball s4 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
																							s4.setShooter(p);
																							s4.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
																							Snowball s5 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
																							s5.setShooter(p);
																							s5.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
																							Snowball s6 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
																							s6.setShooter(p);
																							s6.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
																							Snowball s7 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
																							s7.setShooter(p);
																							s7.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
																							loc.getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), 2F, false, false);
																						}
																					}			
																				}, 1);
																			}			
																		}, 1);
																	}			
																}, 1);
															}			
														}, 1);
													}			
												}, 2);
											}			
										}, 2);
									}			
								}, 3);
							}			
						}, 3);
						
						
					} else {
						p.sendMessage(MessagesConfig.prefix + MessagesConfig.nepfa);
					}
			} else if(p.getItemInHand().getType() == Material.REDSTONE_BLOCK) {
				e.setCancelled(true);
				if(!ColorPaint.uairstrike.contains(p)) {
					if(ColorPaint.painters.size() >= 2) {
						ColorPaint.uairstrike.add(p);
						if(p.getInventory().getItem(2).getAmount() > 1) {
							int a = p.getInventory().getItem(2).getAmount();
							p.getInventory().setItem(2, Utils.ItemStackCreator(MessagesConfig.iuat, MessagesConfig.iuast1, MessagesConfig.iuast2, Material.REDSTONE_BLOCK, a-1));
						} else {
							p.getInventory().setItem(2, null);
						}
						for(Player all : ColorPaint.painters) {
							spawnAirstrike(p, all);
						}
						Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
							@Override
							public void run() {
								ColorPaint.uairstrike.remove(p);
							}			
						}, 100);
					} else {
						p.sendMessage(MessagesConfig.prefix + MessagesConfig.nepfa);
					}
				} else {
					p.sendMessage(MessagesConfig.prefix + MessagesConfig.wfa);
				}
				
			} else if(p.getItemInHand().getType() == Material.EGG) {
				e.setCancelled(true);
			} else if(p.getItemInHand().getType() == Material.SNOW_BALL) {
				e.setCancelled(true);
			}
			}
		}
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getClickedBlock().getType() != null) {
				if(e.getClickedBlock().getType() == Material.WALL_SIGN || e.getClickedBlock().getType() == Material.SIGN 
				|| e.getClickedBlock().getType() == Material.SIGN_POST) {
					Sign s = (Sign) e.getClickedBlock().getState();
					if(s.getLine(0).equalsIgnoreCase(MessagesConfig.jsr1) &&
					   s.getLine(1).equalsIgnoreCase(MessagesConfig.jsr2) &&
					   s.getLine(2).equalsIgnoreCase(MessagesConfig.jsr3)) {
						p.getInventory().clear();
						ColorPaint.painters.add(p);
						Random rnd1 = new Random();
						Utils.teleportPlayer(p, "Paintball-Arena." + s.getLine(3) + "." + rnd1.nextInt(10));
						ColorPaint.arena.put(p, s.getLine(3));
						Random rnd = new Random();
						int x = rnd.nextInt(15);
						ColorPaint.colors.put(p, x);
						ColorPaint.kills.put(p, 0);
						ColorPaint.killstreak.put(p, 0);
						p.setGameMode(GameMode.SURVIVAL);
						p.setHealth(20);
						p.setFoodLevel(20);
						KitClass.addKit(p);
						p.sendMessage(MessagesConfig.prefix + MessagesConfig.jm);
					} else if(s.getLine(0).equalsIgnoreCase(MessagesConfig.qsr1) &&
							   s.getLine(1).equalsIgnoreCase(MessagesConfig.qsr2) &&
							   s.getLine(2).equalsIgnoreCase(MessagesConfig.qsr3)) {
						p.getInventory().clear();
						ColorPaint.painters.remove(p);
						Utils.teleportPlayer(p, "Paintball-Quit");
						ColorPaint.colors.remove(p);
						ColorPaint.killstreak.remove(p);
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(MessagesConfig.prefix + MessagesConfig.qm);
						p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
					}
				}
			}
		} else if(e.getAction() == Action.PHYSICAL) {
			if(e.getClickedBlock().getType() != null) {
				if(e.getClickedBlock().getType() == Material.STONE_PLATE) {
					if(ColorPaint.painters.contains(p)) {
						if(DefaultListener.locs.containsKey(e.getClickedBlock().getLocation().toString())) {
							e.setCancelled(true);
							Location locx = e.getClickedBlock().getLocation();
							locx.getBlock().setType(Material.AIR);
							Player k = DefaultListener.locs.get(e.getClickedBlock().getLocation().toString());
							DefaultListener.locs.remove(e.getClickedBlock().getLocation().toString());
							final Location loc = p.getLocation();
							final Location loc3 = new Location(loc.getWorld(), loc.getX(), loc.getY() + 3, loc.getZ());
							@SuppressWarnings("unused")
							final Location loc25 = new Location(loc.getWorld(), loc.getX(), loc.getY() + 2.5, loc.getZ());
							@SuppressWarnings("unused")
							final Location loc2 = new Location(loc.getWorld(), loc.getX(), loc.getY() + 2, loc.getZ());
							@SuppressWarnings("unused")
							final Location loc15 = new Location(loc.getWorld(), loc.getX(), loc.getY() + 1.5, loc.getZ());
							final Location loc1 = new Location(loc.getWorld(), loc.getX(), loc.getY() + 1, loc.getZ());
							@SuppressWarnings("unused")
							final Location loc05 = new Location(loc.getWorld(), loc.getX(), loc.getY() + 0.5, loc.getZ());
							int i = 0;
							while(i <= 10) {
								i++;
								Snowball s = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
								s.setShooter(k);
								s.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
								Snowball s1 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
								s1.setShooter(k);
								s1.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
								Snowball s2 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
								s2.setShooter(k);
								s2.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
								Snowball s3 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
								s3.setShooter(k);
								s3.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
								Snowball s4 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
								s4.setShooter(k);
								s4.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
								Snowball s5 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
								s5.setShooter(k);
								s5.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
								Snowball s6 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
								s6.setShooter(k);
								s6.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
								Snowball s7 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
								s7.setShooter(k);
								s7.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
								loc.getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), 2F, false, false);
							}
						}
					}
				}
			}
		}
	}
	
	public static void spawnAirstrike(final Player p,Player k) {
		final Location loc = k.getLocation();
		final Location loc3 = new Location(loc.getWorld(), loc.getX(), loc.getY() + 3, loc.getZ());
		final Location loc25 = new Location(loc.getWorld(), loc.getX(), loc.getY() + 2.5, loc.getZ());
		final Location loc2 = new Location(loc.getWorld(), loc.getX(), loc.getY() + 2, loc.getZ());
		final Location loc15 = new Location(loc.getWorld(), loc.getX(), loc.getY() + 1.5, loc.getZ());
		final Location loc1 = new Location(loc.getWorld(), loc.getX(), loc.getY() + 1, loc.getZ());
		final Location loc05 = new Location(loc.getWorld(), loc.getX(), loc.getY() + 0.5, loc.getZ());
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
			@Override
			public void run() {
				loc3.getWorld().playEffect(loc3, Effect.LAVA_POP, 20);
				loc3.getWorld().playEffect(loc3, Effect.LAVA_POP, 20);
				loc3.getWorld().playEffect(loc3, Effect.LAVA_POP, 20);
				loc3.getWorld().playEffect(loc3, Effect.LAVA_POP, 20);
				loc.getWorld().playSound(loc, Sound.LEVEL_UP, 1F, 1F);
				Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
					@Override
					public void run() {
						loc25.getWorld().playEffect(loc25, Effect.LAVA_POP, 20);
						loc25.getWorld().playEffect(loc25, Effect.LAVA_POP, 20);
						loc25.getWorld().playEffect(loc25, Effect.LAVA_POP, 20);
						loc25.getWorld().playEffect(loc25, Effect.LAVA_POP, 20);
						loc.getWorld().playSound(loc, Sound.LEVEL_UP, 1F, 1F);
						Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
							@Override
							public void run() {
								loc2.getWorld().playEffect(loc2, Effect.LAVA_POP, 20);
								loc2.getWorld().playEffect(loc2, Effect.LAVA_POP, 20);
								loc2.getWorld().playEffect(loc2, Effect.LAVA_POP, 20);
								loc2.getWorld().playEffect(loc2, Effect.LAVA_POP, 20);
								loc.getWorld().playSound(loc, Sound.LEVEL_UP, 1F, 1F);
								Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
									@Override
									public void run() {
										loc15.getWorld().playEffect(loc15, Effect.LAVA_POP, 20);
										loc15.getWorld().playEffect(loc15, Effect.LAVA_POP, 20);
										loc15.getWorld().playEffect(loc15, Effect.LAVA_POP, 20);
										loc15.getWorld().playEffect(loc15, Effect.LAVA_POP, 20);
										loc.getWorld().playSound(loc, Sound.LEVEL_UP, 1F, 1F);
										Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
											@Override
											public void run() {
												loc1.getWorld().playEffect(loc1, Effect.LAVA_POP, 20);
												loc1.getWorld().playEffect(loc1, Effect.LAVA_POP, 20);
												loc1.getWorld().playEffect(loc1, Effect.LAVA_POP, 20);
												loc1.getWorld().playEffect(loc1, Effect.LAVA_POP, 20);
												loc.getWorld().playSound(loc, Sound.LEVEL_UP, 1F, 1F);
												Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
													@Override
													public void run() {
														loc05.getWorld().playEffect(loc05, Effect.LAVA_POP, 20);
														loc05.getWorld().playEffect(loc05, Effect.LAVA_POP, 20);
														loc05.getWorld().playEffect(loc05, Effect.LAVA_POP, 20);
														loc05.getWorld().playEffect(loc05, Effect.LAVA_POP, 20);
														loc.getWorld().playSound(loc, Sound.LEVEL_UP, 1F, 1F);
														Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
															@Override
															public void run() {
																loc.getWorld().playEffect(loc, Effect.LAVA_POP, 20);
																loc.getWorld().playEffect(loc, Effect.LAVA_POP, 20);
																loc.getWorld().playEffect(loc, Effect.LAVA_POP, 20);
																loc.getWorld().playEffect(loc, Effect.LAVA_POP, 20);
																loc.getWorld().playSound(loc, Sound.LEVEL_UP, 1F, 1F);
																Bukkit.getScheduler().scheduleSyncDelayedTask(ColorPaint.m, new Runnable() {
																	@Override
																	public void run() {
																		int i = 0;
																		while(i <= 20) {
																			i++;
																			Snowball s = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
																			s.setShooter(p);
																			s.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
																			Snowball s1 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
																			s1.setShooter(p);
																			s1.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
																			Snowball s2 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
																			s2.setShooter(p);
																			s2.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
																			Snowball s3 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
																			s3.setShooter(p);
																			s3.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
																			Snowball s4 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
																			s4.setShooter(p);
																			s4.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
																			Snowball s5 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
																			s5.setShooter(p);
																			s5.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
																			Snowball s6 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
																			s6.setShooter(p);
																			s6.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
																			Snowball s7 = (Snowball) loc1.getWorld().spawnEntity(loc3, EntityType.SNOWBALL);
																			s7.setShooter(p);
																			s7.setVelocity(p.getLocation().getDirection().setY(getDouble()).setX(getDouble()).setZ(getDouble()));
																			loc.getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), 2F, false, false);
																		}
																	}			
																}, 1);
															}			
														}, 1);
													}			
												}, 1);
											}			
										}, 1);
									}			
								}, 2);
							}			
						}, 2);
					}			
				}, 3);
			}			
		}, 3);
	}
	
	public static double getDouble() {
		Random rnd = new Random();
		int i = rnd.nextInt(50);
		int i2 = rnd.nextInt(2)+1;
		double d = i*0.004D;
		if(i2 == 1) {
			d = d*-1;
		}
		return d;
	}

}
