package br.com.aschaves.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aschaves.workshopmongo.domain.User;
import br.com.aschaves.workshopmongo.repository.UserRepository;

@Service // <- Essa notação informa para o Spring que esta classe é um serviço, que pode
			// ser injetável em outras classes
public class UserService {

	/*
	 * Com a notação @Autowired, Vamos instanciar automaticamente um objeto
	 * UserRepository, o serviço conversar com o Repository.
	 * 
	 */
	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();

	}
}
