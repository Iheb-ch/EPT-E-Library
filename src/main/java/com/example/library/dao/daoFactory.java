package com.example.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class daoFactory {
    private static String url;
    private static String username;
    private static String password;

    daoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static daoFactory getInstance() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {

        }

        daoFactory instance = new daoFactory(
                "jdbc:postgresql://localhost:5432/elibrary", "postgres", " ch.com123");
        return instance;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    public BookDAO getBookDao() {
       return new BookDAO(this);
    }

    public OrderDAO getOrderDao(){
        return new OrderDAO(this);
    }
    public StudentDAO getStudentDao(){
        return new StudentDAO(this);
    }
    public LibrarianDAO getLibrarianDao(){
        return new LibrarianDAO(this);
    }
}
