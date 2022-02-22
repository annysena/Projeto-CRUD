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

import br.com.projeto.projetocrud.model.Transacao;
import br.com.projeto.projetocrud.repository.TransacaoRepository;

@RestController
@RequestMapping("/transacao")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransacaoController {

	@Autowired
	private TransacaoRepository transacaoRepository;

	@GetMapping
	public ResponseEntity<List<Transacao>> GetAll() {
		return ResponseEntity.ok(transacaoRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Transacao> GetById(@PathVariable long id) {
		return transacaoRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<Transacao>> getByTipo(@PathVariable String tipo) {
		return ResponseEntity.ok(transacaoRepository.findAllByTipoContainingIgnoreCase(tipo));
	}

	@PostMapping
	public ResponseEntity<Transacao> postTransacao(@RequestBody Transacao transacao) {
		return ResponseEntity.status(HttpStatus.CREATED).body(transacaoRepository.save(transacao));
	}

}
