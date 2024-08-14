package dev.razafindratelo.studentCrud;

import dev.razafindratelo.Student;

import java.util.List;

public interface StudentCRUD {
    Student addStudent(Student s);
    Student getStudentById(String id);
    List<Student> getAllStudent();
    Student updateStudent(String id, Student s);
    boolean deleteStudent(String id);
}
