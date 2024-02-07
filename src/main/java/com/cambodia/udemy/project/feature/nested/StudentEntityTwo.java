package com.cambodia.udemy.project.feature.nested;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntityTwo {
    private int id;
    private String name;
    private SubjectEntity subject;
}
