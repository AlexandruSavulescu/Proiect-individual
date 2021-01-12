package projectrpg.savboy;
import org.bukkit.plugin.java.JavaPlugin;
import net.md_5.bungee.api.ChatColor;
import projectrpg.savboyevents.Battle;
import projectrpg.savboyevents.Eating;
import projectrpg.savboyevents.Events;
import projectrpg.savboyevents.Join;

public class Mainclass extends JavaPlugin
{
	public void onEnable()
	{
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\n#### PROJECT RPG PLUGIN HAS BEEN ENABLED ####\n\n");
		getServer().getPluginManager().registerEvents(new Events(), this);
		getServer().getPluginManager().registerEvents(new Join(), this);
		getServer().getPluginManager().registerEvents(new Eating(), this);
		getServer().getPluginManager().registerEvents(new Battle(), this);
	}
	public void onDisable()
	{
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\n#### PROJECT RPG PLUGIN HAS BEEN DISABLED ####\n\n");
	}
}
