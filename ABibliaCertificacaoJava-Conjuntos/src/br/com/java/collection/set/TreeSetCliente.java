package br.com.java.collection.set;

import java.util.Set;
import java.util.TreeSet;

import br.com.java.collection.comparable.Cliente;
import br.com.java.collection.comparable.ComparatorCliente;

public class TreeSetCliente {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		ComparatorCliente cc = new ComparatorCliente();
		Set s = new TreeSet(cc);
		s.add(new Cliente("Roberto", 31));
		s.add(new Cliente("Roberto", 31));
		s.add(new Cliente("Marcelo", 35));
		s.add(new Cliente("Marcelo", 18));
		s.add(new Cliente("Marcelo", 20));
		s.add(new Cliente("Roberto", 20));
		s.add(new Cliente("Ana", 30));
		s.add(new Cliente("Ana", 20));
		System.out.println(s);
	}

}
