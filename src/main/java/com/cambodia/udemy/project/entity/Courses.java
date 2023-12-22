package com.cambodia.udemy.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_COURSE")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_ID")
    private int id;
    @Column(name = "CO_NAME")
    private String courseName;
    @ManyToOne
    @JoinColumn(name = "co_category_name")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "CO_USER_ID")
    private Users userId;
}
