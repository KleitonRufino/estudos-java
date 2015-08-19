package br.com.java8.defaultmethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Capitulo4 {
	Usuario user1 = new Usuario("Paulo Silveira", 150);
	Usuario user2 = new Usuario("Rodrigo Turini", 120);
	Usuario user3 = new Usuario("Guilherme Silveira", 190);
	// Arrays.asList é uma maneira simples de criar uma List imutável
	List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

	public static void main(String... args) {

		Usuario u1 = new Usuario("Paulo Silveira", 150);
		Usuario u2 = new Usuario("Rodrigo Turini", 120);
		Usuario u3 = new Usuario("Guilherme Silveira", 190);

		List<Usuario> usuarios = Arrays.asList(u1, u2, u3);

		Consumer<Usuario> mostraMensagem = u -> System.out
				.println("antes de imprimir os nomes");

		Consumer<Usuario> imprimeNome = u -> System.out.println(u.getNome());

		usuarios.forEach(mostraMensagem.andThen(imprimeNome));

		// O Predicate eh uma interface funcional q permite testar obj de um
		// determinado tipo
		Predicate<Usuario> predicate = new Predicate<Usuario>() {

			@Override
			public boolean test(Usuario u) {
				return u.getPontos() > 160;
			}
		};

		System.out.println();

		List<Usuario> usuarios2 = new ArrayList<>();
		usuarios2.addAll(usuarios);

		// Dado um Predicate, o removeIf vai remover todos os elementos
		// que devolverem true para esse predicado.

		usuarios2.removeIf(predicate);
		usuarios2.forEach(u -> System.out.println(u.getNome()));

		System.out.println();

		// removeIf so com lambda sem predicate
		usuarios2.removeIf(u -> u.getPontos() > 160);
		usuarios2.forEach(u -> System.out.println(u.getNome()));

	}

	public void andThen() {
		Consumer<Usuario> mostrarMensagem = (u) -> {
			System.out.println("antes de imprimir os nomes");
		};

		Consumer<Usuario> imprimeNome = (u) -> {
			System.out.println(u.getNome());
		};

		usuarios.forEach(mostrarMensagem.andThen(imprimeNome));
	}

	public void removeIfModoI() {
		Predicate<Usuario> predicado = new Predicate<Usuario>() {
			public boolean test(Usuario u) {
				return u.getPontos() > 160;
			}
		};

		List<Usuario> usuarios2 = new ArrayList<Usuario>();
		usuarios2.add(user1);
		usuarios2.add(user2);
		usuarios2.add(user3);

		// Dado um Predicate, o removeIf vai remover todos os elementos
		// que devolverem true para esse predicado.
		usuarios.removeIf(predicado);
		usuarios.forEach(u -> System.out.println(u));
	}

	public void removeIfModoII() {
		// usuarios.forEach((u) -> {System.out.println(u.getNome());});
		usuarios.removeIf((u) -> u.getPontos() > 160);
		usuarios.removeIf((u1) -> {
			return u1.getPontos() > 160;
		});
	}

}