package com.elgo;

import junit.framework.TestCase;

public class FormesTest extends TestCase {

    public void testDisplay() {
        System.out.println( "Hello World!" );
        Position centre = new Position(0., 0.);
        Cercle c1 = new Cercle(centre, 50.);
        c1.display();
        c1.move(2., 2.);
        c1.display();
        Position A = new Position(2., 1.);
        Position B = new Position(1., 1.);
        Position C = new Position(2., 2.);
        Position D = new Position(1., 2.);
        Carre carre = new Carre(A, B, C, D);
        Rectangle rect = new Rectangle(A, B, C, D);
        carre.display();
        rect.display();
        Triangle triangle = new Triangle(A, B, C);
        triangle.display();
    }
}