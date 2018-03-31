package com.paulek.code.utils;

import org.bukkit.ChatColor;

public class fixColors {

    public static String fixColor(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
