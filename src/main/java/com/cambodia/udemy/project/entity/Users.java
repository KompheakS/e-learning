package com.cambodia.udemy.project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_USERS")
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "U_ID")
    private Long id;
    @Column(name = "U_USERNAME")
    @NotBlank
    private String username;
    @Column(name = "U_PASSWORD")
    private String password;
    @Column(name = "U_EMAIL")
    private String email;
    @Column(name = "U_PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "U_DATE_OF_BIRTH", columnDefinition = "DATE")
    private LocalDate dateOfBirth;
    @Column(name = "U_GENDER")
    private String gender;
    /*@Lob
    @Column(name = "U_PHOTO")
    private byte[] photo;*/
    @Column(name = "U_JOIN_DATE")
    private LocalDate joinDate;
}