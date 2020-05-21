package com.elgo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        CercleDAO cercle = new CercleDAO();
        cercle.createForm();
        Position centre = new Position(0., 0.);
        Cercle c1 = new Cercle(centre, 50.);
        cercle.addForme(c1);
        cercle.printAll();
    }
}
