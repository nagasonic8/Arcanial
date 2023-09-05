package arcanial.arcanial.items;

import arcanial.arcanial.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.checkerframework.checker.units.qual.A;
import org.w3c.dom.Attr;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static arcanial.arcanial.Utils.color;

public class ItemManager {
    public static ItemStack novicesword;
    public static ItemStack novicehelmet;
    public static ItemStack novicechestplate;
    public static ItemStack noviceleggings;
    public static ItemStack noviceboots;
    public static ItemStack watermolecule;
    public static ItemStack bubblesword;
    public static ItemStack bubblehelmet;
    public static ItemStack bubblechestplate;
    public static ItemStack bubbleleggings;
    public static ItemStack bubbleboots;
    public static ItemStack bubble;
    public static ItemStack frozendrop;
    public static ItemStack snowball;
    public static ItemStack overlordrankvoucher;
    public static ItemStack rankcoin;
    public static ItemStack oblivionrankvoucher;
    public static ItemStack legendrankvoucher;
    public static ItemStack herorankvoucher;
    public static ItemStack masterrankvoucher;
    public static ItemStack apprenticerankvoucher;
    public static ItemStack dailycratekey;
    public static ItemStack watercratekey;
    public static ItemStack glaciermask;
    public static ItemStack icicle;
    public static ItemStack glacierchestplate;
    public static ItemStack glacierleggings;
    public static ItemStack glacierboots;
    public static ItemStack iceshard;
    public static ItemStack glacierspike;
    public static ItemStack enchantedgoldblock;
    public static ItemStack healthartifact;
    public static ItemStack speedartifact;
    public static ItemStack whirlpoolblade;
    public static ItemStack coldskeletonbow;
    public static ItemStack levelpoint;
    public static ItemStack lootboost2x;
    public static ItemStack lootboost5x;
    public static ItemStack fireendcrystal;
    public static void init() {
        createNoviceSword();
        createNoviceHelmet();
        createNoviceChestplate();
        createNoviceLeggings();
        createNoviceBoots();
        createWaterMolecule();
        createBubbleSword();
        createBubbleHelmet();
        createBubbleChestplate();
        createBubbleLeggings();
        createBubbleBoots();
        createBubble();
        createFrozenDrop();
        createSnowball();
        createOverlordRankVoucher();
        createRankCoin();
        createOblivionRankVoucher();
        createLegendRankVoucher();
        createHeroRankVoucher();
        createMasterRankVoucher();
        createApprenticeRankVoucher();
        createDailyCrateKey();
        createWaterCrateKey();
        createIcicle();
        createGlacierMask();
        createGlacierChestplate();
        createGlacierLeggings();
        createGlacierBoots();
        createIceShard();
        createGlacierSpike();
        createEnchantedGoldBlock();
        createHealthArtifact();
        createSpeedArtifact();
        createWhirlpoolBlade();
        createColdSkeletonBow();
        createLevelPoint();
        createLootBoost2x();
        createLootBoost5x();
        createFireEndCrystal();
    }
    private static void createNoviceSword() {
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§7Novice's Blade");
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        novicesword = item;
    }
    private static void createNoviceHelmet() {
        ItemStack item = new ItemStack(Material.IRON_HELMET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§7Novice's Helmet");
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        novicehelmet = item;
    }
    private static void createNoviceChestplate() {
        ItemStack item = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§7Novice's Chestplate");
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        novicechestplate = item;
    }
    private static void createNoviceLeggings() {
        ItemStack item = new ItemStack(Material.IRON_LEGGINGS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§7Novice's Leggings");
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        noviceleggings = item;
    }
    private static void createNoviceBoots() {
        ItemStack item = new ItemStack(Material.IRON_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§7Novice's Boots");
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        noviceboots = item;
    }
    private static void createWaterMolecule() {
        ItemStack item = new ItemStack(Material.PRISMARINE_CRYSTALS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§bWater Molecule");
        List<String> lore = new ArrayList<>();
        lore.add("§9A molecule made of water.");
        meta.setLore(lore);
        item.setItemMeta(meta);
        watermolecule = item;
    }
    private static void createBubbleSword() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#005aff&lB#0083ff&lu#00a4ff&lb#00c0ff&lb#00d9ff&ll#00f0ff&le #00f0ff&lS#00d3ff&lw#00b2ff&lo#008cff&lr#005aff&ld"));
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        bubblesword = item;
    }
    private static void createBubbleHelmet() {
        ItemStack item = new ItemStack(Material.DIAMOND_HELMET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#005aff&lB#0083ff&lu#00a4ff&lb#00c0ff&lb#00d9ff&ll#00f0ff&le #00f0ff&lH#00d9ff&le#00c0ff&ll#00a4ff&lm#0083ff&le#005aff&lt"));
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(" ");
        lore.add(" ");
        lore.add(" ");
        lore.add(" ");
        lore.add("§eFull Set Bonus: §bBubble Bath");
        lore.add("§6Cover yourself in bubbles, ");
        lore.add("§6granting increased defense.");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        bubblehelmet = item;
    }
    private static void createBubbleChestplate() {
        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#005aff&lB#0083ff&lu#00a4ff&lb#00c0ff&lb#00d9ff&ll#00f0ff&le #00f0ff&lC#00e4ff&lh#00d6ff&le#00c9ff&ls#00baff&lt#00aaff&lp#0099ff&ll#0087ff&la#0072ff&lt#005aff&le"));
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(" ");
        lore.add(" ");
        lore.add(" ");
        lore.add(" ");
        lore.add("§eFull Set Bonus: §bBubble Bath");
        lore.add("§6Cover yourself in bubbles, ");
        lore.add("§6granting increased defense.");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        bubblechestplate = item;
    }
    private static void createBubbleLeggings() {
        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#005aff&lB#0083ff&lu#00a4ff&lb#00c0ff&lb#00d9ff&ll#00f0ff&le #00f0ff&lL#00e0ff&le#00cfff&lg#00bcff&lg#00a8ff&li#0092ff&ln#0079ff&lg#005aff&ls"));
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(" ");
        lore.add(" ");
        lore.add(" ");
        lore.add(" ");
        lore.add("§eFull Set Bonus: §bBubble Bath");
        lore.add("§6Cover yourself in bubbles, ");
        lore.add("§6granting increased defense.");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        bubbleleggings = item;
    }
    private static void createBubbleBoots() {
        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#005aff&lB#0083ff&lu#00a4ff&lb#00c0ff&lb#00d9ff&ll#00f0ff&le #00f0ff&lB#00d3ff&lo#00b2ff&lo#008cff&lt#005aff&ls"));
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(" ");
        lore.add(" ");
        lore.add(" ");
        lore.add(" ");
        lore.add("§eFull Set Bonus: §bBubble Bath");
        lore.add("§6Cover yourself in bubbles, ");
        lore.add("§6granting increased defense.");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        bubbleboots = item;
    }
    private static void createBubble() {
        ItemStack item = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#005aff&lB#0083ff&lu#00a4ff&lb#00c0ff&lb#00d9ff&ll#00f0ff&le"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "It's a bubble, be careful not to pop it!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        bubble = item;
    }
    private static void createFrozenDrop() {
        ItemStack item = new ItemStack(Material.GHAST_TEAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#6ed4faF#83d9fbr#96defbo#a7e2fcz#b7e7fce#c6ecfdn #d5f1feD#e3f5fer#f1faffo#ffffffp"));
        List<String> lore = new ArrayList<>();
        lore.add(color("&bIt is a frozen water droplet."));
        meta.setLore(lore);
        item.setItemMeta(meta);
        frozendrop = item;
   }
    private static void createSnowball() {
        ItemStack item = new ItemStack(Material.SNOWBALL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#ffffff&lS#e9f6ff&ln#d1edff&lo#b9e4ff&lw#9edbff&lb#7fd2ff&la#59c9ff&ll#00c0ff&ll"));
        List<String> lore = new ArrayList<>();
        lore.add(color("&9A tightly packed ball of snow"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        snowball = item;
   }
    private static void createOverlordRankVoucher() {
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#ff0000&lO#ff3d00&lv#ff5a00&le#ff7100&lr#ff8500&ll#ff9800&lo#ffa900&lr#ffba00&ld Rank Voucher"));
        item.setItemMeta(meta);
        overlordrankvoucher = item;
    }
    private static void createRankCoin() {
        ItemStack item = new ItemStack(Material.SUNFLOWER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#ffff00R#ffed00a#ffda00n#ffc800k #ffb500C#ffa300o#ff9100i#ff7e00n"));
        item.setItemMeta(meta);
        rankcoin = item;
    }
    private static void createOblivionRankVoucher() {
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#202020&lO#2a2a2a&lb#353535&ll#404040&li#4b4b4b&lv#565656&li#626262&lo#6e6e6e&ln Rank Voucher"));
        item.setItemMeta(meta);
        oblivionrankvoucher = item;
    }
    private static void createLegendRankVoucher() {
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#00ce30&lL#00b129&le#009621&lg#007b1a&le#006113&ln#00480c&ld Rank Voucher"));
        item.setItemMeta(meta);
        legendrankvoucher = item;
    }
    private static void createHeroRankVoucher() {
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#4a0097&lH#6636ba&le#815ddc&lr#9e84ff&lo Rank Voucher"));
        item.setItemMeta(meta);
        herorankvoucher = item;
    }
    private static void createMasterRankVoucher() {
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#ff6262M#ff6c6ca#ff7675s#ff7f7ft#ff8888e#ff9191r Rank Voucher"));
        item.setItemMeta(meta);
        masterrankvoucher = item;
    }
    private static void createApprenticeRankVoucher() {
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#54ff00A#48ff41p#3fff60p#3aff79r#3bff8fe#43ffa3n#4fffb4t#5fffc3i#71ffd0c#84ffdbe Rank Voucher"));
        item.setItemMeta(meta);
        apprenticerankvoucher = item;
    }
    private static void createDailyCrateKey() {
        ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("&a&lDaily Crate Key"));
        item.setItemMeta(meta);
        dailycratekey = item;
    }
    private static void createWaterCrateKey() {
        ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#0066ff&lW#0079ff&la#008aff&lt#0099ff&le#00a7ff&lr #00b4ff&lC#00c0ff&lr#00ccff&la#00d7ff&lt#00e2ff&le #00ecf9&lK#00f6f1&le#00ffea&ly"));
        item.setItemMeta(meta);
        watercratekey = item;
    }
    private static void createGlacierMask() {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullCreator.itemWithBase64(item, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTFmNzcyZjBlMGE5NGM4NGIyNjgyNmQxNWVjNGNlMzljMDEzZDVmM2ViMGZjOGMxODY4MDA4YzdiNzRjZDAwNSJ9fX0=");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#a0dcff&lG#b2e2ff&ll#c2e8ff&la#d2edff&lc#e1f3ff&li#f0f9ff&le#ffffff&lr #ffffff&lM#e1f3ff&la#c2e8ff&ls#a0dcff&lk"));
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "glaciermaskarmor", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.setUnbreakable(true);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
        item.setItemMeta(meta);
        glaciermask = item;
    }
    private static void createIcicle() {
        ItemStack item = new ItemStack(Material.LIGHT_BLUE_CANDLE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#ffffff&lI#edf8ff&lc#dbf1ff&li#c9eaff&lc#b5e3ff&ll#a0dcff&le"));
        item.setItemMeta(meta);
        icicle = item;
    }
    private static void createGlacierChestplate() {
        ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.AQUA);
        meta.setDisplayName(color("#a0dcff&lG#b2e2ff&ll#c2e8ff&la#d2edff&lc#e1f3ff&li#f0f9ff&le#ffffff&lr #ffffff&lC#f5fbff&lh#ebf7ff&le#e1f3ff&ls#d7efff&lt#cdebff&lp#c2e8ff&ll#b7e4ff&la#ace0ff&lt#a0dcff&le"));
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "glacierchestarmor", 11.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_DYE);
        item.setItemMeta(meta);
        glacierchestplate = item;
    }
    private static void createGlacierLeggings() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.AQUA);
        meta.setDisplayName(color("#a0dcff&lG#b2e2ff&ll#c2e8ff&la#d2edff&lc#e1f3ff&li#f0f9ff&le#ffffff&lr #ffffff&lL#f3faff&le#e6f5ff&lg#d9f0ff&lg#cbebff&li#bee6ff&ln#afe1ff&lg#a0dcff&ls"));
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "glacierlegsarmor", 9, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_DYE);
        item.setItemMeta(meta);
        glacierleggings = item;
    }
    private static void createGlacierBoots() {
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(Color.AQUA);
        meta.setDisplayName(color("#a0dcff&lG#b2e2ff&ll#c2e8ff&la#d2edff&lc#e1f3ff&li#f0f9ff&le#ffffff&lr #ffffff&lB#e9f6ff&lo#d2edff&lo#bae5ff&lt#a0dcff&ls"));
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "glacierbootsarmor", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_DYE);
        item.setItemMeta(meta);
        glacierboots = item;
    }
    private static void createIceShard() {
        ItemStack item = new ItemStack(Material.GHAST_TEAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#6ed7fa&lI#89ddfb&lc#a0e3fc&le #b5e8fc&lS#c9eefd&lh#dbf4fe&la#edf9fe&lr#ffffff&ld"));
        item.setItemMeta(meta);
        iceshard = item;
    }
    private static void createGlacierSpike() {
        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#a0dcff&lG#b2e2ff&ll#c2e8ff&la#d2edff&lc#e1f3ff&li#f0f9ff&le#ffffff&lr #a0dcff&lS#bae5ff&lp#d2edff&li#e9f6ff&lk#ffffff&le"));
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "glacierspikedamage", 10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        meta.addEnchant(Enchantment.KNOCKBACK, 3, false);
        item.setItemMeta(meta);
        glacierspike = item;
    }
    private static void createEnchantedGoldBlock() {
        ItemStack item = new ItemStack(Material.GOLD_BLOCK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("&bEnchanted Gold Block"));
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        enchantedgoldblock = item;
    }
    private static void createHealthArtifact() {
        ItemStack item = new ItemStack(Material.RED_DYE,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("&c&lHealth Artifact"));
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "healthartifacthealth", 10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
        item.setItemMeta(meta);
        healthartifact = item;
    }
    private static void createSpeedArtifact() {
        ItemStack item = new ItemStack(Material.SUGAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("&lSpeed Artifact"));
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "speedartifactspeed", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier);
        item.setItemMeta(meta);
    }
    private static void createWhirlpoolBlade() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#6000ff&lW#4c30ff&lh#3645ff&li#1956ff&lr#0063ff&ll#006fff&lp#007aff&lo#0084ff&lo#1d8dff&ll"));
        List<String> lore = new ArrayList<>();
        lore.add(color("&eRight Click Ability: &bCutting Whirlpool"));
        meta.setLore(lore);
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "whirlpoolbladehealth", 15, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        whirlpoolblade = item;
    }
    private static void createColdSkeletonBow() {
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "coldskeletonbowdamage", 10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        item.setItemMeta(meta);
        coldskeletonbow = item;
    }
    private static void createLevelPoint() {
        ItemStack item = new ItemStack(Material.GREEN_DYE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#00ff06&lL#1df301&le#2ae700&lv#31dc00&le#36d000&ll #3ac500&lP#3cba00&lo#3daf00&li#3da400&ln#3d9900&lt"));
        item.setItemMeta(meta);
        levelpoint = item;
    }
    private static void createLootBoost2x() {
        ItemStack item = new ItemStack(Material.YELLOW_DYE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#fff600&l2x L#fff100&lo#ffeb00&lo#ffe600&lt #ffe100&lB#ffdc00&lo#ffd600&lo#ffd100&ls#ffcc00&lt"));
        List<String> lore = new ArrayList<>();
        lore.add(color("&bRight Click &eto activate a &b2x &eloot boost for &b10 minutes"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        lootboost2x = item;
    }
    private static void createLootBoost5x() {
        ItemStack item = new ItemStack(Material.YELLOW_DYE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("#fff600&l5x L#fff100&lo#ffeb00&lo#ffe600&lt #ffe100&lB#ffdc00&lo#ffd600&lo#ffd100&ls#ffcc00&lt"));
        List<String> lore = new ArrayList<>();
        lore.add(color("&bRight Click &eto activate a &b5x &eloot boost for &b10 minutes"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        lootboost5x = item;
    }
    private static void createFireEndCrystal() {
        ItemStack item = new ItemStack(Material.END_CRYSTAL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color("&c&lFire End Crystal"));
        List<String> lore = new ArrayList<>();
        lore.add(color("&bAn end crystal imbued with the power of fire."));
        meta.setLore(lore);
        item.setItemMeta(meta);
        fireendcrystal = item;
    }
}
