package com.paulek.code.utils;

import com.paulek.code.Main;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class rtpLocation {

    private static JavaPlugin plugin = Main.getInstance();

    public static Location teleportJoin(World world){
        Random RAND = new Random();
        int x = plugin.getConfig().getInt("randomTPminX") + RAND.nextInt(plugin.getConfig().getInt("randomTPmaxX") -
        plugin.getConfig().getInt("randomTPminX") + 1);
        int z = plugin.getConfig().getInt("randomTPminZ") + RAND.nextInt(plugin.getConfig().getInt("randomTPmaxZ") -
        plugin.getConfig().getInt("randomTPminX") + 1);
        int y = world.getHighestBlockYAt(x, z);
        if((world.getBlockAt(new Location(world, x, y, z)).getBiome() == Biome.OCEAN) || (world.getBlockAt(new Location(world, x, y, z)).getBiome() == Biome.DEEP_OCEAN)
                || (world.getBlockAt(new Location(world, x, y, z)).getBiome() == Biome.FROZEN_OCEAN)){
            teleportJoin(world);
        }
        Location loc = new Location(world, x, y, z);
        int yfix = world.getHighestBlockYAt(loc);
        return new Location(world, x, yfix, z);
    }
}
