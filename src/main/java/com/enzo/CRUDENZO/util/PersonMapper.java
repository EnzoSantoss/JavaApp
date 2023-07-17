package com.enzo.CRUDENZO.util;

import com.enzo.CRUDENZO.dto.request.PersonRequestDTO;
import com.enzo.CRUDENZO.dto.response.PersonResponseDTO;
import com.enzo.CRUDENZO.entidade.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {

    public Person toPerson(PersonRequestDTO personDTO){

        return Person.builder()
                .name(personDTO.getName())
                .cpf(personDTO.getCpf())
                .age(personDTO.getAge())
                .build();
    }

    public PersonResponseDTO toPersonDTO(Person person){
        return new PersonResponseDTO(person);
    }

    public List<PersonResponseDTO> toPeopleDTO(List<Person> people){
        return people.stream().map(PersonResponseDTO::new).collect(Collectors.toList());
    }

    public void updatePersonData (Person person, PersonRequestDTO personDTO){
        person.setName(personDTO.getName());
        person.setCpf(personDTO.getCpf());
        person.setAge(personDTO.getAge());
    }
}
