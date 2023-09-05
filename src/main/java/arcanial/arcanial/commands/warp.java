package arcanial.arcanial.commands;

import arcanial.arcanial.Arcanial;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.BitSet;

import static arcanial.arcanial.Utils.color;

public class warp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            double xOffset = 0.5, zOffset = 0.5;
            if (args.length == 1){
                World destination = Bukkit.getWorld(args[0]);
                if (args[0].equalsIgnoreCase("building")){
                    if (player.hasPermission("is.builder")){
                        player.teleport(destination.getSpawnLocation().clone().add(xOffset, 1, zOffset));
                    }else {
                        player.sendMessage(color("&cYou do not have permission to go here"));
                    }
                    return true;
                }
                try {
                    player.teleport(destination.getSpawnLocation().clone().add(xOffset, 1, zOffset));
                }catch (NullPointerException e){
                    player.sendMessage(color("&cCould not find warp."));
                }
            }
        }
        return true;
    }
}
