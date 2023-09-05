package arcanial.arcanial.events;

import arcanial.arcanial.Arcanial;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import static arcanial.arcanial.Utils.color;

public class blockBreak implements Listener {
    public blockBreak(Arcanial plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        if (!player.hasPermission("can.break")){
            event.setCancelled(true);
            player.sendMessage(color("&c<&4&lArcanial&9&lMC&c> You do not have permission to do this."));
        }
    }
}
