package raisetech.StudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

	@Autowired
	private StudentRepository repository;

	public static void main(String[] args) {

		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@GetMapping("/students")
	public List<Student> getStudentList() {

		return repository.search();
	}

}

//  mysql -u root -h localhost --port 3308 -p