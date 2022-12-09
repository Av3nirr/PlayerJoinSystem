package fr.av3nirr;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class Events implements Listener {
    @EventHandler
    public void onNewPLayer(PlayerJoinEvent e) throws InterruptedException {
        Player p = e.getPlayer();
        if(!p.hasPlayedBefore()){
            Main.getInstance().NewPlayers.add(p);
            wait(60000);
            Main.getInstance().NewPlayers.remove(p);
        }
    }
}
