package arcanial.arcanial.mobs;

import arcanial.arcanial.Arcanial;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.event.Listener;

import static arcanial.arcanial.Utils.color;

public class EndCrystals implements Listener {
    static Arcanial plugin;
    public EndCrystals(Arcanial plugin){
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    public static void createFireEndCrystal(Location location){
        EnderCrystal crystal = location.getWorld().spawn(location, EnderCrystal.class);
        crystal.setCustomName(color("Fire"));
        crystal.setCustomNameVisible(false);
    }
    public static void createAirEndCrystal(Location location){
        EnderCrystal crystal = location.getWorld().spawn(location, EnderCrystal.class);
        crystal.setCustomName(color("Air"));
        crystal.setCustomNameVisible(false);
    }
    public static void createWaterEndCrystal(Location location){
        EnderCrystal crystal = location.getWorld().spawn(location, EnderCrystal.class);
        crystal.setCustomName(color("Water"));
        crystal.setCustomNameVisible(false);
    }
}
