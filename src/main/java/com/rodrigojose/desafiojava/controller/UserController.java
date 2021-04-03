package com.rodrigojose.desafiojava.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigojose.desafiojava.domain.repository.UserRepository;
import com.rodrigojose.desafiojava.model.Phone;
import com.rodrigojose.desafiojava.model.User;
import com.rodrigojose.desafiojava.model.service.CadastroPhoneService;
import com.rodrigojose.desafiojava.model.service.CadastroUserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CadastroUserService userService;

	@Autowired
	private CadastroPhoneService phoneService;

	@GetMapping
	public List<User> listar() {
		return userRepository.findAll();

	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> buscar(@PathVariable Long userId) {
		Optional<User> user = userRepository.findById(userId);

		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());

		}

		return ResponseEntity.notFound().build();

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User adicionar(@Valid @RequestBody User user) {
		return userService.salvar(user);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<User> atualizar(@Valid @PathVariable Long userId, @RequestBody User user, Phone phone) {
//       try {
		if (!userRepository.existsById(userId)) {
			return ResponseEntity.notFound().build();
		}

		user.setId(userId);
		user = userService.salvar(user);
		phone.getId();
		phone = phoneService.salvar(phone);

		return ResponseEntity.ok(user);
//       }catch (Exception e) {
//    	   return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//       }
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> remover(@PathVariable Long userId) {
		if (!userRepository.existsById(userId)) {
			return ResponseEntity.notFound().build();

		}
		userService.excluir(userId);
		return ResponseEntity.noContent().build();

	}

}
