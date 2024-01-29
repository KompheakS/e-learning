package com.cambodia.udemy.project.dto.request;

import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersRequest implements Serializable {

    private String username;
    private String password;
    @Email
    private String email;
    private int phoneNumber;
    private LocalDate dateOfBirth;
    private String gender;
    private Timestamp joinDate;
}
