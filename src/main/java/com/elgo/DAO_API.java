package com.elgo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAO_API<Figures>{
    Connection conn = null;

    public abstract void createForm();
    public abstract Figures findForm(int id) throws SQLException;
    public abstract int update(int id , String nom, String prenom);
    public abstract int delete (int id);
    public abstract void printAll ();
}
