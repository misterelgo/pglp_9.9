package com.elgo;

import java.util.Scanner;

public class DrawingApp {
    private  ICommand command;
    private Formes forme ;
    public  void run(){
        DrawingTUI drawform = new DrawingTUI();
        System.out.println("Veuillez entrer une commande:");
        Scanner sc = new Scanner(System.in);
        String userInput=sc.nextLine();
        command = drawform.nextCommand(userInput);
        //System.out.println(userInput);
        command.execute();

    }
    public static void main( String[] args ) {

        System.out.println( "@********* Welcome to our Drawing App! ********@" );
        DrawingApp app = new DrawingApp();
        app.run();
    }
}
