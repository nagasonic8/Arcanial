package arcanial.arcanial.commands;

import arcanial.arcanial.mobs.RPGWarper;
import arcanial.arcanial.mobs.SMPWarper;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawnwarper implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            Location loc = player.getLocation();
            if (args[0].equalsIgnoreCase("rpg")){
                new RPGWarper(loc);
            }else if (args[0].equalsIgnoreCase("smp")){
                new SMPWarper(loc);
            }
        }
        return true;
    }
}
