package br.com.projeto.projetocrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.projetocrud.model.Conta;
import br.com.projeto.projetocrud.repository.ContaRepository;

@RestController
@RequestMapping("/conta")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContaController {

	@Autowired
	private ContaRepository contaRepository;

	@GetMapping
	public ResponseEntity<List<Conta>> GetAll() {
		return ResponseEntity.ok(contaRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Conta> GetById(@PathVariable long id) {
		return contaRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Conta> postConta(@RequestBody Conta conta) {
		return ResponseEntity.status(HttpStatus.CREATED).body(contaRepository.save(conta));
	} 

	@PutMapping
	public ResponseEntity<Conta> putConta(@RequestBody Conta conta) {
		return ResponseEntity.status(HttpStatus.OK).body(contaRepository.save(conta));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		contaRepository.deleteById(id);

	}
}
