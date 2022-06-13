package com.example.library.servlets;

import com.example.library.beans.Book;
import com.example.library.beans.Student;
import com.example.library.dao.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Vector;




@WebServlet(name = "AboutServlet", value = "/About")
public class AboutServlet extends HttpServlet{
    private StudentDAO studentDAO;
    public void init() throws  ServletException {
        daoFactory dao = daoFactory.getInstance();
        this.studentDAO = dao.getStudentDao();
    }

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if((boolean) session.getAttribute("logged"))
        {
            String username = (String) session.getAttribute("username");
            Student student=studentDAO.getStudentById(Integer.parseInt(username));
            request.setAttribute("student",student);

            request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/About.jsp")
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
