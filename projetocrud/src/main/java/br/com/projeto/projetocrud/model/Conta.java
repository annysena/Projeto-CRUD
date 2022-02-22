package br.com.projeto.projetocrud.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_conta")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nomeCliente;

	private String limite;
	
	@OneToMany(mappedBy = "conta", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("conta")
	private List<Transacao> transacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getLimite() {
		return limite;
	}

	public void setLimite(String limite) {
		this.limite = limite;
	}

	public List<Transacao> getTransacao() {
		return transacao;
	}

	public void setTransacao(List<Transacao> transacao) {
		this.transacao = transacao;
	}

}
