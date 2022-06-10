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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Test
    void testGetAllProperties_Success(){

        List<PropertyEntity> propertyEntities = new ArrayList<>();
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setId(1L);
        propertyEntity.setTitle("Dummy");
        propertyEntities.add(propertyEntity);

        PropertyDTO savedDTO = new PropertyDTO();
        savedDTO.setTitle("Dummy");
        savedDTO.setId(1L);

        Mockito.when(propertyRepository.findAll()).thenReturn(propertyEntities);
        Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDTO);

       List<PropertyDTO> listPropertyDTO =  propertyServiceImpl.getAllProperties();

       Assertions.assertEquals(1,listPropertyDTO.size());
    }

    void testUpdateProperty_Success(){

        PropertyDTO savedDTO = new PropertyDTO();
        savedDTO.setTitle("Dummy");
        savedDTO.setId(1L);
        savedDTO.setPrice(3443.43);
        savedDTO.setAddress("wew");
        savedDTO.setDescription("sasa");


        PropertyEntity pe = new PropertyEntity();
        pe.setTitle("Dummy");
        pe.setId(1L);
        savedDTO.setId(1L);
        pe.setPrice(3443.43);
        pe.setAddress("wew");
        pe.setDescription("sasa");


        Mockito.when(propertyRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(pe));
        Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDTO);

        PropertyDTO updatedProperty = propertyServiceImpl.updateProperty(savedDTO, 1l);
        Assertions.assertEquals(savedDTO.getTitle(), updatedProperty.getTitle());
        Assertions.assertEquals(savedDTO.getPrice(), updatedProperty.getPrice());
    }

    @Test
    void testUpdatePropertyDescription(){


        PropertyDTO savedDTO = new PropertyDTO();

        savedDTO.setDescription("updated q");

        savedDTO.setTitle("Dummy");
        savedDTO.setId(1L);
        savedDTO.setPrice(3443.43);
        savedDTO.setAddress("wew");
        savedDTO.setDescription("sasa");

        PropertyEntity pe = new PropertyEntity();
        pe.setTitle("Dummy");
        pe.setId(1L);
        savedDTO.setId(1L);
        pe.setPrice(3443.43);
        pe.setAddress("wew");
        pe.setDescription("updated q");

        Mockito.when(propertyRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(pe));
        Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDTO);

        propertyServiceImpl.updatePropertyDescription(savedDTO, 1L);


        PropertyDTO updatedProperty = propertyServiceImpl.updatePropertyDescription(savedDTO, 1l);
        Assertions.assertEquals(savedDTO.getDescription(), updatedProperty.getTitle());
    }

}
