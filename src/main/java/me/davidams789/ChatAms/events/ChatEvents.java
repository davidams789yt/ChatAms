package me.davidams789.ChatAms.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

import me.davidams789.ChatAms.Main;

public class ChatEvents implements Listener{
    
    private Main plugin;
    public ChatEvents (Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void Chat(PlayerChatEvent e) {
        Player p = e.getPlayer();
        
        if (plugin.chat == false && !p.hasPermission("chatams.write")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void ChatAsync(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        
        if (plugin.chat == false && !p.hasPermission("chatams.write")) {
            e.setCancelled(true);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7No puedes usar el chat en estos momentos!"));
        }
    }
}
