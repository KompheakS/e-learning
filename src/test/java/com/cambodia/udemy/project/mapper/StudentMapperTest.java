package com.cambodia.udemy.project.mapper;

import com.cambodia.udemy.project.feature.Student;
import com.cambodia.udemy.project.feature.StudentEntity;
import com.cambodia.udemy.project.feature.StudentMapper;
import com.cambodia.udemy.project.feature.multiple.AddressEntity;
import com.cambodia.udemy.project.feature.multiple.DeliveryAddress;
import com.cambodia.udemy.project.feature.multiple.DeliveryAddressMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentMapperTest {
    private final StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);
    private final DeliveryAddressMapper deliveryAddressMapper = Mappers.getMapper(DeliveryAddressMapper.class);
    @Test
    public void testEntityMapping(){
        StudentEntity studentEntity = StudentEntity.builder()
                .classVal("X")
                .id(1)
                .name("Test")
                .build();

        Student model = studentMapper.getModelFromEntity(studentEntity);
        System.out.println(model.toString());
        assertEquals(studentEntity.getClassVal(), model.getClassName());
        assertEquals(studentEntity.getId(), model.getId());
        assertEquals(studentEntity.getName(), model.getName());
    }

    @Test
    public void multipleMappingTest(){
        StudentEntity student = StudentEntity.builder()
                .classVal("X")
                .name("Kompheak")
                .id(1)
                .build();

        AddressEntity address = AddressEntity.builder()
                .city("Y")
                .state("Z")
                .houseNo(1)
                .build();

        DeliveryAddress deliveryAddress = deliveryAddressMapper.getDeliveryAddress(student, address);
        assertEquals(deliveryAddress.getName(), student.getName());
        assertEquals(deliveryAddress.getCity(), address.getCity());
        assertEquals(deliveryAddress.getState(), address.getState());
        assertEquals(deliveryAddress.getHouseNumber(), address.getHouseNo());
        System.out.println(deliveryAddress);
    }
}
