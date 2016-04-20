package dk.benjaminbreuner.science;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Science extends JavaPlugin{
	
	public void onEnable(){
		getLogger().info("Science enabled");
		getServer().getPluginManager().registerEvents(new Notes(), this);
	}
	
	public void onDisable(){
		getLogger().info("Science disabled");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("book")) {
			Player player = (Player) sender;; 
		    PlayerInventory inventory = player.getInventory(); 
		    ItemStack itemstack = new ItemStack(Material.DIAMOND, 64);
		    inventory.addItem(itemstack);
			return true;
		} //If this has happened the function will return true. 
	        // If this hasn't happened the value of false will be returned.
		return false; 
	}
}