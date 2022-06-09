package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @InjectMocks
    private PropertyController propertyController; //Mockito is going to create a proxy object of PropertyController and inject it to propertyController test file

    @Mock //Mockito will give memory to property service and will inject this dummy/proxy PropertyService object inside the proxy object of propertyController
    private PropertyService propertyService;

    @Test
    @DisplayName("Test Success Scenario for saving new Property")
    void testSaveProperty(){

        PropertyDTO dto = new PropertyDTO();
        dto.setTitle("Dummy property");

        PropertyDTO savedProperty = new PropertyDTO();
        savedProperty.setId(1L);
        savedProperty.setTitle(dto.getTitle());
        //Do not make the actual call for propertyService.saveProperty(dto) inside controller rather return dummy object
        Mockito.when(propertyService.saveProperty(dto)).thenReturn(savedProperty);

       ResponseEntity<PropertyDTO> responseEntity = propertyController.saveProperty(dto);
        Assertions.assertNotNull(responseEntity.getBody().getId());
        Assertions.assertEquals(HttpStatus.CREATED.value(), responseEntity.getStatusCodeValue());

    }
    @Test
    @DisplayName("Test Success Scenario for fetching all Properties")

    void testGetProperties(){
        List<PropertyDTO> propertyList = new ArrayList<>();
        PropertyDTO dto = new PropertyDTO();
        dto.setId(1L);
        dto.setTitle("Dummy Property");
        propertyList.add(dto);

        //Do not make the actual call for propertyService.saveProperty() inside controller rather return dummy List<propertyDTO> in the controller
        Mockito.when(propertyService.getAllProperties()).thenReturn(propertyList);

        ResponseEntity<List<PropertyDTO>> responseEntity = propertyController.getAllProperties();
        assertEquals(1,responseEntity.getBody().size());
        assertEquals(HttpStatus.OK.value(),responseEntity.getStatusCodeValue());
    }
    @Test
    @DisplayName("Test Success Scenario for Updating only price of the Property")

    void testUpdatePropertyPrice(){

        PropertyDTO dto = new PropertyDTO();
        dto.setPrice(67675.55);
        Mockito.when(propertyService.updatePropertyPrice(Mockito.any(), Mockito.anyLong())).thenReturn(dto);
        ResponseEntity<PropertyDTO> responseEntity = propertyController.updatePropertyPrice(dto, 1L);
        assertEquals(67675.55,responseEntity.getBody().getPrice());
        assertEquals(HttpStatus.OK.value(),responseEntity.getStatusCodeValue());
    }
}
