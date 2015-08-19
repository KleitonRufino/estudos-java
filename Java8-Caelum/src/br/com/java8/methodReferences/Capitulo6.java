package br.com.java8.methodReferences;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Capitulo6 {

	Usuario a = new Usuario("Paulo Silveira", 150);
	Usuario b = new Usuario("Rodrigo Turini", 120);
	Usuario c = new Usuario("Guilherme Silveira", 190);

	List<Usuario> usuarios = Arrays.asList(a, b, c);

	public void tornandoModeradorModoI() {
		usuarios.forEach((u1) -> {
			u1.tornaModerador();
		});
		usuarios.forEach((u1) -> u1.tornaModerador());
	}

	public void tornandoModeradorModoII() {
		usuarios.forEach(Usuario::tornaModerador);
	}

	public void comparatorComparingModoI() {
		usuarios.sort(Comparator.comparing(Usuario::getNome));
	}

	public void comparatorComparingModoII() {
		Function<Usuario, String> byNome = Usuario::getNome;
		usuarios.sort(Comparator.comparing(byNome));
	}

	public void comparatorComparingModoIII() {
		usuarios.sort(Comparator.comparingInt(u -> u.getPontos()));
	}

	public void comparatorComparingModoIV() {
		usuarios.sort(Comparator.comparingInt(Usuario::getPontos));
	}

	public void comparatorComparingModoV() {
		Comparator<Usuario> comparator = Comparator.comparingInt(
				Usuario::getPontos).thenComparing(Usuario::getNome);
		usuarios.sort(comparator);
	}

	public void comparatorComparingModoVI() {
		usuarios.sort(Comparator.comparingInt(Usuario::getPontos)
				.thenComparing(Usuario::getPontos));
	}

	// aqui todos os usuarios nulls irao para o fim da fila
	public void comparatorComparingModoVII() {
		usuarios.sort(Comparator.nullsLast(Comparator
				.comparing(Usuario::getNome)));

		usuarios.sort(Comparator.nullsFirst(Comparator
				.comparing(Usuario::getNome)));
	}

	// ordena em ordem descresente
	public void comparatorComparingModoVIII() {
		usuarios.sort(Comparator.nullsLast(Comparator.comparing(
				Usuario::getPontos).reversed()));
	}

	public void sysout(){
		usuarios.forEach(System.out::println);
	}
}
