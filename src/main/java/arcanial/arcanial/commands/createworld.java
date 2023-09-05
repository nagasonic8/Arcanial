package arcanial.arcanial.commands;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static arcanial.arcanial.Utils.color;

public class createworld implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 2){
            World world;
            String name = args[0];
            String type = args[1];
            if (type.equalsIgnoreCase("flat")){
                try {
                    WorldCreator c = new WorldCreator(name);
                    c.type(WorldType.FLAT);
                    c.generateStructures(false);
                    world = c.createWorld();
                }catch (NullPointerException e){
                    sender.sendMessage(color("An error occurred when attempting to create world. Please try again."));
                }
            }else if (type.equalsIgnoreCase("normal")){
                try {
                    WorldCreator c = new WorldCreator(name);
                    c.type(WorldType.NORMAL);
                    world = c.createWorld();
                }catch (NullPointerException e){
                    sender.sendMessage(color("An error occurred when attempting to create world. Please try again."));
                }
            }else sender.sendMessage(color("&cCorrect usage: /createworld <name> <type>"));
        }else sender.sendMessage(color("&cCorrect usage: /createworld <name> <type>"));
        return true;
    }
}
