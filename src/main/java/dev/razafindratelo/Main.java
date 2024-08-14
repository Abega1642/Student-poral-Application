package dev.razafindratelo;

import dev.razafindratelo.DBConnection.DBConnection;
import dev.razafindratelo.studentCrud.studentCrudImpl.StudentCRUDImpl;
import dev.razafindratelo.studentPortalRepository.StudentPortalRepository;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        var student = new Student(
                "STD23028",
                "Abega1642",
                "+261 00 000 00",
                "hei.abega.2@gmail.com",
                "Address",
                date,
                "Abegà",
                "Razafindratelo",
                Sex.MALE
        );
        StudentCRUDImpl studentService = new StudentCRUDImpl(new StudentPortalRepository());
        
        var newStudent = new Student(
                "STD23028",
                "Abegà",
                "+261 00 000 00",
                "hei.abega.2@gmail.com",
                "Address",
                date,
                "Abegà",
                "Razafindratelo",
                Sex.MALE
        );
    }
}