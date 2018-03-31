package com.paulek.code.listners;

import com.paulek.code.config.ConfigMenager;
import com.paulek.code.utils.rtpLocation;
import org.bukkit.Location;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {

    public void onJoin(org.bukkit.event.player.PlayerJoinEvent e){
        if(ConfigMenager.getConfiguration().getBoolean("rtponjoin_enable")){
            if(!e.getPlayer().hasPlayedBefore()){
                Location l = rtpLocation.teleportJoin(e.getPlayer().getLocation().getWorld());
            }
        }
    }
}
