package arcanial.arcanial.commands;

import arcanial.arcanial.mobs.CustomMob;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class wetzombie implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.isOp()){
                Location loc = player.getLocation();
                CustomMob e = CustomMob.WET_ZOMBIE;
                e.spawn(loc);
            }else{
                player.sendMessage("You are not worthy of this command");
            }
            return true;
        }else{
            sender.sendMessage("Only players can run this command");
        }
        return false;
    }
}
