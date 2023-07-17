package com.enzo.CRUDENZO.repository;

import com.enzo.CRUDENZO.entidade.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
