package br.com.java8.nullpointerexception;

import java.util.Optional;

public class Matricula {

	// empty cria e inicializa o atributo com um Optional vazio
	// public Optional<Curso> maneira1 = Optional.empty();
	// outraForma
	public Optional<Curso> cursoOpcional;


	public Matricula(Curso algumCurso) {
		// TODO Auto-generated constructor stub
		//ira lancar uma exception caso valor seja null
		// this.cursoOpcional = Optional.of(algumCurso);
		cursoOpcional = Optional.ofNullable(algumCurso);
	}

}
