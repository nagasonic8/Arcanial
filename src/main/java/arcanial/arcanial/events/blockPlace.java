package arcanial.arcanial.events;

import arcanial.arcanial.Arcanial;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static arcanial.arcanial.Utils.color;

public class blockPlace implements Listener {
    public blockPlace(Arcanial plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        Player player = event.getPlayer();
        if (!player.hasPermission("can.build")){
            player.sendMessage(color("&c<&4&lArcanial&9&lMC&c> You do not have permission to do this."));
            event.setCancelled(true);
        }
    }
}
