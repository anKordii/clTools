package com.paulek.code.listners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.UUID;

public class EntityDamageEvent implements Listener {

    @EventHandler
    public void onDamage(org.bukkit.event.entity.EntityDamageEvent event){
        if(event.getEntity() instanceof Player){
            if(event.getCause() != org.bukkit.event.entity.EntityDamageEvent.DamageCause.FALL){
                return;
            }
            Player player = ((Player) event.getEntity()).getPlayer();
            UUID uuid = player.getUniqueId();
            if(PlayerInteractListner.getList().contains(uuid)){
                event.setCancelled(true);
                player.setHealth(20);
                PlayerInteractListner.getList().remove(uuid);
            }
        }
    }
}
