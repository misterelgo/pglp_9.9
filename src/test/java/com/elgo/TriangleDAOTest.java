package com.elgo;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleDAOTest {

    @Test
    public void createForm() {
        Position A = new Position(2., 1.);
        Position B = new Position(1., 1.);
        Position C = new Position(2., 2.);
        Triangle triangle = new Triangle("trg1",A, B, C);
        triangle.display();
        TriangleDAO daoTriangle = new TriangleDAO();
        daoTriangle.createForm();
        daoTriangle.addForme(triangle);
        daoTriangle.printAll();
    }
}