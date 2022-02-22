package br.com.projeto.projetocrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.projetocrud.model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

	public List<Transacao> findAllByTipoContainingIgnoreCase(String tipo);
}
