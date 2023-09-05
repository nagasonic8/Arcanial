package arcanial.arcanial.events;

import arcanial.arcanial.Arcanial;
import arcanial.arcanial.Utils;
import arcanial.arcanial.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SuspiciousStewMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static arcanial.arcanial.Utils.color;


public class lootBoosts implements Listener {

    public lootBoosts(Arcanial plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    public static int multiplier = 1;
    public static int boost = 1;
    public static String type;
    public static String length;
    public static Long cooldown = 0L;
    public static Long currentTime;
    public static Long timeRemaining;
    public static boolean boosting = false;
    public static int minutes;
    public static int seconds;
    private Player player;

    @EventHandler
    public void onActivation(PlayerInteractEvent event){
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            player = event.getPlayer();
            ItemStack mainHand = player.getEquipment().getItemInMainHand();
            if (mainHand.getItemMeta().getDisplayName().equals(ItemManager.lootboost2x.getItemMeta().getDisplayName())){
                if (boosting == false){
                    mainHand.setAmount(mainHand.getAmount() - 1);
                    currentTime = System.currentTimeMillis();
                    cooldown = currentTime + 70000;
                    timeRemaining = cooldown - currentTime;
                    type = "2x";
                    length = "10 minutes";
                    boost = 2;
                    boosting = true;
                    Bukkit.getServer().broadcastMessage(color("&b---------------------&c&lArcanial&9&lMC&b---------------------"));
                    Bukkit.getServer().broadcastMessage(" ");
                    Bukkit.getServer().broadcastMessage(color("&e" + player.getName() + " &bhas started a " + type + " boost for " + length));
                    Bukkit.getServer().broadcastMessage(" ");
                    Bukkit.getServer().broadcastMessage(color("&b---------------------&c&lArcanial&9&lMC&b---------------------"));
                    for (Player player1 : Bukkit.getOnlinePlayers()){
                        player1.sendTitle(getTitle(""), getSubtitle(""));
                    }
                }else {
                    player.sendMessage(color("&cThere is already a boost. Please wait until that boost has ended."));
                    return;
                }
            }
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (timeRemaining > 0) {
                        currentTime = System.currentTimeMillis();
                        timeRemaining = cooldown - currentTime;
                        multiplier = boost;
                        updateTime();
                        if (timeRemaining == 60000L){
                            Bukkit.getServer().broadcastMessage(color("&b----------------------&c&lArcanial&9&lMC&b----------------------"));
                            Bukkit.getServer().broadcastMessage(" ");
                            Bukkit.getServer().broadcastMessage(color("&e&l" + type + " &r&bboost ending in 1 minute"));
                            Bukkit.getServer().broadcastMessage(" ");
                            Bukkit.getServer().broadcastMessage(color("&b----------------------&c&lArcanial&9&lMC&b----------------------"));
                        }else if (timeRemaining == 30000L){
                            Bukkit.getServer().broadcastMessage(color("&b----------------------&c&lArcanial&9&lMC&b----------------------"));
                            Bukkit.getServer().broadcastMessage(" ");
                            Bukkit.getServer().broadcastMessage(color("&e&l" + type + " &r&bboost ending in 30 seconds"));
                            Bukkit.getServer().broadcastMessage(" ");
                            Bukkit.getServer().broadcastMessage(color("&b----------------------&c&lArcanial&9&lMC&b----------------------"));
                        }else if (timeRemaining == 10000L){
                            Bukkit.getServer().broadcastMessage(color("&b----------------------&c&lArcanial&9&lMC&b----------------------"));
                            Bukkit.getServer().broadcastMessage(" ");
                            Bukkit.getServer().broadcastMessage(color("&e&l" + type + " &r&bboost ending in 10 seconds"));
                            Bukkit.getServer().broadcastMessage(" ");
                            Bukkit.getServer().broadcastMessage(color("&b----------------------&c&lArcanial&9&lMC&b----------------------"));
                        }else if (timeRemaining == 5000L){
                            Bukkit.getServer().broadcastMessage(color("&b----------------------&c&lArcanial&9&lMC&b----------------------"));
                            Bukkit.getServer().broadcastMessage(" ");
                            Bukkit.getServer().broadcastMessage(color("&e&l" + type + " &r&bboost ending in 5 seconds"));
                            Bukkit.getServer().broadcastMessage(" ");
                            Bukkit.getServer().broadcastMessage(color("&b----------------------&c&lArcanial&9&lMC&b----------------------"));
                        }else if (timeRemaining == 4000L){
                            Bukkit.getServer().broadcastMessage(color("&b----------------------&c&lArcanial&9&lMC&b----------------------"));
                            Bukkit.getServer().broadcastMessage(" ");
                            Bukkit.getServer().broadcastMessage(color("&e&l" + type + " &r&bboost ending in 4 seconds"));
                            Bukkit.getServer().broadcastMessage(" ");
                            Bukkit.getServer().broadcastMessage(color("&b----------------------&c&lArcanial&9&lMC&b----------------------"));
                        }else if (timeRemaining == 3000L){
                            Bukkit.getServer().broadcastMessage(color("&b----------------------&c&lArcanial&9&lMC&b----------------------"));
                            Bukkit.getServer().broadcastMessage(" ");
                            Bukkit.getServer().broadcastMessage(color("&e&l" + type + " &r&bboost ending in 3 seconds"));
                            Bukkit.getServer().broadcastMessage(" ");
                            Bukkit.getServer().broadcastMessage(color("&b----------------------&c&lArcanial&9&lMC&b----------------------"));
                        }else if (timeRemaining == 2000L){
                            Bukkit.getServer().broadcastMessage(color("&b----------------------&c&lArcanial&9&lMC&b----------------------"));
                            Bukkit.getServer().broadcastMessage(" ");
                            Bukkit.getServer().broadcastMessage(color("&e&l" + type + " &r&bboost ending in 2 seconds"));
                            Bukkit.getServer().broadcastMessage(" ");
                            Bukkit.getServer().broadcastMessage(color("&b----------------------&c&lArcanial&9&lMC&b----------------------"));
                        }else if (timeRemaining == 1000L){
                            Bukkit.getServer().broadcastMessage(color("&b----------------------&c&lArcanial&9&lMC&b----------------------"));
                            Bukkit.getServer().broadcastMessage(" ");
                            Bukkit.getServer().broadcastMessage(color("&e&l" + type + " &r&bboost ending in 1 seconds"));
                            Bukkit.getServer().broadcastMessage(" ");
                            Bukkit.getServer().broadcastMessage(color("&b----------------------&c&lArcanial&9&lMC&b----------------------"));
                        }
                    }else if (boosting == true){
                        timeRemaining = 0L;
                        boost = 1;
                        multiplier = 1;
                        boosting = false;
                        Bukkit.getServer().broadcastMessage(color("&b---------------------&c&lArcanial&9&lMC&b---------------------"));
                        Bukkit.getServer().broadcastMessage(" ");
                        Bukkit.getServer().broadcastMessage(color("&e&l" + type + " &r&bboost has ended."));
                        Bukkit.getServer().broadcastMessage(" ");
                        Bukkit.getServer().broadcastMessage(color("&b----------------------&c&lArcanial&9&lMC&b----------------------"));
                    }
                }
            }.runTaskTimer(Arcanial.getPlugin(), 0L, 20L);
        }
    }
    private void updateTime(){
        if (timeRemaining >= 60000L){
             minutes = timeRemaining.intValue() / 60000;
             seconds = timeRemaining.intValue() % 60000 / 1000;
        }else {
            minutes = 0;
            seconds = timeRemaining.intValue() / 1000;
        }
    }
    private String getTitle(String title){
        title = color("&e&l" + type + " boost started!");
        return title;
    }
    private String getSubtitle(String subtitle){
        subtitle = color("&bBy " + player.getName());
        return subtitle;
    }
}
