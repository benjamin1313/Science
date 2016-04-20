package dk.benjaminbreuner.science;

import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class Notes implements Listener{
    @EventHandler
    public void PlayerRightClick(PlayerInteractEntityEvent event) {
    	 if(event.getRightClicked() instanceof Villager){
    		 int lower = 0;
    		 int upper = 10;
    		 int number1 = (int) (Math.random() * upper) + lower;
    		 if (number1 == 1) {
    			 event.getPlayer().sendMessage("I found this old thing");
    		 	event.getPlayer().sendMessage("It's yours if you want it");
    		 	event.setCancelled(true);
    		 }
    	 }
	}
}
