package com.example.conference.Teacher;

import javax.persistence.*;

@Entity
@Table
public class Teacher {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long teacherId;

    @Column
    private String teacherName;

    @Column
    private String teacherEmail;

    @Column
    private String teacherPass;

    @Column
    private String subject;

    Teacher(){}

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Teacher(String teacherName, String teacherEmail, String teacherPass, String subject) {
        this.teacherName = teacherName;
        this.teacherEmail = teacherEmail;
        this.teacherPass = teacherPass;
        this.subject = subject;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherPass() {
        return teacherPass;
    }

    public void setTeacherPass(String teacherPass) {
        this.teacherPass = teacherPass;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Teacher(long teacherId, String teacherName, String teacherEmail,
                   String teacherPass, String subject) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherEmail = teacherEmail;
        this.teacherPass = teacherPass;
        this.subject = subject;
    }


}
