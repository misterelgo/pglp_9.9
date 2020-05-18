package com.elgo;

import java.util.List;

public class FormFactory {
    public static final String cercle = "cercle";
    public static final String rectangle = "rectangle";
    public static final String carre = "carre";
    public static final String triangle = "triangle";

    public Formes getForme(String typeForme, List <String> params) {
        Formes forme = null;

        switch (typeForme) {
            case cercle:
                Position centre = new Position(Double.parseDouble(params.get(2)),Double.parseDouble(params.get(3)));
                forme = new Cercle(centre, 50);
                break;
            case rectangle:
                Position coordA = new Position(Double.parseDouble(params.get(2)),Double.parseDouble(params.get(3)));
                Position coordB = new Position(Double.parseDouble(params.get(4)),Double.parseDouble(params.get(5)));;
                Position coordC = new Position(Double.parseDouble(params.get(6)),Double.parseDouble(params.get(7)));;
                Position coordD = new Position(Double.parseDouble(params.get(2)),Double.parseDouble(params.get(3)));;

                forme = new Rectangle(coordA, coordB, coordC, coordD);
                break;
            case carre:
                forme = new Carré();
                break;
            case triangle:
                forme = new Triangle();
                break;
            default:
                throw new IllegalArgumentException("Type de Forme inconnu");
        }

        return forme;
    }
}