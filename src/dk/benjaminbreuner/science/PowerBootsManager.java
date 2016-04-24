package dk.benjaminbreuner.science;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PowerBootsManager implements Listener{
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event){
		Player player = event.getPlayer();
		if (player.getInventory().getBoots().getItemMeta().getDisplayName().equals("Power Boots v1")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,500,16));
		}else{
			return;
		}
	}
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event){
		if(event.getEntity() instanceof Player){
			Player player = (Player) event.getEntity();
			if (event.getCause() == DamageCause.FALL){
				if (player.getInventory().getBoots().getItemMeta().getDisplayName().equals("Power Boots v1")){
					player.getInventory().getBoots().setDurability(((short)(player.getInventory().getBoots().getDurability()-1)));
					player.sendMessage("damage");
				}
			}
		}
	}
}
