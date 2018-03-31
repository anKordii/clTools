package com.paulek.code.data;

import com.paulek.code.Main;
import com.paulek.code.config.ConfigMenager;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class RtpButtonsData {

    private static List<Location> buttons = new ArrayList<>();
    private static List<String> but = new ArrayList<>();


    public static List getList(){
        return buttons;
    }

    public static void setList(List<Location> button){
        buttons = button;
    }
    public static void addToList(Location location){
        String tosave = location.getWorld().getName() + "#" + location.getBlockX() + "#" + location.getBlockY() + "#" +
                location.getBlockZ();
        but.add(tosave);
        buttons.add(location);
    }
    public static void removeFromList(Location location){
        String tosave = location.getWorld().getName() + "#" + location.getBlockX() + "#" + location.getBlockY() + "#" +
                location.getBlockZ();
        but.remove(tosave);
        buttons.remove(location);
    }
    public static List getStringLoc(){
        return but;
    }

    public static void loadButtons(){
        List<String> buttonstoconvert = ConfigMenager.getConfigurationButtons().getStringList("Buttons");

        if(buttonstoconvert.isEmpty()){
            Main.getInstance().getLogger().info("Randomtp Buttons list are empty!");
            return;
        }

        for(String s : buttonstoconvert){
            String[] str = s.split("#");
            Location loc = new Location(Bukkit.getWorld(str[0]), Integer.parseInt(str[1]),
                    Integer.parseInt(str[2]), Integer.parseInt(str[3]));
            buttons.add(loc);
        }

        if(buttons.isEmpty()){
            return;
        } else {
            for(Location loc : buttons){
                String tosave = loc.getWorld().getName() + "#" + loc.getBlockX() + "#" + loc.getBlockY() + "#" +
                        loc.getBlockZ();
                but.add(tosave);
            }
            int size = buttons.size();
            Main.getInstance().getLogger().info("Loaded: " + size + " locations of randomtp buttons");
        }
    }
}
