package com.paulek.code;

import com.paulek.code.utils.initializePlugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main main;


    @Override
    public void onEnable(){
        main = this;
        initializePlugin.initialize();
    }

    public static Main getInstance(){
        return main;
    }
}
