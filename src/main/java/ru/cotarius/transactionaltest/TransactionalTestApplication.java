package ru.cotarius.transactionaltest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.cotarius.transactionaltest.repository.PersonalRepository;
import ru.cotarius.transactionaltest.service.PersonalService;

@SpringBootApplication
public class TransactionalTestApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(TransactionalTestApplication.class, args);

        PersonalService personalService = context.getBean(PersonalService.class);
        personalService.createNewPerson();
    }

}
