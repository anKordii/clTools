package com.paulek.code.utils;

import com.paulek.code.Main;
import com.paulek.code.listners.*;
import org.bukkit.plugin.java.JavaPlugin;

public class initializeListners {

    private static JavaPlugin plugin = Main.getInstance();

    public static void initialize(){
        plugin.getServer().getPluginManager().registerEvents(new PlayerCommandPreprocessListner(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new BlockBreakListner(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new BlockPlaceListner(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerInteractListner(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new AsyncPlayerChatListner(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ChunkUnloadEvent(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new EntityDeathEvent(), plugin);
        //plugin.getServer().getPluginManager().registerEvents(new EntityDamageEvent(), plugin);
    }
}
