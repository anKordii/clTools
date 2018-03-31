package com.paulek.code.cmds;

import com.paulek.code.utils.fixColors;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class HelpCMD implements CommandExecutor {

    private static List<String> liste;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        for(int i=0; i<liste.size(); i++){
            sender.sendMessage(fixColors.fixColor(liste.get(i)));
        }
        return false;
    }

    public static void setList(List list){
        liste=list;
    }
}
