package dk.benjaminbreuner.science;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemRecipes{
	
	// TODO tag stilling til om powerBoots skal lavet på chemicalWorkbench eller creafting table
	//public void chemicalWorkbench(){
	//	ItemStack Iblock = new ItemStack(Material.IRON_BLOCK);
	//	ItemMeta IblockMeta = Iblock.getItemMeta();
	//	IblockMeta.setDisplayName("Chemical Workbench");
	//	Iblock.setItemMeta(IblockMeta);
	//	
	//	ShapedRecipe CWrecipe = new ShapedRecipe(Iblock);
	//	CWrecipe.shape("###","! !");
	//	CWrecipe.setIngredient('#', Material.WOOD);
	//	CWrecipe.setIngredient('!', Material.STICK);
	//	Bukkit.getServer().addRecipe(CWrecipe);
	//}
	
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
	// TODO skal havde gjort sådan at denne recipe kun virker med Boost sole 
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
