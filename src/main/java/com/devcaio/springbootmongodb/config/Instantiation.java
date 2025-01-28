package com.devcaio.springbootmongodb.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devcaio.springbootmongodb.domain.Post;
import com.devcaio.springbootmongodb.domain.User;
import com.devcaio.springbootmongodb.dto.AuthorDTO;
import com.devcaio.springbootmongodb.dto.CommentDTO;
import com.devcaio.springbootmongodb.repository.PostRepository;
import com.devcaio.springbootmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, Date.from(Instant.now()), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, Date.from(Instant.now()), "Dicas", "Não se aprende escutando e sim fazendo! #foco", new AuthorDTO(alex));
		Post post3 = new Post(null, Date.from(Instant.now()), "How to learn a new language?", "Can someone explain how can i increase my english skills?", new AuthorDTO(bob));
		
		CommentDTO c1 = new CommentDTO(new AuthorDTO(bob), "Aproveite!", Instant.now());
		CommentDTO c2 = new CommentDTO(new AuthorDTO(alex), "Divirta-se bastante!", Instant.now());
		CommentDTO c3 = new CommentDTO(new AuthorDTO(maria), "Isso é verdade, pratico sempre ;)", Instant.now());
		CommentDTO c4 = new CommentDTO(new AuthorDTO(alex), "Try practicing speaking with natives!", Instant.now());
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().add(c3);
		post3.getComments().add(c4);
		
		postRepository.saveAll(Arrays.asList(post1, post2, post3));
		
		maria.getPosts().add(post1);
		alex.getPosts().add(post2);
		bob.getPosts().add(post3);
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
	}
	
}
