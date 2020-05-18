package com.elgo;

public class Carre implements Formes{
    Position A, B, C, D;

    public Carre(Position A, Position B, Position C, Position D){
        if (D.getY() - A.getY() == C.getY() - B.getY() && B.getY() - A.getY() == C.getY() - D.getY()){
            this.A = A;
            this.B = B;
            this.C = C;
            this.D = D;
        }else {
            throw new IllegalArgumentException("Coordonnée innaproprie pour un carre");
        }
    }
    @Override
    public void display() {
        System.out.println("Carré(A("+this.A.getX()+","+this.A.getY()+"), " +
                "B("+this.B.getX()+","+this.B.getY()+"), " +
                "C("+this.C.getX()+","+this.C.getY()+"), " +
                "D("+this.D.getX()+","+this.D.getY()+")");
    }

    @Override
    public void move(double x, double y) {

    }

}
