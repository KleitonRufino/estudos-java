package br.com.java.collection.comparable.sort;

public class LivroII {
	Integer isbn;
	String titulo;

	public LivroII(Integer isbn, String titulo) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return isbn + " " + titulo;
	}

}
