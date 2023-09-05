package arcanial.arcanial.events;

import arcanial.arcanial.Arcanial;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class FireEndCrystalExplode implements Listener {
    public FireEndCrystalExplode(Arcanial plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onEndCrystalExplode(EntityDamageByEntityEvent event){
        Entity entity = event.getEntity();
        if (entity.getType() == EntityType.ENDER_CRYSTAL){
            Player damager = (Player) event.getDamager();
            EnderCrystal crystal = (EnderCrystal) entity;
            if (crystal.getCustomName() == "Fire"){
                for (Entity entity1 : crystal.getNearbyEntities(4, 1, 4)){
                    if (!entity1.isDead()){
                        LivingEntity entity2 = (LivingEntity) entity1;
                        if (entity2 != damager){
                            final int[] n = {1};
                            double y = 0;
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    double x = n[0] * Math.cos(y);
                                    double z = n[0] * Math.sin(y);
                                    entity.getWorld().spawnParticle(Particle.LAVA, entity.getLocation().add(x, y, z), 100);
                                    n[0] = n[0] + 1;
                                }
                            }.runTaskTimerAsynchronously(Arcanial.getPlugin(), 0, 10);
                            entity2.setHealth(entity2.getHealth() - 4);
                            damager.sendMessage("it works!");
                        }
                    }
                }
            }
        }
    }
}
