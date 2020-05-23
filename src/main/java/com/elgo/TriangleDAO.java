package com.elgo;

import java.sql.*;

public class TriangleDAO extends DAO_API {
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
            String dropTables = "DROP TABLE IF EXISTS TRIANGLE";
            String queryTriangle = "CREATE TABLE TRIANGLE" +
                    "(id INT PRIMARY KEY AUTO_INCREMENT," +
                    " sommetX double, " +
                    " sommetY double, " +
                    " leftX double, " +
                    " leftY double, " +
                    "rightX double, rightY double)";

            stmt.executeUpdate(dropTables);
            stmt.executeUpdate(queryTriangle);
            System.out.println("Created Triangle in the given database...");

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

    public void addForme(Triangle triangle){
        Connection conn = null;
        Statement stmt = null;
        try{
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "INSERT INTO TRIANGLE (sommetX, sommetY, leftX, leftY, rightX, rightY) " +
                    "VALUES ("+"'"+triangle.getNom()+"'"+triangle.getSommet().getX()+","+triangle.getSommet().getY()+
                    ","+triangle.getLeftbasePt().getX()+","+triangle.getLeftbasePt().getX()+
                    ","+triangle.getRightbasePt().getX()+","+triangle.getRightbasePt().getX()+")";

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
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT id, nom, sommetX, SommetY, leftX, leftY, rightX, rightY FROM TRIANGLE WHERE nom =  "+"'"+nom+"'";
            stmt.executeQuery(sql);

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("looking for cercle: "+nom);
            // STEP 4: Extract data from result set
            if (rs.next() == true){
                while(rs.next()) {
                    // Retrieve by column name
                    double sommetX = rs.getDouble("sommetX");
                    double sommetY = rs.getDouble("sommetX");
                    double leftX = rs.getDouble("leftX");
                    double leftY = rs.getDouble("leftY");
                    double rightX = rs.getDouble("rightX");
                    double rightY = rs.getDouble("rightY");
                    // Display values
                    System.out.print(nom+" = TRIANGLE" +" A("+sommetX+", "+sommetY+") B("+leftX+","+ leftY+") C("+
                            rightX +", "+rightY+")");
                }
                // STEP 5: Clean-up environment
                rs.close();
            }else{
                System.out.println("This Triangle doesn't exist here");
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
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql = "DELETE FROM TRIANGLE " + "WHERE id = "+ id;
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
            String sql = "SELECT id, nom, sommetX, sommetY, leftX, leftY, rightX, rightY rayon FROM TRIANGLE";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                int id  = rs.getInt("id");
                String nom = rs.getString("nom");
                double sommetX = rs.getDouble("sommetX");
                double sommetY = rs.getDouble("sommetX");
                double leftX = rs.getDouble("leftX");
                double leftY = rs.getDouble("leftY");
                double rightX = rs.getDouble("rightX");
                double rightY = rs.getDouble("righty");
                // Display values
                System.out.print(nom+" = TRIANGLE" + id +" A("+sommetX+", "+sommetY+") B("+leftX+","+ leftY+") C("+
                        rightX +", "+rightY+")");
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
