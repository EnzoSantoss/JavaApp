package com.enzo.CRUDENZO.service;
import com.enzo.CRUDENZO.dto.request.PersonRequestDTO;
import com.enzo.CRUDENZO.dto.response.PersonResponseDTO;
import com.enzo.CRUDENZO.entidade.Person;
import com.enzo.CRUDENZO.repository.PersonRepository;
import com.enzo.CRUDENZO.util.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Primary
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    @Override
    public PersonResponseDTO findById(Long id) {

        //Person person = this.returnPerson(id);
        Person person = returnPerson(id);
        return personMapper.toPersonDTO(person);
    }

    @Override
    public List<PersonResponseDTO> findAll() {

        List<Person> people= personRepository.findAll();
        //List<PersonResponseDTO>allPersonToDTO = allPerson.stream().map((person)-> personMapper.toPersonDTO(person)).toList();
        return personMapper.toPeopleDTO(people);
    }

    @Override
    public PersonResponseDTO register(PersonRequestDTO personDTO) {

        Person person = personMapper.toPerson(personDTO);
        return personMapper.toPersonDTO(personRepository.save(person));

    }

    @Override
    public PersonResponseDTO update(PersonRequestDTO personDTO, Long id) {

        Person person = returnPerson(id);
        personMapper.updatePersonData(person, personDTO);

        return  personMapper.toPersonDTO(personRepository.save(person));
    }

    @Override
    public String delete(Long id) {

        personRepository.deleteById(id);
        return "Person deleted";
    }

    private Person returnPerson (Long id){
        //return personRepository.findById(id).orElseThrow(()-> new RuntimeException("Person not found"));
        return  personRepository.findById(id).orElseThrow(()-> new RuntimeException("Person not found"));
    }
}
