package com.example.library.beans;

import com.example.library.dao.BookDAO;
import com.example.library.dao.OrderDAO;
import com.example.library.dao.daoFactory;

import java.sql.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

public class Book {
    private int bookid;
    private int nbavailable;
    private String author;
    private String title;
    private String category;
    private String status;
    private String imgurl;
    private Date returnDate;
    private OrderDAO orderdao;
    private daoFactory daofact=daoFactory.getInstance();

    public Date getReturnDate(int studentid) {
         orderdao=daofact.getOrderDao();
         returnDate=orderdao.getReturnDateByBookId(this.bookid,studentid);
         return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getStatus() {
        if(is_available())
            status="available";
        else
            status="not_available";
        return status;
    }
    public boolean is_available(){
        return nbavailable>0;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public int getNbavailable() {
        return nbavailable;
    }

    public void setNbavailable(int nbavailable) {
        this.nbavailable = nbavailable;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
