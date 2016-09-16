package br.com.java8.ordenando;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorELambda {
	Usuario a = new Usuario("Paulo Silveira", 150);
	Usuario b = new Usuario("Rodrigo Turini", 120);
	Usuario c = new Usuario("Guilherme Silveira", 190);

	List<Usuario> usuarios = Arrays.asList(a, b, c);

	public static void main(String[] args) {

		// Comparator<Usuario> comparator = (u1, u2) -> u1.getNome().compareTo(
		// u2.getNome());
		//
		// Collections.sort(usuarios, comparator);
		// Outra forma
		// Collections.sort(usuarios,
		// (u1, u2) -> u1.getNome().compareTo(u2.getNome()));

	}


	public void comparatorNull(){
		Comparator<Usuario> c1 = Comparator.comparing(Usuario::getNome,
				Comparator.nullsLast(Comparator.naturalOrder()));
		
		Comparator<Usuario> c2 = Comparator.comparing(u1 -> u1.getNome(),
				Comparator.nullsLast(Comparator.naturalOrder()));
		
		
		Comparator<Usuario> c3 = (u1, u2) -> String.CASE_INSENSITIVE_ORDER.compare(Optional.ofNullable(u1.getNome()).toString(), Optional.ofNullable(u2.getNome()).toString());
		
		Comparator<Usuario> c4 = Comparator.comparing(Usuario::getPontos,
				Comparator.nullsLast(Comparator.naturalOrder()));
		
		Comparator<Usuario> c5 = Comparator.comparing(Usuario::getPontos,
				Comparator.nullsLast(Comparator.naturalOrder())).reversed();
		
		
		Collections.sort(usuarios, c3);
		
		usuarios.forEach(u -> {
			System.out.println(u.getNome());
		});
	}
	
	@SuppressWarnings("unused")
	public void ornedaComparatorModoI() {
		Comparator<Usuario> comparator = (u1, u2) -> u1.getNome().compareTo(
				u2.getNome());
	}

	public void ordenaComparatorModoII() {
		Collections.sort(usuarios,
				(u1, u2) -> u1.getNome().compareTo(u2.getNome()));
	}

	
}
