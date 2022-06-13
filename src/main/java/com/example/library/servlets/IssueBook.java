package com.example.library.servlets;
import com.example.library.beans.Order;
import com.example.library.dao.BookDAO;
import com.example.library.dao.OrderDAO;
import com.example.library.dao.daoFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "IssueBook", value = "/issueBook")
public class IssueBook extends HttpServlet {
    private OrderDAO orderdao;
    public void init() throws  ServletException{
        daoFactory dao=daoFactory.getInstance();
        this.orderdao=dao.getOrderDao();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if ((boolean) session.getAttribute("logged")) {
            request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/IssueBook.jsp")
                    .forward(request, response);
        } else {
            response.sendRedirect("/login");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id=request.getParameter("book_no");
        String sid = request.getParameter("student_id");
        //System.out.println(id+" "+sid);
        int bookid = Integer.parseInt(id);
        int studentid = Integer.parseInt(sid);
        String borrowDate = request.getParameter("book_date_borrowed");
        //System.out.println(borrowDate);


        String returnDate = request.getParameter("book_date_due");
        //System.out.println(returnDate);
        Order order = new Order();

            order.setBookId(bookid);
            order.setStudentId(studentid);

            Date d=Date.valueOf(borrowDate);
            order.setBorrowDate(d );


            Date d2=Date.valueOf(returnDate);
            order.setReturnDate(d2);


            orderdao.newOrder(order);
        response.sendRedirect("/issuedBooks");
    }
}