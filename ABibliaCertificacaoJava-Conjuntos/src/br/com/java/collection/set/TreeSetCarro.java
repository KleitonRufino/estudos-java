package br.com.java.collection.set;

import java.util.Set;
import java.util.TreeSet;

import br.com.java.collection.comparable.Carro;

public class TreeSetCarro {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Set s = new TreeSet();
		s.add(new Carro(123, "Luxo"));
		s.add(new Carro(124, "Popular"));
		s.add(new Carro(122, "Medio"));
		s.add(new Carro(123, "Luxo"));
		System.out.println(s);
	}

}
