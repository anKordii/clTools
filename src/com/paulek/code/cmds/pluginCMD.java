package com.paulek.code.cmds;

import com.paulek.code.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class pluginCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        String version = Main.getInstance().getDescription().getVersion();
        sender.sendMessage("§7---------------§3§lclTools§7---------------");
        sender.sendMessage("§a§lPlugin made by PaulekOfficial");
        sender.sendMessage("§cPlugin version: §6" + version);
        return true;
    }
}
