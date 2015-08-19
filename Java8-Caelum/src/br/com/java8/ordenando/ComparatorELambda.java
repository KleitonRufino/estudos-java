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
