package dk.benjaminbreuner.science;

import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


//TODO fix error  Could not pass event PlayerMoveEvent to Science when player does not wear powerBoots
public class PowerBootsManager implements Listener{
	HashMap<String, String> inJump = new HashMap<String, String>();
	@EventHandler // if the player have Power Boots equipped then moving give them jump boost
	public void onPlayerMove(PlayerMoveEvent event){
		Player player = event.getPlayer();
		if (player.getInventory().getBoots().getItemMeta().getDisplayName().equals("Power Boots v1")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,50,16));
	        if(event.getTo().getBlockY()>event.getFrom().getBlockY()){
	        	if( !inJump.containsKey(player.getName()) || inJump.get(player.getName()).equals("not jumping")){
	        		inJump.put(player.getName(), "jumping");
	        		ItemStack boots = player.getInventory().getBoots();
	        		updateLore(player, boots);
	        	}
	        }
	        //if the player is in a jump and is falling down this sets them as not jumping
	        if(event.getTo().getBlockY()<event.getFrom().getBlockY()){
	        	if(inJump.get(player.getName())=="jumping"){
	        		inJump.put(player.getName(), "not jumping");
	        	}
	        }
		}
		return;
	}
	//will reduce the uses of Power boots
	public void updateLore(Player player, ItemStack item){
		ItemMeta im = item.getItemMeta();
		List<String> lore = im.getLore();
		if(lore.contains(ChatColor.DARK_AQUA + "uses 6")){
			lore.remove(ChatColor.DARK_AQUA + "uses 6");
			lore.add(ChatColor.DARK_AQUA + "uses 5");
		}
		else if(lore.contains(ChatColor.DARK_AQUA + "uses 5")){
			lore.remove(ChatColor.DARK_AQUA + "uses 5");
			lore.add(ChatColor.DARK_AQUA + "uses 4");
		}
		else if(lore.contains(ChatColor.DARK_AQUA + "uses 4")){
			lore.remove(ChatColor.DARK_AQUA + "uses 4");
			lore.add(ChatColor.DARK_AQUA + "uses 3");
		}
		else if(lore.contains(ChatColor.DARK_AQUA + "uses 3")){
			lore.remove(ChatColor.DARK_AQUA + "uses 3");
			lore.add(ChatColor.DARK_AQUA + "uses 2");
		}
		else if(lore.contains(ChatColor.DARK_AQUA + "uses 2")){
			lore.remove(ChatColor.DARK_AQUA + "uses 2");
			lore.add(ChatColor.DARK_AQUA + "uses 1");
		}
		else if(lore.contains(ChatColor.DARK_AQUA + "uses 1")){
			player.getInventory().setBoots(new ItemStack(Material.AIR));
			return;
		}
		im.setLore(lore);
		item.setItemMeta(im);
		player.getInventory().setBoots(item);
	}
}
