package com.example.library.dao;

import com.example.library.beans.Book;
import com.example.library.beans.Librarian;
import com.example.library.beans.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private daoFactory daoFact;


    public StudentDAO(daoFactory daofact) {
        this.daoFact = daofact;
    }

    public void addStudent(Student student) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFact.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO Student VALUES(?, ?,?,?,?,?,?,?,?,?,?,?);");
            preparedStatement.setInt(1, student.getNcin());
            preparedStatement.setInt(2, student.getStudentId());
            preparedStatement.setString(3, student.getLastname());
            preparedStatement.setString(4, student.getName());
            preparedStatement.setInt(5, student.getPhoneNumber());
            preparedStatement.setString(6, student.getEmail());
            preparedStatement.setDate(7, student.getBirthDate());
            preparedStatement.setString(8, student.getGithublink());
            preparedStatement.setString(9, student.getFacebooklink());
            preparedStatement.setString(10, student.getInstagramlink());
            preparedStatement.setString(11, student.getAdress());
            preparedStatement.setString(12, student.getPassword());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteStudent(Student student) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFact.getConnection();
            preparedStatement = connexion.prepareStatement("DELETE FROM Student WHERE ninscrit=?;");
            preparedStatement.setInt(1, student.getStudentId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateStudentInfo(int id, String name, String fname, String email, int phoneNumber, String address) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFact.getConnection();
            preparedStatement = connexion.prepareStatement("UPDATE student SET lastname=(?),name=?,phonenumber=?,email=?,adress=? WHERE studentid=(?);");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, fname);
            preparedStatement.setInt(3, phoneNumber);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, address);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Student> list() {
        List<Student> students = new ArrayList<Student>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFact.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT ncin,studentid,lastname,name,phonenumber,email,birthDate,githublink,instagramlink,facebooklink,adress,password FROM student;");

            while (resultat.next()) {
                int ncin = resultat.getInt("ncin");
                int studentid = resultat.getInt("studentid");
                String lastname = resultat.getString("lastname");
                String name = resultat.getString("name");
                int phonenumber = resultat.getInt("phoneNumber");
                String email = resultat.getString("email");
                String github = resultat.getString("githublink");
                String facebook = resultat.getString("facebooklink");
                String instagram = resultat.getString("instagramlink");
                String password = resultat.getString("password");
                String adress = resultat.getString("adress");
                Date birthdate = resultat.getDate("birthDate");


                Student student = new Student();
                student.setStudentId(studentid);
                student.setAdress(adress);
                student.setEmail(email);
                student.setFacebooklink(facebook);
                student.setInstagramlink(instagram);
                student.setLastname(lastname);
                student.setName(name);
                student.setPassword(password);
                student.setPhoneNumber(phonenumber);
                student.setAdress("adress");
                student.setBirthDate(birthdate);


                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student getStudentById(int id) {
        List<Student> lst = list();
        for (Student student : lst) {
            if ((student.getStudentId()) == (id))
                return student;
        }
        return new Student();

    }
    public Student getStudentByName(String name) {
        List<Student> lst = list();
        for (Student student : lst) {
            if ((student.getName()).equals (name));
                return student;
        }
        return new Student();

    }

    public boolean checkStudent(int id, String password) {
        //Student student=getStudentById(id);
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFact.getConnection();
            statement = connexion.createStatement();
            preparedStatement = connexion.prepareStatement("SELECT * FROM student WHERE studentid=? and password=?;");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, password);
            resultat = preparedStatement.executeQuery();


            return resultat.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
