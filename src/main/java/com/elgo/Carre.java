package com.elgo;

public class Carre implements Formes{
    String nom;
    Position A, B, C, D;

    public Carre(String nom, Position A, Position B, Position C, Position D){
        if (D.getY() - A.getY() == C.getY() - B.getY() && B.getY() - A.getY() == C.getY() - D.getY()){
            this.nom = nom;
            this.A = A;
            this.B = B;
            this.C = C;
            this.D = D;
        }else {
            throw new IllegalArgumentException("Coordonnée innaproprie pour un carre");
        }
    }
    public String getNom() {
        return nom;
    }
    public Position getA() {
        return A;
    }
    public Position getB() {
        return B;
    }
    public Position getC() {
        return C;
    }
    public Position getD() {
        return D;
    }
    @Override
    public void display() {
        System.out.println(nom+" = Carré(A("+this.A.getX()+","+this.A.getY()+"), " +
                "B("+this.B.getX()+","+this.B.getY()+"), " +
                "C("+this.C.getX()+","+this.C.getY()+"), " +
                "D("+this.D.getX()+","+this.D.getY()+")");
    }

    @Override
    public void move(double x, double y) {

    }

}
