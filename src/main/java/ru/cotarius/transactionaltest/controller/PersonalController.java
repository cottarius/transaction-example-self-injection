package ru.cotarius.transactionaltest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cotarius.transactionaltest.entity.Personal;
import ru.cotarius.transactionaltest.service.PersonalService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class PersonalController {

    private final PersonalService personalService;

    @GetMapping
    public List<Personal> getAllUsers() {
        return personalService.getAllPersonals();
    }
}
