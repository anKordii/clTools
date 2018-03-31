package com.paulek.code.listners;

import com.paulek.code.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListner implements Listener {

    int regenerate = Main.getInstance().getConfig().getInt("stoneGeneratorTimeToRegenerate");

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        final Block block1 = event.getBlock();
        Location loc1 = block1.getLocation();
        Location stone1 = new Location(loc1.getWorld(), loc1.getX(), loc1.getY() - 1.0, loc1.getZ());
        final Block sb1 = stone1.getBlock();

        final Block block2 = event.getBlock();
        Location loc2 = block1.getLocation();
        Location stone2 = new Location(loc2.getWorld(), loc2.getX(), loc2.getY() - 1.0, loc2.getZ());
        final Block sb2 = stone1.getBlock();

        if((block1.getType() == Material.STONE) && (sb1.getType() == Material.ENDER_STONE)){

            Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    if(sb1.getType() == Material.ENDER_STONE){
                        block1.setType(Material.STONE);
                    }
                }
            }, regenerate);

        }

        if((block2.getType() == Material.OBSIDIAN) && (sb2.getType() == Material.ENDER_STONE)){

            Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    if(sb2.getType() == Material.ENDER_STONE){
                        block2.setType(Material.OBSIDIAN);
                    }
                }
            }, regenerate);

        }
    }
}
