package projectrpg.savboyevents;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import net.md_5.bungee.api.ChatColor;

public class Events implements Listener
{
	@EventHandler
	public void onInteract(PlayerInteractEvent event)
	{
		Block block = event.getClickedBlock();
		Action action = event.getAction();
		Player player = event.getPlayer();
		World world = player.getWorld();
		Location locv = new Location(world, 4668.0, 54.0, -5994.0);
		Location loch = new Location(world, 4624.0, 64.0, -6025.0);
		
		//Vamp altar check
		if(action.equals(Action.LEFT_CLICK_BLOCK) && block.getLocation().equals(locv))
		{
			if(player.getCustomName().contains("H"))
			{
			player.setCustomName("V");
			player.sendMessage(ChatColor.RED + "You place your hand on the altar.The darkness surrounds you. You are now a vampire.");
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0));
			}else
			if(player.getCustomName().contains("V"))
			{
				player.sendMessage(ChatColor.RED + "You have already embraced the darkness. The altar heals your corrupted body");
				player.setHealth(20);
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
				player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0));
			}else
			if(player.getCustomName().contains("E"))
				player.sendMessage(ChatColor.RED + "You feel the evil that lurks in the altar. Your body rejects the darkness");
		}
		
		
		//Purification altar check
		if(action.equals(Action.LEFT_CLICK_BLOCK) && block.getLocation().equals(loch))
		{
			if(player.getCustomName().contains("V"))
			{
			player.setCustomName("H");
			player.sendMessage(ChatColor.BLUE + "You come close to the altar of light. It's light shines through you and you become clean again.");
			player.removePotionEffect(PotionEffectType.SPEED);
			player.removePotionEffect(PotionEffectType.NIGHT_VISION);
			
			}else
			if(player.getCustomName().contains("H"))
			{
				player.sendMessage(ChatColor.BLUE + "The altar heals you");
				player.setHealth(20);
				player.setFoodLevel(20);
			}else
			if(player.getCustomName().contains("E"))
				player.sendMessage(ChatColor.RED + "You place your hand on the altar of light. It destroys the magic of the wild that you stored within.");
		}
		
		
	}
}
