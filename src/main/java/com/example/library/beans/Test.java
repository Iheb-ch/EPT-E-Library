package com.example.library.beans;

import com.example.library.beans.Book;
import com.example.library.dao.BookDAO;
import com.example.library.dao.LibrarianDAO;
import com.example.library.dao.daoFactory;

import java.sql.*;

public class Test {
    public static void main(String [] args) throws SQLException {
        daoFactory dao=daoFactory.getInstance();

//        BookDAO bookdao=dao.getBookDao();
//        String user="postgres";
//        String pass=" ch.com123";
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//
//        }
//        Connection connexion=dao.getConnection();
//        //connexion = dao.getConnection();
//        Statement st=connexion.createStatement();
//        //st.executeUpdate("INSERT INTO client VALUES(21921,'mohamed','salah',22222222,'mellita djerba')");
//        ResultSet rs = st.executeQuery("SELECT * FROM book");
//        while (rs.next()) {
//            int i = rs.getInt("bookid");
//            String title=rs.getString("title");
//            System.out.println("ROW = " + i + "Title="+title);
//        }
        BookDAO bookdao=dao.getBookDao();
        Book b=bookdao.getBookById(3);
        System.out.println(b.getTitle());
//        LibrarianDAO librarianDAO=dao.getLibrarianDao();
//        if(librarianDAO.checkLibrarian(1,"admin2"))
//            System.out.println("yes yes");
//        else
//            System.out.println("No way");
    }
}
