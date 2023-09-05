package arcanial.arcanial.commands;

import arcanial.arcanial.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static arcanial.arcanial.Utils.color;

public class setflightspeed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length == 1){
                player.setFlySpeed(Float.parseFloat(args[0]));
            }else player.sendMessage(color("&cCorrect usage: /setflightspeed <amount>"));
        }
        return true;
    }
}
