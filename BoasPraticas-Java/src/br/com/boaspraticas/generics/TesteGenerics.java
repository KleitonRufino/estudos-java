package br.com.boaspraticas.generics;

import java.util.ArrayList;
import java.util.List;

public class TesteGenerics {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<? super Cachorro> animais = new ArrayList();

	public void adicionaAnimal(Animal animal) {
		animais.add((Cachorro) animal);
	}

	public <T extends Animal> Animal retornaAnimal(int posicao) {
		return (Animal) animais.get(posicao);
	}
}
