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
@Table(name = "tb_fatura")
public class Fatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String dadosCliente;

	private String saldoAnterior;

	private String totalFatura;

	private String saldoDisponivel;

	private String totalDebitos;

	private String totalCreditos;

	@OneToMany(mappedBy = "fatura", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("fatura")
	private List<Transacao> transacao;

	public long getId() {
		return id;
	}

	public void setId(long id) { 
		this.id = id;
	}

	public String getDadosCliente() {
		return dadosCliente;
	}

	public void setDadosCliente(String dadosCliente) {
		this.dadosCliente = dadosCliente;
	}

	public List<Transacao> getTransacao() {
		return transacao;
	}

	public void setTransacao(List<Transacao> transacao) {
		this.transacao = transacao;
	}

	public String getSaldoAnterior() {
		return saldoAnterior;
	}

	public void setSaldoAnterior(String saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}

	public String getTotalFatura() {
		return totalFatura;
	}

	public void setTotalFatura(String totalFatura) {
		this.totalFatura = totalFatura;
	}

	public String getSaldoDisponivel() {
		return saldoDisponivel;
	}

	public void setSaldoDisponivel(String saldoDisponivel) {
		this.saldoDisponivel = saldoDisponivel;
	}

	public String getTotalDebitos() {
		return totalDebitos;
	}

	public void setTotalDebitos(String totalDebitos) {
		this.totalDebitos = totalDebitos;
	}

	public String getTotalCreditos() {
		return totalCreditos;
	}

	public void setTotalCreditos(String totalCreditos) {
		this.totalCreditos = totalCreditos;
	}

}
