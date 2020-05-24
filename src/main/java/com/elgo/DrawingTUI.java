package com.elgo;

public class DrawingTUI {

    public ICommand nextCommand(String userInput){
        if((userInput.toLowerCase()).indexOf("cercle")!=-1) {
            System.out.println("creation d'un cercle");
            userInput = userInput.replaceAll("\\s","");
            double centrex = Double.parseDouble(Character.toString(userInput.charAt(userInput.indexOf("(")+2)));
            double centrey = Double.parseDouble(Character.toString(userInput.charAt(userInput.indexOf("(")+4)));
            String rayons = userInput.substring(userInput.length()-3, userInput.length()-1);
            double rayon = Double.parseDouble(rayons);
            String nom = userInput.substring(0, userInput.indexOf("="));
            Position centre = new Position(centrex, centrey);
            Cercle cuser = new Cercle(nom, centre, rayon);
            CommandCercle cercleCommand = new CommandCercle(cuser);
            return cercleCommand;
        }
        else if(userInput.indexOf("rectangle")!=-1){
            System.out.println("Creation d'un rectangle");
            CommandRect rectCommand = new CommandRect();
            return rectCommand;
        }
        else if(userInput.indexOf("carre")!=-1) {
            System.out.println("Creation d'un Carre");
            CommandCarre carreCommand = new CommandCarre();
            return carreCommand;
        }
        else
        {
            System.out.println("Creation d'un triangle");
            CommandTrgl trglCommand = new CommandTrgl();
            return trglCommand;
        }
    }
}
