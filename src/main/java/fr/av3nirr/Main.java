package fr.av3nirr;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    //Class instance
    private static Main INSTANCE;


    //Array
    public ArrayList<Player> NewPlayers = new ArrayList<>();
    String[] list = {"§e%player% §fSouhaite la bienvenue à §e%target%", "§e%target% §fest acceuillis par §e%player%"};
    @Override
    public void onEnable() {
        // Assignation d'une valeur à INSTANCE
        INSTANCE = this;

        // Registration des events et commandes
        setCommands();
        setListeners();

        //Mettre ce message une fois que le plugin est fini d'etre enable
        System.out.println("§aEvoWelcome démarre");
    }

    public static Main getInstance(){
        return INSTANCE;
    }
    @Override
    public void onDisable() {
        // Petit message d'aurevoir
        System.out.println(ChatColor.RED + "§aEvoWelcome s'éteint");
    }
    public void setCommands(){
        this.getCommand("p").setExecutor(new CmdPlayerJoin());
    }

    /*
    Quand tu auras + de listeners c'est plus simple de stocker
    ton PluginManager dans une variable
     */
    public void setListeners(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new Events(), this);
    }
}