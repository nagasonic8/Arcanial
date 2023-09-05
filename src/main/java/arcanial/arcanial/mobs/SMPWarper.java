package arcanial.arcanial.mobs;

import arcanial.arcanial.Arcanial;
import arcanial.arcanial.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import static arcanial.arcanial.Utils.color;

public class SMPWarper {

    public SMPWarper(Location location){
        Villager villager = (Villager) location.getWorld().spawnEntity(location, EntityType.VILLAGER);
        villager.setCustomName(color("&c&lArcanial&9&lSurvival"));
        villager.setCustomNameVisible(true);
        villager.setAdult();
        villager.setInvulnerable(true);
        villager.setProfession(Villager.Profession.NONE);
        villager.setVillagerType(Villager.Type.SNOW);
        villager.setAI(false);
    }
}
