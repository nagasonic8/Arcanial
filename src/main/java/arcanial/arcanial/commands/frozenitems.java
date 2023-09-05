package arcanial.arcanial.commands;

import arcanial.arcanial.items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class frozenitems implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            Inventory inv = player.getInventory();
            ItemStack item = (ItemManager.frozendrop);
            ItemStack item1 = (ItemManager.snowball);
            item.setAmount(64);
            item1.setAmount(64);
            inv.addItem(item);
            inv.addItem(item1);
        }else {
            sender.sendMessage("Only players can run this command.");
        }
        return true;
    }
}
