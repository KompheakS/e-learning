package com.cambodia.udemy.project.feature;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class StudentEntity {
    private int id;
    private String name;
    private String classVal;
}
