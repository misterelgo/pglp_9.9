package com.elgo;

public class Rectangle implements Formes{

    Position coordA, coordB, coordC, coordD;
    public Rectangle(Position coordA, Position coordB, Position coordC, Position coordD){
        if (coordD.getY() - coordA.getY() == coordC.getY() - coordB.getY()){
            this.coordA = coordA;
            this.coordB = coordB;
            this.coordC = coordC;
            this.coordD = coordD;
    }else {
            throw new IllegalArgumentException("Coordonnée innaproprie pour un rectangle");
        }
    }
    @Override
    public void display() {
        System.out.println("Rectangle(A("+this.coordA.getX()+","+this.coordA.getY()+"), " +
                                     "B("+this.coordB.getX()+","+this.coordB.getY()+"), " +
                                     "C("+this.coordC.getX()+","+this.coordC.getY()+"), " +
                                     "D("+this.coordD.getX()+","+this.coordD.getY()+")");
    }

    @Override
    public void move(double x, double y) {

    }

}
