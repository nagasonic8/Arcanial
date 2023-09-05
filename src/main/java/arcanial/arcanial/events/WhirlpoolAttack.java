package arcanial.arcanial.events;

import arcanial.arcanial.Arcanial;
import arcanial.arcanial.items.ItemManager;
import arcanial.arcanial.mobs.CustomMob;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.UUID;

public class WhirlpoolAttack implements Listener {
    private final HashMap<UUID, Long> cooldown;
    public WhirlpoolAttack(Arcanial plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.cooldown = new HashMap<>();
    }
    @EventHandler
    public void onRightClick(PlayerInteractEvent event){
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            Player player = event.getPlayer();
            EntityEquipment equipment = player.getEquipment();
            if (equipment.getItemInMainHand().equals(ItemManager.whirlpoolblade)){


                for (Entity e : player.getNearbyEntities(2, 0,2)) {
                    Location location = e.getLocation();
                    World world = e.getWorld();
                    if (e instanceof LivingEntity) {
                        double health = ((LivingEntity) e).getHealth();
                        if (health > 4){
                            ((LivingEntity) e).setHealth(health - 4);
                        }else{
                            ((LivingEntity) e).setHealth(0);
                            if (e.getCustomName().equalsIgnoreCase("§9§lWet Zombie")){
                                Inventory inv = player.getInventory();
                                int max = 3, min = 1, range = max - min + 1;
                                ItemStack item = ItemManager.watermolecule;
                                item.setAmount((int)(Math.random() * range) + min);
                                inv.addItem(item);
                            }
                        }
                        e.setVelocity(new Vector(0, 1, 0));
                        int radius = 1;
                        double y = e.getLocation().getY();
                        double x = radius * Math.cos(y);
                        double z = radius * Math.sin(y);
                        world.spawnParticle(Particle.REDSTONE, e.getLocation().add(x, y, z), 20, new Particle.DustOptions(Color.BLUE, 5.0F));
                    }
                }
            }
        }
    }
}
