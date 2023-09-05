package arcanial.arcanial.mobs;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class LootItem {

    private ItemStack item;
    private int min = 1, max = 1;
    private double dropRate;
    private static Random randomiser = new Random();

    public LootItem(ItemStack item, double spawnChance) {
        this.item = item;
        this.dropRate = spawnChance;
    }

    public LootItem(ItemStack item, int min, int max, double spawnChance) {
        this.item = item;
        this.min = min;
        this.max = max;
        this.dropRate = spawnChance;
    }

    public void tryDropItem(Location loc) {
        if (Math.random() * 101 > dropRate) return;
        int amount = randomiser.nextInt(max - min + 1) + min;
        if (amount == 0) return;
        ItemStack item = this.item.clone();
        item.setAmount(amount);
        loc.getWorld().dropItemNaturally(loc, item);
    }
}
