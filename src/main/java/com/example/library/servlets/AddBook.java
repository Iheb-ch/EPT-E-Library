package com.example.library.servlets;

import com.example.library.beans.Book;
import com.example.library.dao.BookDAO;
import com.example.library.dao.daoFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddBook", value = "/AddBook")
public class AddBook extends HttpServlet {
    private BookDAO bookdao;
    public void init() throws  ServletException{
        daoFactory dao=daoFactory.getInstance();
        this.bookdao=dao.getBookDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if ((boolean) session.getAttribute("logged")) {

            request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/AddBook.jsp")
                    .forward(request, response);

        } else {
            response.sendRedirect("/login");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookid = Integer.parseInt(request.getParameter("book_id"));
        String author = request.getParameter("book_author");
        String title = request.getParameter("book_title");
        String category = request.getParameter("book_category");
        int quantity = Integer.parseInt(request.getParameter("book_qty"));

        Book book = new Book();

        book.setBookid(bookid);
        book.setTitle(title);
        book.setAuthor(author);
        book.setCategory(category);
        book.setNbavailable( quantity);
        bookdao.addBook(book);
        response.sendRedirect("issuedBooks");

    }
}
