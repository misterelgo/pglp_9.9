package com.elgo;

public class DrawingApp {
    public  void run(){
        DrawingTUI drawform = new DrawingTUI();
    }
    public static void main( String[] args ) {
        System.out.println( "@********* Welcome to our Drawing App! ********@" );
        DrawingApp app = new DrawingApp();
        app.run();
    }
}
