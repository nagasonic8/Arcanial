package arcanial.arcanial.commands;

import arcanial.arcanial.Utils;
import arcanial.arcanial.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static arcanial.arcanial.Utils.color;


public class giveitem implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = Bukkit.getPlayer(args[2]);
        if (player == null) {
            player.sendMessage(color("&cCouldn't find a player named " + args[2]));
        }
        String itemName = args[0];
        int amount = Integer.parseInt(args[1]);
        if (args.length != 3) {
            player.sendMessage(color("&cCorrect usage: /giveitem <item> <amount>"));
        } else {
            if (itemName.equalsIgnoreCase("watermolecule")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.watermolecule;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("bubble")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.bubble;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("bubblesword")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.bubblesword;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("bubblehelmet")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.bubblehelmet;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("bubblechestplate")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.bubblechestplate;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("bubbleleggings")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.bubbleleggings;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("bubbleboots")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.bubbleboots;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("novicesword")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.novicesword;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("novicehelmet")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.novicehelmet;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("novicechestplate")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.novicechestplate;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("noviceleggings")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.noviceleggings;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("noviceboots")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.noviceboots;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("rankcoin")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.rankcoin;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("overlordrankvoucher")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.overlordrankvoucher;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("oblivionrankvoucher")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.oblivionrankvoucher;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("legendrankvoucher")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.legendrankvoucher;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("herorankvoucher")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.herorankvoucher;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("masterrankvoucher")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.masterrankvoucher;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("apprenticerankvoucher")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.apprenticerankvoucher;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("dailycratekey")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.dailycratekey;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("watercratekey")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.watercratekey;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("glaciermask")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.glaciermask;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("icicle")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.icicle;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("glacierchestplate")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.glacierchestplate;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("glacierleggings")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.glacierleggings;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("glacierboots")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.glacierboots;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("iceshard")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.iceshard;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("glacierspike")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.glacierspike;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("enchantedgoldblock")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.enchantedgoldblock;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("healthartifact")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.healthartifact;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("speedartifact")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.speedartifact;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("whirlpoolblade")) {
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.whirlpoolblade;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("levelpoint")){
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.levelpoint;
                item.setAmount(amount);
                inv.addItem(item);
            } else if (itemName.equalsIgnoreCase("lootboost2x")){
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.lootboost2x;
                item.setAmount(amount);
                inv.addItem(item);
            }else if (itemName.equalsIgnoreCase("fireendcrystal")){
                Inventory inv = player.getInventory();
                ItemStack item = ItemManager.fireendcrystal;
                item.setAmount(amount);
                inv.addItem(item);
            }
        }
        return true;
    }
}