package br.com.java8.lambda;

import java.util.function.Consumer;

//Java 8
//Consumer: realizar alguma tarefa que faca sentido
public class Mostrador implements Consumer<Usuario> {

	@Override
	public void accept(Usuario u) {
		// tarefa = mostrar nome do usuario
		System.out.println(u.getNome());
	}
	
}
