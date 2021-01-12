package projectrpg.savboyevents;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;

public class Join implements Listener
{
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();
		if(player.hasPlayedBefore())
		{
			return;
		}
		else
			player.setCustomName("H");
			player.sendMessage(ChatColor.WHITE + "Ah, a new born into the world of Project RPG. Welcome to the server. I hope that you will enjoy your time here");
	}
	
}
