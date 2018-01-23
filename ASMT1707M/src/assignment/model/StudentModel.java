/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.model;

import assignment.entity.Student;

import java.sql.*;
import java.util.ArrayList;

/**
 * Làm nhiệm vụ thao tác với bảng students trong database. Các thao tác gồm có:
 * thêm mới một sinh viên, sửa sinh viên, lấy danh sách sinh viên, xoá thông tin
 * sinh viên.
 *
 * @author daolinh
 */
public class StudentModel {

    /*
     * Lấy danh sách sinh viên trong database và trả về
     * một arraylist các đối tượng Student.
     */
    public ArrayList<Student> getListStudent() {
        // Khởi tạo một array líst rỗng để chứa dữ liệu trả về.
        ArrayList<Student> listStudent = new ArrayList<>();

        // Tạo kết nối tới database, thực thi câu lệnh "select * from students";
        Connection connection = ConnectionHelper.getConnection();
        if (connection == null) {
            return listStudent;
        }
        try {
            // Tạo đối tượng statement để thực thi lệnh sql.
            Statement statement = connection.createStatement();
            // Thực thi câu lệnh sql với kết quả trả về đưa vào resultset.
            ResultSet rs = statement.executeQuery("select * from students");
            // Với từng dòng trả về trong resultset, lấy ra các cột tương ứng và tạo đối tượng student.
            while (rs.next()) {
                int id = rs.getInt("id");
                String rollNumber = rs.getString("rollNumber");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                int gender = rs.getInt("gender");
                int status = rs.getInt("status");
                long createdAt = rs.getLong("createdAt");
                long updateAt = rs.getLong("updateAt");
                // Tạo ra đối tượng student tương ứng với các trường vừa lấy ra.
                Student student = new Student(id, rollNumber, name, phone, email, gender, status, createdAt, updateAt);
                // Thêm đối tượng vừa tạo vào arraylist (tạo ở trên cùng).
                listStudent.add(student);
            }
        } catch (SQLException ex) {
            System.err.println("Can not connect to database.");
        }

        // trả về kết quả default;
        return listStudent;
    }

    public boolean insert(Student student) {
        // Tạo kết nối tới database;
        Connection connection = ConnectionHelper.getConnection();
        if (connection == null) {
            return false;
        }
        try {
            String sqlInsert = "insert into students (rollNumber, name, email, phone, gender, createdAt, updateAt) values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, student.getRollNumber());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setInt(5, student.getGender());
            preparedStatement.setLong(6, student.getCreatedAt());
            preparedStatement.setLong(7, student.getUpdateAt());
            preparedStatement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Can not insert student.");
        }

        return false;
    }

    public Student getById(int id) {
        Student student = new Student();

        Connection connection = ConnectionHelper.getConnection();
        if (connection == null) {
            return null;
        }
        try {
            Statement stt = connection.createStatement();
            ResultSet rs = stt.executeQuery("SELECT  * FROM students WHERE id = " + id);
            while (rs.next()) {
                int studentId = rs.getInt("id");
                String studentRollNumber = rs.getString("rollNumber");
                String studentName = rs.getString("name");
                String studentPhone = rs.getString("phone");
                String studentEmail = rs.getString("email");
                int studentGender = rs.getInt("gender");
                int studentStatus = rs.getInt("status");
                long studentCreatedAt = rs.getLong("createdAt");
                long studentUpdateAt = rs.getLong("updateAt");
                student = new Student(studentId,
                        studentRollNumber,
                        studentName,
                        studentPhone,
                        studentEmail,
                        studentGender,
                        studentStatus,
                        studentCreatedAt,
                        studentUpdateAt);
            }
        } catch (SQLException e) {
            System.err.println("Can not connect to Database");
        }
        return student;
    }

    public boolean update(Student student) {
        // Tạo kết nối tới database;
        Connection connection = ConnectionHelper.getConnection();
        if (connection == null) {
            return false;
        }
        try {
            String update = "UPDATE students SET name = ?, email = ?, phone = ? WHERE  id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getPhone());
            preparedStatement.setInt(4, student.getId());
            preparedStatement.execute();

        } catch (SQLException ex) {
            System.err.println("Can not insert student.");
        }

        return false;
    }


    public boolean delete(Student student) {
        Connection connection = ConnectionHelper.getConnection();
        if (connection == null) {
            return false;
        }
        try {
            String delete = "DELETE FROM students WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.err.println("Can not delete student.");
        }
        return false;
    }
}