package dev.razafindratelo.studentCrud.studentCrudImpl;

import dev.razafindratelo.users.Student;
import dev.razafindratelo.studentCrud.StudentCRUD;
import dev.razafindratelo.studentPortalRepository.StudentPortalRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class StudentCRUDImpl implements StudentCRUD {
    StudentPortalRepository studentPortalRepository;

    @Override
    public Student addStudent(Student s) {
        return studentPortalRepository.insertStudent(s);
    }

    @Override
    public Student getStudentById(String id) {
        return studentPortalRepository.findById(id);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentPortalRepository.findAll();
    }

    @Override
    public Student updateStudent(String id, Student s) {
        return studentPortalRepository.updateStudent(id, s);
    }

    @Override
    public boolean deleteStudent(String id) {
        return studentPortalRepository.deleteStudent(id);
    }
}
