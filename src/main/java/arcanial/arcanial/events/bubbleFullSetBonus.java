package arcanial.arcanial.events;

import arcanial.arcanial.Arcanial;
import arcanial.arcanial.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class bubbleFullSetBonus implements Listener {

    private final HashMap<UUID, Long> cooldown;

    public bubbleFullSetBonus(Arcanial plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.cooldown = new HashMap<>();
    }

    @EventHandler
    public void playerDamage(EntityDamageByEntityEvent event){
        if (event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            EntityEquipment equipment = player.getEquipment();
            ItemStack helmet = equipment.getHelmet();
            ItemStack chest = equipment.getChestplate();
            ItemStack legs = equipment.getLeggings();
            ItemStack boots = equipment.getBoots();
            if (helmet.equals(ItemManager.bubblehelmet) && chest.equals(ItemManager.bubblechestplate) && legs.equals(ItemManager.bubbleleggings) && boots.equals(ItemManager.bubbleboots)){
                if (!this.cooldown.containsKey(player.getUniqueId())){
                    this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());

                    event.setCancelled(true);
                }else {
                    long timeElapsed = System.currentTimeMillis() - cooldown.get(player.getUniqueId());
                    if (timeElapsed >= 20000){
                        this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
