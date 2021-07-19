package com.example.conference.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

@RestController
@Service
public class StudentController {

    /*
    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/resources/templates/");
        bean.setSuffix(".html");
        return bean;
    }
     */

    @Autowired
   public StudentRepo studentRepo;

    @RequestMapping("/con/student-login")
    public ModelAndView studentLogin() {
    ModelAndView modelAndView=new ModelAndView();
    modelAndView.setViewName("student-login");
    return modelAndView;
    }

    @GetMapping("/findAllStudents")
    public List<Student> findAllStudents(){

        //inserted some student records as the API should return something
        studentRepo.save(new Student("Suraj","suraj@gmail.com", "Suraj"));
        studentRepo.save(new Student("Sandy","sandy@gmail.com", "Sandy"));
        studentRepo.save(new Student("Pramod","pramod@gmail.com", "Pramod"));
        studentRepo.save(new Student("Akshay","akshay@gmail.com", "Akshay"));

        return studentRepo.findAll();
    }



    @RequestMapping("con/student-login-validation")
    public ModelAndView validate(@RequestParam("student-email") String email,
                          @RequestParam ("student-pass") String pass) {
        ModelAndView model = new ModelAndView();
       List<Student> DBResult = studentRepo.findByStudentEmail(email);

        boolean found = false;
        long id;
        for (Student s : DBResult) {
            String testPass = s.getStudentPass();
            if (testPass.equals(pass)) {
                id=s.getStudentRollNo();
                found = true;
                break;

            }
        }//foreach

        if (found) {
            model.setViewName("con/conference/{id}");
        } else {
            model.setViewName("error");
            }
        return model;
    }



    @GetMapping("con/conference/{id}")
    ModelAndView con() {
        ModelAndView model = new ModelAndView();
        model.setViewName("conference");
        return model;
    }

    @PostMapping("/com/student-save")
    public ModelAndView saveStudent(@RequestParam("student-email") String name,
                                @RequestParam("student-email") String email,
                                @RequestParam ("student-pass") String pass){
        studentRepo.save(new Student(name, email, pass));
        ModelAndView model=new ModelAndView();
        model.setViewName("student-login");
        return model;
    }



}
