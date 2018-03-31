package com.paulek.code.listners;

import com.paulek.code.config.ConfigMenager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ChunkUnloadEvent implements Listener {

    @EventHandler
    public void onUnload(org.bukkit.event.world.ChunkUnloadEvent event){
        if(ConfigMenager.getConfiguration().getBoolean("disableunloading_chunks")){
            event.setCancelled(true);
        }
    }
}
