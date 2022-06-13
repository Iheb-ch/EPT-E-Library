package com.example.library.servlets;

import com.example.library.beans.Student;
import com.example.library.dao.BookDAO;
import com.example.library.dao.LibrarianDAO;
import com.example.library.dao.StudentDAO;
import com.example.library.dao.daoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Profile", value = "/profile")
public class Profile extends HttpServlet {
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

        if(session.getAttribute("username")==null||session.getAttribute("password")==null)
            response.sendRedirect("/login");
        else {
            String username = (String) session.getAttribute("username");
            String password = (String) session.getAttribute("password");
            if(studentDAO.checkStudent(Integer.parseInt(username),password)) {
                Student student=studentDAO.getStudentById(Integer.parseInt(username));
                //System.out.println(student.getName());
                request.setAttribute("student",student);
                request.getServletContext()
                        .getRequestDispatcher("/WEB-INF/profile.jsp")
                        .forward(request, response);
            }
            else
                response.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ninscrit=request.getParameter("ninscrit");
        String fullname=request.getParameter("fullname");

        String email=request.getParameter("email");
        String phoneNumber=request.getParameter("phoneNumber");
        String adress=request.getParameter("adress");
        String name="";
        int idx=0;
        for(int i=0;i<fullname.length();i++){
            if(fullname.charAt(i)==' ') {
                idx=i+1;
                break;
            }
            name+=fullname.charAt(i);
        }
        String fname=fullname.substring(idx);
        //System.out.println(ninscrit+" "+ name+" "+" "+fname+" "+email+" " +phoneNumber);
        studentDAO.updateStudentInfo(Integer.parseInt(ninscrit),name,fname,email,Integer.parseInt(phoneNumber),adress);
        response.sendRedirect("/profile");
    }
}
