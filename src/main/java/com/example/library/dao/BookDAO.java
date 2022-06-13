package com.example.library.dao;

import com.example.library.beans.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private daoFactory daoFact;

    public BookDAO(daoFactory daofact) {

        this.daoFact = daofact;
    }

    public void addBook(Book book) {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFact.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO book VALUES(?, ?,?,?,?,?);");
            preparedStatement.setInt(1, book.getBookid());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getCategory());
            preparedStatement.setString(4, book.getAuthor());
            preparedStatement.setInt(5, book.getNbavailable());
            preparedStatement.setString(6, "available");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addSample(Book book){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFact.getConnection();
            preparedStatement = connexion.prepareStatement("UPDATE book SET nbavailable=(?) WHERE bookid=(?);");
            preparedStatement.setInt(1, book.getNbavailable() + 1);
            preparedStatement.setInt(2, book.getBookid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Book> list() {
        ArrayList<Book> books = new ArrayList<Book>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFact.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT bookid,title,category,author,nbavailable,status,imgurl FROM book;");

            while (resultat.next()) {
                int bookid = resultat.getInt("bookid");
                String title = resultat.getString("title");
                String category = resultat.getString("category");
                String author = resultat.getString("author");
                int nbavailable = resultat.getInt("nbavailable");
                String status = resultat.getString("status");
                String imgurl = resultat.getString("imgurl");

                Book book = new Book();
                book.setBookid(bookid);
                book.setAuthor(author);
                book.setCategory(category);
                book.setNbavailable(nbavailable);
                book.setTitle(title);
                book.setStatus(status);
                book.setImgurl(imgurl);


                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public Book getBookByName(String title) {
        List<Book> lst = list();
        for (Book book : lst) {
            if ((book.getTitle()).equals(title))
                return book;
        }
        return new Book();
    }
    public Book getBookById(int id) {
        List<Book> lst = list();
        for (Book book : lst) {
            if ((book.getBookid())==(id))
                return book;
        }
        return new Book();

    }

        public void deleteBook(Book book) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFact.getConnection();
            preparedStatement = connexion.prepareStatement("UPDATE book SET nbavailable=(?) WHERE bookid=(?);");
            preparedStatement.setInt(1, book.getNbavailable() - 1);
            preparedStatement.setInt(2, book.getBookid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Book> getBooksByCategory(String category) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        List<Book> books = new ArrayList<Book>();
        ResultSet resultat = null;

        try {
            connexion = daoFact.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT bookid,title,category,author,nbavailable,status,imgurl FROM book WHERE category=?;");
            preparedStatement.setString(1, category);
            resultat = preparedStatement.executeQuery();
            while (resultat.next()) {
                int bookid = resultat.getInt("bookid");
                String title = resultat.getString("title");

                String author = resultat.getString("author");
                int nbavailable = resultat.getInt("nbavailable");
                String status = resultat.getString("status");
                String imgurl = resultat.getString("imgurl");
                Book book = new Book();
                book.setBookid(bookid);
                book.setAuthor(author);
                book.setCategory(category);
                book.setNbavailable(nbavailable);
                book.setTitle(title);

                book.setStatus(status);
                book.setImgurl(imgurl);

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    public List<Book> getAllAvailable(){
        List<Book> lst = list();
        List<Book> available=new ArrayList<Book>();
        for(Book b:lst){
            if(b.getStatus().equals("available"))
                available.add(b);
        }
        return available;
    }
    public List<Book> getAllUnavailable(){
        List<Book> lst = list();
        List<Book> notavailable=new ArrayList<Book>();
        for(Book b:lst){
            if(b.getStatus().equals("not_available"))
                notavailable.add(b);
        }
        return notavailable;
    }
}
