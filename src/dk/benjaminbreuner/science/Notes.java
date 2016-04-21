package dk.benjaminbreuner.science;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.BookMeta;

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
    		 	Player player = (Player) event.getPlayer(); 
    		 	GiveNote1(player);
    		 	
    		 }
    	 }
	}
    public void GiveNote1(Player p){
    	ItemStack note = new ItemStack(Material.WRITTEN_BOOK);
	 	BookMeta meta = (BookMeta)note.getItemMeta();
	 	meta.setTitle("Research  notes");
        meta.setAuthor("Scientist");
        meta.setPages("My studies show that there are a lot of potential energi in magma_cream. "
        		+ "that might could be used in some items",
        		"further research have show that it is possible to realease the potential energi in magma_cream in a small burst "
        		+ "i can't wait to get started playing aroud with it",
        		"This is a great day my team and i just createt a pair of boots that ueses magma_cream and in theory they should be able to launch a parson a few feet in the air",
        		"success! The boots works. kinda. Bob did take some dammage and they are only good for a few jumps.",
        		"sadly this will be my last notes for this project. "
        		+ "the project have been shut down because of Bobs accident and i won't be able to continue on my own. "
        		+ "I have left some instructions on how the boots are made on the next page",
        		"by combining magma_cream and a iron_igot you create a sole that can be placed under a pair of shoes");
        note.setItemMeta(meta);
        PlayerInventory inventory = p.getInventory(); 
        inventory.addItem(note);
    }
}
