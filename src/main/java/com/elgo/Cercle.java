package com.elgo;

public class Cercle implements Formes {

    int rayon;
    Position centre;
    public Cercle(Position centre, int rayon){
        this.centre = centre;
        this.rayon = rayon;

    }
    @Override
    public void display() {
        System.out.println("Cercle(centre("+centre.getX()+","+centre.getY()+")rayon: "+rayon+")");
}

    @Override
    public void move(double x, double y) {
        centre.setX(x);
        centre.setY(y);
    }
}
