package com.example.projeto.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

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
		
		Post post1 = new Post(null, sdf.parse("21/20/2020"), "to chegando em canadá", "god god god", maria);
		Post post2 = new Post(null, sdf.parse("22/20/2020"), "ja cheguei canadá", "god god god", maria);
		
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		
		
	}

}
