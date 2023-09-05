package arcanial.arcanial.commands;

import arcanial.arcanial.items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class bubbleitems implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            ItemStack item = (ItemManager.watermolecule);
            ItemStack item1 = (ItemManager.bubble);
            item.setAmount(64);
            item1.setAmount(64);
            Inventory inv = player.getInventory();
            inv.addItem(item);
            inv.addItem(item1);
        } else {
            sender.sendMessage("Only players can run this command.");
        }
        return false;
    }
}
