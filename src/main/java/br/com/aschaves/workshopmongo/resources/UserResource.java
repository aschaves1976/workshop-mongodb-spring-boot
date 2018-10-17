package br.com.aschaves.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.aschaves.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	// @RestController - Informa que a classe é um recurso REST
	// @RequestMapping - Informa o caminho do endpoint

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findALL() {
		User maria = new User("1", "Maria Brown", "mariab@gmail.com");
		User alex = new User("2", "Alex Green", "alexg@gmail.com");

		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));

		return ResponseEntity.ok().body(list);

	}
}
