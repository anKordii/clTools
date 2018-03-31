package com.paulek.code.utils;

import com.paulek.code.config.ConfigMenager;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class giantutil {

    private static List<String> nicks = ConfigMenager.getGigants().getStringList("names_gigants");
    private static int maxX = ConfigMenager.getGigants().getInt("maxX");
    private static int maxZ = ConfigMenager.getGigants().getInt("maxZ");
    private static World world = Bukkit.getWorld(ConfigMenager.getGigants().getString("world_name"));
    private static int skeletos = ConfigMenager.getGigants().getInt("settings.skeletons");
    private static int spiders = ConfigMenager.getGigants().getInt("settings.spiders");
    private static double health = ConfigMenager.getGigants().getDouble("settings.health");
    private static List<ItemStack> loots;

    public static List<String> getNicks() {
        return nicks;
    }

    public static void setNicks(List<String> nicks) {
        giantutil.nicks = nicks;
    }

    public static int getMaxX() {
        return maxX;
    }

    public static int getMaxZ() {
        return maxZ;
    }

    public static World getWorld() {
        return world;
    }

    public static int getSkeletos() {
        return skeletos;
    }

    public static int getSpiders() {
        return spiders;
    }

    public static double getHealth() {
        return health;
    }

    public static List<ItemStack> getLoots() {
        return loots;
    }

    public static void setLoots(List<ItemStack> loots) {
        giantutil.loots = loots;
    }
}
