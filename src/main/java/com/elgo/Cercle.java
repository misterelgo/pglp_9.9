package com.elgo;

public class Cercle implements Formes {

    String nom;
    double rayon;
    Position centre;
    public Cercle(String nom, Position centre, double rayon){
        this.nom = nom;
        this.centre = centre;
        this.rayon = rayon;

    }

    public double getRayon() {
        return rayon;
    }
    public String getNom() {
        return nom;
    }
    public Position getCentre() {
        return centre;
    }
    @Override
    public void display() {
        System.out.println(nom+" = Cercle(centre("+centre.getX()+","+centre.getY()+")rayon: "+rayon+")");
}

    @Override
    public void move(double x, double y) {
        centre.setX(x);
        centre.setY(y);
    }
}
