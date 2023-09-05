package arcanial.arcanial.events;

import arcanial.arcanial.Arcanial;
import arcanial.arcanial.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Bukkit.getPluginManager;

public class mobDrops implements Listener {
    public mobDrops(Arcanial plugin) {
        getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void mobDeath(EntityDeathEvent event) {
        event.getDrops().clear();
        event.setDroppedExp(0);
        LivingEntity entity = event.getEntity();
        Server server = Bukkit.getServer();

        if (entity instanceof Zombie){
            if (entity.getCustomName().equals("§9§lWet Zombie")){
                if (entity.getKiller() instanceof Player){
                    Player player = entity.getKiller();
                    Inventory inv = player.getInventory();
                    int max = 3, min = 1, range = max - min + 1;
                    ItemStack item = ItemManager.watermolecule;
                    item.setAmount((int)(Math.random() * range) + min);
                    item.setAmount(item.getAmount() * lootBoosts.multiplier);
                    inv.addItem(item);
                    int xpmax = 10, xpmin = 5, xprange = xpmax = xpmin + 1;
                    int amount = (int)(Math.random() * xprange) + xpmin;
                    server.dispatchCommand(server.getConsoleSender(), "clv addExp " + amount + " " + player.getName());
                }else{

                }

            }
        }else if (entity instanceof Stray){
            if (entity.getCustomName().equals("§b§lCold Skeleton")){
                Player player = entity.getKiller();
                Inventory inv = player.getInventory();
                inv.addItem(ItemManager.frozendrop);
            }
        }
    }
}
