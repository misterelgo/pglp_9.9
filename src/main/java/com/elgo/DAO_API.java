package com.elgo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAO_API<Figures>{
    Connection conn = null;

    public abstract void createForm();
    public abstract Figures findForm(String nom) throws SQLException;
    public abstract void delete (int id);
    public abstract void printAll ();
}
