package com.paulek.code.cmds;

import com.paulek.code.config.ConfigMenager;
import com.paulek.code.data.ChatDisableData;
import com.paulek.code.utils.fixColors;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatCMD implements CommandExecutor{


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(sender.hasPermission("inftools.chat")) {
            if (args.length == 0) {
                sender.sendMessage("§cChat commands:");
                sender.sendMessage("§c/chat disabe - disables chat for players");
                sender.sendMessage("§c/chat enable - enables chat for players");
                sender.sendMessage("§c/chat clear - clears the chat");
                return false;
            }
            if((args[0].equalsIgnoreCase("enable")) || (args[0].equalsIgnoreCase("on"))){
                if(ChatDisableData.isIschaton()){
                    sender.sendMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("chatisalreadyon")));
                } else {
                    ChatDisableData.setIschaton(true);
                    sender.sendMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("chatseton")));
                }
                return false;
            }
            if((args[0].equalsIgnoreCase("disable")) || (args[0].equalsIgnoreCase("off"))){
                if(!ChatDisableData.isIschaton()){
                    sender.sendMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("chatisalreadyoff")));
                } else {
                    ChatDisableData.setIschaton(false);
                    sender.sendMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("chatsetoff")));
                }
                return false;
            }
            if(args[0].equalsIgnoreCase("clear")){
                for(Player p : Bukkit.getOnlinePlayers()){
                    for(int i = 0; i<200; i++) {
                        p.sendMessage("");
                    }
                }
                sender.sendMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("clearchat")));
                Bukkit.broadcastMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("chatwasclearby"))
                .replace("{player}", sender.getName()));
                return false;
            }
        } else {
            sender.sendMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("noPermisions")));
            return false;
        }
        return false;
    }
}
