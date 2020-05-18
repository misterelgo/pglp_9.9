package com.elgo;

import java.util.ArrayList;
import java.util.List;

public class CompositeForm implements Formes{

    private List<Formes> formsGroup =new ArrayList<>();
    @Override
    public void display() {
        for (Formes forme : formsGroup) {
            forme.display();
        }
    }

    @Override
    public void move(double x, double y) {

    }


    public List<Formes> getFormsGroup() {
        return formsGroup;
    }

    public void setGroupeForme(List<Formes> formsGroup) {
        this.formsGroup = formsGroup;
    }
    public void add(Formes forme)
    {
        formsGroup.add(forme);
    }
    public void remove(Formes forme)
    {
        formsGroup.remove(forme);
    }
}
