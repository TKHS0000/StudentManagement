package raisetech.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import raisetech.StudentManagement.converter.StudentConverter;
import raisetech.StudentManagement.domain.StudentDetail ;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.service.StudentService;
import java.util.List;

@Controller
public class StudentController {

    private StudentService service;
    private StudentConverter converter ;


    @Autowired
    public StudentController(StudentService service, StudentConverter converter) {

        this.service = service;
        this.converter = converter ;
    }


    @GetMapping("/studentList")
    public String getStudentList(Model model) {
        List<Student> students = service.searchStudentList();
        List<StudentsCourses> studentsCourses = service.searchStudentsCourseList();

        model.addAttribute("studentList", converter.convertStudentDetails(students,studentsCourses)) ;
        return "studentList";
    }



    @GetMapping("/studentsCourseList")
    public List<StudentsCourses> searchStudentsCourseList() {
        return service.searchStudentsCourseList();
    }


}