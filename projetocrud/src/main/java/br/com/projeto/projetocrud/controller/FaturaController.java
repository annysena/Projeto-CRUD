package br.com.projeto.projetocrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.projetocrud.model.Fatura;
import br.com.projeto.projetocrud.repository.FaturaRepository;

@RestController
@RequestMapping("/fatura")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FaturaController {

	@Autowired
	private FaturaRepository faturaRepository;

	@GetMapping
	public ResponseEntity<List<Fatura>> GetAll() {
		return ResponseEntity.ok(faturaRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Fatura> GetById(@PathVariable long id) {
		return faturaRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/dadosCliente/{dadosCliente}") 
	public ResponseEntity<List<Fatura>> getByDadosCliente(@PathVariable String dadosCliente) {
		return ResponseEntity.ok(faturaRepository.findAllByDadosClienteContainingIgnoreCase(dadosCliente));
	}

	@PostMapping
	public ResponseEntity<Fatura> postFatura(@RequestBody Fatura fatura) {
		return ResponseEntity.status(HttpStatus.CREATED).body(faturaRepository.save(fatura));
	}

}
