package br.com.java8.ordenando;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListSortELambda {
	Usuario a = new Usuario("Paulo Silveira", 150);
	Usuario b = new Usuario("Rodrigo Turini", 120);
	Usuario c = new Usuario("Guilherme Silveira", 190);

	List<Usuario> usuarios = Arrays.asList(a, b, c);

	public static void main(String[] args) {

		// usuarios.sort((u1, u2) -> u1.getNome().compareTo(u2.getNome()));

		// usuarios.sort(Comparator.comparing(u -> u.getNome()));
	}

	public void compareTo() {
		usuarios.sort((u1, u2) -> u1.getNome().compareTo(u2.getNome()));
	}

	public void comparatorCompare() {
		Comparator<Usuario> comparator = Comparator.comparing((u1) -> u1
				.getNome());
		usuarios.sort(comparator);

		usuarios.sort(Comparator.comparing((u2) -> u2.getNome()));
	
		
	}
}
