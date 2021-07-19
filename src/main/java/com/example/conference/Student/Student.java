package com.example.conference.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Student {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentRollNo;

    @Column
    public String studentName;

    @Column
    private String studentEmail;
    @Column
    private String studentPass;

    public Student() {
    }

    public Student(String studentName, String studentEmail, String studentPass) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentPass = studentPass;
    }

    public Student(long studentRollNo, String studentName, String studentEmail, String studentPass) {
        this.studentRollNo = studentRollNo;
        studentName = studentName;
        studentEmail = studentEmail;
        studentPass = studentPass;
    }

    public long getStudentRollNo() {
        return studentRollNo;
    }

    public void setStudentRollNo(Long studentRollNo) {
        this.studentRollNo = studentRollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPass() {
        return studentPass;
    }

    public void setStudentPass(String studentPass) {
        this.studentPass = studentPass;
    }

}
