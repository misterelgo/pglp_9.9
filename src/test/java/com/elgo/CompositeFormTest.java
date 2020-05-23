package com.elgo;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CompositeFormTest {

    @Test
    public void display() {
        CompositeForm group1 = new CompositeForm("quadrilatere");

        Position centre = new Position(0., 0.);
        Cercle c1 = new Cercle("c1", centre, 50.);
        Position A = new Position(2., 1.);
        Position B = new Position(1., 1.);
        Position C = new Position(2., 2.);
        Position D = new Position(1., 2.);
        Carre carre = new Carre("carre1",A, B, C, D);
        Rectangle rect = new Rectangle("rect1",A, B, C, D);
        Triangle triangle = new Triangle("trg1",A, B, C);

        group1.add(rect);
        group1.add(carre);
        group1.display();

    }
}