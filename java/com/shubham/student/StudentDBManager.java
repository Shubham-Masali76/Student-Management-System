package com.shubham.student;

import java.sql.*;
import java.util.*;

public class StudentDBManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/studentdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "3546";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addStudent(Student s) {
        String sql = "INSERT INTO students (name, course, marks, email, phone) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect(); 
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, s.getName());
            stmt.setString(2, s.getCourse());
            stmt.setInt(3, s.getMarks());
            stmt.setString(4, s.getEmail());
            stmt.setString(5, s.getPhone());
            stmt.executeUpdate();
            System.out.println("Student added to DB.");
        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = connect(); 
            Statement stmt = conn.createStatement(); 
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student s = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("course"),
                    rs.getInt("marks"),
                    rs.getString("email"),
                    rs.getString("phone"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
        return list;
    }

    public Student getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        try (Connection conn = connect(); 
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("course"),
                    rs.getInt("marks"),
                    rs.getString("email"),
                    rs.getString("phone"));
            }
        } catch (SQLException e) {
            System.out.println("Error searching student: " + e.getMessage());
        }
        return null;
    }

    public boolean updateStudent(Student s) {
        String sql = "UPDATE students SET name=?, course=?, marks=?, email=?, phone=? WHERE id=?";
        try (Connection conn = connect(); 
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, s.getName());
            stmt.setString(2, s.getCourse());
            stmt.setInt(3, s.getMarks());
            stmt.setString(4, s.getEmail());
            stmt.setString(5, s.getPhone());
            stmt.setInt(6, s.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = connect(); 
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
        return false;
    }
}
