package br.com.java.collection.comparable;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class ComparatorCliente implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Cliente c1 = (Cliente) o1;
		Cliente c2 = (Cliente) o2;
		return c1.idade - c2.idade;
	}

}
