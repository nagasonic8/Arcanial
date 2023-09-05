package arcanial.arcanial.events;

import arcanial.arcanial.Arcanial;
import arcanial.arcanial.items.ItemManager;
import arcanial.arcanial.mobs.EndCrystals;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class FireEndCrystalPlace implements Listener {
    public FireEndCrystalPlace(Arcanial plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onRightClick(PlayerInteractEvent event){
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            Player player = event.getPlayer();
            if (player.getItemInUse().equals(ItemManager.fireendcrystal)){
                Block block = event.getClickedBlock();
                Location loc = block.getLocation();
                EndCrystals.createFireEndCrystal(loc.add(0, 1, 0));
            }
        }
    }
}
