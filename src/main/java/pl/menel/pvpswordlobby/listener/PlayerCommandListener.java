package pl.menel.pvpswordlobby.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import pl.menel.pvpswordlobby.Main;
import pl.menel.pvpswordlobby.menager.PvPMenager;

public class PlayerCommandListener implements Listener {
    private final Main plugin;
    private final PvPMenager pvPMenager;
    public PlayerCommandListener(Main plugin, PvPMenager pvPMenager) {
        this.plugin = plugin;
        this.pvPMenager = pvPMenager;
    }
    @EventHandler
    public void onCommandUse(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        if (pvPMenager.pvpList.contains(player)) {
            player.sendMessage(plugin.colorize(plugin.getConfig().getString("settings-message.DisableCommand")));
            event.setCancelled(true);
        }
    }
}
