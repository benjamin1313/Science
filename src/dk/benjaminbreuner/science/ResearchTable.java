package dk.benjaminbreuner.science;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ResearchTable implements Listener{
	@EventHandler
	public void PlayerRightClick(PlayerInteractEvent event) {
		if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(event.getClickedBlock().getType().equals(Material.CARPET)){
				Location loc = event.getClickedBlock().getLocation();
				if(isTable(loc)){
					event.getPlayer().sendMessage("You found a Research Table");
				}
			}
		}
	}
	public boolean isTable(Location loc){
		loc.setY(loc.getY()-1);
		Block b1 = loc.getBlock();
		if(b1.getType().equals(Material.IRON_BLOCK)){
			return true;
		}
		return false;
	}
}
