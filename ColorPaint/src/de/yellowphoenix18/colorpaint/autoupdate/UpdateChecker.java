package de.yellowphoenix18.colorpaint.autoupdate;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import de.yellowphoenix18.colorpaint.ColorPaint;
import de.yellowphoenix18.colorpaint.config.MessagesConfig;

public class UpdateChecker {
	
	public static void updateJar(Player p) {
		try {
            URL url = new URL("http://yellowphoenix18.de/downloads/ColorPaint.jar");
            URLConnection urlCon = url.openConnection();
   
            InputStream is = urlCon.getInputStream();
            FileOutputStream fos = new FileOutputStream("plugins/ColorPaint.jar");
    
            byte[] array = new byte[1000];
            int leido = is.read(array);
            while (leido > 0) {
                fos.write(array, 0, leido);
                leido = is.read(array);
              
            }
            is.close();
            fos.close();
            p.sendMessage(MessagesConfig.prefix + "§aUpdate sussesfully!");
        } catch (Exception e) {
        	e.printStackTrace();
        	ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
    		console.sendMessage("§cError while Updating");
        }
	}
	
	public static void updateJar() {
		try {
            URL url = new URL("http://yellowphoenix18.de/downloads/ColorPaint.jar");
            URLConnection urlCon = url.openConnection();
   
            InputStream is = urlCon.getInputStream();
            FileOutputStream fos = new FileOutputStream("plugins/ColorPaint.jar");
    
            byte[] array = new byte[1000];
            int leido = is.read(array);
            while (leido > 0) {
                fos.write(array, 0, leido);
                leido = is.read(array);
              
            }
            is.close();
            fos.close();
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
    		console.sendMessage("§aUpdate sussesfully");
        } catch (Exception e) {
        	e.printStackTrace();
        	ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
    		console.sendMessage("§cError while Updating");
        }
	}
	
	public static String checkVersion() {
        String latestversion;
        boolean isupdate;
        try {
            URL urlv = new URL("http://yellowphoenix18.de/update.php?plugin=colorpaintplus");
            BufferedReader in = new BufferedReader(new InputStreamReader(urlv.openStream()));
            latestversion = in.readLine();
            if(latestversion.equalsIgnoreCase(ColorPaint.m.getDescription().getVersion())){
                isupdate = true;
            }else{
                isupdate = false;
            }
            in.close();
        } catch (IOException e) {
            System.out.println("[ColorPaintPlus] No Connection for Updating");
            return "";
        }
        if(isupdate){
            return "§aColorPaintPlus is up to date";
        }else{
            return "§bColorPaintPlus §cneeds an update, lastest Version: §6" + latestversion + ". §bUse §6'/pb update' §bto update ColorPaintPlus";
        }
    }
	
	public static boolean needUpdate(){
        String latestversion;
        boolean isupdate;
        try {
            URL urlv = new URL("http://yellowphoenix18.de/versions/clp.php");
            BufferedReader in = new BufferedReader(new InputStreamReader(urlv.openStream()));
            latestversion = in.readLine();
            if(latestversion.equalsIgnoreCase(ColorPaint.m.getDescription().getVersion())){
                isupdate = true;
            }else{
                isupdate = false;
            }
            in.close();
        } catch (IOException e) {
            System.out.println("[Paintball] No Connection for Updating");
            return false;
        }
        if(isupdate){
            return false;
        }else{
            return true;
        }
    }	
}
