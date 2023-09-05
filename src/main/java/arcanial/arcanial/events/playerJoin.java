package arcanial.arcanial.events;

import arcanial.arcanial.Arcanial;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

import static org.bukkit.Bukkit.getOfflinePlayers;
import static org.bukkit.Bukkit.getPluginManager;

public class playerJoin implements Listener {
    public playerJoin(Arcanial plugin) {
        getPluginManager().registerEvents(this, plugin);
    }
    private World world = Bukkit.getWorld("lobby");
    double xOffset = 0.5, zOffset = 0.5;
    private Server server = Bukkit.getServer();
    private Location spawn = world.getSpawnLocation().clone().add(xOffset, 1, zOffset);
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPlayedBefore()) {
            event.setJoinMessage("§7{§a+§7} " + player.getName());
            player.teleport(spawn);
        }else if (!player.hasPlayedBefore()){
            int players = 0;
            for (OfflinePlayer offlinePlayer : getOfflinePlayers()){
                int i = ++players;
                players = i;
            }
            event.setJoinMessage("§4{§9+§4} §cWelcome " + ChatColor.BLUE + player.getName() + " §dto §4Arcanial§9MC §c[#" + players + "§c]");


            player.sendMessage("§e~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            player.sendMessage("        §c§lWelcome to §4§lArcanial§9§lMC      ");
            player.sendMessage("§cTo get started, do /kit to get starter gear. ");
            player.sendMessage("§cOnce you have done that, head through the    ");
            player.sendMessage("                §cwater portal.                ");
            player.sendMessage("§cGo to the starting zone, it should look like ");
            player.sendMessage("             §cwater made of glass.            ");
            player.sendMessage("  §cKill the mobs in the zone to collect their ");
            player.sendMessage("      §cloot, then trade the loot in for       ");
            player.sendMessage("              §cupgraded armor.                ");
            player.sendMessage("§e~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            player.teleport(spawn);
        }
    }
}
