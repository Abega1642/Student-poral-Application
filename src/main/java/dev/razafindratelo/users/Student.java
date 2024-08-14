package dev.razafindratelo.users;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Student extends User {
    private String firstName;
    private String lastName;
    private Sex sex;

    public Student(
            String id,
            String username,
            String phoneNumber,
            String email,
            String address,
            LocalDate birthDate,
            String firstName,
            String lastName,
            Sex sex) {

        super(id, username, phoneNumber, email, address, birthDate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + this.getId() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", birthDate=" + getBirthDate() + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                '}';
    }
}
