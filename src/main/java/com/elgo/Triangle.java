package com.elgo;

public class Triangle implements Formes{
    Position sommet, leftbasePt, rightbasePt;

    public Triangle(Position sommet, Position leftbasePt, Position rightbasePt){
        this.sommet = sommet;
        this.leftbasePt = leftbasePt;
        this.rightbasePt = rightbasePt;
    }

    @Override
    public void display() {
        System.out.println("Triangle(Sommet("+this.sommet.getX()+","+this.sommet.getY()+"), " +
                "Point_base_Gauche("+this.leftbasePt.getX()+","+this.leftbasePt.getY()+"), " +
                "Point_base_droite("+this.rightbasePt.getX()+","+this.rightbasePt.getY()+")");
    }

    @Override
    public void move(double x, double y) {

    }

}
