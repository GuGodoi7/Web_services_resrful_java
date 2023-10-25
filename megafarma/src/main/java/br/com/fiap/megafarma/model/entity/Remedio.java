package br.com.fiap.megafarma.model.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

public class Remedio {

	private Long id;
	@NotBlank
	private String nome;
	@NotNull
	@PositiveOrZero
	private Double preco;
	@PastOrPresent
	private LocalDate dataDeFabricacao;
	@FutureOrPresent
	private LocalDate dataDeValidade;
	
	public Remedio() {
		
	}

	public Remedio(Long id, @NotBlank String nome, @NotNull @PositiveOrZero Double preco,
			@PastOrPresent LocalDate dataDeFabricacao, @FutureOrPresent LocalDate dataDeValidade) {
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

