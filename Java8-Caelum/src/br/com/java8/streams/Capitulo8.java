package br.com.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import br.com.java8.streamsEcollectors.filtros.Usuario;

public class Capitulo8 {
	Usuario user1 = new Usuario("Paulo Silveira", 150);
	Usuario user2 = new Usuario("Rodrigo Turini", 120);
	Usuario user3 = new Usuario("Guilherme Silveira", 90);
	// Arrays.asList é uma maneira simples de criar uma List imutável
	List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

	// List<Usuario> usuarios = new ArrayList<Usuario>();

	public void filtrarUsuariosComMaisDe100PtsEOrdenar() {
		usuarios.stream().filter(u -> u.getPontos() > 100)
				.sorted(Comparator.comparing(Usuario::getNome));
	}

	public void somarDoisInteirosUsandoReduce() {
		// somando todos os pontos
		int valorInicial = 0;
		usuarios.stream().mapToInt(Usuario::getPontos)
				.reduce(valorInicial, (a, b) -> a + b);
		usuarios.stream().mapToInt(Usuario::getPontos).reduce(0, Integer::sum);
	}

	public void multiplicarDoisInteirosUsandoReduce() {
		// multiplicar todos os pontos
		usuarios.stream().mapToInt(Usuario::getPontos)
				.reduce(1, (a, b) -> a * b);
	}

	public void verificandoSeHaAlgumModerador() {
		boolean hasModerador = usuarios.stream().anyMatch(Usuario::isModerador);
		System.out.println(hasModerador);
	}
}
