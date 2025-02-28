package com.journeymiles.service;

import com.journeymiles.entity.TestimonyEntity;
import com.journeymiles.repository.TestimonyRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TestimonyService {

    private final TestimonyRepository testimonyRepository;

    public TestimonyService(TestimonyRepository testimonyRepository) {
        this.testimonyRepository = testimonyRepository;
    }

    public TestimonyEntity save(TestimonyEntity testimonyEntity) throws PersistenceException {
        try{
            testimonyEntity.setDateInsert(new Date());
            return testimonyRepository.save(testimonyEntity);
        } catch (Exception e){
            throw new PersistenceException("Error when saving testimony!", e);
        }
    }

    public List<TestimonyEntity> findAll() throws PersistenceException {
        try{
            return testimonyRepository.findAll();
        } catch (Exception e){
            throw new PersistenceException("Error when searching All testimony!", e);
        }
    }

    public Optional<TestimonyEntity> findById(Long id) throws PersistenceException {
        try{
            return testimonyRepository.findById(id);
        } catch (Exception e){
            throw new PersistenceException("Error when searching testimony by id", e);
        }
    }

    public TestimonyEntity update(TestimonyEntity testimonyEntity) throws PersistenceException {
        try{
            testimonyEntity.setDateUpdate(new Date());
            return testimonyRepository.save( testimonyEntity);
        } catch (Exception e){
            throw new PersistenceException("Error when updating testimony!", e);
        }
    }

    public List<TestimonyEntity> findRandomTestimony() throws PersistenceException {
        try{
            return testimonyRepository.findRandomTestimony();
        } catch (Exception e){
            throw new PersistenceException("Erro when searching testimony random, 3 results!", e);
        }
    }

    public void delete(Long id) throws PersistenceException {
        try {
            testimonyRepository.delete(testimonyRepository.findById(id).get());
        } catch (Exception e){
            throw new PersistenceException("Erro when deleting testimony!", e);
        }
    }
}
