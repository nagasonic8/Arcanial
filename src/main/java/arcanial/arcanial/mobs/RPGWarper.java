package arcanial.arcanial.mobs;

import arcanial.arcanial.Arcanial;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;

import static arcanial.arcanial.Utils.color;

public class RPGWarper {

    public RPGWarper(Location location){
        Villager villager = (Villager) location.getWorld().spawnEntity(location, EntityType.VILLAGER);
        villager.setCustomName(color("&c&lArcanial&9&lRPG"));
        villager.setCustomNameVisible(true);
        villager.setAdult();
        villager.setInvulnerable(true);
        villager.setProfession(Villager.Profession.NONE);
        villager.setVillagerType(Villager.Type.DESERT);
        villager.setAI(false);
    }
}
