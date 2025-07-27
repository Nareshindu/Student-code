// // package com.sms.service;

// // import java.util.List;

// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.stereotype.Service;

// // import com.sms.dao.StudentDao;
// // import com.sms.model.Student;

// // @Service
// // public class StudentServiceImpl  implements StudentService{
	
// // 	@Autowired
// // 	private StudentDao studentDao;

	

// // 	@Override
// // 	public void createStudent(Student student) {
// // 		System.out.println("service started");
// // 		studentDao.createStudent(student);
		
// // 	}

// // 	@Override
// // 	public List<Student> getAllStudents() {
// // 		List<Student> students=studentDao.getAllStudents();
// // 		return students;
// // 	}

// // 	@Override
// // 	public void deleteStudent(int sid) {
// // 		 studentDao.deleteStudent(sid);
		
// // 	}

// // 	@Override
// // 	public Student getStudent(int sid) {
// // 		Student student=studentDao.getStudent(sid);
// // 		return student;
// // 	}

// // 	 @Override
// // 	    public boolean isStudentExistsByEmail(String email) {
// // 	        return studentDao.isStudentExistsByEmail(email);
// // 	    }
// // 	 @Override
// // 	    public boolean isStudentExistsByPhone(String phoneNumber) {
// // 	        return studentDao.isStudentExistsByPhone(phoneNumber);
// // 	    }

// // 	@Override
// // 	public void updateStudent(Student updatedStudent) {
// // 		studentDao.updateStudent(updatedStudent);
		
// // 	}
// // }


// package com.sms.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.sms.model.Student;
// import com.sms.repository.StudentRepository;

// @Service
// public class StudentServiceImpl implements StudentService {

//     @Autowired
//     private StudentRepository studentRepository;

//     @Override
//     public int saveStudent(Student student) {
//         Student saved = studentRepository.save(student);
//         return saved.getId();
//     }

//     @Override
//     public List<Student> getAllStudents() {
//         return studentRepository.findAll();
//     }

//     @Override
//     public Student getStudentById(int id) {
//         Optional<Student> optional = studentRepository.findById(id);
//         return optional.orElse(null);
//     }

//     @Override
//     public void deleteStudent(int id) {
//         studentRepository.deleteById(id);
//     }

//     @Override
//     public void updateStudent(Student student) {
//         studentRepository.save(student);
//     }
// }

package com.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.model.Student;
import com.sms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Save a student and return generated ID
    @Override
    public int saveStudent(Student student) {
        Student saved = studentRepository.save(student);
        return saved.getId();
    }

    // Return all students
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Return a student by ID
    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Delete a student by ID
    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    // Update a student record
    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    // Check if a student exists by email
    @Override
    public boolean isStudentExistsByEmail(String email) {
        return studentRepository.findAll().stream()
                .anyMatch(s -> email.equalsIgnoreCase(s.getEmail()));
    }

    // Check if a student exists by phone
    @Override
    public boolean isStudentExistsByPhone(String phone) {
        return studentRepository.findAll().stream()
                .anyMatch(s -> phone.equalsIgnoreCase(s.getPhoneNumber()));
    }

    // Create a student and return saved object
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get a student by ID (duplicate of getStudentById but used by controller)
    @Override
    public Student getStudent(int id) {
        return studentRepository.findById(id).orElse(null);
    }
}
