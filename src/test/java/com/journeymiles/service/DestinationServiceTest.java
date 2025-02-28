package com.journeymiles.service;

import com.journeymiles.entity.DestinationEntity;
import com.journeymiles.repository.DestinationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DestinationServiceTest {

    Long id = 1L;
    String name = "Name test";

    @InjectMocks
    DestinationService destinationService;

    @Mock
    DestinationRepository destinationRepository;

    @Mock
    DestinationEntity destinationEntity;

    @Test
    void create() throws PersistenceException {
        when(destinationRepository.save(destinationEntity)).thenReturn(destinationEntity);
        var result = destinationService.save(destinationEntity);
        verify(destinationRepository, only()).save(destinationEntity);
        assertEquals(destinationEntity, result);
    }

    @Test
    void findAll() throws PersistenceException {
        List<DestinationEntity> list = new ArrayList<>();
        list.add(destinationEntity);
        when(destinationRepository.findAll()).thenReturn(list);
        var result = destinationService.findAll();
        verify(destinationRepository, only()).findAll();
        assertNotNull(result);
    }

    @Test
    void findById() throws PersistenceException {
        when(destinationRepository.findById(id)).thenReturn(Optional.ofNullable(destinationEntity));
        var result = destinationService.findById(id);
        verify(destinationRepository, only()).findById(id);
        assertNotNull(result);
    }

    @Test
    void update() throws PersistenceException {
        when(destinationRepository.save(destinationEntity)).thenReturn(destinationEntity);
        var result = destinationService.update(destinationEntity);
        verify(destinationRepository, only()).save(destinationEntity);
        assertNotNull(result);
    }

    @Test
    void findWithFilter() throws PersistenceException {
        List<DestinationEntity> list = new ArrayList<>();
        list.add(destinationEntity);
        when(destinationRepository.findByNameContains(name)).thenReturn(list);
        destinationService.findByNameContains(name);
        verify(destinationRepository, only()).findByNameContains(name);
    }
}