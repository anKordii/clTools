package com.paulek.code.utils;

import com.paulek.code.Main;
import com.paulek.code.cmds.ChatCMD;
import com.paulek.code.cmds.HelpCMD;
import com.paulek.code.cmds.RandomCMD;
import com.paulek.code.cmds.pluginCMD;
import org.bukkit.plugin.java.JavaPlugin;

public class initializeCommands {

    private static JavaPlugin plugin = Main.getInstance();

    public static void initialize(){
        plugin.getCommand("help").setExecutor(new HelpCMD());
        plugin.getCommand("randomtp").setExecutor(new RandomCMD());
        plugin.getCommand("chat").setExecutor(new ChatCMD());
        plugin.getCommand("clTools").setExecutor(new pluginCMD());
    }
}
