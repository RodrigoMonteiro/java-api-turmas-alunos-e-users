package com.atividade05.apirest.Controller;

import com.atividade05.apirest.DTO.UserDTO;
import com.atividade05.apirest.Model.User;
import com.atividade05.apirest.Repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@CrossOrigin(origins="*")
@Api(value= "API REST de users.")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/signup")
	@ResponseBody
	@ApiOperation(value ="Cria um usuário (utilizado quando não está logano no sistema)")
	public ResponseEntity<User> createUser(@RequestBody UserDTO user) {
		try {
			return ResponseEntity
					.ok(userRepository.save(new User(user.getEmail(), user.getPassword(), user.getUsername())));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping(value ="/api/users")
	@ApiOperation(value ="Retorna um lista com todos os users cadastrados.")
	public List<User> listaUsuarios() {
		return userRepository.findAll();
	}

	@GetMapping(value ="/api/users/{id}")
	@ApiOperation(value ="Retorna um user com o id passado por parâmetro.")
	public Optional<User> usuarioById(@PathVariable(value = "id") Integer id) {
		return userRepository.findById(id);

	}
	
	@PostMapping(value ="/api/users")
	@ApiOperation(value ="Adiciona um user a lista de users cadastrados.")
	public void adicionarUser(@RequestBody User user) {
		userRepository.save(user);
	}
	
	@DeleteMapping(value ="/api/users/{id}")
	@ApiOperation(value ="Deleta um user que teve o id passado por parâmetro.")
	public void removerUser(@PathVariable (value = "id") Integer id) {
		userRepository.deleteById(id);
	}
	@PutMapping(value ="/api/users/{id}")
	@ApiOperation(value ="Edita um user que teve o id passado por parâmetro.")
	public void atualizarUser(@PathVariable (value ="id") Integer id, @RequestBody User user) {
		List<User> listaUsers = userRepository.findAll();
		for (User u : listaUsers) {
			if (u.getId() == id) {
				u.setNome(user.getNome());
				u.setPassword(user.getPassword());
				u.setUsername(user.getUsername());
				userRepository.save(u);
			}
		}
	}

}