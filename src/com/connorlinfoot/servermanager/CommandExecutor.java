package com.connorlinfoot.servermanager;

import org.bukkit.Bukkit;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommandExecutor {

    static void Start(){
        Long cet = Main.getInstance().getConfig().getInt("Command Executor Time") * 20L;
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(),new Runnable() {
            @Override
            public void run() {
                try {
                    ResultSet resultSet = Main.c.prepareStatement("SELECT * FROM `Commands` WHERE `ran` == NULL;").executeQuery();
                    while( resultSet.next() ){
                        String command = resultSet.getString("command");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),command);
                        Main.c.prepareStatement("DELETE FROM `Commands` WHERE `ID` = " + resultSet.getInt("ID") + ";").executeUpdate();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }, 0L, cet);
    }

}
