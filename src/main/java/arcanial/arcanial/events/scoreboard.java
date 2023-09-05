package arcanial.arcanial.events;

import arcanial.arcanial.Arcanial;
import arcanial.arcanial.Utils;
import fr.mrmicky.fastboard.FastBoard;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static arcanial.arcanial.Utils.color;

public class scoreboard implements Listener {
    private final Map<UUID, FastBoard> boards = new HashMap<>();

    public scoreboard(Arcanial plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (FastBoard board : boards.values()){
                Player player = board.getPlayer();
                updateBoard(board,
                        "",
                        "&aOnline: &3" + Bukkit.getOnlinePlayers().size(),
                        "&9" + player.getName(),
                        "&cLevel: " + PlaceholderAPI.setPlaceholders(player, "%clv_player_level%"),
                        "&bNext Level: " + PlaceholderAPI.setPlaceholders(player, "%clv_player_exp_remaining%") + " xp",
                        "",
                        "&e&lLoot Boost: " + lootBoosts.multiplier + "x",
                        "&e " + lootBoosts.minutes + "m " + lootBoosts.seconds + "s remaining",
                        "");
            }
        }, 10L, 10L);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        FastBoard board = new FastBoard(player);
        String title = color("   &c&lArcanial&9&lMC   ");
        board.updateTitle(title);
        boards.put(player.getUniqueId(), board);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        FastBoard board = boards.remove(player.getUniqueId());
        if (board != null){
            board.delete();
        }
    }

    private void updateBoard(FastBoard board, String ... lines){
        for (int a = 0; a < lines.length; a++){
            lines[a] = color(lines[a]);
        }

        board.updateLines(lines);
    }
}
