package de.yellowphoenix18.colorpaint.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class DamageListener implements Listener {
	
	@EventHandler
	public void on(EntityDamageEvent e) {
		if(e.getCause() == DamageCause.DROWNING || e.getCause() == DamageCause.FIRE ||
		   e.getCause() == DamageCause.SUFFOCATION || e.getCause() == DamageCause.FALL ||
		   e.getCause() == DamageCause.STARVATION || e.getCause() == DamageCause.CONTACT ||
		   e.getCause() == DamageCause.ENTITY_EXPLOSION) {
			e.setCancelled(true);
		}
	}

}
