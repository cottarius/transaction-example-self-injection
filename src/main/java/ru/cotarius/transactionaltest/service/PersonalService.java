package ru.cotarius.transactionaltest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.cotarius.transactionaltest.entity.Personal;
import ru.cotarius.transactionaltest.repository.PersonalRepository;

import java.util.List;

//@RequiredArgsConstructor
@Service
public class PersonalService {

    private final PersonalRepository personalRepository;

    //PersonalService personalService здесь для self-injection
    private final PersonalService personalService;

    /**
     * @Lazy здесь нужна, чтобы предотвратить зацикливание с выбросом ошибки
     * @param personalRepository
     * @param personalService
     */
    @Autowired
    public PersonalService(PersonalRepository personalRepository, @Lazy PersonalService personalService) {
        this.personalRepository = personalRepository;
        this.personalService = personalService;
    }

    @Transactional()
    public void createNewPerson() throws Exception {
        Personal personal1 = new Personal();
        personal1.setName("person1");
        personalRepository.save(personal1);
        personalService.addNewPerson();
    }

    /**
     * Propagation.REQUIRES_NEW - означает, что во время первой транзакции начинается вторая транзакция,
     * а первая входитв режим ожидания
     * @throws Exception
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void addNewPerson() throws Exception {
        Personal personal2 = new Personal();
        personal2.setName("person2");
        personalRepository.save(personal2);
        throw new Exception();
    }

    public List<Personal> getAllPersonals(){
        return personalRepository.findAll();
    }
}
