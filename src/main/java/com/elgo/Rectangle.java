package com.elgo;

public class Rectangle implements Formes{

    String nom;
    Position coordA, coordB, coordC, coordD;
    public Rectangle(String nom, Position coordA, Position coordB, Position coordC, Position coordD){
        if (coordD.getY() - coordA.getY() == coordC.getY() - coordB.getY()){
            this.nom = nom;
            this.coordA = coordA;
            this.coordB = coordB;
            this.coordC = coordC;
            this.coordD = coordD;
    }else {
            throw new IllegalArgumentException("Coordonnée innaproprie pour un rectangle");
        }
    }
    public String getNom() {
        return nom;
    }
    public Position getCoordA() {
        return coordA;
    }
    public Position getCoordB() {
        return coordB;
    }
    public Position getCoordC() {
        return coordC;
    }
    public Position getCoordD() {
        return coordD;
    }
    @Override
    public void display() {
        System.out.println(nom+" = Rectangle(A("+this.coordA.getX()+","+this.coordA.getY()+"), " +
                                     "B("+this.coordB.getX()+","+this.coordB.getY()+"), " +
                                     "C("+this.coordC.getX()+","+this.coordC.getY()+"), " +
                                     "D("+this.coordD.getX()+","+this.coordD.getY()+")");
    }

    @Override
    public void move(double x, double y) {

    }

}
