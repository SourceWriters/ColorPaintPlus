package de.yellowphoenix18.colorpaint.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.yellowphoenix18.colorpaint.autoupdate.UpdateChecker;
import de.yellowphoenix18.colorpaint.config.MainConfig;
import de.yellowphoenix18.colorpaint.config.MessagesConfig;
import de.yellowphoenix18.colorpaint.util.Utils;

public class JoinListener implements Listener {
	
	@EventHandler
	public void on(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(MainConfig.globalspawn == true) {
			Utils.teleportPlayer(p, "Paintball-Quit");
			if(UpdateChecker.needUpdate()) {
				if(MainConfig.autoupdate == true) {
					UpdateChecker.updateJar();
				}
			}
			if(p.isOp()) {
				p.sendMessage(MessagesConfig.name + UpdateChecker.checkVersion());
			}
		}
	}

}
