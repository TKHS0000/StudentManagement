package raisetech.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.repository.StudentRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {



    @Autowired

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> searchStudentList() {
        return repository.search();


    }

    public StudentDetail searchStudent(String id) {
        Student student = repository.searchStudent(id);
        List<StudentsCourses> studentsCourses = repository.searchStudentsCourses(student.getId()) ;
        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setStudent(student);
        studentDetail.setStudentsCourses(studentsCourses);
        return studentDetail ;

    }

    public List<StudentsCourses> searchStudentsCourseList() {
        return repository.searchStudentsCoursesList();
    }

    @Transactional
    public void registerStudent(StudentDetail studentDetail) {
        repository.registerStudent(studentDetail.getStudent());
        for(StudentsCourses studentsCourse:studentDetail.getStudentsCourses()){
            studentsCourse.setStudentsId(studentDetail.getStudent().getId());
            studentsCourse.setCourseStart(LocalDateTime.now());
            studentsCourse.setCourseEnd(LocalDateTime.now().plusYears(1));
            repository.registerStudentCourses(studentsCourse) ;
        }
    }
    @Transactional
    public void updateStudent(StudentDetail studentDetail) {
        repository.updateStudent(studentDetail.getStudent());
    for(StudentsCourses studentsCourse:studentDetail.getStudentsCourses()){
        repository.updateStudentCourses(studentsCourse) ;
    }
}


}





