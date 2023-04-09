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

import com.senac.api.entity.Badge;
import com.senac.api.entity.BadgeNivel;
import com.senac.api.request.BadgeRequest;
import com.senac.api.response.BadgeResponse;
import com.senac.api.service.BadgeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/badge")
public class BadgeController {

	@Autowired
	private BadgeService badgeService;
	
	@PostMapping
	public ResponseEntity<BadgeResponse> adicionar(@Valid @RequestBody BadgeRequest badgeReq){
		ModelMapper mapper = new ModelMapper();
		Badge badge = mapper.map(badgeReq, Badge.class);
		badge = badgeService.adicionar(badge);
		return new ResponseEntity<>(mapper.map(badge, BadgeResponse.class), HttpStatus.CREATED);
	}
	
    @PostMapping("/upload")
    public ResponseEntity<BadgeResponse> uploadFile(
    		@RequestParam("descricao")String descricao, 
    		@RequestParam("img")MultipartFile file, 
    		@RequestParam("badgeNivelId")BadgeNivel badgeNivelId) throws Exception {
    	ModelMapper mapper = new ModelMapper();
    	
        //String downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/badge/").path(file.getOriginalFilename()/*.toString()*/).toUriString();

    	Badge badge = new Badge();
    	badge.setDescricao(descricao);
    	badge.setImg(file.getBytes());
    	badge.setStatus(true);
    	badge.setBadgeNivelId(badgeNivelId);
    	
    	badge = badgeService.upload(file, badge);
        
    	return new ResponseEntity<>(mapper.map(badge, BadgeResponse.class), HttpStatus.CREATED);
    }
    
    @GetMapping("/busca")
    public ResponseEntity<List<BadgeResponse>> buscar(
    		@RequestParam(value = "descricao", required = false) String descricao,
    		@RequestParam(value = "nivel", required = false) BadgeNivel nivel
    		){
    	Badge filter = new Badge();
    	filter.setDescricao(descricao);
    	filter.setBadgeNivelId(nivel);
    	
    	List<Badge> badges = badgeService.buscar(filter);
    	ModelMapper mapper = new ModelMapper();
    	List<BadgeResponse> resposta = badges.stream().map(badge -> mapper.map(badge, BadgeResponse.class)).collect(Collectors.toList());
    	return new ResponseEntity<>(resposta, HttpStatus.OK);
    }
	
	@GetMapping
	public ResponseEntity<List<BadgeResponse>> obterTodos(){
		List<Badge> badges = badgeService.obterTodos();
		ModelMapper mapper = new ModelMapper();
		List<BadgeResponse> resposta = badges.stream().map(badge -> mapper.map(badge, BadgeResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<BadgeResponse>> obterPorId(@PathVariable Long id){
		Optional<Badge> badgeEncontrado = badgeService.obterPorId(id);
		BadgeResponse badge = new ModelMapper().map(badgeEncontrado.get(), BadgeResponse.class);
		return new ResponseEntity<>(Optional.of(badge), HttpStatus.OK);
	}
	
	@GetMapping("/badgeNivel/{id}")
	public ResponseEntity<List<BadgeResponse>> obterPorNivel(@PathVariable Long id){
		List<Badge> badges = badgeService.obterPorNivel(id);
		ModelMapper mapper = new ModelMapper();
		List<BadgeResponse> resposta = badges.stream().map(badge -> mapper.map(badge, BadgeResponse.class)).collect(Collectors.toList());
		return new ResponseEntity<>(resposta, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		badgeService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BadgeResponse> atualizar(@Valid @RequestBody BadgeRequest badgeReq, @PathVariable Long id){
		ModelMapper mapper = new ModelMapper();
		Badge badge = mapper.map(badgeReq, Badge.class);
		badge = badgeService.atualizar(id, badge);
		return new ResponseEntity<>(mapper.map(badge, BadgeResponse.class), HttpStatus.OK);
	}
	
}
