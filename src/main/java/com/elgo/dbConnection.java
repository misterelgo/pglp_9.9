package com.elgo;
import java.sql.*;
public class dbConnection {

    private static String dbURL = "jdbc:derby://localhost:1527/formDB;create=true";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
    private static void display(String message) {
        System.out.println(message);
    }

    private static void stop(String message) {
        System.err.println(message);
        System.exit(99);
    }

    public  Connection getConnection() {
        // chargement du pilote
        //connection a la base de données
        display("connexion a la base de données");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            //Get a connection
            this.conn = DriverManager.getConnection(dbURL);
            if (this.conn!=null)
            {
                display("connected Successfully");
            }
        } catch (SQLException | ClassNotFoundException e) {
            stop("Connection à la base de données impossible");
        }
        return conn;
    }

}
