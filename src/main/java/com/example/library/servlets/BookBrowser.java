package com.example.library.servlets;

import com.example.library.beans.Book;
import com.example.library.beans.Student;
import com.example.library.dao.BookDAO;
import com.example.library.dao.StudentDAO;
import com.example.library.dao.daoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@WebServlet(name = "BookBrowser", value = "/bookbrowser")
public class BookBrowser extends HttpServlet {
    private BookDAO bookdao;
    private StudentDAO studentDAO;
    public void init() throws  ServletException{
        daoFactory dao=daoFactory.getInstance();
        this.bookdao=dao.getBookDao();
        this.studentDAO = dao.getStudentDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean logged = false;
        session.setAttribute("logged", logged);
        if(session.getAttribute("username")==null||session.getAttribute("password")==null)
            response.sendRedirect("/login");
        else {
            String username = (String) session.getAttribute("username");
            String password = (String) session.getAttribute("password");
            if(studentDAO.checkStudent(Integer.parseInt(username), password)) {
                session.setAttribute("logged",true);
                ArrayList<Book> books = bookdao.list();
                Student student=studentDAO.getStudentById(Integer.parseInt(username));
                request.setAttribute("student",student);
                request.setAttribute("books", books);
                request.getServletContext()
                        .getRequestDispatcher("/WEB-INF/bookbrowser.jsp")
                        .forward(request, response);
            }
            else {
                response.sendRedirect("/login");
            }}}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        Book book = bookdao.getBookByName(search);
        System.out.println(book.getTitle());
        request.setAttribute("book", book);
        request.getServletContext()
                .getRequestDispatcher("/WEB-INF/bookbrowser.jsp")
                .forward(request, response);
    }
}
