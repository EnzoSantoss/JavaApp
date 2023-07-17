package com.enzo.CRUDENZO.controller;

import com.enzo.CRUDENZO.dto.request.PersonRequestDTO;
import com.enzo.CRUDENZO.dto.response.PersonResponseDTO;
import com.enzo.CRUDENZO.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonResponseDTO>  findById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok().body(personService.findById(id));
    }

    @GetMapping
    public  ResponseEntity<List<PersonResponseDTO>> findMany(){
        return  ResponseEntity.ok().body(personService.findAll());
    }

    @PostMapping
    public ResponseEntity<PersonResponseDTO> register(@RequestBody PersonRequestDTO personRequestDTO, UriComponentsBuilder uriBuilder){

        PersonResponseDTO personResponseDTO = personService.register(personRequestDTO);

        URI uri = uriBuilder.path("/people/{id}").buildAndExpand(personResponseDTO.getId()).toUri();
        return  ResponseEntity.created(uri).body(personResponseDTO);
    }

    @PutMapping(value= "/{id}")
    public  ResponseEntity<PersonResponseDTO> update(@RequestBody PersonRequestDTO personRequestDTO, @PathVariable(name= "id") Long id){
        return ResponseEntity.ok().body(personService.update(personRequestDTO,id));
    }

    @DeleteMapping(value= "/{id}")
    public  ResponseEntity<String> delete(@PathVariable(name = "id") Long id){
        return  ResponseEntity.ok().body(personService.delete(id));
    }
}
