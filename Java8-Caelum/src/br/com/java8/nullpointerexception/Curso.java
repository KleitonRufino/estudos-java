package br.com.java8.nullpointerexception;

import java.util.Optional;

public class Curso {
	
	private String nome;
	private Optional<String> descricao;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Optional<String> getDescricao() {
		return descricao;
	}

	public void setDescricao(Optional<String> descricao) {
		this.descricao = descricao;
	}

}
