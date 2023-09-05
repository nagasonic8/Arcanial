package arcanial.arcanial.events;

import arcanial.arcanial.Arcanial;
import arcanial.arcanial.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static arcanial.arcanial.Utils.color;
import static org.bukkit.Bukkit.getPluginManager;

public class rankVouchers implements Listener {
    public rankVouchers(Arcanial plugin){
        getPluginManager().registerEvents(this, plugin);
    }
    private Server server = Bukkit.getServer();

    @EventHandler
    public void onRightClick(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR)){
            ItemStack item = player.getItemInHand();
            String name = item.getItemMeta().getDisplayName();
            if (name.equalsIgnoreCase(ItemManager.overlordrankvoucher.getItemMeta().getDisplayName())){
                if (!player.hasPermission("is.owner") || !player.hasPermission("is.admin") || !player.hasPermission("is.headmod") || !player.hasPermission("is.mod") || !player.hasPermission("is.trainee") || !player.hasPermission("is.builder")){
                    String PlayerName = player.getName();
                    item.setAmount(item.getAmount() - 1);
                    server.dispatchCommand(server.getConsoleSender(), "lp user " + PlayerName + " parent add overlord");
                }else player.sendMessage(color("&cYou have a better rank than this one."));
            }else if (name.equalsIgnoreCase(ItemManager.oblivionrankvoucher.getItemMeta().getDisplayName())){
                if (!player.hasPermission("is.owner") || !player.hasPermission("is.admin") || !player.hasPermission("is.headmod") || !player.hasPermission("is.mod") || !player.hasPermission("is.trainee") || !player.hasPermission("is.builder") || !player.hasPermission("is.overlord")){
                    String PlayerName = player.getName();
                    item.setAmount(item.getAmount() - 1);
                    server.dispatchCommand(server.getConsoleSender(), "lp user " + PlayerName + " parent add oblivion");
                }else player.sendMessage(color("&cYou have a better rank than this one."));
            }else if (name.equalsIgnoreCase(ItemManager.legendrankvoucher.getItemMeta().getDisplayName())){
                if (!player.hasPermission("is.owner") || !player.hasPermission("is.admin") || !player.hasPermission("is.headmod") || !player.hasPermission("is.mod") || !player.hasPermission("is.trainee") || !player.hasPermission("is.builder") || !player.hasPermission("is.overlord") || !player.hasPermission("is.legend")) {
                    String PlayerName = player.getName();
                    item.setAmount(item.getAmount() - 1);
                    server.dispatchCommand(server.getConsoleSender(), "lp user " + PlayerName + " parent add legend");
                }else player.sendMessage(color("&cYou have a better rank than this one."));
            }else if (name.equalsIgnoreCase(ItemManager.herorankvoucher.getItemMeta().getDisplayName())){
                if (!player.hasPermission("is.owner") || !player.hasPermission("is.admin") || !player.hasPermission("is.headmod") || !player.hasPermission("is.mod") || !player.hasPermission("is.trainee") || !player.hasPermission("is.builder") || !player.hasPermission("is.overlord") || !player.hasPermission("is.legend") || !player.hasPermission("is.hero")) {
                    String PlayerName = player.getName();
                    item.setAmount(item.getAmount() - 1);
                    server.dispatchCommand(server.getConsoleSender(), "lp user " + PlayerName + " parent add hero");
                }else player.sendMessage(color("&cYou have a better rank than this one."));
            }else if (name.equalsIgnoreCase(ItemManager.masterrankvoucher.getItemMeta().getDisplayName())){
                if (!player.hasPermission("is.owner") || !player.hasPermission("is.admin") || !player.hasPermission("is.headmod") || !player.hasPermission("is.mod") || !player.hasPermission("is.trainee") || !player.hasPermission("is.builder") || !player.hasPermission("is.overlord") || !player.hasPermission("is.legend") || !player.hasPermission("is.hero") || !player.hasPermission("is.master")) {
                    String PlayerName = player.getName();
                    item.setAmount(item.getAmount() - 1);
                    server.dispatchCommand(server.getConsoleSender(), "lp user " + PlayerName + " parent add master");
                }else player.sendMessage(color("&cYou have a better rank than this one."));
            }else if (name.equalsIgnoreCase(ItemManager.apprenticerankvoucher.getItemMeta().getDisplayName())){
                if (!player.hasPermission("is.owner") || !player.hasPermission("is.admin") || !player.hasPermission("is.headmod") || !player.hasPermission("is.mod") || !player.hasPermission("is.trainee") || !player.hasPermission("is.builder") || !player.hasPermission("is.overlord") || !player.hasPermission("is.legend") || !player.hasPermission("is.hero") || !player.hasPermission("is.master") || !player.hasPermission("is.apprentice")) {
                    String PlayerName = player.getName();
                    item.setAmount(item.getAmount() - 1);
                    server.dispatchCommand(server.getConsoleSender(), "lp user " + PlayerName + " parent add master");
                }else player.sendMessage(color("&cYou have a better rank than this one."));
            }
        }
    }
}
