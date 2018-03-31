package com.paulek.code.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.minecraft.server.v1_8_R3.Packet;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Collection;

public class skinfixer {


    public void fixSkin(CraftPlayer craftPlayer){
        GameProfile profile = craftPlayer.getProfile();

        try{
//            profile =
        } catch (Exception e){

        }

        Collection<Property> collection = profile.getProperties().get("textures");

        profile.getProperties().removeAll("textures");
        profile.getProperties().putAll("textures", collection);
    }


    public void sendPacket(Packet packet){
        for(Player player : Bukkit.getOnlinePlayers()){
            ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
        }
    }
}
