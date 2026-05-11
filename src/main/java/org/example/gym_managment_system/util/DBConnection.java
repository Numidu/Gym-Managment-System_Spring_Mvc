package org.example.gym_managment_system.util;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:sqlite:C:/DB/gym.db";

    public static Connection getConnection(){

        try {

            Class.forName("org.sqlite.JDBC");
            System.out.println("Connecting to database...");
            return DriverManager.getConnection(URL);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}
