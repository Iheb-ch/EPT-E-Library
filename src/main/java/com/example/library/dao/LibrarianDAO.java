package com.example.library.dao;

import com.example.library.beans.Book;
import com.example.library.beans.Librarian;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibrarianDAO {
    private daoFactory daoFact;

    public LibrarianDAO(daoFactory daofact) {
        this.daoFact = daofact;
    }
    public ArrayList<Librarian> listl() {
        ArrayList<Librarian> librarians = new ArrayList<Librarian>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFact.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT id,name,lastname,password FROM librarian;");

            while (resultat.next()) {
                int id = resultat.getInt("id");
                String name = resultat.getString("name");
                String lastname = resultat.getString("lastname");
                String password = resultat.getString("password");

                Librarian librarian=new Librarian();
                librarian.setId(id);
                librarian.setLastname(lastname);
                librarian.setName(name);
                librarian.setPassword(password);


                librarians.add(librarian);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return librarians;
    }
    public Librarian getLibrarianById(int id){
        ArrayList<Librarian> lst = listl();
        for (Librarian librarian : lst) {
            if ((librarian.getId())==(id))
                return librarian;
        }
        return new Librarian();

    }
    public boolean checkLibrarian(int id,String password){
        Librarian lb=getLibrarianById(id);
        if(lb.getPassword()==null)
            return false;
        return (lb.getPassword()).equals(password);

    }

}
