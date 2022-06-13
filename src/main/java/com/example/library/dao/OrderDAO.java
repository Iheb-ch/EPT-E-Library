package com.example.library.dao;

import com.example.library.beans.Book;
import com.example.library.beans.Order;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAO {

    private daoFactory daoFact;
    private BookDAO bookdao;//=daoFact.getBookDao();

    public OrderDAO(daoFactory daofact) {
        this.daoFact = daofact;
    }
    public void newOrder(Order order){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFact.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO orders VALUES(?, ?,?,?);");
            preparedStatement.setInt(1, order.getStudentId());
            preparedStatement.setInt(2, order.getBookId());
            preparedStatement.setDate(3,order.getBorrowDate() );
            preparedStatement.setDate(4, order.getReturnDate());
            preparedStatement.executeUpdate();
            bookdao=daoFact.getBookDao();
            Book book=bookdao.getBookById(order.getBookId());
            bookdao.deleteBook(book);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void returnBook(Order order){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFact.getConnection();
            preparedStatement = connexion.prepareStatement("DELETE FROM orders WHERE bookid=? AND studentid=?;");
            preparedStatement.setInt(1, order.getStudentId());
            preparedStatement.setInt(2, order.getBookId());
            preparedStatement.executeUpdate();
            Book book=bookdao.getBookById(order.getBookId());
            bookdao.addSample(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void returnBookById(int id){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        Statement statement=null;
        ResultSet resultat=null;
        try{
            connexion=daoFact.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT bookid FROM orders WHERE  id=?");
            preparedStatement.setInt(1, id);
            resultat=preparedStatement.executeQuery();
            int bookid=0;
            while (resultat.next()) {
                bookid=resultat.getInt("bookid");


            }
            System.out.println(bookid);
//            Book book=bookdao.getBookById(bookid);
//            bookdao.addSample(book);
        }catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connexion = daoFact.getConnection();
            preparedStatement = connexion.prepareStatement("DELETE FROM orders WHERE id=?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

//            Book book=bookdao.getBookById(order.getBookId());
//            bookdao.addSample(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<Order> getOrdersById(int id){
        ArrayList<Order> orders=listOrders();
        ArrayList<Order> listorders=new ArrayList<Order>();
        for(Order order:orders){
            if(order.getStudentId()==id)
                listorders.add(order);
        }
        return listorders;
    }
    public ArrayList<Order> listOrders(){
        ArrayList<Order> orders=new ArrayList<Order>();
        Connection connexion = null;
        Statement statement=null;
        ResultSet resultat = null;

        try {
            connexion = daoFact.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT studentid,bookid,borrowdate,returndate,id FROM orders ");

            while (resultat.next()) {
                int studentid = resultat.getInt("studentid");
                int bookid= resultat.getInt("bookid");
                Date borrowdate=resultat.getDate("borrowdate");
                Date returndate=resultat.getDate("returndate");
                int id=resultat.getInt("id");
                Order order=new Order();
                order.setStudentId(studentid);
                order.setBookId(bookid);
                order.setBorrowDate(borrowdate);
                order.setReturnDate(returndate);
                order.setId(id);


                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
    public ArrayList<Book> getBooksOrderedByStudentId(int id){
        ArrayList<Order> orders=listOrders();
        ArrayList<Book> books=new ArrayList<Book>();
        bookdao=daoFact.getBookDao();
        for(Order order:orders){
            if(order.getStudentId()==id){
                int idd=order.getBookId();
                System.out.println(idd);
                Book bb=bookdao.getBookById(idd);
                books.add(bb);
            }

        }
        return books;
    }
    public Date getReturnDateByBookId(int bookid, int studentid){
        ArrayList<Order> orders=listOrders();
        for(Order order:orders){
            if(order.getStudentId()==studentid && order.getBookId()==bookid){
                return order.getReturnDate();
            }

        }
        return new Date(2022,04,23);
    }

}



