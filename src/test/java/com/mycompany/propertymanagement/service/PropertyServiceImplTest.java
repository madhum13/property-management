package com.mycompany.propertymanagement.service;


import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.impl.PropertyServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

public class PropertyServiceImplTest {

    @InjectMocks
    private PropertyServiceImpl propertyServiceImpl;

    @Mock
    private PropertyConverter propertyConverter;

    @Mock
    private PropertyRepository propertyRepository;
    @Test
    void testSaveProperty_Success(){
        PropertyDTO dto = new PropertyDTO();
        dto.setTitle("Dummy");

        PropertyEntity propertyEntity = new PropertyEntity();

        PropertyEntity savedEntity = new PropertyEntity();
        propertyEntity.setTitle("Dummy");
        savedEntity.setId(1L);

        PropertyDTO savedDTO = new PropertyDTO();
        savedDTO.setTitle("Dummy");
        savedDTO.setId(1L);

        Mockito.when(propertyConverter.convertDTOToEntity(Mockito.any())).thenReturn(propertyEntity);
        Mockito.when(propertyRepository.save(Mockito.any())).thenReturn(savedEntity);
        Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDTO);

        PropertyDTO result = propertyServiceImpl.saveProperty(dto);
        Assertions.assertEquals(savedDTO.getId(), result.getId());
    }

}
