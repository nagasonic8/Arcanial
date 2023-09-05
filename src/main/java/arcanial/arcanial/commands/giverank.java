package arcanial.arcanial.commands;

import arcanial.arcanial.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static arcanial.arcanial.Utils.color;

public class giverank implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("is.owner")){
                if (args.length < 2 || args.length > 2){
                    player.sendMessage(color("&cCorrect usage: /giverank <rank> <player>"));
                }else {
                    String rank = args[0];
                    String target = args[1];
                    Server server = Bukkit.getServer();
                    try {
                        server.dispatchCommand(server.getConsoleSender(), "lp user " + target + " parent add " + rank);
                    }catch (NullPointerException e){
                        player.sendMessage(color("Could not give rank, try again."));
                    }
                }
            }
        }
        return true;
    }
}
