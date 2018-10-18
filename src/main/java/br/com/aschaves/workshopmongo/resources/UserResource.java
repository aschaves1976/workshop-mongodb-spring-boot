package br.com.aschaves.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
