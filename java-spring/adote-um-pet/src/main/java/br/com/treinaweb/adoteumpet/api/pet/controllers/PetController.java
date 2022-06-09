package br.com.treinaweb.adoteumpet.api.pet.controllers;

// import java.util.ArrayList;
import java.util.List;
// import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.adoteumpet.api.pet.dtos.PetRequest;
import br.com.treinaweb.adoteumpet.api.pet.dtos.PetResponse;
// import br.com.treinaweb.adoteumpet.api.pet.mappers.PetMapper;
import br.com.treinaweb.adoteumpet.api.pet.services.PetService;
// import br.com.treinaweb.adoteumpet.core.models.Pet;
// import br.com.treinaweb.adoteumpet.core.repositories.PetRepository;

@RestController
@RequestMapping("/api/pets")
public class PetController {

	// @Autowired
	// private PetRepository petRepository;

	// @Autowired
	// private PetMapper petMapper;
	
	@Autowired
	private PetService petService;
	
	@GetMapping
	public List<PetResponse> findAll() {
		// var pets = petRepository.findAll();
		// var petResponses = new ArrayList<PetResponse>();
		// for (Pet pet : pets) {
		// 	petResponses.add(petMapper.toResponse(pet));
		// }
		// return petResponses;
		return petService.findAll();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetResponse create(@RequestBody @Valid PetRequest petRequest) {
		return petService.create(petRequest);
	}

}
