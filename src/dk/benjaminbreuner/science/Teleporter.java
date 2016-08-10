package dk.benjaminbreuner.science;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


public class Teleporter implements Listener{
	@EventHandler
	public void PlayerRightClick(PlayerInteractEvent event){
		Player player = event.getPlayer();
		if(isTeleporter(event) && player.isOp()) {
			player.sendMessage("this is a teleporter");
		}
	}
	
	public boolean isTeleporter(PlayerInteractEvent event){
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(event.getClickedBlock().getType().equals(Material.REDSTONE_BLOCK)){
				//find better way to do this
				Location loc = event.getClickedBlock().getLocation();
				Location loc1 = loc;
				Location loc2 = loc;
				Location loc3 = loc;
				Location loc4 = loc;
				Location loc5 = loc;
				Location loc6 = loc;
				Location loc7 = loc;
				Location loc8 = loc;
				Location loc9 = loc;
				Location loc10 = loc;
				Location loc11 = loc;
				Location loc12 = loc;
				Location loc13 = loc;
				Location loc14 = loc;
				Location loc15 = loc;
				Location loc16 = loc;
				Location loc17 = loc;
				loc1.setY(loc1.getY()-1);
				loc2.setX(loc2.getX()-1);
				loc3.setX(loc3.getX()-1);
				loc3.setZ(loc3.getZ()-1);
				loc4.setZ(loc4.getZ()-1);
				loc5.setZ(loc5.getZ()-1);
				loc5.setX(loc5.getX()+1);
				loc6.setX(loc6.getX()+1);
				loc7.setX(loc7.getX()+1);
				loc7.setZ(loc7.getZ()+1);
				loc8.setZ(loc8.getZ()+1);
				loc9.setX(loc9.getX()-1);
				loc9.setZ(loc9.getZ()+1);
				Block b1 = loc1.getBlock();
				Block b2 = loc2.getBlock();
				Block b3 = loc3.getBlock();
				Block b4 = loc4.getBlock();
				Block b5 = loc5.getBlock();
				Block b6 = loc6.getBlock();
				Block b7 = loc7.getBlock();
				Block b8 = loc8.getBlock();
				Block b9 = loc9.getBlock();
				if(b1.getType().equals(Material.NOTE_BLOCK) && b2.getType().equals(Material.REDSTONE_LAMP_ON)){
					
					return true;
				}
			}
		}
		return false;
	}
}
