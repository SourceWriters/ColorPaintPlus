package de.yellowphoenix18.colorpaint.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.yellowphoenix18.colorpaint.ColorPaint;
import de.yellowphoenix18.colorpaint.config.MessagesConfig;

public class QuitListener implements Listener {
	
	@EventHandler
	public void on(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if(ColorPaint.painters.contains(p)) {
			p.getInventory().clear();
			ColorPaint.painters.remove(p);
			ColorPaint.colors.remove(p);
			ColorPaint.killstreak.remove(p);
			p.setGameMode(GameMode.SURVIVAL);
			p.sendMessage(MessagesConfig.name + MessagesConfig.qm);			
		}
	}

}
