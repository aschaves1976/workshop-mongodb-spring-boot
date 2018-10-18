package br.com.aschaves.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.aschaves.workshopmongo.domain.User;
import br.com.aschaves.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	// @RestController - Informa que a classe é um recurso REST
	// @RequestMapping - Informa o caminho do endpoint

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findALL() {

		List<User> list = service.findAll();

		return ResponseEntity.ok().body(list);

	}
}
