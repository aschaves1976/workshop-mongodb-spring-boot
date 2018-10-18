package br.com.aschaves.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aschaves.workshopmongo.domain.User;
import br.com.aschaves.workshopmongo.dto.UserDTO;
import br.com.aschaves.workshopmongo.repository.UserRepository;
import br.com.aschaves.workshopmongo.services.exception.ObjectNotFoundException;

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

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		repo.deleteById(id);
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
