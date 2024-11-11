package raisetech.StudentManagement.repository ;

import org.apache.ibatis.annotations.Select;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import java.util.List;

public interface StudentRepository {

    @Select("SELECT * FROM students WHERE age BETWEEN 30 AND 39")
    List<Student> searchStudentsIn30s();

    @Select("SELECT * FROM students_courses WHERE studentcourse = 'Java'")
    List<StudentsCourses> searchJavaCourses();
}
