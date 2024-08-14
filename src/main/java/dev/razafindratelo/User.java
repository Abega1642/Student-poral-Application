package dev.razafindratelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public abstract class User {
    private String id;
    private String username;
    private String phoneNumber;
    private String email;
    private String address;
    private LocalDate birthDate;
}
