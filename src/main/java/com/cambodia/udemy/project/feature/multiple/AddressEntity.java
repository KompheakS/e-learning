package com.cambodia.udemy.project.feature.multiple;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class AddressEntity {
    private int houseNo;
    private String city;
    private String state;
}
