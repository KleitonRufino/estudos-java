package br.com.java.collection.comparable.sort;

@SuppressWarnings("rawtypes")
public class LivroI implements Comparable{
	Integer isbn;
	String titulo;

	public LivroI(Integer isbn, String titulo) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return isbn + " " + titulo;
	}

	@Override
	public int compareTo(Object o) {
		LivroI l = (LivroI) o;
		return this.isbn.compareTo(l.isbn);
	}
	
	
}
