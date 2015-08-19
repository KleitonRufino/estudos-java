package br.com.java8.nullpointerexception;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class NullPointerException {

	public static void main(String[] args) {

		Curso curs = new Curso();
		curs.setNome("nome");
		curs.setDescricao(Optional.ofNullable("descricao"));
		Matricula m1 = new Matricula(curs);
		Matricula m2 = new Matricula(null);
		List<Matricula> matriculas = Arrays.asList(m1, m2);

		// opcao 1
		for (Matricula matricula : matriculas) {
			Optional<Curso> cursoOpcional = matricula.cursoOpcional;
			if (cursoOpcional.isPresent())
				System.out.println(cursoOpcional.get().getNome());
			else
				System.out.println("curso nao presente");
		}

		// // opcao 3
		for (Matricula matricula : matriculas) {
			matricula.cursoOpcional.ifPresent(c -> System.out.println(c
					.getNome()));
		}

		// // opcao 4
//		matriculas
//				.forEach(m -> {
//					Curso curso = m.cursoOpcional
//							.orElseThrow(IllegalArgumentException::new);
//				});
		
		// // opcao 5
//		matriculas.forEach(m -> {
//			m.cursoOpcional.ifPresent(c -> {
//				System.out.println(c.getNome().orElse("sem nome"));
//			});
//		});

		// // opcao 6
		matriculas.forEach(m -> {
			m.cursoOpcional.ifPresent(c -> {
				Optional<String> descricao = c.getDescricao();
				if (descricao.isPresent() && !descricao.get().isEmpty()) {
					System.out.println(descricao.get());
				}
			});
		});
		//
		// // opcao 7
		matriculas.forEach(m -> {
			m.cursoOpcional.flatMap(Curso::getDescricao).filter(d -> !d.isEmpty())
					.ifPresent(System.out::println);
		});
	}
}
