package arcanial.arcanial.mobs;

import arcanial.arcanial.Arcanial;
import arcanial.arcanial.Utils;
import arcanial.arcanial.items.ItemManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum CustomMob {

    WET_ZOMBIE("§9§lWet Zombie", 15, 15, 100, 10, true, EntityType.ZOMBIE, null, Utils.makeArmorSet(new ItemStack(Material.CHAINMAIL_HELMET), null, null, null), new LootItem(ItemManager.watermolecule, 1, 3, 100)),
    COLD_SKELETON("§b§lCold Skeleton", 25, 30, 100, 15, true, EntityType.STRAY, ItemManager.coldskeletonbow, Utils.makeArmorSet(new ItemStack(Material.IRON_HELMET), null, null, null), new LootItem(ItemManager.frozendrop, 1, 3, 100)),
    ;

    private String name;
    private Map<Entity, CustomMob> allcustommobs = new HashMap<>();
    private double maxHealth, atkDamage, spawnChance, targetRange;
    private boolean isAdult;
    private EntityType type;
    private ItemStack mainItem;
    private ItemStack[] armor;
    private List<LootItem> lootTable;

    CustomMob(String name, double maxHealth, double atkDamage, double spawnChance, double targetRange, boolean isAdult, EntityType type, ItemStack mainItem, ItemStack[] armor, LootItem... lootItems) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.atkDamage = atkDamage;
        this.spawnChance = spawnChance;
        this.targetRange = targetRange;
        this.isAdult = isAdult;
        this.type = type;
        this.mainItem = mainItem;
        this.armor = armor;
        lootTable = Arrays.asList(lootItems);
    }

    public LivingEntity spawn(Location location){
        LivingEntity entity = (LivingEntity) location.getWorld().spawnEntity(location, type);
        entity.setCustomNameVisible(true);
        entity.setCustomName(name);
        entity.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(atkDamage);
        entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(maxHealth);
        entity.setHealth(maxHealth);
        EntityEquipment inv = entity.getEquipment();
        if (armor != null) inv.setArmorContents(armor);
        inv.setHelmetDropChance(0f);
        inv.setChestplateDropChance(0f);
        inv.setLeggingsDropChance(0f);
        inv.setBootsDropChance(0f);
        inv.setItemInMainHand(mainItem);
        inv.setItemInMainHandDropChance(0f);
        if (entity instanceof Zombie){
            if (isAdult == true) ((Zombie) entity).setAdult();
        }
        return entity;
    }

    public void tryDropLoot(Location location) {
        for (LootItem item : lootTable){
            item.tryDropItem(location);
        }
    }

    public String getName() {
        return name;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public double getSpawnChance() {
        return spawnChance;
    }
}
