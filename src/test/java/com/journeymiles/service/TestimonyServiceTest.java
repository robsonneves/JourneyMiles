package com.journeymiles.service;

import com.journeymiles.entity.TestimonyEntity;
import com.journeymiles.repository.TestimonyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TestimonyServiceTest {

    Long id = 1L;

    @InjectMocks
    TestimonyService testimonyService;

    @Mock
    TestimonyRepository testimonyRepository;

    @Mock
    TestimonyEntity testimonyEntity;

    @Test
    void create() throws PersistenceException {
        when(testimonyRepository.save(testimonyEntity)).thenReturn(testimonyEntity);
        var result = testimonyService.save(testimonyEntity);
        verify(testimonyRepository, only()).save(testimonyEntity);
        assertNotNull(result);
    }

    @Test
    void findAll() throws PersistenceException {
        List<TestimonyEntity> list = new ArrayList<>();
        list.add(testimonyEntity);
        when(testimonyRepository.findAll()).thenReturn(list);
        var result = testimonyService.findAll();
        verify(testimonyRepository, only()).findAll();
        assertNotNull(result);
    }

    @Test
    void findById() throws PersistenceException {
        when(testimonyRepository.findById(id)).thenReturn(Optional.ofNullable(testimonyEntity));
        var result = testimonyService.findById(id);
        verify(testimonyRepository, only()).findById(id);
        assertNotNull(result);
    }

    @Test
    void update() throws PersistenceException {
        when(testimonyRepository.save(testimonyEntity)).thenReturn(testimonyEntity);
        var result = testimonyService.update(testimonyEntity);
        verify(testimonyRepository, only()).save(testimonyEntity);
        assertNotNull(result);
    }

    @Test
    void findRandomTestimony() throws PersistenceException {
        List<TestimonyEntity> list = new ArrayList<>();
        list.add(testimonyEntity);
        when(testimonyRepository.findRandomTestimony()).thenReturn(list);
        var result = testimonyService.findRandomTestimony();
        verify(testimonyRepository, only()).findRandomTestimony();
        assertNotNull(result);
    }
}