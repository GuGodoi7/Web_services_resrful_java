package br.com.fiap.megafarma.model.entity;

import java.time.LocalDate;

public class Remedio {

	private Long id;
	private String nome;
	private Double preco;
	private LocalDate dataDeFabricacao;
	private LocalDate dataDeValidade;
	
	public Remedio() {
		
	}

	public Remedio(Long id, String nome, Double preco, LocalDate dataDeFabricacao, LocalDate dataDeValidade) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.dataDeFabricacao = dataDeFabricacao;
		this.dataDeValidade = dataDeValidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public LocalDate getDataDeFabricacao() {
		return dataDeFabricacao;
	}

	public void setDataDeFabricacao(LocalDate dataDeFabricacao) {
		this.dataDeFabricacao = dataDeFabricacao;
	}

	public LocalDate getDataDeValidade() {
		return dataDeValidade;
	}

	public void setDataDeValidade(LocalDate dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	}

}

