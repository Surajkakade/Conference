package com.example.conference.Teacher;

import com.example.conference.Student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface TeacherRepo extends JpaRepository <Teacher, Long>{
    @Override
    List<Teacher> findAll();

    @Query(value = "SELECT t FROM TEACHER t WHERE t.TEACHER_EMAIL=:teacherEmail",
            nativeQuery = true)
    List<Teacher> findByTeacherEmail(String email);
}
