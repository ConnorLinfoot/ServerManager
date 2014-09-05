package com.connorlinfoot.servermanager.API;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.sql.ResultSet;

public class BanSystem {

    public static boolean banPlayer(OfflinePlayer player){

    }

    public static boolean banPlayer(String playerName){
        OfflinePlayer player = Bukkit.getOfflinePlayer(playerName);
        return banPlayer(player);
    }

    public static boolean unbanPlayer(OfflinePlayer player){

    }

    public static boolean unbanPlayer(String playerName){
        OfflinePlayer player = Bukkit.getOfflinePlayer(playerName);
        return unbanPlayer(player);
    }

    public static boolean isPlayerBanned(OfflinePlayer player){

    }

    public static boolean isPlayerBanned(String playerName){
        OfflinePlayer player = Bukkit.getOfflinePlayer(playerName);
        return isPlayerBanned(player);
    }

    public static ResultSet getTable(){
        return null;
    }

}
