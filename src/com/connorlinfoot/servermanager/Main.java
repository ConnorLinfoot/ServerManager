package com.connorlinfoot.servermanager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.sql.Connection;


public class Main extends JavaPlugin implements Listener {
    private static Plugin instance;
    static Connection c = null;

    com.connorlinfoot.servermanager.MySQL.MySQL MySQL = null;
    public void onEnable() {
        instance = this;
        getConfig().options().copyDefaults(true);
        saveConfig();

        String mySQLUser = getConfig().getString("MySQL.User");
        String mySQLName = getConfig().getString("MySQL.Name");
        String mySQLHost = getConfig().getString("MySQL.Host");
        String mySQLPass = getConfig().getString("MySQL.Pass");
        MySQL = new com.connorlinfoot.servermanager.MySQL.MySQL(this, mySQLHost, "3306", mySQLName, mySQLUser, mySQLPass);

        Server server = getServer();
        ConsoleCommandSender console = server.getConsoleSender();

        c = MySQL.openConnection();
        if( c == null ){
            console.sendMessage(ChatColor.RED + "ReporterHelper Failed To Start, Check Your MySQL Settings!");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        console.sendMessage(ChatColor.GREEN + "========== ServerManager! ==========");
        console.sendMessage(ChatColor.GREEN + "=========== VERSION: 0.1 ===========");
        console.sendMessage(ChatColor.GREEN + "======== BY CONNOR LINFOOT! ========");

        // Activate Command Executor
        CommandExecutor.Start();
    }

    public void onDisable() {
        getLogger().info(getDescription().getName() + " has been disabled!");
    }

    public static Plugin getInstance() {
        return instance;
    }
}
