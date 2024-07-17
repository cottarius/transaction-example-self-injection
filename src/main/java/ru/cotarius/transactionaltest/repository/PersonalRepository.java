package ru.cotarius.transactionaltest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cotarius.transactionaltest.entity.Personal;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Integer> {

}
