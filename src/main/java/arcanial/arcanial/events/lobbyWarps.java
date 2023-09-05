package arcanial.arcanial.events;

import arcanial.arcanial.Arcanial;
import arcanial.arcanial.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import static arcanial.arcanial.Utils.color;

public class lobbyWarps implements Listener {
    public lobbyWarps(Arcanial plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onVillagerInteract(PlayerInteractEntityEvent event){
        Player player = event.getPlayer();
        if (event.getRightClicked().getCustomName().equalsIgnoreCase("&c&lArcanial&9&lSurvival")){
            World world = Bukkit.getWorld("smp");
            player.sendMessage(color("&aSending you to ArcanialSurvival"));
            Location loc = world.getSpawnLocation().clone().add(0.5, 0, 0.5);
            player.teleport(loc);
        } else if (event.getRightClicked().getCustomName().equalsIgnoreCase("&c&lArcanial&9&lRPG")) {
            World world = Bukkit.getWorld("rpgspawn");
            player.sendMessage(color("&aSending you to ArcanialRPG"));
            Location loc = world.getSpawnLocation().clone().add(0.5, 0, 0.5);
            player.teleport(loc);
        }
    }
}
