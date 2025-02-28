package com.journeymiles.controller;

import com.journeymiles.entity.TestimonyEntity;
import com.journeymiles.service.PersistenceException;
import com.journeymiles.service.TestimonyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TestimonyControllerTest {

    Long id = 1L;

    @InjectMocks
    TestimonyController testimonyController;

    @Mock
    TestimonyService testimonyService;

    @Mock
    TestimonyEntity testimonyEntity;

    @Test
    void create() throws PersistenceException {
        var result = testimonyController.create(testimonyEntity);
        verify(testimonyService, only()).save(testimonyEntity);
        assertEquals("200 OK", result.getStatusCode().toString());
    }

    @Test
    void read() throws PersistenceException {
        var result = testimonyController.read();
        verify(testimonyService, only()).findAll();
        assertEquals("200 OK", result.getStatusCode().toString());
    }

    @Test
    void readId() throws PersistenceException {
        when(testimonyService.findById(id)).thenReturn(Optional.ofNullable(testimonyEntity));
        var result = testimonyController.read(id);
        verify(testimonyService, only()).findById(id);
        assertEquals("200 OK", result.getStatusCode().toString());
    }

    @Test
    void update() throws PersistenceException {
        when(testimonyService.update(testimonyEntity)).thenReturn(testimonyEntity);
        var result = testimonyController.update(testimonyEntity);
        verify(testimonyService, only()).update(testimonyEntity);
        assertEquals("200 OK", result.getStatusCode().toString());
    }

    @Test
    void readRandom() throws PersistenceException {

        List<TestimonyEntity> list = new ArrayList<>();
        list.add(testimonyEntity);

        when(testimonyService.findRandomTestimony()).thenReturn(list);
        var result = testimonyController.readRandom();
        verify(testimonyService, only()).findRandomTestimony();
        assertEquals("200 OK", result.getStatusCode().toString());
    }

    @Test
    void delete() throws PersistenceException {
        testimonyController.delete(id);
        verify(testimonyService, only()).delete(any());
    }
}