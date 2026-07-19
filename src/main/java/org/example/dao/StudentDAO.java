package org.example.dao;

import org.example.model.Student;
import org.example.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public boolean addStudent(Student student) {

        String sql= "INSERT INTO students (name,age,city) VALUES(?,?,?)";
        try {
            Connection conn= DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,student.getName());
            ps.setInt(2,student.getAge());
            ps.setString(3,student.getCity());

            int rows=ps.executeUpdate();
            conn.close();
            return rows>0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public List<Student> getAllStudents() {
        List<Student> students=new ArrayList<>();
        String sql= "SELECT * FROM students";
        try{
            Connection conn= DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while (rs.next()) {
                Student student=new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setCity(rs.getString("city"));
                students.add(student);
            }
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }

    public Student getStudentById(int id){
        Student student=null;
        String sql="SELECT  * FROM students WHERE id=?";

        try{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs=ps.executeQuery();

            if (rs.next()) {

                student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setCity(rs.getString("city"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public boolean updateStudent(Student student){
        String sql="UPDATE students SET name=?,age=?,city=? WHERE id=?";
        try {
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getCity());
            ps.setInt(4, student.getId());

            int rows = ps.executeUpdate();

            conn.close();
            return  rows>0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteStudent(int id){
        String sql="DELETE FROM students WHERE id=?";
        try {
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setInt(1,id);

            int rows=ps.executeUpdate();
            conn.close();
            return rows>0;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}