package com.paulek.code.listners;

import com.paulek.code.config.ConfigMenager;
import com.paulek.code.utils.fixColors;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListner implements Listener{

    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        Block block = event.getBlock();
        Location loc = new Location(block.getWorld(), block.getX(), block.getY() - 1.0D, block.getZ());
        Block sb = loc.getBlock();
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(EnumParticle.NOTE, true, (float) (block.getX()), (float) (block.getY()), (float) (block.getZ()),
                1, 1, 1, 10, 50);
        if((block.getType() == Material.STONE) && (sb.getType() == Material.ENDER_STONE)){
            for(Player p : Bukkit.getOnlinePlayers()){
                ((CraftPlayer) p.getPlayer()).getHandle().playerConnection.sendPacket(packet);
            }
            event.getPlayer().sendMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("stoneGeneratorPlace")));
        }
        if((block.getType() == Material.OBSIDIAN) && (sb.getType() == Material.ENDER_STONE)){
            for(Player p : Bukkit.getOnlinePlayers()){
                ((CraftPlayer) p.getPlayer()).getHandle().playerConnection.sendPacket(packet);
            }
            event.getPlayer().sendMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("stoneGeneratorPlace")));
        }
    }
}