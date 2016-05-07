package dk.benjaminbreuner.science;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

//TODO clean this up
//TODO fix bug that give you a extra pair of leather_boots then nothing is equipped
public class ResearchTable implements Listener{
	HashMap<String, String> RecipeStage = new HashMap<String, String>();
	@SuppressWarnings("deprecation")//setItemInHand and getItemInHand
	@EventHandler
	public void PlayerRightClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(event.getClickedBlock().getType().equals(Material.CARPET)){
				Location loc = event.getClickedBlock().getLocation();
				if(isTable(loc)){
					//all of the above is true this is a crafting table and the player can now
					//try to match the recipes
					ItemStack itemInHand = player.getItemInHand();
					event.setCancelled(true);
					if(!RecipeStage.containsKey(player.getName()) || RecipeStage.get(player.getName()).equals("none")){
						if(itemInHand.getType().equals(Material.IRON_INGOT) && itemInHand.getItemMeta().getDisplayName().equals("Boost Sole")){
							player.setItemInHand(new ItemStack(Material.AIR));
							RecipeStage.put(player.getName(), "boostsole1");
						}
					}
					else if(RecipeStage.get(player.getName()).equals("boostsole1")){
						if(itemInHand.getType().equals(Material.AIR )){
							return;
						}
						else if(!itemInHand.getType().equals(Material.LEATHER_BOOTS )){
							RecipeStage.put((player.getName()), "none");
							player.sendMessage("You Broke it, now you have to start over");
							return;
							
						}
						ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
						ItemMeta bootsMeta = boots.getItemMeta();
						bootsMeta.setDisplayName("Power Boots v1");
						List<String> lore = new ArrayList<String>();
					    lore.add(ChatColor.DARK_AQUA + "uses 6");
					    bootsMeta.setLore(lore); 
						boots.setItemMeta(bootsMeta);
						player.setItemInHand(boots);
						player.sendMessage("You just created a pair of Power Boots v1");
						RecipeStage.put((player.getName()), "none");
					}
				}
			}
		}
	}
	//if it is a research table
	public boolean isTable(Location loc){
		loc.setY(loc.getY()-1);
		Block b1 = loc.getBlock();
		if(b1.getType().equals(Material.IRON_BLOCK)){
			return true;
		}
		return false;
	}
}
