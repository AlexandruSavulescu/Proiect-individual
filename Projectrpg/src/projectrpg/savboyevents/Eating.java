package projectrpg.savboyevents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import net.md_5.bungee.api.ChatColor;


public class Eating implements Listener
{
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		if(player.getItemInHand().equals(null) || event.getAction().equals(null))
			;
		else
		{
		Action action = event.getAction();
		ItemStack item = player.getItemInHand();
		if(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK))
		if(item.getType().isEdible() && player.getCustomName().contains("V"))
		{
			player.sendMessage(ChatColor.RED + "You try eating but are unable to. You feel an intense thirst for blood");
			event.setCancelled(true);
		}
		}
	}
}
 