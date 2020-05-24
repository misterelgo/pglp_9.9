package com.elgo;

import org.junit.Test;

import static org.junit.Assert.*;

public class CercleDAOTest {

    @Test
    public void createForm() {
        Position centre = new Position(0., 0.);
        Cercle c1 = new Cercle("c1", centre, 50.);
        CercleDAO cercle = new CercleDAO(c1);
        cercle.createForm();
        cercle.addForme(c1);
        cercle.printAll();
        cercle.findForm("c1");
        cercle.printAll();
    }
}