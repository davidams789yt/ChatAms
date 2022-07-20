package me.davidams789.ChatAms;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.davidams789.ChatAms.commands.Chat;
import me.davidams789.ChatAms.events.ChatEvents;

public class Main extends JavaPlugin{

    public static boolean chat = true;
    
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l[&a&lChatAms&8&l] &aEl plugin ha sido activado"));
        registerCommands();
        registerEvents();
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l[&a&lChatAms&8&l] &cEl plugin ha sido desactivado"));
    }

    public void registerCommands() {
        getCommand("chat").setExecutor(new Chat(this));
    }

    public void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ChatEvents(this), this);
    }
}
