package com.paulek.code.listners;

import com.paulek.code.config.ConfigMenager;
import com.paulek.code.data.RtpButtonsData;
import com.paulek.code.utils.ActionBar;
import com.paulek.code.utils.fixColors;
import com.paulek.code.utils.rtpLocation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerInteractListner implements Listener {

    private static String message;

    private static List<UUID> list = new ArrayList<>();

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Action action = event.getAction();
        Block clickedb = event.getClickedBlock();


        if((action == Action.RIGHT_CLICK_BLOCK) && ((clickedb.getType() == Material.WOOD_BUTTON) || (clickedb.getType() == Material.STONE_BUTTON))){
            Location loc = clickedb.getLocation();
            Player player = event.getPlayer();
            if(RtpButtonsData.getList().contains(loc)){
                Location totp = rtpLocation.teleportJoin(loc.getWorld());

                loc.getWorld().loadChunk(totp.getBlockX(), totp.getBlockZ());

                //list.add(player.getUniqueId());
                player.teleport(totp);

                Location locafter = player.getLocation();
                message = ConfigMenager.getMessages().getString("random");
                message = fixColors.fixColor(message).replace("{x}", String.valueOf(locafter.getBlockX()))
                        .replace("{y}", String.valueOf(locafter.getBlockY()))
                        .replace("{z}", String.valueOf(locafter.getBlockZ()));
                ActionBar.createBar(player, message,10);
            }
        }
    }

    public static List<UUID> getList() {
        return list;
    }
}
