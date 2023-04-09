package com.senac.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.senac.api.entity.Usuario;
import com.senac.api.request.UsuarioRequest;
import com.senac.api.response.UsuarioResponse;
import com.senac.api.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UsuarioController {

	@Autowired
	private UsuarioService userService;
	
	@PostMapping
	public ResponseEntity<UsuarioResponse> adicionar(@Valid @RequestBody UsuarioRequest userReq){
		ModelMapper mapper = new ModelMapper();
		Usuario user = mapper.map(userReq, Usuario.class);
		user = userService.adicionar(user);
		return new ResponseEntity<>(mapper.map(user, UsuarioResponse.class), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioResponse>> obterTodos(){
		List<Usuario> users = userService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<UsuarioResponse> resposta = users.stream().map(user -> mapper.map(user, UsuarioResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<UsuarioResponse>> obterPorId(@PathVariable Long id){
		Optional<Usuario> dto = userService.obterPorId(id);
		UsuarioResponse user = new ModelMapper().map(dto.get(), UsuarioResponse.class);
		return new ResponseEntity<>(Optional.of(user), HttpStatus.OK);
	}
	
	@GetMapping("buscaEmail/{email}")
	public ResponseEntity<Optional<UsuarioResponse>> obterPorEmail(@PathVariable("email") String email){
		Optional<Usuario> dto = userService.obterPorEmail(email);
		UsuarioResponse user = new ModelMapper().map(dto.get(), UsuarioResponse.class);
		return new ResponseEntity<>(Optional.of(user), HttpStatus.OK);
	}
	
	@GetMapping("buscaCpf/{cpf}")
	public ResponseEntity<Optional<UsuarioResponse>> obterPorCpf(@PathVariable("cpf") String cpf){
		Optional<Usuario> dto = userService.obterIdPorCpf(cpf);
		UsuarioResponse user = new ModelMapper().map(dto.get(), UsuarioResponse.class);
		return new ResponseEntity<>(Optional.of(user), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioResponse> atualizar(@Valid @RequestBody UsuarioRequest userReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		Usuario user = mapper.map(userReq, Usuario.class);
		user = userService.atualizar(id, user);
		return new ResponseEntity<>(mapper.map(user, UsuarioResponse.class), HttpStatus.OK);
	}
	
    @PostMapping("/updateProfileImage")
    public ResponseEntity<UsuarioResponse> uploadFile(@RequestParam("id")Long id, @RequestParam("file")MultipartFile file) throws Exception {
    	ModelMapper mapper = new ModelMapper();
    	Usuario user = new Usuario();
    	user = userService.updateProfileImage(id, file);
    	return new ResponseEntity<>(mapper.map(user, UsuarioResponse.class), HttpStatus.OK);
    
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		userService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
