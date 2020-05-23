package com.elgo;

import org.junit.Test;

import static org.junit.Assert.*;

public class CercleDAOTest {

    @Test
    public void createForm() {
        CercleDAO cercle = new CercleDAO();
        cercle.createForm();
        Position centre = new Position(0., 0.);
        Cercle c1 = new Cercle("c1", centre, 50.);
        cercle.addForme(c1);
        cercle.printAll();
        cercle.findForm("c1");
        cercle.printAll();
    }
}