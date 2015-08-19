package br.com.boaspraticas.generics;

public class Cachorro extends Animal {
	public Cachorro(String nome) {
		super.nome = nome;
	}

	public void late() {
		System.out.println("late");
	}
}
