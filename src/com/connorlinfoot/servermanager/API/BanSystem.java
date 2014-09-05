package com.connorlinfoot.servermanager.API;

import com.connorlinfoot.servermanager.Main;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        String playerName = player.getName();
        return isPlayerBanned(playerName);
    }

    public static boolean isPlayerBanned(String playerName){
        try {
            return getTable("`PlayerName` = '" + playerName + "'").next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ResultSet getTable(){
        return getTable(null);
    }

    public static ResultSet getTable(String whereStatement){
        try {
            if( whereStatement != null ){
                return Main.c.prepareStatement("SELECT * FROM `Bans` WHERE " + whereStatement + ";").executeQuery();
            } else {
                return Main.c.prepareStatement("SELECT * FROM `Bans`;").executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
