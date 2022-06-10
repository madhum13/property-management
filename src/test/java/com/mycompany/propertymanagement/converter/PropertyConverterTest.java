package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.entity.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

public class PropertyConverterTest {

    @InjectMocks
    private PropertyConverter propertyConverter;

    @Test
    void testConvertDTOToEntity_Success(){

        PropertyDTO dto = new PropertyDTO();
        dto.setTitle("Dummy");
        dto.setPrice(34343.32);

        PropertyEntity propertyEntity = propertyConverter.convertDTOToEntity(dto);

        Assertions.assertEquals(dto.getPrice(), propertyEntity.getPrice());
        Assertions.assertEquals(dto.getTitle(), propertyEntity.getTitle());
    }
    @Test
    void testConvertEntityToDTO_Success(){

        PropertyEntity entity = new PropertyEntity();
        entity.setTitle("Dummy");
        entity.setPrice(3434.32);
        UserEntity ue = new UserEntity();
        entity.setUserEntity(ue);

        PropertyDTO propertyDTO = propertyConverter.convertEntityToDTO(entity);

        Assertions.assertEquals(entity.getPrice(), propertyDTO.getPrice());
        Assertions.assertEquals(entity.getTitle(), propertyDTO.getTitle());
    }
}
