package com.journeymiles.controller;

import com.journeymiles.entity.DestinationEntity;
import com.journeymiles.service.DestinationService;
import com.journeymiles.service.PersistenceException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DestinationControllerTest {

    String name = "name";
    String nameUpdate = "Update Name";
    Long id = 1L;

    @InjectMocks
    DestinationController destinationController;

    @Mock
    DestinationService destinationService;

    @Mock
    DestinationEntity destinationEntity;

    @Test
    void create() throws PersistenceException {
        var result = destinationController.create(destinationEntity);
        verify(destinationService, only()).save(destinationEntity);
        assertEquals("200 OK", result.getStatusCode().toString());
    }

    @Test
    void read() throws PersistenceException {
        var result = destinationController.read();
        verify(destinationService, only()).findAll();
        assertEquals("200 OK", result.getStatusCode().toString());
    }

    @Test
    void readWithName() throws PersistenceException {
        var result = destinationController.read(name);
        verify(destinationService, only()).findByNameContains(name);
        assertEquals("200 OK", result.getStatusCode().toString());
    }

    @Test
    void readId() throws PersistenceException {
        when(destinationService.findById(id)).thenReturn(Optional.ofNullable(destinationEntity));
        var result = destinationController.read(id);
        verify(destinationService, only()).findById(id);
        assertEquals("200 OK", result.getStatusCode().toString());
    }

    @Test
    void updateReturnNull() throws PersistenceException {
        destinationEntity.setName(nameUpdate);
        var result = destinationController.update(destinationEntity);
        verify(destinationService, only()).update(destinationEntity);
        assertEquals("200 OK", result.getStatusCode().toString());
    }

    @Test
    void updateReturnNotNull() throws PersistenceException {
        destinationEntity.setName(nameUpdate);
        when(destinationService.update(destinationEntity)).thenReturn(destinationEntity);
        var result = destinationController.update(destinationEntity);
        verify(destinationService, only()).update(destinationEntity);
        assertEquals("200 OK", result.getStatusCode().toString());
    }

    @Test
    void delete() throws PersistenceException {
        destinationController.delete(id);
        verify(destinationService, only()).delete(any());
    }
}