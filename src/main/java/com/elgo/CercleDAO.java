package com.elgo;



import java.sql.*;


public class CercleDAO extends DAO_API{

    Cercle cercle;
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/formes";

    //  Database credentials
    static final String USER = "elgo";
    static final String PASS = "";
    public CercleDAO(Cercle cercle){
        this.cercle = cercle;
    }

    @Override
    public void createForm() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // STEP 3: Execute a query
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            String dropTables = "DROP TABLE IF EXISTS CERCLE";
            String queryCercle = "CREATE TABLE CERCLE" +
                                 "(id INT PRIMARY KEY AUTO_INCREMENT," +
                                 " nom varchar(40), " +
                                 " centreX double, " +
                                 "centreY double, rayon double)";

            stmt.executeUpdate(dropTables);
            stmt.executeUpdate(queryCercle);
            System.out.println("Created table in given database...");

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

    public void addForme(Cercle cercle){
        Connection conn = null;
        Statement stmt = null;
        try{
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "INSERT INTO cercle (nom, centreX, centreY, rayon) " +
                    "VALUES ("+"'"+cercle.getNom()+"'"+","+cercle.getCentre().getX()+","+cercle.getCentre().getY()+","+cercle.getRayon()+")";

            stmt.executeUpdate(sql);

            System.out.println("Inserted form into the table...");

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
            String sql = "SELECT id, nom, centreX, centreY, rayon FROM CERCLE WHERE nom =  "+"'"+nom+"'";
            stmt.executeQuery(sql);

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("looking for cercle: "+nom);
            // STEP 4: Extract data from result set
            if (rs.next() == true){
                while(rs.next()) {
                    // Retrieve by column name
                    double centreX = rs.getDouble("centreX");
                    double centreY = rs.getDouble("centreY");
                    double rayon = rs.getDouble("rayon");

                    // Display values
                    System.out.print(nom+" = Cercle" +"("+centreX+", "+centreY+") "+rayon+")");
                }
                // STEP 5: Clean-up environment
                rs.close();
            }else{
                System.out.println("This Cercle doesn't exist here");
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
            String sql = "DELETE FROM CERCLE " + "WHERE id = "+ id;
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
            String sql = "SELECT id, nom, centreX, centreY, rayon FROM CERCLE";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                int id  = rs.getInt("id");
                String nom = rs.getString("nom");
                double centreX = rs.getDouble("centreX");
                double centreY = rs.getDouble("centreY");
                double rayon = rs.getDouble("rayon");

                // Display values
                System.out.print(nom+" = Cercle" + id +"("+centreX+", "+centreY+") "+rayon+")");
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
