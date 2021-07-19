package com.example.conference.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Repository
@Transactional
public interface StudentRepo extends JpaRepository<Student, Long> {
    @Override
    List<Student> findAll();

    @Override
    Student save(Student s);


    @Query(value = "SELECT s FROM STUDENT s WHERE s.STUDENT_EMAIL=:studentEmail",
            nativeQuery = true)
    List<Student> findByStudentEmail(@Param("studentEmail") String studentEmail);



}
