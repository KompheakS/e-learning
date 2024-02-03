package com.cambodia.udemy.project.dto.response;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersResponse {
    private String username;
    private String email;
    private String gender;
    private LocalDate joinDate;
}