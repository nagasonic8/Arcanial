package arcanial.arcanial.commands;

import arcanial.arcanial.items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

import static arcanial.arcanial.Utils.color;

public class rank implements CommandExecutor {

    private HashMap<UUID, Long> cooldown;

    public rank(){
        this.cooldown = new HashMap<>();
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only players can run this command.");
            return true;
        }

        Player player = (Player) sender;

        if (!this.cooldown.containsKey(player.getUniqueId())){
            this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
            ItemStack item = new ItemStack(ItemManager.rankcoin);
            Inventory inv = player.getInventory();
            if (player.hasPermission("is.staff")){
                item.setAmount(128);
                inv.addItem(item);
            }else if (player.hasPermission("is.overlord")){
                item.setAmount(64);
                inv.addItem(item);
            }else if (player.hasPermission("is.oblivion")){
                item.setAmount(32);
                inv.addItem(item);
            }else if (player.hasPermission("is.legend")){
                item.setAmount(16);
                inv.addItem(item);
            }else if (player.hasPermission("is.hero")){
                item.setAmount(8);
                inv.addItem(item);
            }else if (player.hasPermission("is.master")){
                item.setAmount(4);
                inv.addItem(item);
            }else if (player.hasPermission("is.apprentice")){
                item.setAmount(2);
                inv.addItem(item);
            }else{
                player.sendMessage(color("&cYou do not have a rank."));
            }
            return true;
        }else {
            long timeElapsed = System.currentTimeMillis() - cooldown.get(player.getUniqueId());
            if (timeElapsed >= 86400000){
                this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                ItemStack item = new ItemStack(ItemManager.rankcoin);
                Inventory inv = player.getInventory();
                if (player.hasPermission("is.staff")){
                    item.setAmount(128);
                    inv.addItem(item);
                }else if (player.hasPermission("is.overlord")){
                    item.setAmount(64);
                    inv.addItem(item);
                }else if (player.hasPermission("is.oblivion")){
                    item.setAmount(32);
                    inv.addItem(item);
                }else if (player.hasPermission("is.legend")){
                    item.setAmount(16);
                    inv.addItem(item);
                }else if (player.hasPermission("is.hero")){
                    item.setAmount(8);
                    inv.addItem(item);
                }else if (player.hasPermission("is.master")){
                    item.setAmount(4);
                    inv.addItem(item);
                }else if (player.hasPermission("is.apprentice")){
                    item.setAmount(2);
                    inv.addItem(item);
                }else{
                    player.sendMessage(color("&cYou do not have a rank."));
                }
                return true;
            }else {
                if (timeElapsed > 82800000){
                    player.sendMessage("§cYou can't claim /rank for another " + ((86400000 - timeElapsed) / 60000) + " minutes.");
                    return true;
                }else if (timeElapsed > 86340000){
                    player.sendMessage("§cYou can't claim /rank for another " + ((86400000 - timeElapsed) / 1000) + " seconds");
                    return true;
                }else {
                    player.sendMessage("§cYou can't claim /rank for another " + ((86400000 - timeElapsed) / 3600000) + " hours");
                    return true;
                }
            }
        }
    }
}
