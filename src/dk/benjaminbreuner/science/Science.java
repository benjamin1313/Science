package dk.benjaminbreuner.science;

import dk.benjaminbreuner.science.ItemRecipes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Science extends JavaPlugin{
	
	public void onEnable(){
		getLogger().info("Science enabled");
		getServer().getPluginManager().registerEvents(new Notes(), this);
		//loading recipes
		new ItemRecipes().boostsole();
		new ItemRecipes().powerBootsV1();
	}
	
	public void onDisable(){
		getLogger().info("Science disabled");
		Bukkit.getServer().clearRecipes();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("science")) {
		    sender.sendMessage(ChatColor.BLUE + "---------------Science---------------");
		    sender.sendMessage(ChatColor.AQUA + "Made by benjamin1313");
			return true;
		}
		return false; 
	}
}