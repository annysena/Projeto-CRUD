package br.com.projeto.projetocrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.projetocrud.model.Fatura;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Long> {

	public List<Fatura> findAllByDadosClienteContainingIgnoreCase(String dadosCliente);
}
