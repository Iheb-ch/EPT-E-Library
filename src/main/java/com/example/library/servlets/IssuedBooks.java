package com.example.library.servlets;
import com.example.library.beans.Book;
import com.example.library.beans.Order;
import com.example.library.dao.LibrarianDAO;
import com.example.library.dao.OrderDAO;
import com.example.library.dao.daoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "IssuedBooks", value = "/issuedBooks")
public class IssuedBooks extends HttpServlet {

    private OrderDAO orderdao;
    public void init() throws  ServletException{
        daoFactory dao=daoFactory.getInstance();
        this.orderdao=dao.getOrderDao();

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if ((boolean) session.getAttribute("logged")) {

            ArrayList<Order> orders = orderdao.listOrders();
            request.setAttribute("orders", orders);
            request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/IssuedBooks.jsp")
                    .forward(request, response);
        } else {
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("returnBook");
        orderdao.returnBookById(Integer.parseInt(orderId));
        ArrayList<Order> orders = orderdao.listOrders();
        request.setAttribute("orders", orders);
        request.getServletContext()
                .getRequestDispatcher("/WEB-INF/IssuedBooks.jsp")
                .forward(request, response);
    }
}