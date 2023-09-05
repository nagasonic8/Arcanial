package arcanial.arcanial.commands;

import arcanial.arcanial.Utils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

import static arcanial.arcanial.Utils.color;

public class spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            World spawn = Bukkit.getWorld("rpgspawn");
            try {
                player.teleport(spawn.getSpawnLocation().clone().add(0.5, 0, 0.5));
            } catch (NullPointerException e) {
                player.sendMessage(color("&cFailed to teleport."));
            }
        }else sender.sendMessage("Only players can run this command.");
        return true;
    }
}
