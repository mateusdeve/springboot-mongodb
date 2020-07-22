package com.example.projeto.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update( @RequestBody UserDTO objDto, @PathVariable String id) {
		
		User obj = service.fromDTO(objDto);
		obj.setId(id);
		
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
}
