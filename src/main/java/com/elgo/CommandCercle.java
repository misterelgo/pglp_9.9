package com.elgo;

public class CommandCercle implements ICommand {
    private Cercle cercle;
    CercleDAO cercleDAO = new CercleDAO(cercle);
    public CommandCercle(Cercle cercle){
        this.cercle = cercle;
    }
    @Override
    public void execute() {
        cercleDAO.createForm();
        cercleDAO.addForme(cercle);
        cercleDAO.printAll();
    }
}
