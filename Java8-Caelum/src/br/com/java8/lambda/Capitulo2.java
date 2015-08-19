package br.com.java8.lambda;

import java.util.Arrays;
import java.util.List;

import br.com.java8.defaultmethods.Consumer;

public class Capitulo2 {
	// imprimir todos os usuarios

	Usuario user1 = new Usuario("Paulo Silveira", 150);
	Usuario user2 = new Usuario("Rodrigo Turini", 120);
	Usuario user3 = new Usuario("Guilherme Silveira", 190);
	// Arrays.asList é uma maneira simples de criar uma List imutável
	List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

	public static void main(String[] args) {
		Capitulo2 cap = new Capitulo2();
		cap.imprimirUsuariosManeiraClassica();

		// Usuario user1 = new Usuario("Paulo Silveira", 150);
		// Usuario user2 = new Usuario("Rodrigo Turini", 120);
		// Usuario user3 = new Usuario("Guilherme Silveira", 190);
		// // Arrays.asList é uma maneira simples de criar uma List imutável
		// List<Usuario> usuarios = Arrays.asList(user1, user2, user3);
		//
		// // for (Usuario u : usuarios)
		// // System.out.println(u.getNome());
		//
		// // A partir daqui Java 8
		//
		// // Jeito 1
		// Mostrador mostrador = new Mostrador();
		// usuarios.forEach(mostrador);
		//
		// // Jeito 2 - CLASSE ANONIMA
		// Consumer<Usuario> mostrador2 = new Consumer<Usuario>() {
		//
		// @Override
		// public void accept(Usuario u) {
		// System.out.println(u.getNome());
		// }
		//
		// };
		// usuarios.forEach(mostrador2);
		//
		// // Jeito 3
		// usuarios.forEach(new Consumer<Usuario>() {
		//
		// @Override
		// public void accept(Usuario u) {
		// System.out.println(u.getNome());
		// }
		// });
		//
		// // Jeito 4 - Lambda
		// Consumer<Usuario> mostrador3 = (Usuario u) -> {
		// System.out.println(u.getNome());
		// };
		//
		// Consumer<Usuario> mostrador4 = u -> {
		// System.out.println(u.getNome());
		// };
		//
		// Consumer<Usuario> mostrador5 = u -> System.out.println(u.getNome());
		//
		// // Jeito 5 - Lambda
		// usuarios.forEach(u -> System.out.println(u.getNome()));

	}

	public void imprimirUsuariosManeiraClassica() {
		for (Usuario u : usuarios) {
			System.out.println(u.getNome());
		}
	}

	@SuppressWarnings("unused")
	public void imprimirUsuarioLambdaModoI() {

		Consumer<Usuario> mostrador = (Usuario u) -> {
			System.out.println(u.getNome());
		};

	}

	@SuppressWarnings("unused")
	public void imprimirUsuarioLambdaModoII() {
		Consumer<Usuario> mostrador = (Usuario u) -> System.out.println(u
				.getNome());
	}

	public void imprimirUsuarioLambdaModoIII() {
		usuarios.forEach(u -> System.out.println(u.getNome()));
		usuarios.forEach(u -> System.out.println(u.getPontos()));
	}
	
	
}
