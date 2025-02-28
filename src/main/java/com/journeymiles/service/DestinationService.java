package com.journeymiles.service;

import com.journeymiles.entity.DestinationEntity;
import com.journeymiles.repository.DestinationRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public DestinationEntity save(DestinationEntity destinationEntity) throws PersistenceException {
        try{
            destinationEntity.setDateInsert(new Date());
            return destinationRepository.save(destinationEntity);
        } catch (Exception e){
            throw new PersistenceException("Error when saving destination!", e);
        }
    }

    public List<DestinationEntity> findAll() throws PersistenceException {
        try{
            return destinationRepository.findAll();
        } catch (Exception e){
            throw new PersistenceException("Error when searching All destination!", e);
        }
    }

    public Optional<DestinationEntity> findById(Long id) throws PersistenceException {
        try{
            return destinationRepository.findById(id);
        } catch (Exception e){
            throw new PersistenceException("Error when searching destination by id",e);
        }
    }

    public DestinationEntity update(DestinationEntity destinationEntity) throws PersistenceException {
        try{
            destinationEntity.setDateUpdate(new Date());
            return destinationRepository.save( destinationEntity);
        } catch (Exception e){
            throw new PersistenceException("Error when updating destination!", e);
        }
    }

    public List<DestinationEntity> findByNameContains(String name) throws PersistenceException {
        try{
            return destinationRepository.findByNameContains(name);
        } catch (Exception e){
            throw new PersistenceException("Erro when searching destination by name!", e);
        }
    }

    public void delete(Long id) throws PersistenceException {
        try {
            destinationRepository.delete(destinationRepository.findById(id).get());
        } catch (Exception e){
            throw new PersistenceException("Erro when deleting destination!", e);
        }
    }
}
