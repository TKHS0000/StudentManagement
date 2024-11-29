package raisetech.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.converter.StudentConverter;
import raisetech.StudentManagement.domain.StudentDetail ;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.service.StudentService;
import java.util.List;

@RestController
public class StudentController {

    private StudentService service;
    private StudentConverter converter ;


    @Autowired
    public StudentController(StudentService service, StudentConverter converter) {

        this.service = service;
        this.converter = converter ;
    }


    @GetMapping("/studentList")
    public List<StudentDetail> getStudentList() {
        List<Student> students = service.searchStudentList();
        List<StudentsCourses> studentsCourses = service.searchStudentsCourseList();

        return converter.convertStudentDetails(students, studentsCourses);
    }



    @GetMapping("/studentsCourseList")
    public List<StudentsCourses> searchStudentsCourseList() {
        return service.searchStudentsCourseList();
    }


}