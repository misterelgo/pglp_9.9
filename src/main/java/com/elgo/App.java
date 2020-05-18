package com.elgo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Position centre = new Position(0., 0.);
        Cercle c1 = new Cercle(centre, 50);
        c1.display();
        c1.move(2., 2.);
        c1.display();
    }
}
