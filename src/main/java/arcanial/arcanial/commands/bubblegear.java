package arcanial.arcanial.commands;

import arcanial.arcanial.items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class bubblegear implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            ItemStack item = (ItemManager.bubblesword);
            ItemStack item1 = (ItemManager.bubblehelmet);
            ItemStack item2 = (ItemManager.bubblechestplate);
            ItemStack item3 = (ItemManager.bubbleleggings);
            ItemStack item4 = (ItemManager.bubbleboots);
            Inventory inv = player.getInventory();
            inv.addItem(item);
            inv.addItem(item1);
            inv.addItem(item2);
            inv.addItem(item3);
            inv.addItem(item4);
        }else{
            sender.sendMessage("Only players can run this command.");
        }
        return true;
    }
}
