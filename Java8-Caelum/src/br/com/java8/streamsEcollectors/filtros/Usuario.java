package br.com.java8.streamsEcollectors.filtros;
public class Usuario {
	private String nome;
	private int pontos;
	private boolean moderador;

	public Usuario(String nome, int pontos) {
		super();
		this.nome = nome;
		this.pontos = pontos;
	}

	public String getNome() {
		return nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void tornaModerador() {
		this.moderador = true;
	}

	public boolean isModerador() {
		return moderador;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", pontos=" + pontos + ", moderador=" + moderador + "]";
	}
	
	
}