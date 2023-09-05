package arcanial.arcanial.commands;

import arcanial.arcanial.items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class kit implements CommandExecutor {

    private HashMap<UUID, Long> cooldown;

    public kit() {
        this.cooldown = new HashMap<>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only Players can run this command");
            return true;
        }
        Player player = (Player) sender;
        if (player.hasPermission("is.staff")){
            ItemStack item = new ItemStack(ItemManager.novicesword);
            ItemStack item1 = new ItemStack(ItemManager.novicehelmet);
            ItemStack item2 = new ItemStack(ItemManager.novicechestplate);
            ItemStack item3 = new ItemStack(ItemManager.noviceleggings);
            ItemStack item4 = new ItemStack(ItemManager.noviceboots);
            Inventory inv = player.getInventory();
            inv.addItem(item);
            inv.addItem(item1);
            inv.addItem(item2);
            inv.addItem(item3);
            inv.addItem(item4);
            return true;
        }
        if (!this.cooldown.containsKey(player.getUniqueId())) {
            this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());

            ItemStack item = new ItemStack(ItemManager.novicesword);
            ItemStack item1 = new ItemStack(ItemManager.novicehelmet);
            ItemStack item2 = new ItemStack(ItemManager.novicechestplate);
            ItemStack item3 = new ItemStack(ItemManager.noviceleggings);
            ItemStack item4 = new ItemStack(ItemManager.noviceboots);
            Inventory inv = player.getInventory();
            inv.addItem(item);
            inv.addItem(item1);
            inv.addItem(item2);
            inv.addItem(item3);
            inv.addItem(item4);
            return true;
        }else{

            long timeElapsed = System.currentTimeMillis() - cooldown.get(player.getUniqueId());
            //10 minutes
            if (timeElapsed >= 600000){

                this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                ItemStack item = new ItemStack(ItemManager.novicesword);
                ItemStack item1 = new ItemStack(ItemManager.novicehelmet);
                ItemStack item2 = new ItemStack(ItemManager.novicechestplate);
                ItemStack item3 = new ItemStack(ItemManager.noviceleggings);
                ItemStack item4 = new ItemStack(ItemManager.noviceboots);
                Inventory inv = player.getInventory();
                inv.addItem(item);
                inv.addItem(item1);
                inv.addItem(item2);
                inv.addItem(item3);
                inv.addItem(item4);
                return true;
            }else{
                player.sendMessage("§cYou can't claim /kit for another " + ((600000 - timeElapsed) / 1000) + " seconds.");
                return true;
            }
        }
    }
}