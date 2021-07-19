package com.example.conference.Teacher;

import com.example.conference.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@Service
public class TeacherController {

    @Autowired
    TeacherRepo teacherRepo;

    @GetMapping("/findAllTeachers")
    public List<Teacher> findAllTeachers(){
        //putting some values so it could list

        teacherRepo.save(new Teacher("Kartiki", "kartiki@gmail.com",
                "kartiki","Maths"));
        teacherRepo.save(new Teacher("Pranali", "Pranali@gmail.com",
                "Pranali","Java"));

        return teacherRepo.findAll();
    }

    @RequestMapping("/con/teacher-login")
    public ModelAndView teacherLogin() {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("teacher-login");
        return modelAndView;
    }

    @RequestMapping("con/teacher-login-validation")
    public ModelAndView validate(@RequestParam("teacher-email") String email,
                                 @RequestParam ("teacher-pass") String pass) {
        ModelAndView model = new ModelAndView();
        List<Teacher> DBResult = teacherRepo.findByTeacherEmail(email);
        boolean found = false;
        long id= 0;
        for (Teacher s : DBResult) {
            String testPass = s.getTeacherPass();
            if (testPass.equals(pass)) {
                found = true;
                id=s.getTeacherId();
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
    ModelAndView con(){
        ModelAndView model= new ModelAndView();
        model.setViewName("conference");
        return model;
    }

    @PostMapping("/com/teacher-save")
    public ModelAndView saveStudent(@RequestParam("teacher-email") String name,
                                    @RequestParam("teacher-email") String email,
                                    @RequestParam ("teacher-pass") String pass,
                                    @RequestParam ("teacher-subject") String sub){
        teacherRepo.save(new Teacher(name, email, pass, sub));
        ModelAndView model=new ModelAndView();
        model.setViewName("teacher-login");
        return model;
    }



}//class
