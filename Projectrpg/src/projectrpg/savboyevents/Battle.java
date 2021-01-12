package projectrpg.savboyevents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Battle implements Listener
{
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event)
	{
		if(event.getDamager() instanceof Player)
		{
		Player damager = (Player) event.getDamager();
		if(damager.getCustomName().contains("V"))
		{
			event.setDamage(event.getDamage() + 0.25*event.getDamage());
			damager.setFoodLevel((int)(damager.getFoodLevel() + 0.25*event.getDamage()));
			damager.setSaturation((float) 0.26);
		}
		if(damager.getCustomName().contains("B"))
		{
			damager.setFoodLevel((int)(damager.getFoodLevel() + 0.5*event.getDamage()));
		}
		}
	}
}
