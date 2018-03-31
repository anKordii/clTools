package com.paulek.code.cmds;

import com.paulek.code.config.ConfigMenager;
import com.paulek.code.data.RtpButtonsData;
import com.paulek.code.utils.fixColors;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

public class RandomCMD implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender.hasPermission("cltools.randomtp")) {
            if (args.length == 0) {
                sender.sendMessage("§cRandomTp usage:");
                sender.sendMessage("§c/randomtp setbutton - sets the buton to randomtp");
                sender.sendMessage("§c/randomtp removebutton - removes the buton to randomtp");
                return true;
            }
            if (args[0].equalsIgnoreCase("removebutton")) {
                Player player = (Player) sender;
                if (!(sender instanceof Player)) {
                    sender.sendMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("errornotplayer")));
                    return false;
                }
                if ((player.getTargetBlock((Set<Material>) null, 1).getType() == Material.WOOD_BUTTON) || (player.getTargetBlock((Set<Material>) null, 5).getType() == Material.STONE_BUTTON)) {
                    Location loc = player.getTargetBlock((Set<Material>) null, 1).getLocation();
                    if (RtpButtonsData.getList().contains(loc)) {
                        RtpButtonsData.removeFromList(loc);
                        ConfigMenager.removeButtons();
                        ConfigMenager.getConfigurationButtons().set("Buttons", RtpButtonsData.getStringLoc());
                        ConfigMenager.saveButtons();
                        sender.sendMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("removetbutton")));
                    } else {
                        sender.sendMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("errorbuttondontexist")));
                    }
                } else {
                    sender.sendMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("errorlookbutton")));
                    return false;
                }
            }
            if (args[0].equalsIgnoreCase("setbutton")) {
                Player player = (Player) sender;
                if (!(sender instanceof Player)) {
                    sender.sendMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("errornotplayer")));
                    return false;
                }
                if ((player.getTargetBlock((Set<Material>) null, 1).getType() == Material.WOOD_BUTTON) || (player.getTargetBlock((Set<Material>) null, 5).getType() == Material.STONE_BUTTON)) {
                    Location loc = player.getTargetBlock((Set<Material>) null, 1).getLocation();
                    if (RtpButtonsData.getList().contains(loc)) {
                        sender.sendMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("errorbuttonexist")));
                        return false;
                    }
                    Location button = new Location(Bukkit.getWorld(loc.getWorld().getName()), loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
                    RtpButtonsData.addToList(button);
                    ConfigMenager.removeButtons();
                    ConfigMenager.getConfigurationButtons().set("Buttons", RtpButtonsData.getStringLoc());
                    ConfigMenager.saveButtons();
                    sender.sendMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("createbutton")));
                    return true;
                } else {
                    sender.sendMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("errorlookbutton")));
                    return false;
                }
            }
        } else {
            sender.sendMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("noPermisions")));
        }
        return false;
    }
}
