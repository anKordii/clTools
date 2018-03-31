package com.paulek.code.listners;

import com.paulek.code.Main;
import com.paulek.code.config.ConfigMenager;
import com.paulek.code.utils.fixColors;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandPreprocessListner implements Listener {


    @EventHandler
    public void playerCmdPre(PlayerCommandPreprocessEvent event) {
        String command = event.getMessage().toLowerCase();
        Player player = event.getPlayer();
        if (!player.hasPermission("clTools.admin.bypass")) {
            if ((command.matches("/pl")) || (command.matches("/plugins")) || (command.matches("/ver")) ||
                    (command.matches("/version")) || (command.equals("/?"))) {
                event.setCancelled(true);
                player.sendMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("noPermisions")));
            }
            if ((command.startsWith("/bukkit")) || (command.startsWith("/spigot")) || (command.startsWith("/minecraft"))
                    || (command.startsWith("/calc")) || (command.startsWith("//calc")) || (command.startsWith("/pl"))
                    || (command.startsWith("/plugins")) || (command.startsWith("/?")) || (command.startsWith("/ver"))
                    || (command.startsWith("/version"))) {
                event.setCancelled(true);
                player.sendMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("noPermisions")));
            }
        }
    }
}
