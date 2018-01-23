/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.entity;

/**
 * Class chứa các thuộc tính giống với bảng students trong database. Contructor
 * chưa các trường quan trọng của một sinh viên bao gồm: rollNumber, name,
 * phone, email. Cần có một contructor rỗng mặc định.
 *
 * @author daolinh
 */
public class Student {

    private int id;
    private String rollNumber;
    private String name;
    private String phone;
    private String email;
    private int gender;
    private int status;
    private long createdAt;
    private long updateAt;

    public Student() {
    }

    public Student(int status, long createdAt, long updateAt) {
        this.status = status;
        this.createdAt = createdAt = System.currentTimeMillis();
        this.updateAt = updateAt = System.currentTimeMillis();
    }

    public Student(String rollNumber, String name, String phone, String email) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Student(int id, String rollNumber, String name, String phone, String email, int gender, int status) {
        this.id = id;
        this.rollNumber = rollNumber;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }

    public Student(int id, String rollNumber, String name, String phone, String email, int gender, int status, long createdAt, long updateAt) {
        this.id = id;
        this.rollNumber = rollNumber;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.status = status;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", rollNumber='" + rollNumber + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}