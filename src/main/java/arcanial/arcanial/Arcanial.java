package arcanial.arcanial;

import arcanial.arcanial.commands.*;
import arcanial.arcanial.events.*;
import arcanial.arcanial.items.ItemManager;
import arcanial.arcanial.mobs.CustomMob;
import arcanial.arcanial.mobs.EndCrystals;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import java.util.*;

import static arcanial.arcanial.Utils.color;

public final class Arcanial extends JavaPlugin {

    private World rpgspawn;
    private World lobby;
    private static Arcanial plugin;
    private World rpgwater;
    private World building;
    private Server server = Bukkit.getServer();
    private BukkitTask ranktask;
    private BukkitTask wztask1;
    private BukkitTask wztask2;
    private BukkitTask wztask3;
    private BukkitTask wztask4;
    private BukkitTask wztask5;
    private BukkitTask cstask1;
    private BukkitTask fullsettask;
    private BukkitTask goldgen1;
    private BukkitTask goldgen2;
    private BukkitTask goldgen3;
    private Map<Entity, CustomMob> wzentities1 = new HashMap<>();
    private Map<Entity, CustomMob> wzentities2 = new HashMap<>();
    private Map<Entity, CustomMob> wzentities3 = new HashMap<>();
    private Map<Entity, CustomMob> wzentities4 = new HashMap<>();
    private Map<Entity, CustomMob> wzentities5 = new HashMap<>();
    private Map<Entity, CustomMob> csentities1 = new HashMap<>();
       @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("fly").setExecutor(new fly());
        getCommand("kit").setExecutor(new kit());
        getCommand("rank").setExecutor(new rank());
        new playerJoin(this);
        ItemManager.init();
        getCommand("wetzombie").setExecutor(new wetzombie());
        getCommand("bubblegear").setExecutor(new bubblegear());
        getCommand("bubbleitems").setExecutor(new bubbleitems());
        getCommand("frozenitems").setExecutor(new frozenitems());
        new deathMessage(this);
        new mobDrops(this);
        new rankVouchers(this);
        new blockPlace(this);
        new blockBreak(this);
        spawnWetZombie1(1, 5 * 20);
        spawnWetZombie2(1, 5 * 20);
        spawnWetZombie3(1, 5 * 20);
        spawnWetZombie4(1, 5 * 20);
        spawnColdSkeleton1(1, 5 * 20);
        rpgspawn = Bukkit.getWorld("rpgspawn");
        rpgwater = Bukkit.getWorld("rpgwater");
        building = Bukkit.getWorld("building");
        lobby = Bukkit.getWorld("lobby");
        getCommand("warp").setExecutor(new warp());
        getCommand("spawn").setExecutor(new spawn());
        getCommand("giverank").setExecutor(new giverank());
        getCommand("giveitem").setExecutor(new giveitem());
        fullSetBonuses();
        getCommand("createworld").setExecutor(new createworld());
        goldGenerator1(30);
        goldGenerator2(30);
        goldGenerator3(30);
        getCommand("setflightspeed").setExecutor(new setflightspeed());
        new bubbleFullSetBonus(this);
        new glacierFullSetBonus(this);
        plugin = this;
        new WhirlpoolAttack(this);
        ranks();
        new scoreboard(this);
        new lootBoosts(this);
        new lobbyWarps(this);
        getCommand("spawnwarper").setExecutor(new spawnwarper());
        new EndCrystals(this);
        new FireEndCrystalExplode(this);
        new FireEndCrystalPlace(this);
    }
    public void ranks() {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard s = manager.getNewScoreboard();
        Team owner = s.registerNewTeam("1");
        owner.setPrefix(color("#ff0000&lO#ff2d00&lw#ff4200&ln#ff5100&le#ff5f00&lr ✬ " + ""));
        owner.setNameTagVisibility(NameTagVisibility.ALWAYS);
        Team admin = s.registerNewTeam("2");
        admin.setPrefix(color("#7b0000&lA#9a0004&ld#bb0004&lm#dd0003&li#ff0101&ln ✬ " + ""));
        admin.setNameTagVisibility(NameTagVisibility.ALWAYS);
        Team headmod = s.registerNewTeam("3");
        headmod.setPrefix(color("#070096&lH#0028ac&le#0043c1&la#005bd3&ld #0073e3&lM#008bf2&lo#00a2ff&ld ✬ " + ""));
        headmod.setNameTagVisibility(NameTagVisibility.ALWAYS);
        Team mod = s.registerNewTeam("4");
        mod.setPrefix(color("#0c00ff&lM#006eff&lo#00a2ff&ld ✬ " + ""));
        mod.setNameTagVisibility(NameTagVisibility.ALWAYS);
        Team trainee = s.registerNewTeam("5");
        trainee.setPrefix(color("#00ff0c&lT#00ff2f&lr#00ff43&la#00ff53&li#00ff60&ln#00ff6d&le#00ff78&le ✬ " + ""));
        trainee.setNameTagVisibility(NameTagVisibility.ALWAYS);
        Team builder = s.registerNewTeam("6");
        builder.setPrefix(color("#ff7e00&lB#ff9200&lu#ffa600&li#ffba00&ll#ffce00&ld#ffe200&le#fff600&lr ✬ " + ""));
        builder.setNameTagVisibility(NameTagVisibility.ALWAYS);
        Team overlord = s.registerNewTeam("7");
        overlord.setPrefix(color("#ff0000&lO#ff3d00&lv#ff5a00&le#ff7100&lr#ff8500&ll#ff9800&lo#ffa900&lr#ffba00&ld ✬ " + ""));
        overlord.setNameTagVisibility(NameTagVisibility.ALWAYS);
        Team oblivion = s.registerNewTeam("8");
        oblivion.setPrefix(color("#202020&lO#2a2a2a&lb#353535&ll#404040&li#4b4b4b&lv#565656&li#626262&lo#6e6e6e&ln ✬ " + ""));
        oblivion.setNameTagVisibility(NameTagVisibility.ALWAYS);
        Team legend = s.registerNewTeam("9");
        legend.setPrefix(color("#00ce30&lL#00b129&le#009621&lg#007b1a&le#006113&ln#00480c&ld ✬ " + ""));
        legend.setNameTagVisibility(NameTagVisibility.ALWAYS);
        Team hero = s.registerNewTeam("a");
        hero.setPrefix(color("#4a0097&lH#6636ba&le#815ddc&lr#9e84ff&lo ✬ " + ""));
        hero.setNameTagVisibility(NameTagVisibility.ALWAYS);
        Team master = s.registerNewTeam("b");
        master.setPrefix(color("#ff6262M#ff6c6ca#ff7675s#ff7f7ft#ff8888e#ff9191r ✬ " + ""));
        master.setNameTagVisibility(NameTagVisibility.ALWAYS);
        Team apprentice = s.registerNewTeam("c");
        apprentice.setPrefix(color("#54ff00A#48ff41p#3fff60p#3aff79r#3bff8fe#43ffa3n#4fffb4t#5fffc3i#71ffd0c#84ffdbe ✬ " + ""));
        apprentice.setNameTagVisibility(NameTagVisibility.ALWAYS);
        Team member = s.registerNewTeam("d");
        member.setPrefix(color("#909090M#818181e#727272m#646464b#565656e#484848r ✬ " + ""));
        member.setNameTagVisibility(NameTagVisibility.ALWAYS);
        ranktask = new BukkitRunnable(){
            Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
            @Override
            public void run() {
                for (Player player : onlinePlayers){
                    String name = player.getName();
                    if (player.hasPermission("is.owner")){
                        s.getTeam("1").addPlayer(player);
                    }else if (player.hasPermission("is.admin")) {
                        player.setDisplayName(color("#7b0000&lA#9a0004&ld#bb0004&lm#dd0003&li#ff0101&ln ✬ " + name));
                        player.setCustomName(color("#7b0000&lA#9a0004&ld#bb0004&lm#dd0003&li#ff0101&ln ✬ " + name));
                        player.setCustomNameVisible(true);
                        player.setPlayerListName(color("#7b0000&lA#9a0004&ld#bb0004&lm#dd0003&li#ff0101&ln ✬ " + name));
                    }else if (player.hasPermission("is.headmod")) {
                        player.setDisplayName(color("#070096&lH#0028ac&le#0043c1&la#005bd3&ld #0073e3&lM#008bf2&lo#00a2ff&ld ✬ " + name));
                        player.setCustomName(color("#070096&lH#0028ac&le#0043c1&la#005bd3&ld #0073e3&lM#008bf2&lo#00a2ff&ld ✬ " + name));
                        player.setCustomNameVisible(true);
                        player.setPlayerListName(color("#070096&lH#0028ac&le#0043c1&la#005bd3&ld #0073e3&lM#008bf2&lo#00a2ff&ld ✬ " + name));
                    }else if (player.hasPermission("is.mod")) {
                        player.setDisplayName(color("#0c00ff&lM#006eff&lo#00a2ff&ld ✬ " + name));
                        player.setCustomName(color("#0c00ff&lM#006eff&lo#00a2ff&ld ✬ " + name));
                        player.setCustomNameVisible(true);
                        player.setPlayerListName(color("#0c00ff&lM#006eff&lo#00a2ff&ld ✬ " + name));
                    }else if (player.hasPermission("is.trainee")) {
                        player.setDisplayName(color("#00ff0c&lT#00ff2f&lr#00ff43&la#00ff53&li#00ff60&ln#00ff6d&le#00ff78&le ✬ " + name));
                        player.setCustomName(color("#00ff0c&lT#00ff2f&lr#00ff43&la#00ff53&li#00ff60&ln#00ff6d&le#00ff78&le ✬ " + name));
                        player.setCustomNameVisible(true);
                        player.setPlayerListName(color("#00ff0c&lT#00ff2f&lr#00ff43&la#00ff53&li#00ff60&ln#00ff6d&le#00ff78&le ✬ " + name));
                    }else if (player.hasPermission("is.builder")){
                        player.setDisplayName(color("#ff7e00&lB#ff9200&lu#ffa600&li#ffba00&ll#ffce00&ld#ffe200&le#fff600&lr ✬ " + name));
                        player.setCustomName(color("#ff7e00&lB#ff9200&lu#ffa600&li#ffba00&ll#ffce00&ld#ffe200&le#fff600&lr ✬ " + name));
                        player.setCustomNameVisible(true);
                        player.setPlayerListName(color("#ff7e00&lB#ff9200&lu#ffa600&li#ffba00&ll#ffce00&ld#ffe200&le#fff600&lr ✬ " + name));
                    }else if (player.hasPermission("is.overlord")){
                        player.setDisplayName(color("#ff0000&lO#ff3d00&lv#ff5a00&le#ff7100&lr#ff8500&ll#ff9800&lo#ffa900&lr#ffba00&ld ✬ ") + name);
                        player.setCustomName(color("#ff0000&lO#ff3d00&lv#ff5a00&le#ff7100&lr#ff8500&ll#ff9800&lo#ffa900&lr#ffba00&ld ✬ ") + name);
                        player.setCustomNameVisible(true);
                        player.setPlayerListName(color("#ff0000&lO#ff3d00&lv#ff5a00&le#ff7100&lr#ff8500&ll#ff9800&lo#ffa900&lr#ffba00&ld ✬ ") + name);
                    }else if (player.hasPermission("is.oblivion")){
                        player.setDisplayName(color("#202020&lO#2a2a2a&lb#353535&ll#404040&li#4b4b4b&lv#565656&li#626262&lo#6e6e6e&ln ✬ " + name));
                        player.setCustomName(color("#202020&lO#2a2a2a&lb#353535&ll#404040&li#4b4b4b&lv#565656&li#626262&lo#6e6e6e&ln ✬ " + name));
                        player.setCustomNameVisible(true);
                        player.setPlayerListName(color("#202020&lO#2a2a2a&lb#353535&ll#404040&li#4b4b4b&lv#565656&li#626262&lo#6e6e6e&ln ✬ " + name));
                    }else if (player.hasPermission("is.legend")){
                        player.setDisplayName(color("#00ce30&lL#00b129&le#009621&lg#007b1a&le#006113&ln#00480c&ld ✬ " + name));
                        player.setCustomName(color("#00ce30&lL#00b129&le#009621&lg#007b1a&le#006113&ln#00480c&ld ✬ " + name));
                        player.setCustomNameVisible(true);
                        player.setPlayerListName(color("#00ce30&lL#00b129&le#009621&lg#007b1a&le#006113&ln#00480c&ld ✬ " + name));
                    }else if (player.hasPermission("is.hero")) {
                        player.setDisplayName(color("#4a0097&lH#6636ba&le#815ddc&lr#9e84ff&lo ✬ " + name));
                        player.setCustomName(color("#4a0097&lH#6636ba&le#815ddc&lr#9e84ff&lo ✬ " + name));
                        player.setCustomNameVisible(true);
                        player.setPlayerListName(color("#4a0097&lH#6636ba&le#815ddc&lr#9e84ff&lo ✬ " + name));
                    }else if (player.hasPermission("is.master")){
                        player.setDisplayName(color("#ff6262M#ff6c6ca#ff7675s#ff7f7ft#ff8888e#ff9191r ✬ " + name));
                        player.setCustomName(color("#ff6262M#ff6c6ca#ff7675s#ff7f7ft#ff8888e#ff9191r ✬ " + name));
                        player.setCustomNameVisible(true);
                        player.setPlayerListName(color("#ff6262M#ff6c6ca#ff7675s#ff7f7ft#ff8888e#ff9191r ✬ " + name));
                    }else if (player.hasPermission("is.apprentice")){
                        player.setDisplayName(color("#54ff00A#48ff41p#3fff60p#3aff79r#3bff8fe#43ffa3n#4fffb4t#5fffc3i#71ffd0c#84ffdbe ✬ " + name));
                        player.setCustomName(color("#54ff00A#48ff41p#3fff60p#3aff79r#3bff8fe#43ffa3n#4fffb4t#5fffc3i#71ffd0c#84ffdbe ✬ " + name));
                        player.setCustomNameVisible(true);
                        player.setPlayerListName(color("#54ff00A#48ff41p#3fff60p#3aff79r#3bff8fe#43ffa3n#4fffb4t#5fffc3i#71ffd0c#84ffdbe ✬ " + name));
                    }else {
                        player.setDisplayName(color("#909090M#818181e#727272m#646464b#565656e#484848r ✬ " + name));
                        player.setCustomName(color("#909090M#818181e#727272m#646464b#565656e#484848r ✬ " + name));
                        player.setCustomNameVisible(true);
                        player.setPlayerListName(color("#909090M#818181e#727272m#646464b#565656e#484848r ✬ " + name));
                    }
                }
            }
        }.runTaskTimer(this, 0L, 1L);
    }
    public void spawnWetZombie1(int mobCap, int spawnTime) {
         wztask1 = new BukkitRunnable() {
             Server server = Bukkit.getServer();
             List<Entity> removal = new ArrayList<>();
             Set<Entity> spawned = wzentities1.keySet();
             Collection<? extends Player> onlineplayers = Bukkit.getOnlinePlayers();
             int diff = mobCap - wzentities1.size();
             @Override
             public void run() {
                 for (Entity entity : spawned) {
                     if (!(entity == null)) {
                         if (!entity.isValid() || entity.isDead()) removal.add(entity);
                     }
                 }
                 spawned.removeAll(removal);
                 diff = mobCap - wzentities1.size();
                 if (diff <= 0) return;
                 if (diff == 1){
                     int X = 22, Z = -46;
                     Block block = rpgwater.getHighestBlockAt(X, Z);
                     Location loc = block.getLocation().clone().add(0.5,1,0.5);
                     CustomMob e = CustomMob.WET_ZOMBIE;
                     wzentities1.put(e.spawn(loc), e);
                 }
             }
         }.runTaskTimer(this, 0L, spawnTime);
    }
    public void spawnWetZombie2(int mobCap, int spawnTime) {
         wztask2 = new BukkitRunnable() {
             Set<Entity> spawned = wzentities2.keySet();
             List<Entity> removal = new ArrayList<>();
             int diff = mobCap - wzentities2.size();
             @Override
             public void run() {
                 for (Entity entity : spawned) {
                     if (!(entity == null)){
                         if (!entity.isValid() || entity.isDead()) removal.add(entity);
                     }
                 }
                 spawned.removeAll(removal);
                 diff = mobCap - wzentities2.size();
                 if (diff <= 0) return;
                 if (diff == 1){
                     int X = 33, Z = -46;
                     Block block = rpgwater.getHighestBlockAt(X, Z);
                     Location loc = block.getLocation().clone().add(0.5, 1, 0.5);
                     CustomMob e = CustomMob.WET_ZOMBIE;
                     wzentities2.put(e.spawn(loc), e);
                 }
             }
         }.runTaskTimer(this, 0L, spawnTime);
    }
    public void spawnWetZombie3(int mobCap, int spawnTime) {
        wztask3 = new BukkitRunnable() {
            Set<Entity> spawned = wzentities3.keySet();
            List<Entity> removal = new ArrayList<>();
            int diff = mobCap - wzentities3.size();
            @Override
            public void run() {
                for (Entity entity : spawned) {
                    if (!(entity == null)){
                        if (!entity.isValid() || entity.isDead()) removal.add(entity);
                    }
                }
                spawned.removeAll(removal);
                diff = mobCap - wzentities3.size();
                if (diff <= 0) return;
                if (diff == 1){
                    int X = 26, Z = -32;
                    Block block = rpgwater.getHighestBlockAt(X, Z);
                    Location loc = block.getLocation().clone().add(0.5, 1, 0.5);
                    CustomMob e = CustomMob.WET_ZOMBIE;
                    wzentities3.put(e.spawn(loc), e);
                }
            }
        }.runTaskTimer(this, 0L, spawnTime);
    }
    public void spawnWetZombie4(int mobCap, int spawnTime) {
        wztask4 = new BukkitRunnable() {
            Set<Entity> spawned = wzentities4.keySet();
            List<Entity> removal = new ArrayList<>();
            int diff = mobCap - wzentities4.size();
            @Override
            public void run() {
                for (Entity entity : spawned) {
                    if (!(entity == null)){
                        if (!entity.isValid() || entity.isDead()) removal.add(entity);
                    }
                }
                spawned.removeAll(removal);
                diff = mobCap - wzentities4.size();
                if (diff <= 0) return;
                if (diff == 1){
                    int X = 16, Z = -39;
                    Block block = rpgwater.getHighestBlockAt(X, Z);
                    Location loc = block.getLocation().clone().add(0.5, 1, 0.5);
                    CustomMob e = CustomMob.WET_ZOMBIE;
                    wzentities4.put(e.spawn(loc), e);
                }
            }
        }.runTaskTimer(this, 0L, spawnTime);
    }
    public void spawnColdSkeleton1(int mobCap, int spawnTime){
        cstask1 = new BukkitRunnable() {
            Set<Entity> spawned = csentities1.keySet();
            List<Entity> removal = new ArrayList<>();
            int diff = mobCap - csentities1.size();
            @Override
            public void run() {
                for (Entity entity : spawned) {
                    if (!(entity == null)){
                        if (!entity.isValid() || entity.isDead()) removal.add(entity);
                    }
                }
                spawned.removeAll(removal);
                diff = mobCap - csentities1.size();
                if (diff <= 0) return;
                if (diff == 1){
                    int X = -294, Z = -49;
                    Block block = rpgspawn.getHighestBlockAt(X, Z);
                    Location loc = block.getLocation().clone().add(0, 1, 0);
                    CustomMob e = CustomMob.COLD_SKELETON;
                    csentities1.put(e.spawn(loc), e);
                }
            }
        }.runTaskTimer(this, 0L, spawnTime);
    }
    public void fullSetBonuses(){
          fullsettask = new BukkitRunnable(){
              @Override
              public void run() {
                  for (Player player : server.getOnlinePlayers()){
                      EntityEquipment armor = player.getEquipment();
                      ItemStack helmet = armor.getHelmet();
                      ItemStack chestplate = armor.getChestplate();
                      ItemStack leggings = armor.getLeggings();
                      ItemStack boots = armor.getBoots();
                      if (helmet != null && chestplate != null && leggings != null && boots != null){
                          if (helmet.equals(ItemManager.bubblehelmet) && chestplate.equals(ItemManager.bubblechestplate) && leggings.equals(ItemManager.bubbleleggings) && boots.equals(ItemManager.bubbleboots)){
                              player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, 2));
                          }
                      }
                  }
              }
          }.runTaskTimer(this, 0L, 1);
    }
    public void goldGenerator1(int spawnTime){
           goldgen1 = new BukkitRunnable() {
               @Override
               public void run(){
                   int X = 53, Z = 38;
                   ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
                   Block block = rpgspawn.getHighestBlockAt(X, Z);
                   Location loc = block.getLocation().clone().add(0.5, 1, 0.5);
                   rpgspawn.dropItem(loc, item);
               }
           }.runTaskTimer(this, 0L, spawnTime);
    }
    public void goldGenerator2(int spawnTime){
           goldgen2 = new BukkitRunnable() {

               @Override
               public void run() {
                   int X = 57, Z = 45;
                   ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
                   Block block = rpgspawn.getHighestBlockAt(X, Z);
                   Location loc = block.getLocation().clone().add(0.5, 1, 0.5);
                   rpgspawn.dropItem(loc, item);
               }
           }.runTaskTimer(this, 0L, spawnTime);
    }
    public void goldGenerator3(int spawnTime){
           goldgen3 = new BukkitRunnable() {
               @Override
               public void run() {
                   int X = 64, Z = 50;
                   ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
                   Block block = rpgspawn.getHighestBlockAt(X, Z);
                   Location loc = block.getLocation().clone().add(0.5, 1, 0.5);
                   rpgspawn.dropItem(loc, item);
               }
           }.runTaskTimer(this, 0L, spawnTime);
    }

    public static Arcanial getPlugin() {
        return plugin;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Shutting Down");
        for (World world : Bukkit.getWorlds()){
            for (Entity entity : world.getEntities()){
                entity.remove();
            }
        }
    }
}
