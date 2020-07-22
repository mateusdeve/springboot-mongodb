package com.example.projeto.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto.dto.UserDTO;
import com.example.projeto.entities.User;
import com.example.projeto.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDTODtos = list.stream().map(x-> new UserDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTODtos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		
		User user = service.findById(id);
		
		return ResponseEntity.ok().body(new UserDTO(user));
	}
	
	@PostMapping
	public ResponseEntity<User> insert( @RequestBody UserDTO objDto) {
		
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		
		return ResponseEntity.ok().body(obj);
	}

}
