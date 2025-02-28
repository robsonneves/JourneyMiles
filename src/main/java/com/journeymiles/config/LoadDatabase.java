package com.journeymiles.config;

import com.journeymiles.entity.DestinationEntity;
import com.journeymiles.entity.TestimonyEntity;
import com.journeymiles.repository.DestinationRepository;
import com.journeymiles.repository.TestimonyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(
            TestimonyRepository testimonyRepository,
            DestinationRepository destinationRepository) {

        TestimonyEntity testimonyEntity = new TestimonyEntity();
        testimonyEntity.setPhoto("photo test");
        testimonyEntity.setTestimony("testimony test");

        DestinationEntity destinationEntity = new DestinationEntity();
        destinationEntity.setName("name test");
        destinationEntity.setPhoto("photo test");

        return args -> {
            log.info("Preloading " + testimonyRepository.save(testimonyEntity));
            log.info("Preloading " + destinationRepository.save(destinationEntity));
        };
    }
}
