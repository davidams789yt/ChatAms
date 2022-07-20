package me.davidams789.ChatAms.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.davidams789.ChatAms.Main;

public class Chat implements CommandExecutor {

    private Main plugin;
    public Chat(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        Player p = (Player) sender;

        if (args.length == 0) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l[&a&lChatAms&8&l] &cUso: /chat <on/off/clear>"));
        } else {
            // /chat on
            if (args[0].equalsIgnoreCase("on")) {
                if (p.hasPermission("chatams.on")) {
                    if (plugin.chat == true) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l[&a&lChatAms&8&l] &cEl chat ya estaba activado!"));
                    } else {
                        plugin.chat = true;
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7El chat se ha vuelto a activar!"));
                    }
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l[&a&lChatAms&8&l] &cNo tienes permisos para utilizar ese comando!"));
                }
            
            // /chat off
            } else if (args[0].equalsIgnoreCase("off")){
                if (p.hasPermission("chatams.off")) {
                    if (plugin.chat == false) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l[&a&lChatAms&8&l] &cEl chat ya estaba desactivado!"));
                    } else {
                        plugin.chat = false;
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7El chat se desactivo temporalmente!"));
                    }
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l[&a&lChatAms&8&l] &cNo tienes permisos para ejecutar ese comando!"));
                }

            // /chat clear
            } else if (args[0].equalsIgnoreCase("clear")) {
                if (p.hasPermission("chatams.clear")) {
                    for (int i = 0; i < 90; i++) {
                        Bukkit.broadcastMessage(" ");
                    }
                    
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "El chat ha sido borrado!"));
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l[&a&lChatAms&8&l] &cNo tienes permisos para ejecutar ese comando!"));
                }
            }
        }

        return true;
    }
    
}
