package com.paulek.code.listners;

import com.paulek.code.utils.giantutil;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class EntityDeathEvent implements Listener {

    Random random = new Random();

    @EventHandler
    public void onDeath(org.bukkit.event.entity.EntityDeathEvent event){
        if(event.getEntityType().equals(EntityType.GIANT)){
            if(giantutil.getNicks().contains(event.getEntity().getCustomName())){
                ItemStack item = (ItemStack) giantutil.getLoots().get(random.nextInt(giantutil.getLoots().size()));

                giantutil.getWorld().dropItemNaturally(event.getEntity().getLocation(), item);
            }
        }
    }
}
