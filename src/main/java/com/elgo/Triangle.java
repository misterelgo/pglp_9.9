package com.elgo;

public class Triangle implements Formes{
    String nom;
    Position sommet, leftbasePt, rightbasePt;

    public Triangle(String nom, Position sommet, Position leftbasePt, Position rightbasePt){
        this.nom = nom;
        this.sommet = sommet;
        this.leftbasePt = leftbasePt;
        this.rightbasePt = rightbasePt;
    }
    public String getNom() {
        return nom;
    }
    public Position getSommet() {
        return sommet;
    }
    public Position getLeftbasePt() {
        return leftbasePt;
    }
    public Position getRightbasePt() {
        return rightbasePt;
    }

    @Override
    public void display() {
        System.out.println(nom+" = Triangle(Sommet("+this.sommet.getX()+","+this.sommet.getY()+"), " +
                "Point_base_Gauche("+this.leftbasePt.getX()+","+this.leftbasePt.getY()+"), " +
                "Point_base_droite("+this.rightbasePt.getX()+","+this.rightbasePt.getY()+")");
    }

    @Override
    public void move(double x, double y) {

    }

}
