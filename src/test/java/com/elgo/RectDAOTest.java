package com.elgo;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectDAOTest {

    @Test
    public void createForm() {
        Position A = new Position(2., 1.);
        Position B = new Position(1., 1.);
        Position C = new Position(2., 2.);
        Position D = new Position(1., 2.);
        Carre carre = new Carre("carre1",A, B, C, D);
        Rectangle rect = new Rectangle("trg1",A, B, C, D);
        RectDAO daoRect = new RectDAO();
        daoRect.createForm();
        daoRect.addForme(rect);
        daoRect.printAll();
    }
}