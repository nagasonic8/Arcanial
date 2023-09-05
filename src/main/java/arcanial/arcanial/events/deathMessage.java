package arcanial.arcanial.events;

import arcanial.arcanial.Arcanial;
import arcanial.arcanial.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;


public class deathMessage implements Listener {
    public deathMessage(Arcanial plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        Player player = event.getEntity();
        if (player.getKiller() instanceof Player){
            String killerName = player.getKiller().getName();
            String name = player.getName();
            ItemStack killItem = player.getKiller().getItemInHand();
            String mainhand = killItem.getItemMeta().getDisplayName();
            if (mainhand != null){
                event.setDeathMessage(Utils.color("&c" + killerName + " ⚔ " + name + " using " + mainhand));
            }else {
                event.setDeathMessage(Utils.color("&c" + killerName + " ⚔ " + name));
            }
        }
    }
}
