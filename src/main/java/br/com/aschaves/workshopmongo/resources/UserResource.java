package br.com.aschaves.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.aschaves.workshopmongo.domain.User;
import br.com.aschaves.workshopmongo.dto.UserDTO;
import br.com.aschaves.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	// @RestController - Informa que a classe é um recurso REST
	// @RequestMapping - Informa o caminho do endpoint

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findALL() {

		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {

		User obj = service.findById(id);

		return ResponseEntity.ok().body(new UserDTO(obj));

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO) {

		User obj = service.fromDTO(objDTO);
		service.insert(obj);
		// retornando uma resposta vazia, porém com a url do recurso criado - Isso é uma
		// boa prática
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
}
