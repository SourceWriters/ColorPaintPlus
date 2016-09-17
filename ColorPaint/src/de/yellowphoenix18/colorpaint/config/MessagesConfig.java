package de.yellowphoenix18.colorpaint.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class MessagesConfig {
	
	public static File f = new File("plugins/ColorPaint", "messages.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
	
	public static String prefix = "§7[§bPaintball§7] §7";
	public static String dmk = "§7You killed §b%Player% §7.";
	public static String dmp = "§7You were killed by §b%Killer% §7.";
	public static String jm = "§7You joined §bPaintball §7.";
	public static String qm = "§7You have left §bPaintball §7.";
	public static String ooa = "§cYou have no Ammo left.";
	public static String nepfa = "§cThere are not enough Player for a Airstrike.";
	public static String wfa = "§cYou must wait before you can use the Airstrike.";
	public static String gak = "§b%Player% §7got a §c%KillStreak% §bKillstreak§7.";
	public static String nip = "§cYou arent inside of a Paintball-Arena.";
	public static String nop = "§cYou havent the Permission to enter this Command.";
	public static String nea = "§cToo much/not enough Arguments.";
	
	public static String jsr1 = "§b[Paintball]";
	public static String jsr2 = "§7join";
	public static String jsr3 = "§bPaintball";
	
	public static String qsr1 = "§b[Paintball]";
	public static String qsr2 = "§7leave";
	public static String qsr3 = "§bPaintball";
	
	public static String iat = "§bAirstrike";
	public static String iast1 = "§7Blow up some";
	public static String iast2 = "§7Persons!";
	
	public static String imgt = "§cMachine§bGun";
	public static String imgst1 = "§7Throw more than 15";
	public static String imgst2 = "§7Paintballs in a row";
	
	public static String igt = "§bPaintball§7-§bGun";
	public static String igst1 = "§7Throw some";
	public static String igst2 = "§7Paintballs";
	
	public static String iuat = "§bPaintball§7-§bGun";
	public static String iuast1 = "§7Throw some";
	public static String iuast2 = "§7Paintballs";
	
	public static String ieat = "§bAmmo";
	public static String ieast1 = "§7Your normal";
	public static String ieast2 = "§7Ammo";
	
	public static String isat = "§bAmmo";
	public static String isast1 = "§7Your MachineGun";
	public static String isast2 = "§7Ammo";
	
	public static String ilat = "§bLandmine";
	public static String ilast1 = "§7Blow up the";
	public static String ilast2 = "§7interatcing Player";
	
	public static String scoreboard = "§7Paintball";
	
	public static void loadConfig() {
		
		if(cfg.getString("Messages.Prefix") == null) {
			cfg.set("Messages.Prefix", "&7[&bPaintball&7] ");
		}
		if(cfg.getString("Messages.DeathMessage.Killer") == null) {
			cfg.set("Messages.DeathMessage.Killer", "&7You killed &b%Player% &7.");
		}
		if(cfg.getString("Messages.DeathMessage.Player") == null) {
			cfg.set("Messages.DeathMessage.Player", "&7You were killed by &b%Killer% &7.");
		}
		if(cfg.getString("Messages.JoinMessage") == null) {
			cfg.set("Messages.JoinMessage", "&7You joined &bPaintball &7.");
		}
		if(cfg.getString("Messages.QuitMessage") == null) {
			cfg.set("Messages.QuitMessage", "&7You have left &bPaintball &7.");
		}
		if(cfg.getString("Messages.OutOfAmmo") == null) {
			cfg.set("Messages.OutOfAmmo", "&cYou have no Ammo left!.");
		}
		if(cfg.getString("Messages.NotEnoughPlayerForAirstrike") == null) {
			cfg.set("Messages.NotEnoughPlayerForAirstrike", "&cThere are not enough Player for a Airstrike!.");
		}
		if(cfg.getString("Messages.WaitForAirstrike") == null) {
			cfg.set("Messages.WaitForAirstrike", "&cYou must wait before you can use the Airstrike!.");
		}
		if(cfg.getString("Messages.KillStreak") == null) {
			cfg.set("Messages.KillStreak", "&b%Player% &7got a &c%KillStreak% &bKillstreak&7.");
		}
		if(cfg.getString("Messages.NotInside") == null) {
			cfg.set("Messages.NotInside", "&cYou arent inside of a Paintball-Arena.");
		}
		if(cfg.getString("Messages.NoPermission") == null) {
			cfg.set("Messages.NoPermission", "&cYou havent the Permission to enter this command.");
		}
		if(cfg.getString("Messages.NotEnoughArguments") == null) {
			cfg.set("Messages.NotEnoughArguments", "&cToo much/not enough Arguments.");
		}
		if(cfg.getString("Scoreboard.Title") == null) {
			cfg.set("Scoreboard.Title", "&7Paintball.");
		}
		if(cfg.getString("Signs.JoinSign.Row1") == null) {
			cfg.set("Signs.JoinSign.Row1", "&b[Paintball]");
		}
		if(cfg.getString("Signs.JoinSign.Row2") == null) {
			cfg.set("Signs.JoinSign.Row2", "&7join");
		}
		if(cfg.getString("Signs.JoinSign.Row3") == null) {
			cfg.set("Signs.JoinSign.Row3", "&bPaintball");
		}
		if(cfg.getString("Signs.QuitSign.Row1") == null) {
			cfg.set("Signs.QuitSign.Row1", "&b[Paintball]");
		}
		if(cfg.getString("Signs.QuitSign.Row2") == null) {
			cfg.set("Signs.QuitSign.Row2", "&7leave");
		}
		if(cfg.getString("Signs.QuitSign.Row3") == null) {
			cfg.set("Signs.QuitSign.Row3", "&bPaintball");
		}
		if(cfg.getString("Items.Airstrike.Title") == null) {
			cfg.set("Items.Airstrike.Title", "&bAirstrike");
		}
		if(cfg.getString("Items.Airstrike.SubTitle1") == null) {
			cfg.set("Items.Airstrike.SubTitle1", "&7Blow up some");
		}
		if(cfg.getString("Items.Airstrike.SubTitle2") == null) {
			cfg.set("Items.Airstrike.SubTitle2", "&7Persons");
		}
		if(cfg.getString("Items.MachineGun.Title") == null) {
			cfg.set("Items.MachineGun.Title", "&cMachine&bGun");
		}
		if(cfg.getString("Items.MachineGun.SubTitle1") == null) {
			cfg.set("Items.MachineGun.SubTitle1", "&7Throw more than 15");
		}
		if(cfg.getString("Items.MachineGun.SubTitle2") == null) {
			cfg.set("Items.MachineGun.SubTitle2", "&7Paintballs in a row");
		}
		if(cfg.getString("Items.Gun.Title") == null) {
			cfg.set("Items.Gun.Title", "&bPaintball&7-&bGun");
		}
		if(cfg.getString("Items.Gun.SubTitle1") == null) {
			cfg.set("Items.Gun.SubTitle1", "&7Throw some");
		}
		if(cfg.getString("Items.Gun.SubTitle2") == null) {
			cfg.set("Items.Gun.SubTitle2", "&7Paintballs");
		}
		if(cfg.getString("Items.UltimateAirstrike.Title") == null) {
			cfg.set("Items.UltimateAirstrike.Title", "&cUltimate&7-&bAirstrike");
		}
		if(cfg.getString("Items.UltimateAirstrike.SubTitle1") == null) {
			cfg.set("Items.UltimateAirstrike.SubTitle1", "&7Blow up every Player");
		}
		if(cfg.getString("Items.UltimateAirstrike.SubTitle2") == null) {
			cfg.set("Items.UltimateAirstrike.SubTitle2", "&7in Paintball");
		}
		if(cfg.getString("Items.EggAmmo.Title") == null) {
			cfg.set("Items.EggAmmo.Title", "&bAmmo");
		}
		if(cfg.getString("Items.EggAmmo.SubTitle1") == null) {
			cfg.set("Items.EggAmmo.SubTitle1", "&7Your normal");
		}
		if(cfg.getString("Items.EggAmmo.SubTitle2") == null) {
			cfg.set("Items.EggAmmo.SubTitle2", "&7Ammo");
		}
		if(cfg.getString("Items.SnowballAmmo.Title") == null) {
			cfg.set("Items.SnowballAmmo.Title", "&bAmmo");
		}
		if(cfg.getString("Items.SnowballAmmo.SubTitle1") == null) {
			cfg.set("Items.SnowballAmmo.SubTitle1", "&7Your normal");
		}
		if(cfg.getString("Items.SnowballAmmo.SubTitle2") == null) {
			cfg.set("Items.SnowballAmmo.SubTitle2", "&7Ammo");
		}
		if(cfg.getString("Items.Landmine.Title") == null) {
			cfg.set("Items.Landmine.Title", "&bLandmine");
		}
		if(cfg.getString("Items.Landmine.SubTitle1") == null) {
			cfg.set("Items.Landmine.SubTitle1", "&7Blow up the");
		}
		if(cfg.getString("Items.Landmine.SubTitle2") == null) {
			cfg.set("Items.Landmine.SubTitle2", "&7interacting Player");
		}		
		if(cfg.getString("Scoreboard.Title") == null) {
			cfg.set("Scoreboard.Title", "&7Paintball");
		}
		if(cfg.getString("Items.Landmine.Title") == null) {
			cfg.set("Items.Landmine.Title", "&bLandmine");
		}
		if(cfg.getString("Items.Landmine.SubTitle1") == null) {
			cfg.set("Items.Landmine.SubTitle1", "&7Blow up the");
		}
		if(cfg.getString("Items.Landmine.SubTitle2") == null) {
			cfg.set("Items.Landmine.SubTitle2", "&7interacting Player");
		}
		if(cfg.getString("Messages.NoPermission") == null) {
			cfg.set("Messages.NoPermission", "&cYou havent the Permission to enter this command.");	
		}
		if(cfg.getString("Messages.NotEnoughArguments") == null) {
			cfg.set("Messages.NotEnoughArguments", "&cToo much/not enough Arguments.");		
		}
		
		try {
			cfg.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		prefix = cfg.getString("Messages.Prefix").replace("&", "§");
		dmk = cfg.getString("Messages.DeathMessage.Killer").replace("&", "§");
		dmp = cfg.getString("Messages.DeathMessage.Player").replace("&", "§");
		jm = cfg.getString("Messages.JoinMessage").replace("&", "§");
		qm = cfg.getString("Messages.QuitMessage").replace("&", "§");
		ooa = cfg.getString("Messages.OutOfAmmo").replace("&", "§");
		nepfa = cfg.getString("Messages.NotEnoughPlayerForAirstrike").replace("&", "§");
		wfa = cfg.getString("Messages.WaitForAirstrike").replace("&", "§");
		gak = cfg.getString("Messages.KillStreak").replace("&", "§");
		nip = cfg.getString("Messages.NotInside").replace("&", "§");
		nop = cfg.getString("Messages.NoPermission").replace("&", "§");
		nea = cfg.getString("Messages.NotEnoughArguments").replace("&", "§");
		scoreboard = cfg.getString("Scoreboard.Title").replace("&", "§");
		if(scoreboard.length() > 14) {
			scoreboard = scoreboard.substring(0, 14);
		}
		
		jsr1 = cfg.getString("Signs.JoinSign.Row1").replace("&", "§");
		jsr2 = cfg.getString("Signs.JoinSign.Row2").replace("&", "§");
		jsr3 = cfg.getString("Signs.JoinSign.Row3").replace("&", "§");
		
		qsr1 = cfg.getString("Signs.QuitSign.Row1").replace("&", "§");
		qsr2 = cfg.getString("Signs.QuitSign.Row2").replace("&", "§");
		qsr3 = cfg.getString("Signs.QuitSign.Row3").replace("&", "§");
		
		iat = cfg.getString("Items.Airstrike.Title").replace("&", "§");
		iast1 = cfg.getString("Items.Airstrike.SubTitle1").replace("&", "§");
		iast2 = cfg.getString("Items.Airstrike.SubTitle2").replace("&", "§");
		
		imgt = cfg.getString("Items.MachineGun.Title").replace("&", "§");
		imgst1 = cfg.getString("Items.MachineGun.SubTitle1").replace("&", "§");
		imgst2 = cfg.getString("Items.MachineGun.SubTitle2").replace("&", "§");
		
		igt = cfg.getString("Items.Gun.Title").replace("&", "§");
		igst1 = cfg.getString("Items.Gun.SubTitle1").replace("&", "§");
		igst2 = cfg.getString("Items.Gun.SubTitle2").replace("&", "§");
		
		ieat = cfg.getString("Items.EggAmmo.Title").replace("&", "§");
		ieast1 = cfg.getString("Items.EggAmmo.SubTitle1").replace("&", "§");
		ieast2 = cfg.getString("Items.EggAmmo.SubTitle2").replace("&", "§");
		
		isat = cfg.getString("Items.SnowballAmmo.Title").replace("&", "§");
		isast1 = cfg.getString("Items.SnowballAmmo.SubTitle1").replace("&", "§");
		isast2 = cfg.getString("Items.SnowballAmmo.SubTitle2").replace("&", "§");
		
		iuat = cfg.getString("Items.UltimateAirstrike.Title").replace("&", "§");
		iuast1 = cfg.getString("Items.UltimateAirstrike.SubTitle1").replace("&", "§");
		iuast2 = cfg.getString("Items.UltimateAirstrike.SubTitle2").replace("&", "§");
		
		ilat = cfg.getString("Items.Landmine.Title").replace("&", "§");
		ilast1 = cfg.getString("Items.Landmine.SubTitle1").replace("&", "§");
		ilast2 = cfg.getString("Items.Landmine.SubTitle2").replace("&", "§");
		
	}

}
