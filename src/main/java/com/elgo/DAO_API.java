package com.elgo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

public interface DAO_API<T> extends Serializable {
    Connection conn = null;

    public abstract T createForm(T obj);
    public abstract T findForm(int id) throws SQLException;
    public abstract int update(int id , String nom, String prenom);
    public abstract int delete (int id);
    public abstract void printAll ();
}
