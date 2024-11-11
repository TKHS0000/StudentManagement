package raisetech.StudentManagement.service;

import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }


    public List<Student> searchStudentsIn30s() {
        return repository.searchStudentsIn30s();
    }


    public List<StudentsCourses> searchJavaCourseList() {
        return repository.searchJavaCourses();
    }
}
