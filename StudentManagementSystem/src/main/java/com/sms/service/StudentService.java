// package com.sms.service;

// import java.util.List;

// import com.sms.model.Student;

// public interface StudentService {

// 	void createStudent(Student student);

// 	List<Student> getAllStudents();

// 	void deleteStudent(int sid);

// 	Student getStudent(int sid);

// 	void updateStudent(Student updatedStudent);

// 	boolean isStudentExistsByEmail(String email);

// 	boolean isStudentExistsByPhone(String email);

// }


// package com.sms.service;

// import java.util.List;

// import com.sms.model.Student;

// public interface StudentService {
//     int saveStudent(Student student);
//     List<Student> getAllStudents();
//     Student getStudentById(int id);
//     void deleteStudent(int id);
//     void updateStudent(Student student);
// }


package com.sms.service;

import java.util.List;

import com.sms.model.Student;

public interface StudentService {

    // Used for saving a new student
    int saveStudent(Student student);

    // Returns all students
    List<Student> getAllStudents();

    // Returns a student by ID
    Student getStudentById(int id);

    // Deletes a student by ID
    void deleteStudent(int id);

    // Updates an existing student
    void updateStudent(Student student);

    // Check if a student exists by email (for validation)
    boolean isStudentExistsByEmail(String email);

    // Check if a student exists by phone (for validation)
    boolean isStudentExistsByPhone(String phone);

    // ✅ Newly added methods required by controller

    // Create and return the saved student (used in controller)
    Student createStudent(Student student);

    // Return a student by ID (used in controller)
    Student getStudent(int id);
}

