package com.paulek.code.listners;

import com.paulek.code.config.ConfigMenager;
import com.paulek.code.data.ChatDisableData;
import com.paulek.code.utils.fixColors;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

public class AsyncPlayerChatListner implements Listener {

//    private String cenzored = ConfigMenager.getMessages().getString("replace_chat_message");
//    private List<String> tocenzor = ChatDisableData.getTocenzor();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();

        if(!player.hasPermission("clTools.bypass")){
            if(ChatDisableData.isIschaton() == false) {
                event.setCancelled(true);
                player.sendMessage(fixColors.fixColor(ConfigMenager.getMessages().getString("chatoff")));
            }
        }

//        if(!ChatDisableData.isEnablecenzor()){
//            return;
//        }
//
//        for(String cenzor : tocenzor){
//            event.setMessage(event.getMessage().replaceAll(cenzor, cenzored));
//        }
    }
}
