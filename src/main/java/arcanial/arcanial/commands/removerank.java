package arcanial.arcanial.commands;

import arcanial.arcanial.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static arcanial.arcanial.Utils.color;

public class removerank implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("is.owner")){
                if (args.length < 2 || args.length > 2){
                    player.sendMessage(color("&cCorrect usage: /removerank <player>"));
                }else {
                    String targetName = args[0];
                    Server server = Bukkit.getServer();
                    Player target = server.getPlayer(targetName);
                    try {
                        if (target.hasPermission("is.owner")){
                            server.dispatchCommand(server.getConsoleSender(), "lp user " + targetName + " parent remove owner");
                        }else if (target.hasPermission("is.admin")){
                            server.dispatchCommand(server.getConsoleSender(), "lp user " + targetName + " parent remove admin");
                        }else if (target.hasPermission("is.headmod")){
                            server.dispatchCommand(server.getConsoleSender(), "lp user " + targetName + " parent remove headmod");
                        }else if (target.hasPermission("is.mod")){
                            server.dispatchCommand(server.getConsoleSender(), "lp user " + targetName + " parent remove mod");
                        }else if (target.hasPermission("is.trainee")){
                            server.dispatchCommand(server.getConsoleSender(), "lp user " + targetName + " parent remove trainee");
                        }else if (target.hasPermission("is.builder")){
                            server.dispatchCommand(server.getConsoleSender(), "lp user " + targetName + " parent remove builder");
                        }else if (target.hasPermission("is.overlord")){
                            server.dispatchCommand(server.getConsoleSender(), "lp user " + targetName + " parent remove overlord");
                        }else if (target.hasPermission("is.oblivion")){
                            server.dispatchCommand(server.getConsoleSender(), "lp user " + targetName + " parent remove oblivion");
                        }else if (target.hasPermission("is.legend")){
                            server.dispatchCommand(server.getConsoleSender(), "lp user " + targetName + " parent remove legend");
                        }else if (target.hasPermission("is.hero")){
                            server.dispatchCommand(server.getConsoleSender(), "lp user " + targetName + " parent remove hero");
                        }else if (target.hasPermission("is.master")){
                            server.dispatchCommand(server.getConsoleSender(), "lp user " + targetName + " parent remove master");
                        }else if (target.hasPermission("is.apprentice")){
                            server.dispatchCommand(server.getConsoleSender(), "lp user " + targetName + " parent remove apprentice");
                        }else {
                            player.sendMessage(color("&cFailed to remove rank."));
                        }
                    }catch (NullPointerException e){
                        player.sendMessage(color("&cAn error occurred when attempting to remove rank."));
                    }
                }
            }
        }
        return true;
    }
}
