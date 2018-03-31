package com.paulek.code.config;

import com.paulek.code.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class ConfigMenager {

    private static  JavaPlugin plugin = Main.getInstance();
    private static  File configf;
    private static  File helpf;
    private static  File buttonsf;
    private static  File msgf;
    private static  File giantf;
    private static File cenzorf;
    private static  YamlConfiguration help, buttons, msgs, gigants, cenzor;


    public static  void checkFiles() {

        configf = new File(plugin.getDataFolder(), "config.yml");
        helpf = new File(plugin.getDataFolder(), "help.yml");
        buttonsf = new File(plugin.getDataFolder(), "buttons.yml");
        msgf = new File(plugin.getDataFolder(), "messages.yml");
        giantf = new File(plugin.getDataFolder(), "gigants.yml");
        //cenzorf = new File(plugin.getDataFolder(), "cenznor.yml");

        if (!configf.exists()) {
            configf.getParentFile().mkdirs();
            plugin.saveResource("config.yml", true);
            plugin.getLogger().info("Config.yml not found, creating new one :D");
        }
        if (!helpf.exists()) {
            helpf.getParentFile().mkdirs();
            plugin.saveResource("help.yml", true);
            plugin.getLogger().info("Help.yml not found, creating new one :D");
        }
        if (!buttonsf.exists()) {
            helpf.getParentFile().mkdirs();
            plugin.saveResource("buttons.yml", true);
            plugin.getLogger().info("Buttons.yml not found, creating new one :D");
        }
        if (!msgf.exists()) {
            helpf.getParentFile().mkdirs();
            plugin.saveResource("messages.yml", true);
            plugin.getLogger().info("Messages.yml not found, creating new one :D");
        }
        if (!giantf.exists()) {
            giantf.getParentFile().mkdirs();
            plugin.saveResource("gigants.yml", true);
            plugin.getLogger().info("Gigants.yml not found, creating new one :D");
        }
//        if (!cenzorf.exists()) {
//            cenzorf.getParentFile().mkdirs();
//            plugin.saveResource("cenzor.yml", true);
//            plugin.getLogger().info("Cenzor.yml not found, creating new one :D");
//        }

        try {
            help = YamlConfiguration.loadConfiguration(helpf);
            buttons = YamlConfiguration.loadConfiguration(buttonsf);
            msgs = YamlConfiguration.loadConfiguration(msgf);
            gigants = YamlConfiguration.loadConfiguration(giantf);
            //cenzor = YamlConfiguration.loadConfiguration(cenzorf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static YamlConfiguration getMessages() {
        return msgs;
    }

    public static YamlConfiguration getConfiguration(){
        return help;
    }

    public static YamlConfiguration getConfigurationButtons(){
        return buttons;
    }

    public static YamlConfiguration getGigants() {
        return gigants;
    }

    public static YamlConfiguration getCenzor() {
        return cenzor;
    }

    public static void saveButtons(){
        try{
            buttons.save(buttonsf);
        } catch (IOException e){
            Main.getInstance().getLogger().info("An erron on saving Buttons.yml : " + e);
        }
    }
    public static void removeButtons(){
        try{
            buttons.set("Buttons", null);
        } catch (Exception e){
            Main.getInstance().getLogger().info("An erron on removing Buttons.yml : " + e);
        }
    }
}
