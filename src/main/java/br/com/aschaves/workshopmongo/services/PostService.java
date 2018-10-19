package br.com.aschaves.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aschaves.workshopmongo.domain.Post;
import br.com.aschaves.workshopmongo.domain.User;
import br.com.aschaves.workshopmongo.repository.PostRepository;
import br.com.aschaves.workshopmongo.services.exception.ObjectNotFoundException;

@Service // <- Essa notação informa para o Spring que esta classe é um serviço, que pode
			// ser injetável em outras classes
public class PostService {

	/*
	 * Com a notação @Autowired, Vamos instanciar automaticamente um objeto
	 * UserRepository, o serviço conversar com o Repository.
	 * 
	 */
	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
