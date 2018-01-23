/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.controller;

import assignment.entity.Student;
import assignment.model.StudentModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author daolinh
 */
public class StudentController {

    private final StudentModel model = new StudentModel();

    public void printStudentList() {
        ArrayList<Student> list = model.getListStudent();
        System.out.println("===========================Student list=======================");
        System.out.println("Id \t Name \t Gender \t Status");
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.println(student.getId() + "\t" + student.getName() + "\t" + (student.getGender() == 1 ? "Male" : (student.getGender() == 0 ? "Female" : "Other")) + "\t" + (student.getStatus() == 0 ? "Truant" : "Attend"));
        }
        System.out.println("===============================================================");
    }

    public void addStudent() {
        Student student = new Student();
        System.out.println("=================== Add New Student ====================");
        // Dùng scanner yêu cầu người dùng nhập vào từ bàn phím.
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Yêu cầu người dùng nhập.
            System.out.println("Please enter your name: ");
            // Lấy giá trị người dùng nhập vào để gán cho biến.
            String value = scanner.nextLine();

            if (value != null && value.length() > 5) {
                student.setName(value);
                break;
            }
            System.out.println("Name's required.");
        }

        while (true) {
            // Yêu cầu người dùng nhập.
            System.out.println("Please enter your email: ");
            // Lấy giá trị người dùng nhập vào để gán cho biến.
            String value = scanner.nextLine();

            if (value != null && value.length() > 0) {
                student.setEmail(value);
                break;
            }
            System.out.println("Email's required.");
        }

        while (true) {
            // Yêu cầu người dùng nhập.
            System.out.println("Please enter your roll number: ");
            // Lấy giá trị người dùng nhập vào để gán cho biến.
            String value = scanner.nextLine();

            if (value != null && value.length() > 0) {
                student.setRollNumber(value);
                break;
            }
            System.out.println("Rollnumber's required.");
        }

        while (true) {
            System.out.println("Please enter student gender: ");
            System.out.println("Female = 0");
            System.out.println("Male = 1");
            System.out.println("Other = 2");
            int value = scanner.nextInt();
            scanner.nextLine();
            if (-1 < value && value < 3) {
                student.setGender(value);
                break;
            }
            System.out.println("Gender's required.");
        }

        while (true) {
            // Yêu cầu người dùng nhập.
            System.out.println("Please enter your phone: ");
            // Lấy giá trị người dùng nhập vào để gán cho biến.
            String value = scanner.nextLine();

            if (value != null && value.length() > 0) {
                student.setPhone(value);
                break;
            }
            System.out.println("Phone's required.");
        }

        long createdAt = new Long(System.currentTimeMillis());
        student.setCreatedAt(createdAt);
        model.insert(student);
        System.out.println("==================================================");
    }

    public void editStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("================= Edit student ==================");
        System.out.println("Please enter student id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Student existStudent = model.getById(id);
        if (existStudent == null) {
            System.out.println("Student is not exist or has been deleted!");
        } else {
            System.out.println("Student information: ");
            System.out.println("Id: " + existStudent.getId());
            System.out.println("Roll Number: " + existStudent.getRollNumber());
            System.out.println("Name: " + existStudent.getName());
            System.out.println("Email: " + existStudent.getEmail());
            System.out.println("Phone: " + existStudent.getPhone());
            System.out.println("-----------------------------------------------");
            System.out.println("Please enter new name: ");
            String name = scanner.nextLine();
            System.out.println("Please enter new email: ");
            String email = scanner.nextLine();
            System.out.println("Please enter new phone: ");
            String phone = scanner.nextLine();

            existStudent.setName(name);
            existStudent.setEmail(email);
            existStudent.setPhone(phone);

            long updateAt = new Long(System.currentTimeMillis());
            existStudent.setUpdateAt(updateAt);
            model.update(existStudent);
            System.out.println("Update success!");
        }
    }

    public void getStudentDetail() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=============== Get student  detail ================");
        System.out.println("Please enter student id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Student existStudent = model.getById(id);
        SimpleDateFormat timeFomat = new SimpleDateFormat("hh:mm:ss a dd/MM/yyyy Z");
        String timeCreated = timeFomat.format(existStudent.getCreatedAt());
        String timeUpdate = timeFomat.format(existStudent.getUpdateAt());
        if (existStudent == null) {
            System.out.println("Student is not exist or has been deleted!");
        } else {
            System.out.println("Student information: ");
            System.out.println("Id: " + existStudent.getId());
            System.out.println("Roll Number: " + existStudent.getRollNumber());
            System.out.println("Name: " + existStudent.getName());
            System.out.println("- Gender Student: " + (existStudent.getGender() == 1 ? "Male" : (existStudent.getGender() == 0 ? "Female:" : "Other")));
            System.out.println("Email: " + existStudent.getEmail());
            System.out.println("Phone: " + existStudent.getPhone());
            System.out.println("- Created At:     " + timeCreated + " GMT");
            System.out.println("- Status Student: " + existStudent.getStatus());
            if (existStudent.getUpdateAt() == 0) {
                System.out.println("- Update At:      " + "Never Update");
            } else {
                System.out.println("- Update At:      " + timeUpdate + " GMT");
            }
            System.out.println("================================================");

        }
    }

    public void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("================ Delete student ===============");
        System.out.println("Please enter student id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Student existStudent = model.getById(id);
        if (existStudent == null) {
            System.out.println("Student is not exist or has been deleted!");
        } else {
            System.out.println("Student information: ");
            System.out.println("Id: " + existStudent.getId());
            System.out.println("Roll Number: " + existStudent.getRollNumber());
            System.out.println("Name: " + existStudent.getName());
            System.out.println("Email: " + existStudent.getEmail());
            System.out.println("Phone: " + existStudent.getPhone());
            System.out.println("-----------------------------------------------");
        // y = yes - n = no. press delete
            System.out.println("Could you want to delete student 's record? (Press Y = Yes/ N = No)");
            System.out.println("-------------------------------------------------------------------");
            String choice = "y";
            String choicey = scanner.nextLine();
            if(choicey.equalsIgnoreCase(choice) == true){
                model.delete(existStudent);
                System.out.println("Delete Success!!!!");
            }else{
                System.out.println("Bye Byte");
                System.exit(1);
            }
        }
    }
}