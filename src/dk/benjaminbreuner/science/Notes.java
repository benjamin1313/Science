package dk.benjaminbreuner.science;

import java.util.ArrayList;
import java.util.List;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.BookMeta;

public class Notes implements Listener{
    @EventHandler //if the player Right click on a villager they have a chance to receive
    //a  random book with Research notes
    public void PlayerRightClick(PlayerInteractEntityEvent event) {
    	 if(event.getRightClicked() instanceof Villager){
    //TODO Remove breakpoints when finished with testing
    //		 int lower = 0;
    //		 int upper = 10;
   // 		 int number1 = (int) (Math.random() * upper) + lower;
    		 int number1 = 1; 
    		 if (number1 == 1) {
    			event.getPlayer().sendMessage("I found this old thing");
    		 	event.getPlayer().sendMessage("It's yours if you want it");
    		 	event.setCancelled(true);
    		 	
    			int i = 1;
    			if ( i == i) {
    				int e = i; }
    			
    		 	
    		 	Player player = (Player) event.getPlayer(); 
    		 	GiveNote1(player);
    		 	
    		 }
    	 }
	}
    //Research  notes
    public void GiveNote1(Player p){
    	ItemStack note = new ItemStack(Material.WRITTEN_BOOK);
	 	BookMeta meta = (BookMeta)note.getItemMeta();
	 	meta.setTitle("Research notes");
        meta.setAuthor(/*ChatColor.DARK_AQUA*/  "Scientist " + ChatColor.AQUA + "Benjamin");
        List<String> lore = new ArrayList<String>();
		  lore.add(ChatColor.GREEN + "This is a ragged book");
		  lore.add(ChatColor.GREEN + "It looks like it has been in a box for 50 years");
        meta.setLore(lore);
        meta.setPages("My studies show that there are a lot of potential energi in" + ChatColor.DARK_BLUE + " Magma_Cream. " + ChatColor.BLACK
        		+ "That could be used in some items",
        		"Further research have shown that it is possible to realease the potential energi in" + ChatColor.DARK_BLUE + " Magma_Cream" + ChatColor.BLACK + " in a small bursts. "
        		+ "I can't wait to start playing around with it",
        		"This is a great day, my team and i just created a pair of boots that uses" + ChatColor.DARK_BLUE + " Magma_Cream " + ChatColor.BLACK + "and in theory they should be able to launch a person a few feet into the air",
        		"Success! The boots worked."
        		+ "Kinda.."
        		+ "Bob did take some dammage and they are only good for a few jumps.",
        		"Sadly this will be my last notes for this project. "
        		+ "The project have been shut down, because of Bob's accident, and i won't be able to continue on my own. "
        		+ "I have left some instructions on how the boots are made on the next page",
        		"By combining " + ChatColor.DARK_BLUE + "Magma_Cream" + ChatColor.BLACK + " and an " + ChatColor.DARK_BLUE + "Iron_Ingot" + ChatColor.BLACK + " in the Research Table you create a sole that can be placed under a pair of shoes");
        note.setItemMeta(meta);
        PlayerInventory inventory = p.getInventory(); 
        inventory.addItem(note);
    }

		
}
