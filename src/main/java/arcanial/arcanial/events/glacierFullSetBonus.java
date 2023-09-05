package arcanial.arcanial.events;

import arcanial.arcanial.Arcanial;
import arcanial.arcanial.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class glacierFullSetBonus implements Listener {

    public glacierFullSetBonus(Arcanial plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void playerDamage(EntityDamageByEntityEvent event){
        if (event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            Entity damager = event.getDamager();
            EntityEquipment equipment = player.getEquipment();
            ItemStack helmet = equipment.getHelmet();
            ItemStack chest = equipment.getChestplate();
            ItemStack legs = equipment.getLeggings();
            ItemStack boots = equipment.getBoots();
            PotionEffect effect = new PotionEffect(PotionEffectType.SLOW, 3 * 20, 2, false, false, false);
            if (helmet.equals(ItemManager.glaciermask) && chest.equals(ItemManager.glacierchestplate) && legs.equals(ItemManager.glacierleggings) && boots.equals(ItemManager.glacierboots)){
                if (damager instanceof Mob) {
                    Mob mob = (Mob) event.getDamager();
                    mob.addPotionEffect(effect);
                }else if (damager instanceof Player){
                    Player entity = (Player) event.getDamager();
                    entity.addPotionEffect(effect);
                }
            }
        }
    }
}
