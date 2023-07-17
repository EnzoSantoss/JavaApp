package com.enzo.CRUDENZO.service;

import com.enzo.CRUDENZO.dto.request.PersonRequestDTO;
import com.enzo.CRUDENZO.dto.response.PersonResponseDTO;

import java.util.List;

public interface PersonService {

    PersonResponseDTO findById(Long id);

    List<PersonResponseDTO> findAll();

    PersonResponseDTO register (PersonRequestDTO personDTO);

    PersonResponseDTO update (PersonRequestDTO personDTO,Long id);

    String delete (Long id);
}
