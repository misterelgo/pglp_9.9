package com.elgo;

import java.sql.*;

public class RectDAO extends DAO_API{
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/formes";

    //  Database credentials
    static final String USER = "elgo";
    static final String PASS = "";

    @Override
    public void createForm() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // STEP 3: Execute a query
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            String dropTables = "DROP TABLE IF EXISTS RECTANGLE";
            String queryRect = "CREATE TABLE RECTANGLE" +
                    "(id INT PRIMARY KEY AUTO_INCREMENT," +
                    " nom varchar(40), " +
                    " ax double, " +
                    " ay double, " +
                    " bx double, " +
                    " by double, " +
                    " cx double, " +
                    " cy double, " +
                    "dx double, dy double)";
            stmt.executeUpdate(dropTables);
            stmt.executeUpdate(queryRect);
            System.out.println("Created Rectangle in the given database...");

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
    }

    public void addForme(Rectangle rect){
        Connection conn = null;
        Statement stmt = null;
        try{
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Connected database successfully...");

            // STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "INSERT INTO RECTANGLE (nom, ax, ay, bx, by, cx, cy, dx, dy) " +
                    "VALUES ("+"'"+rect.getNom()+"'"+
                    ","+rect.getCoordA().getX()+","+rect.getCoordA().getY()+
                    ","+rect.getCoordB().getX()+","+rect.getCoordB().getX()+
                    ","+rect.getCoordC().getX()+","+rect.getCoordC().getX()+
                    ","+rect.getCoordD().getX()+","+rect.getCoordD().getX()+")";

            stmt.executeUpdate(sql);

            System.out.println("Inserted records into the table...");

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }
    @Override
    public Object findForm(String nom){
        Connection conn = null;
        Statement stmt = null;
        try{
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Connected database successfully...");

            // STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT id, nom, ax, ay, bx, by, cx, cy, dx, dy FROM RECTANGLE WHERE nom =  "+"'"+nom+"'";
            stmt.executeQuery(sql);

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("looking for rectangle : "+nom);
            // STEP 4: Extract data from result set
            if (rs.next() == true){
                while(rs.next()) {
                    // Retrieve by column name
                    double ax = rs.getDouble("ax");
                    double ay = rs.getDouble("ay");
                    double bx = rs.getDouble("bx");
                    double by = rs.getDouble("by");
                    double cx = rs.getDouble("cx");
                    double cy = rs.getDouble("cy");
                    double dx = rs.getDouble("dx");
                    double dy = rs.getDouble("dy");
                    // Display values
                    System.out.print(nom+" = RECTANGLE" +" A("+ax+", "+ay+") B("+bx+","+ by+") C("+
                            cx +", "+cy+" D("+ dx +", "+dy+")");
                }
                // STEP 5: Clean-up environment
                rs.close();
            }else{
                System.out.println("This Rectangle doesn't exist here");
            }

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        return null;
    }

    public void update(int id, String nom, String prenom) {

    }

    @Override
    public void delete(int id) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            stmt = conn.createStatement();
            String sql = "DELETE FROM RECTANGLE " + "WHERE id = "+ id;
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }

    @Override
    public void printAll() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // STEP 3: Execute a query
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            String sql = "SELECT id, nom, ax, ay, bx, by, cx, cy, dx, dy FROM RECTANGLE";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                int id  = rs.getInt("id");
                String nom = rs.getString("nom");
                double ax = rs.getDouble("ax");
                double ay = rs.getDouble("ay");
                double bx = rs.getDouble("bx");
                double by = rs.getDouble("by");
                double cx = rs.getDouble("cx");
                double cy = rs.getDouble("cy");
                double dx = rs.getDouble("dx");
                double dy = rs.getDouble("dy");
                // Display values
                System.out.print(nom+" = RECTANGLE" + id +" A("+ax+", "+ay+") B("+bx+","+ by+") C("+
                        cx +", "+cy+" D("+ dx +", "+dy+")");
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }
}
