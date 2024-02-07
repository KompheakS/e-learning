package com.cambodia.udemy.project.feature.multiple;

import com.cambodia.udemy.project.feature.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface DeliveryAddressMapper {
    @Mapping(source = "student.name", target = "name")
    @Mapping(source = "address.houseNo", target = "houseNumber")
    DeliveryAddress getDeliveryAddress(StudentEntity student, AddressEntity address);
}
