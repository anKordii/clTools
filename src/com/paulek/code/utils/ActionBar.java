package com.paulek.code.utils;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ActionBar {

    public static void createBar(Player player, String message, int time){
        IChatBaseComponent msg = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + message + "\"}");

        PacketPlayOutChat packet = new PacketPlayOutChat(msg, (byte)2);


        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
    }
}
