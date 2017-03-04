package de.yellowphoenix18.colorpaint.listener;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import de.yellowphoenix18.colorpaint.ColorPaint;

public class DefaultListener implements Listener {
	
	public static HashMap<String, Player> locs = new HashMap<String, Player>();
	public static HashMap<Location, Player> locs_real = new HashMap<Location, Player>();

	@EventHandler
	public void on(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(ColorPaint.painters.contains(p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void on(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(ColorPaint.painters.contains(p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void on(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if(ColorPaint.painters.contains(p)) {
			if(e.getBlock().getType() != Material.STONE_PLATE) {
				e.setCancelled(true);	
			} else {
				locs.put(e.getBlock().getLocation().toString(), p);
				locs_real.put(e.getBlock().getLocation(), p);
			}
		}
	}
	
	@EventHandler
	public void on(PlayerPickupItemEvent e) {
		Player p = e.getPlayer();
		if(ColorPaint.painters.contains(p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void on(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if(ColorPaint.painters.contains(p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void on(FoodLevelChangeEvent e) {
		Player p = (Player) e.getEntity();
		if(ColorPaint.painters.contains(p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e) {
        if (e.getSpawnReason() == SpawnReason.EGG) {
            e.setCancelled(true);
        }
    }
	
	@EventHandler
	public void on(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(ColorPaint.painters.contains(p)) {
			e.setCancelled(true);
			for(Player all : ColorPaint.painters) {
				all.sendMessage("§8[§a" + ColorPaint.kills.get(p) + "§8] §6" + p.getName() + " §8>> §7" + e.getMessage());
				all.playSound(all.getLocation(), Sound.CAT_MEOW, 1F, 1F);
			}
		}
	}
	
	@EventHandler
	public void on(EntityDamageEvent e) {
		if(e.getCause() == DamageCause.BLOCK_EXPLOSION || e.getCause() == DamageCause.ENTITY_EXPLOSION) {
			e.setCancelled(true);
		}
	}
	
	
}
