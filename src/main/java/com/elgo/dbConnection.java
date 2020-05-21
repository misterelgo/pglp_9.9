package com.elgo;
import java.sql.*;
public class dbConnection {
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
    String queryCercle = "CREATE TABLE cercle(Id INT PRIMARY KEY AUTO_INCREMENT, centreX double, centreY double, Rayon double)";
    String queryRectangle = "CREATE TABLE rectangle(Id INT PRIMARY KEY AUTO_INCREMENT, AX double, AY double, BX double, BY double, CX double, CY double,DX double, DY double)";
    String queryCarre = "CREATE TABLE rectangle(Id INT PRIMARY KEY AUTO_INCREMENT, AX double, AY double, BX double, BY double, CX double, CY double,DX double, DY double)";
    String queryTriangle = "CREATE TABLE rectangle(Id INT PRIMARY KEY AUTO_INCREMENT, sommetX double, sommetY double, baseX double, baseY double, basedX double, basedY double)";
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
            Class.forName("org.h2.Driver");
            //Get a connection
            conn = DriverManager.getConnection("jdbc:h2:~/formes", "elgo", "" );
            Statement stmt = conn.createStatement();
            if (conn!=null)
            {
                display("connected Successfully");
                stmt.executeUpdate(queryCercle);
                stmt.executeUpdate(queryRectangle);
                stmt.executeUpdate(queryCarre);
                stmt.executeUpdate(queryTriangle);
            }
        } catch (SQLException | ClassNotFoundException e) {
            stop("Connection à la base de données impossible");
        }
        return conn;
    }

}
