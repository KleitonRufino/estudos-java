package br.com.java.collection.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class TesteLinkedHashSet {
	int a;

	public TesteLinkedHashSet(int a) {
		this.a = a;
	}

	@Override
	public int hashCode() {
		return a ^ 13;
	}

	@Override
	public boolean equals(Object obj) {
		if ((obj instanceof TesteHashSet) && ((TesteHashSet) obj).a == this.a)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "Atributo a: " + a;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// LinkedHashSet assegura a nao existencia de duplicatas,
		// itera por ordem de entrada
		
		Set conjunto = new LinkedHashSet();
		TesteHashSet x, y, z;
		x = new TesteHashSet(12);
		y = new TesteHashSet(15);
		z = new TesteHashSet(12);
		conjunto.add(x);
		conjunto.add(y);
		conjunto.add(z);
		System.out.println(conjunto);
	}

}
