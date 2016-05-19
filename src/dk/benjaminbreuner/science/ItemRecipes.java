package dk.benjaminbreuner.science;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemRecipes{
	
	public void boostSole(){
		ItemStack ingot = new ItemStack(Material.IRON_INGOT);
		ItemMeta ingotMeta = ingot.getItemMeta();
		ingotMeta.setDisplayName("Boost Sole");
		ingot.setItemMeta(ingotMeta);
		ShapelessRecipe soleRecipe = new ShapelessRecipe(ingot);
		soleRecipe.addIngredient(Material.MAGMA_CREAM);
		soleRecipe.addIngredient(Material.IRON_INGOT);
		Bukkit.getServer().addRecipe(soleRecipe);
		
	}
    //crafting table recipe for PowerBoots
	//public void powerBootsV1(){
	//	ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
	//	ItemMeta bootsMeta = boots.getItemMeta();
	//	bootsMeta.setDisplayName("Power Boots v1");
	//	boots.setItemMeta(bootsMeta);
	//	ShapelessRecipe bootsRecipe = new ShapelessRecipe(boots);
	//	bootsRecipe.addIngredient(Material.IRON_INGOT);
	//	bootsRecipe.addIngredient(Material.LEATHER_BOOTS);
	//	Bukkit.getServer().addRecipe(bootsRecipe);
	//}
	
}
