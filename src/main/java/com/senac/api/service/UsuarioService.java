package com.senac.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.senac.api.entity.Usuario;
import com.senac.api.exception.DataIntegrityViolationException;
import com.senac.api.exception.ObjectnotFoundException;
import com.senac.api.repository.UsuarioRepository;

import jakarta.validation.Valid;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository userRepository;
	
	//@Autowired
	//private BCryptPasswordEncoder encoder;
	
	public Usuario login(String email, String senha) {
		Optional<Usuario> usuario = userRepository.findByEmail(email);
		
		if(!usuario.isPresent()) {
			throw new ObjectnotFoundException("Usuario não encontrado para o email informado.");
		}
		
		if(usuario.get().getSenha().equals(senha)) {
			throw new DataIntegrityViolationException("Senha inválida.");
		}
		
		/*Response personalizada do login*/
		//LoginResponse loginResponse = new LoginResponse();
		//loginResponse.setId(usuario.get().getId());
		//loginResponse.setNome(usuario.get().getNomeCompleto());
		//loginResponse.setEmail(email);	
		
		return usuario.get();
	}

	public Usuario adicionar(Usuario user) {
		user.setId(null);
		//userDto.setSenha(encoder.encode(userDto.getSenha()));
		user.setStatus(true);
		validaPorCpfEEmail(user);	
		user = userRepository.save(user);
		user.setId(user.getId());
		return user;
	}
	
	public List<Usuario> obterTodos(){
		List<Usuario> users = userRepository.findAll();
		return users;
	}
	
	public Optional<Usuario> obterPorId(Long id){
		Optional<Usuario> user = userRepository.findById(id);
		
		if(user.isEmpty()) {
			throw new ObjectnotFoundException("USUARIO COM ID : '" + id + "' NÃO ENCONTRADO!");
		}
		
		return user;
	}
	
	public Optional<Usuario> obterPorEmail(String email){
		Optional<Usuario> userEncontrado = userRepository.findByEmail(email);
		
		if(userEncontrado.isEmpty()) {
			throw new ObjectnotFoundException("USUARIO COM CPF : '" + email + "' NÃO ENCONTRADO!");
		}
		
		return userEncontrado;
	}
	
	public Optional<Usuario> obterIdPorCpf(String cpf){
		Optional<Usuario> userEncontrado = userRepository.findByCpf(cpf);
		
		if(userEncontrado.isEmpty()) {
			throw new ObjectnotFoundException("USUARIO COM CPF : '" + cpf + "' NÃO ENCONTRADO!");
		}
		
		return userEncontrado;
	}
	
	public Usuario atualizar(Long id, @Valid Usuario user) {
		Optional<Usuario> userId = userRepository.findById(id);
		
		if(userId.isEmpty()) {
			throw new ObjectnotFoundException("USUARIO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		user.setId(id);
		user.setId(id);
		user.setSenha(user.getSenha());
		validaPorCpfEEmail(user);
		userRepository.save(user);
		return user;
	}
	
	public Usuario updateProfileImage(Long id, MultipartFile file) throws Exception {
		Optional<Usuario> userEncontrado = userRepository.findById(id);
		System.out.println("filename: " + file.getOriginalFilename() );
		if(userEncontrado.isEmpty()) {
			throw new ObjectnotFoundException("USUARIO COM ID: '" + id + "' NÃO ENCONTRADO!");
		}
		
		Usuario user = new Usuario();
		user.setId(id);
		user.setCpf(userEncontrado.get().getCpf());
		user.setNomeCompleto(userEncontrado.get().getNomeCompleto());
		user.setApelido(userEncontrado.get().getApelido());
		user.setEmail(userEncontrado.get().getEmail());
		user.setDataNascimento(userEncontrado.get().getDataNascimento());
		user.setTelefone(userEncontrado.get().getTelefone());
		//userDto.setAtendimentoDataCadastro(userEncontrado.get().getAtendimentoDataCadastro());
		user.setFoto(file.getBytes());
		user.setSenha(userEncontrado.get().getSenha());
		user.setStatus(userEncontrado.get().getStatus());
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
	    try {
	       if(fileName.contains("..")) {
	         throw  new Exception("Filename contains invalid path sequence " + fileName);
	       }

	      userRepository.save(user);
	      return user;

	    } catch (Exception e) {
	       throw new Exception("Could not save File: " + fileName);
	    }
	 }
	
	public void deletar(Long id) {
		Optional<Usuario> user = userRepository.findById(id);
		
		if(user.isEmpty()) {
			throw new ObjectnotFoundException("USUARIO COM ID: '\" + id + \"' NÃO ENCONTRADO!");
		}
		
		userRepository.deleteById(id);
	}
	
	private void validaPorCpfEEmail(Usuario user) {
		Optional<Usuario> obj = userRepository.findByCpf(user.getCpf());
		
		if(obj.isPresent() && obj.get().getId() != user.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}
		
		obj = userRepository.findByEmail(user.getEmail());
		
		if(obj.isPresent() && obj.get().getId() != user.getId()) {
			throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
		}
	}
	
}
