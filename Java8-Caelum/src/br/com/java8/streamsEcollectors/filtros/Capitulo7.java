package br.com.java8.streamsEcollectors.filtros;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Capitulo7 {

	public static void main(String[] args) {
		Capitulo7 cap = new Capitulo7();
		cap.testando();
	}

	Usuario user1 = new Usuario("Paulo Silveira", 150);
	Usuario user2 = new Usuario("Rodrigo Turini", 120);
	Usuario user3 = new Usuario("Guilherme Silveira", 90);
	// Arrays.asList � uma maneira simples de criar uma List imut�vel
	List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

	// List<Usuario> usuarios = new ArrayList<Usuario>();

	public void testando() {
		// filtrando usuarios a cima de 100 pt
		List<Usuario> list = usuarios.stream().filter(u -> u.getPontos() > 100).collect(Collectors.toList());
		System.out.println("Impriminto Usuarios acima de 100pts");
		list.forEach(System.out::println);
		System.out.println("\n");

		// filtrando usuario com maior numero de pontos dos usuario com mais de
		// 100 pts
		Optional<Usuario> op = usuarios.stream().filter(u -> u.getPontos() > 100)
				.max(Comparator.comparing(Usuario::getPontos));
		System.out.println("Usuario com maior numero de pontos dos usuarios com mais de 100 pts");
		System.out.println(op.get());
		System.out.println("\n");

		// tornar todos os usuarios moderador acima de 130 pts moderador
		// usuarios.stream().filter(u -> u.getPontos() >
		// 130).forEach(Usuario::tornaModerador);;
		usuarios.stream().filter(u -> u.getPontos() > 130).peek(Usuario::tornaModerador).findAny();
		usuarios.forEach(System.out::println);
	}

	public void filtrar10UsuariosComMaisPontos() {
		usuarios.sort(Comparator.comparingInt(Usuario::getPontos).reversed());

		usuarios.subList(0, 1).forEach(Usuario::tornaModerador);

		usuarios.forEach(u -> System.out.println(u));

	}

	public void filtrarUsuarioComMaisDe100Pontos() {

		Stream<Usuario> stream = usuarios.stream().filter((u1) -> u1.getPontos() > 100);

		stream.forEach(System.out::println);

		usuarios.stream().filter(u2 -> u2.getPontos() > 100).forEach(System.out::println);
	}

	public void filtrarUsuariosQueSaoModeradores() {
		usuarios.stream().filter(Usuario::isModerador).forEach(System.out::println);
		;
	}

	@SuppressWarnings("unused")
	public void filtrarUsuariosComMaisDe100PontosERetornaList() {
		List<Usuario> maisQue100 = usuarios.stream().filter(u1 -> u1.getPontos() > 100).collect(Collectors.toList());

		maisQue100.forEach(System.out::println);

		Set<Usuario> set1 = usuarios.stream().filter(u2 -> u2.getPontos() > 100).collect(Collectors.toSet());
		Set<Usuario> set2 = usuarios.stream().filter(u3 -> u3.getPontos() > 100)
				.collect(Collectors.toCollection(HashSet::new));
	}

	@SuppressWarnings("unused")
	public void recuperandoUmListDePontos() {
		List<Integer> pontos1 = usuarios.stream().map(u -> u.getPontos()).collect(Collectors.toList());

		List<Integer> pontos2 = usuarios.stream().map(Usuario::getPontos).collect(Collectors.toList());
	}

	public void pontuacaoMedia() {
		System.out.println(usuarios.stream().mapToInt(Usuario::getPontos).average().getAsDouble());
	}

	public void trantandoDivisaoPorZero() {
		OptionalDouble media = usuarios.stream().mapToInt(Usuario::getPontos).average();

		double pontuacaoMedia = media.orElse(0.0);

		System.out.println(pontuacaoMedia);

		System.out.println(usuarios.stream().mapToInt(Usuario::getPontos).average().orElse(0.0));

		// Lancando uma Excpetion

		usuarios.stream().mapToInt(Usuario::getPontos).average().orElseThrow(IllegalStateException::new);
	}

	public void filtroUsuarioComMaiorQuantidadeDePontos() {
		// utilizando Optional para tratar caso o valor seja null
		Optional<Usuario> max = usuarios.stream().max(Comparator.comparingInt(Usuario::getPontos));
		// System.out.println(max.get());
		Usuario user = max.orElse(null);

		System.out.println(user);
	}

	public void imprimindoTodosOsUsuariosComMaisDe100Pts() {
		// peek realiza uma tarefa
		usuarios.stream().filter(u -> u.getPontos() > 100).peek(System.out::println).findAny();
	}

	public void menorQtdDePontos() {
		System.out.println(usuarios.stream().min(Comparator.comparing(Usuario::getPontos)).get());
	}

	public void maiorQtdDePontos() {
		System.out.println(usuarios.stream().max(Comparator.comparing(Usuario::getPontos)).get());
	}

	public void somandoTodosOsPontosDoUsuario() {
		System.out.println(usuarios.stream().mapToInt(Usuario::getPontos).sum());
	}

}
