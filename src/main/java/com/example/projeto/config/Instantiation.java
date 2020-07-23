package com.example.projeto.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.projeto.dto.AuthorDTO;
import com.example.projeto.dto.CommentDTO;
import com.example.projeto.entities.Post;
import com.example.projeto.entities.User;
import com.example.projeto.repository.PostRepository;
import com.example.projeto.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, sdf.parse("21/20/2020"), "to chegando em canadá", "god god god", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("22/20/2020"), "ja cheguei canadá", "god god god", new AuthorDTO(maria));
		
		
		CommentDTO com1 = new CommentDTO("Boa viagem mano", sdf.parse("22/02/2020"), new AuthorDTO(alex));
		CommentDTO com3 = new CommentDTO("volte logo", sdf.parse("22/02/2020"), new AuthorDTO(bob));
		
		post1.getComments().addAll(Arrays.asList(com1, com3));
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getList().addAll(Arrays.asList(post1,post2));
		userRepository.saveAll(Arrays.asList(maria));
		
		userRepository.saveAll(Arrays.asList(alex,bob));
		
		
		
	}

}
