/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.test;

import assignment.entity.Student;
import java.util.Scanner;

/**
 *
 * @author daolinh
 */
public class Test {

    public static void main(String[] args) {
        Student student = new Student();
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
        
        System.out.println(student.toString());
    }
}
