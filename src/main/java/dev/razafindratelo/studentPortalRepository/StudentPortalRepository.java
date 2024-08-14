package dev.razafindratelo.studentPortalRepository;

import dev.razafindratelo.DBConnection.DBConnection;
import dev.razafindratelo.Sex;
import dev.razafindratelo.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentPortalRepository {
    DBConnection dbConnection;

    public StudentPortalRepository() {
        this.dbConnection = new DBConnection();
    }

    public Student insertStudent(Student student) {
        try {
            PreparedStatement insertion = dbConnection
                    .getConnection()
                    .prepareStatement("""
                    INSERT INTO student VALUES (?,?,?,?,?,?,?,?,?)""");
            insertion.setString(1, student.getId());
            insertion.setString(2, student.getUsername());
            insertion.setString(3, student.getLastName());
            insertion.setString(4, student.getFirstName());
            insertion.setString(5, student.getPhoneNumber());
            insertion.setString(6, student.getAddress());
            insertion.setString(7, (student.getSex().equals(Sex.FEMALE) ? "F" : "M"));
            insertion.setDate(8, Date.valueOf(student.getBirthDate()));
            insertion.setString(9, student.getEmail());

            if (insertion.executeUpdate() > 0) {
                return student;
            }
        } catch (SQLException e) {
            System.out.println("Error inserting student " + student.getId());
        }
        return null;
    }

    public Student findById(String id) {
        Student student = null;
        try {
            PreparedStatement getStudent = dbConnection
                    .getConnection()
                    .prepareStatement("SELECT * FROM student WHERE id = ?");

            getStudent.setString(1, id);
            ResultSet resultSet = getStudent.executeQuery();

            String username = resultSet.getString("user_name");
            String lastName = resultSet.getString("last_name");
            String firstName = resultSet.getString("first_name");
            String phoneNumber = resultSet.getString("phone_number");
            String address = resultSet.getString("address");
            String email = resultSet.getString("email");
            LocalDate birthDate = resultSet.getDate("birth_date").toLocalDate();
            Sex sex = (resultSet.getString("sex").equalsIgnoreCase("M")
                    ? Sex.MALE : Sex.FEMALE);

            student = new Student(
                    id,
                    username,
                    phoneNumber,
                    email,
                    address,
                    birthDate,
                    firstName,
                    lastName,
                    sex
            );
            return student;
        } catch (SQLException e) {
            System.out.println("failed");
        }
        return student;
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement getAll = dbConnection
                    .getConnection()
                    .prepareStatement("SELECT * FROM student");
            ResultSet resultSet = getAll.executeQuery();

            while (resultSet.next()) {
                String identification = resultSet.getString("id");
                String username = resultSet.getString("user_name");
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String phoneNumber = resultSet.getString("phone_number");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                LocalDate birthDate = resultSet.getDate("birthday").toLocalDate();
                Sex sex = (resultSet.getString("sex").equalsIgnoreCase("M")
                        ? Sex.MALE : Sex.FEMALE);

                var student = new Student(
                        identification,
                        username,
                        phoneNumber,
                        email,
                        address,
                        birthDate,
                        firstName,
                        lastName,
                        sex
                );
                students.add(student);
            }
            return students;

        } catch (SQLException e) {
            System.out.println("failed!");
        }
        return null;
    }

    public Student updateStudent(String id, Student s) {
        try {
            PreparedStatement update = dbConnection
                    .getConnection()
                    .prepareStatement(
                            """
                        UPDATE student 
                            SET id = ?,
                            user_name = ?,
                            last_name = ?,
                            first_name = ?,
                            phone_number = ?,
                            address = ?,
                            birthday = ?,
                            sex = ?,
                            email = ?
                        WHERE id = ? """);

            update.setString(1, s.getId());
            update.setString(2, s.getUsername());
            update.setString(3, s.getLastName());
            update.setString(4, s.getFirstName());
            update.setString(5, s.getPhoneNumber());
            update.setString(6, s.getAddress());
            update.setDate(7, Date.valueOf(s.getBirthDate()));
            update.setString(8, s.getSex().equals(Sex.FEMALE) ? "F" : "M");
            update.setString(9, s.getEmail());
            update.setString(10, id);

            if (update.executeUpdate() > 0) {
                System.out.println("Student updated successfully!");
            }
            return s;
        } catch (SQLException e) {
            System.out.println("Update failed!");
        }
        return null;
    }

    public boolean deleteStudent(String id) {
        try {
            PreparedStatement deletion = dbConnection
                    .getConnection()
                    .prepareStatement(
                            """
                                DELETE FROM student WHERE id = ?
                                """);
            deletion.setString(1, id);
            if (deletion.executeUpdate() > 0) {
                System.out.println("Student deleted successfully!");
            }
            return true;
        } catch(SQLException e) {
            System.out.println("student deletion failed!");
        }
        return false;
    }
}
