package fr.av3nirr;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class CmdPlayerJoin implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;

        if(args.length != 1) {
            p.sendMessage("§cVous devez définir un Joueur !");
            return false;
        }else{
            Player target = p.getServer().getPlayer(args[1]);
            if (Main.getInstance().NewPlayers.contains(target)){
                //envoie du message au joueur
                p.sendMessage("§aTu as bien reçu XX€ car tu as souhaité la bienvenue au joueur: §e" + target.getName());
                //Broadcast du message de bienvenue
                Random r = new Random();
                for (Player bcPLayers : p.getServer().getOnlinePlayers()){
                    bcPLayers.sendMessage(Main.getInstance().list[r.nextInt(Main.getInstance().list.length)].replace("%player%", p.getName()).replace("%target%", target.getName()));
                }
                //ajout de l'argent ! (faire le Multiplicateur)
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "/eco add " + p.getName() + 500);
            }else{
                p.sendMessage("§cDommage... Il n'y a pas de joueurs nouveaux. Tu pourrait faire de la pub !");
            }
        }
        return false;
    }
}
