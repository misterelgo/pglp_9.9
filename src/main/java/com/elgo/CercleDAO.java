package com.elgo;

import java.sql.SQLException;

public class CercleDAO implements DAO_API{
    @Override
    public Object createForm(Object obj) {
        return null;
    }

    @Override
    public Object findForm(int id) throws SQLException {
        return null;
    }

    @Override
    public int update(int id, String nom, String prenom) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public void printAll() {

    }
}
