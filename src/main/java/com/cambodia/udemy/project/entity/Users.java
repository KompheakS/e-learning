package com.cambodia.udemy.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

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
    private String username;
    @Column(name = "U_PASSWORD")
    private String password;
    @Column(name = "U_EMAIL")
    private String email;
    @Column(name = "U_DATE_OF_BIRTH")
    private Timestamp dateOfBirth;
    @Column(name = "U_GENDER")
    private String gender;
    @Lob
    @Column(name = "U_PHOTO")
    private byte[] photo;
    @Column(name = "U_JOIN_DATE")
    private Timestamp joinDate;
}
