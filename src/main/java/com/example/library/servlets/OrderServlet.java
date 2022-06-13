package com.example.library.servlets;

import com.example.library.beans.Book;
import com.example.library.beans.Order;
import com.example.library.beans.Student;
import com.example.library.dao.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

@WebServlet(name = "OrderServlet", value = "/Order")
public class OrderServlet extends HttpServlet {
    private StudentDAO studentDAO;
    private BookDAO bookDAO;
    private LibrarianDAO librarianDAO;
    private OrderDAO orderdao;
    public void init() throws  ServletException {
        daoFactory dao = daoFactory.getInstance();
        this.studentDAO = dao.getStudentDao();
        this.librarianDAO = dao.getLibrarianDao();
        this.orderdao=dao.getOrderDao();
        this.bookDAO=dao.getBookDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if((boolean) session.getAttribute("logged"))
        {
            String username = (String) session.getAttribute("username");
            String password = (String) session.getAttribute("password");

            Student student = studentDAO.getStudentById(Integer.parseInt(username));
            System.out.println(username);
            request.setAttribute("student",student);
            ArrayList<Book> books=orderdao.getBooksOrderedByStudentId(Integer.parseInt(username));
            request.setAttribute("books", books);
            request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/Order.jsp")
                    .forward(request, response);
        }
        else
        {
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
