package com.example.library.servlets;

import com.example.library.dao.LibrarianDAO;
import com.example.library.dao.StudentDAO;
import com.example.library.dao.daoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = "/login")
public class Login extends HttpServlet {

    private StudentDAO studentDAO;
    private LibrarianDAO librarianDAO;
    public void init() throws  ServletException {
        daoFactory dao = daoFactory.getInstance();
        this.studentDAO = dao.getStudentDao();
        this.librarianDAO = dao.getLibrarianDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.invalidate();
        session = request.getSession();
        session.setAttribute("logged",false);

        this.getServletContext()
                .getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        session.setAttribute("logged", false);
        if(studentDAO.checkStudent(Integer.parseInt(username), password)){
            session.setAttribute("logged", true);
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            response.sendRedirect("/bookbrowser");
        }
        else if(librarianDAO.checkLibrarian(Integer.parseInt(username), password))
        {
            session.setAttribute("logged", true);
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            response.sendRedirect("/issuedBooks");
        }
        else
        {
            boolean error = true;
            request.setAttribute("error",error);
            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }
    }
}
