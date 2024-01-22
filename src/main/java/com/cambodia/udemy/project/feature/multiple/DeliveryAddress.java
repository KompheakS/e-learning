package com.cambodia.udemy.project.feature.multiple;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DeliveryAddress {
    private String name;
    private int houseNumber;
    private String city;
    private String state;
}
